package com.hibernate.HibernateProject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetDetails {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		/*-------------we can write same in this way -----------*/

//		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session session = factory.openSession();
		
		/* load() method first will create proxy.
		 * when we use object then it fire the Query 
		 * 
		 * Note :-  In the below statement only one time query will run 
		 * 			when use Object then run query
		 */
		
		Student student = (Student)session.load(Student.class, 102);
		System.out.println(student.getName()+ " : "+student.getCity());
		
		Student student1 = (Student)session.load(Student.class, 102);
		System.out.println(student1.getName()+ " : "+student1.getCity());
		
		/* get() method first will check if data is present in session,
		 * then return if not then hit query in database 
		 * 
		 * Note :-  In the below statement only one time query will run 
		 * 			because data is already present in session 
		 */
		
		Address adr = session.get(Address.class, 2);
		System.out.println(adr.getStreet()+ " : "+adr.getCity());
		Address adr1 = session.get(Address.class, 2);
		System.out.println(adr.getStreet()+ " : "+adr1.getCity());

		
		session.close();
		factory.close();

	}

}
