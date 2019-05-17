package com.solutionia.hibernatedemo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.solutionia.hibernatedemo.entity.Student;

public class ReadStudent {
	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory=new Configuration()
		.configure("hibernate.cfg.xml")
		.addAnnotatedClass(Student.class)
		.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			Student student = session.get(Student.class, 1);
			
			System.out.println(student);
			session.getTransaction().commit();
		}
		catch(Exception ex ) {
			ex.printStackTrace();
		}
		
	}

}
