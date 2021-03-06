package com.whyun.util.db.source.impl;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.whyun.util.config.MySqlConfigProperty2;
import com.whyun.util.db.source.AbstractDataSource;

public class DruidSourceMysql2 extends AbstractDataSource {

	private volatile static DruidSourceMysql2 instance;	
	
	
	private DruidSourceMysql2() throws Exception {
		dataSource = DruidDataSourceFactory.createDataSource(
				MySqlConfigProperty2.getInstance().getProperties());		
	}

	public static DruidSourceMysql2 getInstance() throws Exception {
		if (instance == null) {
			synchronized (DruidSourceMysql2.class) {
				if (instance == null) {
					instance = new DruidSourceMysql2();
				}
			}
		}
		return instance;
	}	
	
}
