package com.xdl.stormKafka;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Test {

	/**
	 * @param args
	 */
	public static String cookieValue = "ab1cd3ef4gh2ig5kl6mn7op8qr9st0uvwxyz";
	public static String[] devName = { "MacBook Pro", "MacBook Air", "Windows" };
	public static String[] osName = { "mac os x 10.9", "mac win 7", "win 7",
			"win 10" };

	public static String time() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String localtime = sdf.format(date);
		return localtime;

	}

	public static String userAccount() {
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 2; i++) {
			sb.append(random.nextInt(10));
		}
		String account = "022966601" + sb.toString();
		return account;
	}

	/*
	 * 随机生成国内IP地址
	 */
	public static String getUserIp() {

		// ip范围
		int[][] range = { { 607649792, 608174079 },// 36.56.0.0-36.63.255.255
				{ 1038614528, 1039007743 },// 61.232.0.0-61.237.255.255
				{ 1783627776, 1784676351 },// 106.80.0.0-106.95.255.255
				{ 2035023872, 2035154943 },// 121.76.0.0-121.77.255.255
				{ 2078801920, 2079064063 },// 123.232.0.0-123.235.255.255
				{ -1950089216, -1948778497 },// 139.196.0.0-139.215.255.255
				{ -1425539072, -1425014785 },// 171.8.0.0-171.15.255.255
				{ -1236271104, -1235419137 },// 182.80.0.0-182.92.255.255
				{ -770113536, -768606209 },// 210.25.0.0-210.47.255.255
				{ -569376768, -564133889 }, // 222.16.0.0-222.95.255.255
		};

		Random rdint = new Random();
		int index = rdint.nextInt(10);
		String ip = userIP(range[index][0]
				+ new Random().nextInt(range[index][1] - range[index][0]));
		return ip;
	}

	/*
	 * 将十进制转换成ip地址
	 */
	public static String userIP(int ip) {
		int[] b = new int[4];
		String uip = "";

		b[0] = (int) ((ip >> 24) & 0xff);
		b[1] = (int) ((ip >> 16) & 0xff);
		b[2] = (int) ((ip >> 8) & 0xff);
		b[3] = (int) (ip & 0xff);
		uip = Integer.toString(b[0]) + "." + Integer.toString(b[1]) + "."
				+ Integer.toString(b[2]) + "." + Integer.toString(b[3]);

		return uip;
	}

	public static String qqid() {
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 2; i++) {
			sb.append(random.nextInt(10));
		}
		String qid = "6165817" + sb.toString();
		return qid;
	}

	public static String natIP() {
		int a = 108 * 256 * 256 + 1 * 256 + 5;
		int b = 145 * 256 * 256 + 110 * 256 + 35;
		int c = new Random().nextInt(b - a) + a;
		//String ip1 = Integer.toHexString(c / (256 * 256));
		String ip2 = Integer.toString(((c / 256) % 256));
		String ip3 = Integer.toString((c % 256));
		String nip = "192." + "168" + "." + ip2 + "." + ip3;
		return nip;
	}

	public static String cookieValue() {
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 32; i++) {
			int number = random.nextInt(32);
			sb.append(cookieValue.charAt(number));
		}
		return sb.toString();
	}

	public static String result() {
		Random random = new Random();
		return time() + "\t" + userAccount() + "\t" + getUserIp() + "\t"
				+ qqid() + "\t" + natIP() + "\t" + cookieValue() + "\t"
				+ devName[random.nextInt(3)] + "\t" + osName[random.nextInt(4)];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * random 13
		 */

		/*
		 * Random random = new Random(); StringBuilder str = new
		 * StringBuilder(); for (int i = 0; i < 3; i++) {
		 * str.append(random.nextInt(10)); } String account = "02296660" + str;
		 * System.out.println(account);
		 */

		/**
		 * time
		 */
		/*
		 * Date date = new Date(); SimpleDateFormat sdf = new
		 * SimpleDateFormat("yyyyMMddHHmmss"); String str = sdf.format(date);
		 * 
		 * System.out.println(str);
		 */
		/**
		 * ip
		 */
		/*
		 * int a = 108 * 256 * 256 + 1 * 256 + 5; int b = 145 * 256 * 256 + 110
		 * * 256 + 35; int c = new Random().nextInt(b - a) + a; String ip1 =
		 * Integer.toHexString(c / (256 * 256)); String ip2 =
		 * Integer.toString(((c / 256) % 256)); String ip3 = Integer.toString((c
		 * % 256)); System.out.println("192." + ip1 + "." + ip2 + "." + ip3);
		 */

		/**
		 * ip 2
		 */
		while(true){
		String str = result();
		System.out.println(str);
		}
		
	}
}