package com.lanou3g.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

/*
 * 获取数据库连接池类
 */
public class DataSourceUtil {
 	private static BasicDataSource dataSource = new BasicDataSource();
 	static {
 		//	读取文件
 		InputStream inputStream = DataSourceUtil.class.getClassLoader().getResourceAsStream("dbinfo.properties");
 		Properties properties = new Properties();
 		try {
			properties.load(inputStream);
			dataSource.setDriverClassName(properties.getProperty("driverClass"));
	 		dataSource.setUrl(properties.getProperty("url"));
	 		dataSource.setUsername(properties.getProperty("user"));
	 		dataSource.setPassword(properties.getProperty("password"));
	 		//	扩展设置
	 		dataSource.setInitialSize(Integer.parseInt(properties.getProperty("initialSize")));	// 初始化连接数量
	 		dataSource.setMaxActive(Integer.parseInt(properties.getProperty("maxActive"))); // 最大连接数量
	 		dataSource.setMaxIdle(Integer.parseInt(properties.getProperty("maxIdle"))); // 最大空闲连接
	 		dataSource.setMinIdle(Integer.parseInt(properties.getProperty("minIdle"))); // 最小空闲连接
		} catch (IOException e) {
			e.printStackTrace();
		}
 	}
 	//	私有化
 	private DataSourceUtil() { }

	public static BasicDataSource getDataSource() {
 		return dataSource;
 	}
}