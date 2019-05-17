package com.solutionia.hibernatedemo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.solutionia.hibernatedemo.entity.Student;

public class CreateStudentDemo {
	public static void main(String[] args) {
		SessionFactory sessionFactory=new Configuration()
										  .configure("hibernate.cfg.xml")
										  .addAnnotatedClass(Student.class)
										  .buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		try {
			Student student = new Student("Robin","Hood","robin@gmail.com");
//			Student student1 = new Student("Soloj","Khan","sojol@gmail.com");
//			Student student2 = new Student("Sam","Jonston","sal@gmail.com");
//			Student student3 = new Student("Kevin","Smith","kevin@gmail.com");
			
			session.beginTransaction();
			session.save(student);
//			session.save(student1);
//			session.save(student2);
//			session.save(student3);
			session.getTransaction().commit();
			System.out.println("Student saved!!");
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
