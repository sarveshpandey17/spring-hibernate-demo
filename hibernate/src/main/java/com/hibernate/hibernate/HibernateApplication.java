package com.hibernate.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.hibernate.boot.Metadata;
import org.hibernate.SessionFactory;


@SpringBootApplication
public class HibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateApplication.class, args);
		student s1=new student();
		s1.setID(2);		
		s1.setname("Sarvesh");
		s1.setStudentClass("BSC-CS");
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure().build();
		Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory sf=meta.getSessionFactoryBuilder().build();
		Session session=sf.openSession();
		Transaction t=session.beginTransaction(); //Transaction ke bina data safe tarike se DB me store nahi hoga.
		// Transaction ensure karta hai ki agar koi error aaya toh rollback ho sake. 
		session.persist(s1);
		t.commit(); //Ye transaction ko commit kar raha hai. Matlab ab data permanently DB me save ho gaya
		System.out.println("Successfully update");
		sf.close();
		session.close();
	}

}
