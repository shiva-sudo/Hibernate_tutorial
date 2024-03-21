package com.hibernate.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MapDemo {
	public static void main(String[] args) {

		/*----create session factory object */

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		/*-----Creating  Question class object-----*/

		Question que1 = new Question();
		que1.setQuestionId(101);
		que1.setQuestion("what is java");

		/*-----Creating  Question class object-----*/

		Answer ans1 = new Answer();
		ans1.setAnswerId(301);
		ans1.setAnswer("Java  is a programming  language");
		ans1.setQuestion(que1);
		que1.setAnswer(ans1);

		Question que2 = new Question();
		que2.setQuestionId(102);
		que2.setQuestion("What is collection Frmework");

		/*-----Creating  Question class object-----*/

		Answer ans2 = new Answer();
		ans2.setAnswerId(302);
		ans2.setAnswer("Collection framework is API to work with objects in java");
		ans2.setQuestion(que2);
		que2.setAnswer(ans2);

		Question que3 = new Question();
		que3.setQuestionId(103);
		que3.setQuestion("What is maven");

		/*-----Creating  Question class object-----*/

		Answer ans3 = new Answer();
		ans3.setAnswerId(303);
		ans3.setAnswer("Maven is a build tool which help to download project dependencies");
		ans3.setQuestion(que3);
		que3.setAnswer(ans3);

		/*--------open/create Session------*/

		Session session = factory.openSession();
		session.beginTransaction();

		/*--------save------*/
		session.save(que1);
		session.save(que2);
		session.save(que3);
		session.save(ans1);
		session.save(ans2);
		session.save(ans3);

		session.getTransaction().commit();

		/*--------Fetching the value------*/

		Question newq = session.get(Question.class, 103);
		System.out.println(newq.getQuestion());
		System.out.println(newq.getAnswer().getAnswer());

		session.close();

	}
}
