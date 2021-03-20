package com.ggsliquor.DemoHib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) 
    {
		/*
		 * Alien hemraj = new Alien(); hemraj.setAid(103); hemraj.setAname("AJ");
		 * hemraj.setColor("Yellow");
		 * 
		 * Configuration con = new
		 * Configuration().configure().addAnnotatedClass(Alien.class);
		 * SessionFactory sf= con.buildSessionFactory();
		 * Session session = sf.openSession();
         * org.hibernate.Transaction tx = session.beginTransaction();
         * session.save(hemraj);
         * tx.commit();
		 */
    	
    	Laptop laptop =new Laptop();
    	laptop.setId(101);
    	laptop.setLname("Dell");
    	
    	Student student = new Student();
    	student.setRollno(1);
    	student.setSname("HSharma");
    	student.setMarks(100);
    //	student.setLaptop(laptop);
    	student.getLaptop().add(laptop);
    	
    	Configuration config = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
    	ServiceRegistry registry = (ServiceRegistry) new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
    	
       SessionFactory sf = config.buildSessionFactory(registry);
        
        Session session = sf.openSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.save(laptop);
        session.save(student);
        
        session.getTransaction().commit();
    }
}
