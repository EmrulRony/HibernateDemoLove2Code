package com.solutionia.hibernatedemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.solutionia.hibernatedemo.entity.Student;

public class ReadAll {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			Query<Student> query =session.createQuery("Select S from Student S");
			List<Student> studentList = query.getResultList();
			for (Student student : studentList) {
				System.out.println(student);
			}
		}
		catch (Exception ex) {
			System.out.println(ex);
		}
	}

}
