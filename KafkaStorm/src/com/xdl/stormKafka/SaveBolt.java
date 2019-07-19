package com.xdl.stormKafka;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Tuple;

public class SaveBolt extends BaseRichBolt{
	private String username = "hadoop";
	private String password = "hadoop";
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://master:3306/storm";
	private Connection conn = null;
	
	@Override
	public void execute(Tuple input) {
		// TODO Auto-generated method stub
		System.out.println("--------------waiting insert.....---------------");
		//String timeStamp = input.getStringByField("TimeStamp");
		//int count = input.getStringByField("count");
		int count = input.getIntegerByField("count");
		String sql = "insert into test3(count) values(?)";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,count);
			//pstmt.setInt(2, count);
			pstmt.execute();
			System.out.println("--------------insert successful!!---------------");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	

	@Override
	public void prepare(Map conf, TopologyContext context, OutputCollector collector) {
		// TODO Auto-generated method stub
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		// TODO Auto-generated method stub
	
	}

}
