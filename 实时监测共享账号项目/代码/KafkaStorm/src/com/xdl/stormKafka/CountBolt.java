package com.xdl.stormKafka;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;

public class CountBolt extends BaseRichBolt {
	private static Set<String> set1 = new HashSet<>();
	private static Set<String> set2 = new HashSet<>();
	private static Set<String> set3 = new HashSet<>();
	private static Map<String, Integer> map1 = new HashMap<>();
	private static Map<String, Integer> map2 = new HashMap<>();
	private static Map<String, Integer> map3 = new HashMap<>();
	private static Set<String> msg = new HashSet<String>();
	//private static List<String> list = new ArrayList<String>();
	private static String TimeStamp = null;
	private OutputCollector collector = null;

	@Override
	public void execute(Tuple input) {
		String line = input.getString(0);
		String[] words = line.split("\t");
		//System.out.println("||---------" + line + "----------||");

		if (TimeStamp == null) {
			TimeStamp = words[0];
			System.out.println(TimeStamp);
		} else if (Long.parseLong(words[0]) - Long.parseLong(TimeStamp) >= (long)60000) {
			System.out.println("get:" + words[1] + "");
			Values values = new Values(msg.size());
			collector.emit(values);
			System.out.println("send success");
			System.out.println("------------------------------" + TimeStamp
					+ "-------------------------------------");
			set1.clear();
			set2.clear();
			set3.clear();
			msg.clear();
			map1.clear();
			map2.clear();
			map3.clear();
			TimeStamp = words[0];
		}

		int count1 = 0;
		int count2 = 0;
		int count3 = 0;

		String str1 = words[1] + "\t" + words[4];
		if (set1.add(str1)) {
			if (map1.containsKey(words[1])) {
				count1 = map1.get(words[1]);
			}
			count1++;
			map1.put(words[1], count1);
		}

		String str2 = words[1] + "\t" + words[3];
		if (set2.add(str2)) {
			if (map2.containsKey(words[1])) {
				count2 = map2.get(words[1]);
			}
			count2++;
			map2.put(words[1], count2);
		}

		String str3 = words[1] + "\t" + words[5] + words[6] + words[7];
		if (set3.add(str3)) {
			if (map3.containsKey(words[1])) {
				count3 = map3.get(words[1]);
			}
			count3++;
			map3.put(words[1], count3);
		}

		if (count1 == 6 || count2 == 21 || count3 == 6) {

			msg.add(words[1]);
			System.out.println(msg);
		}
	}

	@Override
	public void prepare(Map conf, TopologyContext context,
			OutputCollector collector) {
		this.collector = collector;
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields("count"));
	}
}
