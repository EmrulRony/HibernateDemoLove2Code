package com.solutionia.hibernatedemo.relations;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.solutionia.hibernatedemo.entity.Course;
import com.solutionia.hibernatedemo.entity.Instructor;
import com.solutionia.hibernatedemo.entity.InstructorDetail;

public class OneToMany {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Course.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Instructor.class).buildSessionFactory();

		try {
			Session session = sessionFactory.getCurrentSession();
			Course course = new Course("Sociology");
			
			session.beginTransaction();
			Instructor instructor = session.get(Instructor.class, 3);
			course.setInstructor(instructor);
			instructor.getCourse().add(course);
			session.save(course);
			session.getTransaction().commit();
			System.out.println("Done!!");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
