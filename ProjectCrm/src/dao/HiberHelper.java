package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HiberHelper {

	static Configuration cfg; 
	static SessionFactory sf;
	static Session s;
	public static void configure()
	{
		cfg= new Configuration();
		cfg.configure("hibernate.cfg.xml");
		sf = cfg.buildSessionFactory();
		s= sf.openSession();
	}
	public static Query dqlOperation(String query)
	{
		return s.createQuery(query);
	}
	public static void dmlInsert(Object c)
	{
		Transaction tx = s.beginTransaction();
		s.save(c);
	    tx.commit();
	    s.close();
		
	}
	public static void dmlUpdate(Object c)
	{
		Transaction tx = s.beginTransaction();
		s.update(c);
	    tx.commit();
	    s.close();
		
	}
	public static void dmlDelete(Object c)
	{
		Transaction tx = s.beginTransaction();
		s.delete(c);
	    tx.commit();
	    s.close();
		
	}
	public static void closeConn()
	{
		s.close();
	}
}
