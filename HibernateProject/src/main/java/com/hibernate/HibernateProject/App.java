package com.hibernate.HibernateProject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Shiva
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("project Started....");
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		/*-------------------Creating  student Object----------------*/

		Student stud = new Student();
		stud.setId(103);
		stud.setName("Shiva");
		stud.setCity("Delhi");
		System.out.println(stud);

		/*-------------------Creating object of Address class---------------------*/

		Address adr = new Address();
		adr.setStreet("Street No 1");
		adr.setCity("Bangalore");
		adr.setIsopen(true);
		adr.setAddedDate(new Date());
		adr.setArea(156.3456);

		/*-------------------Reading Image---------------------*/

		FileInputStream fis = new FileInputStream("src/main/java/adv.jpg");
		byte[] data = new byte[fis.available()];
		fis.read(data);
		adr.setImage(data);
		
		Session session = factory.openSession();
//      session.beginTransaction();
//      session.save(stud);
//      session.getTransaction().commit();

		/*----------------Another  way to write----------------------*/

		Transaction tx = session.beginTransaction();
		session.save(stud);
		session.save(adr);
		tx.commit();
		session.close();
		System.out.println("inserted Successful");
	}

}
