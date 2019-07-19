package cn.yml.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp.BasicDataSourceFactory;

public class DBUtils {
	private static DataSource ds;// 连接池对象

	static {
		InputStream in = DBUtils.class.getClassLoader().getResourceAsStream("dbcp.properties");
		// 创建属性对象，加载连接池的配置参数
		Properties pro = new Properties();
		try {
			pro.load(in);
			// 连接池工厂类创建连接池对象需要连接池的配置参数（通过一个属性对象传递）
			ds = BasicDataSourceFactory.createDataSource(pro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * get Connection Object
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}

	public static void closeRes(Connection conn, ResultSet rs, Statement st) {
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if (st != null)
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
