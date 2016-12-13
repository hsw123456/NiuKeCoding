package com.hsw.myutils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.junit.experimental.theories.Theories;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {
	
	private static DataSource dataSource = null;
	
	static{
		dataSource = new ComboPooledDataSource("helloC3p0"); 
	}
	
	public static Connection getConnection2() throws Exception{
		
		return dataSource.getConnection();
	}
	
	//返回一个Connection对象
	
	public static Connection getConnection() throws SQLException, Exception{
		
		Properties properties = new Properties();
		//获得该类的类加载器并将配置文件读入输入流
		InputStream inStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
		properties.load(inStream);
		
		//准备数据库连接的四个字符串
		String driverClass = properties.getProperty("driverClass");
		String user = properties.getProperty("user");
		String password = properties.getProperty("password");
		String url = properties.getProperty("jdbcUrl");
		
		//注册驱动
		Class.forName(driverClass);
		Connection connection = DriverManager.getConnection(url, user, password);
		return connection;
	}
	
	public static void releaseDB(Connection connection, Statement statement, ResultSet resultSet){
		
		if(resultSet != null){
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(statement != null){
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(connection != null){
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
