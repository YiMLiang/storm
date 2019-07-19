package com.xdl.stormKafka;

import com.google.common.collect.ImmutableList;   
  
import storm.kafka.BrokerHosts;  
import storm.kafka.KafkaSpout;  
import storm.kafka.SpoutConfig;  
import storm.kafka.StringScheme;  
import storm.kafka.ZkHosts;  
import backtype.storm.Config;  
import backtype.storm.LocalCluster;  
import backtype.storm.StormSubmitter;  
import backtype.storm.spout.SchemeAsMultiScheme;  
import backtype.storm.topology.TopologyBuilder;  
public class CountTopology {
	 /** 
     * @param args 
     */  
    public static void main(String[] args) {  
        try{  
            String kafkaZookeeper = "master:2181,slave:2181,slave1:2181";
            BrokerHosts brokerHosts = new ZkHosts(kafkaZookeeper);
            SpoutConfig kafkaConfig = new SpoutConfig(brokerHosts, "pro-kflume", "/storm", "stormid");
            kafkaConfig.scheme = new SchemeAsMultiScheme(new StringScheme());
            kafkaConfig.zkServers =  ImmutableList.o=f("master","slave","slave1");
            kafkaConfig.zkPort = 2181;
            
            //kafkaConfig.forceFromStart = true;

            TopologyBuilder builder = new TopologyBuilder();
            System.out.println("waitting connection!!!!");
            builder.setSpout("spout", new KafkaSpout(kafkaConfig), 5);
         
          //*************************下面是所有处理逻辑，只关注这个*****************************  
            builder.setBolt("countBolt", new CountBolt(),4).shuffleGrouping("spout");
            //builder.setBolt("countBolt2", new CountBolt2(),3).shuffleGrouping("countBolt");
            builder.setBolt("saveBolt", new SaveBolt(),2).shuffleGrouping("countBolt");
            
            
            
            //*************************下面是所有处理逻辑，只关注这个*****************************  

            
            
            
            Config conf = new Config();  
            conf.setDebug(true);  
              
            if (args!=null&&args.length>0) {
    			conf.setNumWorkers(4);
    			StormSubmitter.submitTopology(args[0], conf, builder.createTopology());
    			
    		} else {
    			conf.setNumWorkers(2);
    			LocalCluster local = new LocalCluster();
    			local.submitTopology("wordcount", conf, builder.createTopology());
    			
    		}
        }catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
}
