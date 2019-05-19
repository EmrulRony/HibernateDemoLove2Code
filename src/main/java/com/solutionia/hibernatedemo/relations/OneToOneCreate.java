package com.solutionia.hibernatedemo.relations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.solutionia.hibernatedemo.entity.Instructor;
import com.solutionia.hibernatedemo.entity.InstructorDetail;

public class OneToOneCreate {
	
	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
							.addAnnotatedClass(Instructor.class)
							.addAnnotatedClass(InstructorDetail.class)
							.buildSessionFactory();
		Session session=factory.getCurrentSession();
		
		try {
			Instructor instructor = new Instructor ("Abul","Kasem","ronyemrul@gmail.com");
			InstructorDetail instructorDetail = new InstructorDetail("youtube/abulkasem", "football");
			instructor.setInstructorDetail(instructorDetail);
			session.beginTransaction();
			System.out.println("Saving Instructor....");
			session.save(instructor);
			session.getTransaction().commit();
			System.out.println("Saved!!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

}
