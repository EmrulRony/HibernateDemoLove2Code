package com.solutionia.hibernatedemo.relations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.solutionia.hibernatedemo.entity.Instructor;
import com.solutionia.hibernatedemo.entity.InstructorDetail;

public class CascadedDeleteOneToOne {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, 4);
			// Removing bi-drirectional link to only delete InstructorDetail
			instructorDetail.getInstructor().setInstructorDetail(null);
			session.delete(instructorDetail);
//			System.out.println(instructorDetail.getInstructor());
			
			session.getTransaction().commit();
			System.out.println("Done!!");
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
