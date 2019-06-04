package com.lanou3g.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/*
 * 作用
 * 获取Session对象
 */
public class HibernateUtil {
	private static SessionFactory sessionFactory;
	static {
		//	读文件
		Configuration configure = new Configuration().configure();
		//	创建Session工厂
		sessionFactory = configure.buildSessionFactory();
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	//	获取Session的方法
	public static Session getOpenSession() {
		return sessionFactory.openSession();
	}
	//	要试用该方法 必须在主配置文件中配置一下
	public static Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
}
