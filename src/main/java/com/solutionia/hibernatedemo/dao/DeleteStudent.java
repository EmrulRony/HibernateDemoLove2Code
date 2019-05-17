package com.solutionia.hibernatedemo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.solutionia.hibernatedemo.entity.Student;

public class DeleteStudent {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			Student student = session.get(Student.class, 9);
			session.delete(student);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		finally {
			System.out.println("Student deleted!!");
			session.getTransaction().commit();
		}
	}

}
