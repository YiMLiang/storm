package com.xdl.stormKafka;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class kflumeProduct {
	/**
	 * create data
	 */
	/*
	 * public static List<String> creatData() {
	 * 
	 * List<String> list = new ArrayList<>();
	 * 
	 * Configuration conf = new Configuration(); String uri =
	 * "hdfs://master:9000/sogou/20181025/sogou500w.txt"; try { FileSystem fs =
	 * FileSystem.get(URI.create(uri), conf); FSDataInputStream in = fs.open(new
	 * Path(uri)); BufferedReader reader = new BufferedReader( new
	 * InputStreamReader(in)); while (reader.readLine() != null) { if
	 * (list.size() <= 300) { String msgs = reader.readLine(); String[] str =
	 * msgs.split("\t"); list.add(str[2]); } else { break; } }
	 * 
	 * } catch (Exception e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * return list;
	 * 
	 * }
	 */

	/**
	 * send socket-UDP
	 */

	/*
	 * public void udpSendSocket() { DatagramSocket ds; try { ds = new
	 * DatagramSocket(); List<String> dataflumn = kflumeProduct.creatData(); for
	 * (String list : dataflumn) { ; byte[] by = list.getBytes(); DatagramPacket
	 * dp = new DatagramPacket(by, by.length,
	 * InetAddress.getByName("192.168.2.53"), 10006); ds.send(dp); } } catch
	 * (Exception e) { e.printStackTrace(); } }
	 */

	/**
	 * send socket-TCP
	 */
	public void tcpSendSocket() {
		Socket s1 = null;
		try {
			/*
			 * List<String> dataflumn = kflumeProduct.creatData(); s1 = new
			 * Socket("192.168.150.132", 5140); //
			 * System.out.println(dataflumn); for (String list : dataflumn) {
			 * PrintWriter pw = new PrintWriter(s1.getOutputStream());
			 * pw.println(list); System.out.println(list); pw.flush();
			 * 
			 * 
			 * BufferedOutputStream bosout = new BufferedOutputStream(
			 * s1.getOutputStream()); bosout.write(list.getBytes());
			 * bosout.flush();
			 * 
			 * }
			 */
			/**
			 * createData
			 */
			s1 = new Socket("192.168.150.132", 5140);
			PrintWriter pw = new PrintWriter(s1.getOutputStream());
			String line = com.xdl.stormKafka.Test.result();
			pw.println(line.toString());
			System.out.println(line.toString());
			pw.flush();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != s1) {
				try {
					s1.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * send socket-TCP
	 */
	public void tcpSendSocket2() {
		Socket s1 = null;
		try {
			/*
			 * List<String> dataflumn = kflumeProduct.creatData(); s1 = new
			 * Socket("192.168.150.133", 5140); //
			 * System.out.println(dataflumn); for (String list : dataflumn) {
			 * PrintWriter pw = new PrintWriter(s1.getOutputStream());
			 * pw.println(list); System.out.println(list); pw.flush();
			 * 
			 * 
			 * BufferedOutputStream bosout = new BufferedOutputStream(
			 * s1.getOutputStream()); bosout.write(list.getBytes());
			 * bosout.flush();
			 * 
			 * }
			 */
			s1 = new Socket("192.168.150.133", 5140);
			PrintWriter pw = new PrintWriter(s1.getOutputStream());
			String line = com.xdl.stormKafka.Test.result();
			pw.println(line.toString());
			System.out.println(line.toString());

			pw.flush();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != s1) {
				try {
					s1.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) throws UnknownHostException {

		// List<String> list = ProductData.creatData();
		// for(String ss : list){
		// System.out.println(ss);
		// }
		Thread thread = new Thread(new SleepRunner());
		thread.start();
		Thread thread2 = new Thread(new SleepRunner2());
		thread2.start();

	}
}

/**
 * set rate of transform
 */
class SleepRunner implements Runnable {

	private kflumeProduct pd = new kflumeProduct();

	@SuppressWarnings("static-access")
	@Override
	public void run() {
		while (true) {
			try {
				pd.tcpSendSocket();
				Thread.currentThread().sleep((long) (Math.random() * 1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

/**
 * set rate of transform
 */
class SleepRunner2 implements Runnable {

	private kflumeProduct pd = new kflumeProduct();

	@SuppressWarnings("static-access")
	@Override
	public void run() {

		while (true) {
			try {
				pd.tcpSendSocket2();
				Thread.currentThread().sleep((long) (Math.random() * 1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
