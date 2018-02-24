package com.gameorm.db.dao;

import java.util.EnumSet;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;

import com.bean.User;
import com.gameorm.config.OrmServiceRegistry;

public class BaseGameDaoImpl<T> implements OrmGameDao<T>{
	
	private SessionFactory sessionFactory = null;
	
	private ServiceRegistry serviceRegistry;
	
	private Metadata metadata;
	
	static{
		
	}
	
	public BaseGameDaoImpl() {
		// TODO Auto-generated constructor stub
		serviceRegistry = buildOrmServiceRegistry();
		metadata = buildMetadata();
        SchemaExport schemaExport = new SchemaExport();
        //schemaExport.create 会删除表 重新建立表 慎用
        schemaExport.createOnly(EnumSet.of(TargetType.DATABASE), metadata);
         sessionFactory = metadata.buildSessionFactory(); 
	}
	
	public BaseGameDaoImpl(String propertiesPath){
		serviceRegistry = buildOrmServiceRegistry(propertiesPath);
		metadata = buildMetadata();
        SchemaExport schemaExport = new SchemaExport();
        //schemaExport.create 会删除表 重新建立表 慎用
        schemaExport.createOnly(EnumSet.of(TargetType.DATABASE), metadata);
        sessionFactory = metadata.buildSessionFactory(); 
	}
	
	public BaseGameDaoImpl(Properties properties){
		serviceRegistry = buildOrmServiceRegistry(properties);
		metadata = buildMetadata();
        SchemaExport schemaExport = new SchemaExport();
        //schemaExport.create 会删除表 重新建立表 慎用
        schemaExport.createOnly(EnumSet.of(TargetType.DATABASE), metadata);
        sessionFactory = metadata.buildSessionFactory(); 
	}
	
	
	public ServiceRegistry buildOrmServiceRegistry(){
		return (new OrmServiceRegistry()).build();
	}
	
	public ServiceRegistry buildOrmServiceRegistry(String propertiesPath){
		return (new OrmServiceRegistry(propertiesPath)).build();
	}
	
	public ServiceRegistry buildOrmServiceRegistry(Properties properties){
		return (new OrmServiceRegistry(properties)).build();
	}
	
	
	public Metadata buildMetadata(){
		Metadata metadata = new MetadataSources(serviceRegistry).addAnnotatedClass(User.class).buildMetadata();
		return metadata;
	}

	@Override
	public T save(T pojo) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(pojo);
            transaction.commit();
        } catch (Exception e) {
            // TODO: handle exception
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        } finally {
            session.close();
           // sessionFactory.close();
        }
		return null;
	}

	@Override
	public T delete(T pojo) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
             session.delete(pojo);
            transaction.commit();
        } catch (Exception e) {
            // TODO: handle exception
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        } finally {
            session.close();
           // sessionFactory.close();
        }
		return null;
	}

	@Override
	public T update(T pojo) {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.openSession();
	        Transaction transaction = null;
	        try {
	            transaction = session.beginTransaction();
	            session.update(pojo);
	            transaction.commit();
	        } catch (Exception e) {
	            // TODO: handle exception
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            throw e;
	        } finally {
	            session.close();
	            //essionFactory.close();
	        }
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T select(T pojo,Integer id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
        Transaction transaction = null;
        T obj = null;
        try {
            transaction = session.beginTransaction();
           // session.get
            obj = (T) session.get(pojo.getClass(), id);
            transaction.commit();
        } catch (Exception e) {
            // TODO: handle exception
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        } finally {
            session.close();
           // sessionFactory.close();
        }

       return obj;
	}

	@Override
	public T select(T pojo) {
		// TODO Auto-generated method stub
		return null;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public ServiceRegistry getServiceRegistry() {
		return serviceRegistry;
	}

	public Metadata getMetadata() {
		return metadata;
	}
	
	
	

}
