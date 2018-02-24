package com.gameorm.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import com.bean.ExportDB;

public class OrmServiceRegistry extends StandardServiceRegistryBuilder {
	
	
	public OrmServiceRegistry(Properties properties){
		this.applySettings(properties);
	}
	
	/**
	 *
	 * 
	 * 
	 */
	public OrmServiceRegistry(String propertiesFileName){
        InputStream in = ExportDB.class.getClassLoader().getResourceAsStream(propertiesFileName);
        Properties properties = new Properties();
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.applySettings(properties);
	}
	
	/**
	 *
	 * 默认加载classpath下的hibernate.properties配置文件
	 *
	 */
	public OrmServiceRegistry(){
        InputStream in = ExportDB.class.getClassLoader().getResourceAsStream("hibernate.properties");
        Properties properties = new Properties();
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.applySettings(properties);
	}
	
	public StandardServiceRegistry build(){
		return super.build();
	}
	
	

}
