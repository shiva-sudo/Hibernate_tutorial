package com.hibernate.HibernateProject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmObjDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Configuration cfg = new Configuration();
//		cfg.configure("hibernate.cfg.xml");
//		SessionFactory factory = cfg.buildSessionFactory();

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Student student = new Student();
		student.setId(2101690);
		student.setName("Nikita");
		student.setCity("Delhi");
		
		
		Certificate certificate = new Certificate();
		certificate.setCourse("Java Full Stack");
		certificate.setDuration("6 Months");
		student.setCerti(certificate);
		
		Student student1 = new Student();
		student1.setId(2101691);
		student1.setName("Ankit");
		student1.setCity("Bangalore");
		
		
		Certificate certificate1 = new Certificate();
		certificate1.setCourse("Spring Boot");
		certificate1.setDuration("3 Months");
		student1.setCerti(certificate1);
		
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		s.save(student);
		s.save(student1);
		
		tx.commit();
		s.close();
		factory.close();

	}

}
