package com.bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.EnumSet;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
import org.junit.Test;

import com.fasterxml.classmate.AnnotationConfiguration;
import com.gameorm.db.dao.BaseGameDaoImpl;
import com.gameorm.db.dao.UserGameDaoImpl;  
  
  
  
/** 
 * ��hbm����ddl 
 * 
 */  
public class ExportDB {  
  
    /** 
     * @param args 
     */  
	//@Test
    public  void test() {  

        InputStream in = ExportDB.class.getClassLoader().getResourceAsStream("hibernate.properties");
        Properties properties = new Properties();
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    	//properties.
    	//ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(properties).build();
    	Metadata metadata = new MetadataSources(serviceRegistry).addAnnotatedClass(User.class).buildMetadata();
        SchemaExport schemaExport = new SchemaExport();
        //schemaExport.create ��ɾ���� ���½����� ����
        schemaExport.createOnly(EnumSet.of(TargetType.DATABASE), metadata);
    	System.out.println("success:" + Thread.currentThread().getName()+" state:"+Thread.currentThread().getState());
    	User user = new User();
    	user.setName("1874");
    	SessionFactory sessionFactory = metadata.buildSessionFactory();  
    	try {
			save(sessionFactory, user);
			User queryUser = queryById(sessionFactory, 2);
			System.out.println(queryUser.toString());
			queryUser.setAddress("�л��۹�");
			update(sessionFactory, queryUser);
			queryUser = queryById(sessionFactory, 2);
			System.out.println(queryUser.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			  StandardServiceRegistryBuilder.destroy( serviceRegistry);  
		}
    	System.exit(0);
    	
    }
    
    
    public static void save(SessionFactory sessionFactory,User user) throws Exception {
        System.out.println("����User����");
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            // TODO: handle exception
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        } finally {
        	session.close();
            //sessionFactory.close();
        }
    }
    
    /**
     * @param id
     * @return
     * @throws Exception
     */
    public static User queryById(SessionFactory sessionFactory,Integer id) throws Exception {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        User user = null;
        try {
            transaction = session.beginTransaction();
            user = (User) session.get(User.class, id);
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

        return user;
    }


    /**
     * @param user
     *            ��֪id��Userʵ����
     * @throws Exception
     */
    public static void update(SessionFactory sessionFactory,User user) throws Exception {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(user);
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
    }

    /**
     * @param user
     *            Ҫɾ����user,�Ѿ����浽���ݿ��,id����
     * @throws Exception
     */
    public static void delete(SessionFactory sessionFactory,User user) throws Exception {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete("User", user);
            transaction.commit();
        } catch (Exception e) {
            // TODO: handle exception
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        } finally {
            session.close();
            sessionFactory.close();
        }
    }


    @Test
    public void test1(){
    	BaseGameDaoImpl<User> userDao = new UserGameDaoImpl();
    	User user = new User();
    	user.setCreateTime(new Date(System.currentTimeMillis()));
    	user.setId(1778);
    	user.setName("������");
    	user.setPassword("1235");
    	user.setAddress("������");
    	userDao.save(user);
    	
    	System.out.println(userDao.select(user, 17).toString());
    }
}  