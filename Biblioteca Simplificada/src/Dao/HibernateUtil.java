package Dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import biblioteca.models.classes.Autor;
import biblioteca.models.classes.Editora;
import biblioteca.models.classes.Emprestimo;
import biblioteca.models.classes.Livro;
import biblioteca.models.classes.Pessoa;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	 
	private HibernateUtil() {
	}
	 
	public static SessionFactory getSessionFactory() {
	if (sessionFactory == null) {
	try {
	// Create the SessionFactory from standard (hibernate.cfg.xml)
	// config file.
	AnnotationConfiguration ac = new AnnotationConfiguration();
	ac.addAnnotatedClass(Livro.class);
	ac.addAnnotatedClass(Autor.class);
	ac.addAnnotatedClass(Editora.class);
	ac.addAnnotatedClass(Emprestimo.class);
	ac.addAnnotatedClass(Pessoa.class);
	sessionFactory = ac.configure().buildSessionFactory();
	} catch (Throwable ex) {
	// Log the exception.
	System.err.println("Initial SessionFactory creation failed." + ex);
	throw new ExceptionInInitializerError(ex);
	}
	return sessionFactory;
	} else {
	return sessionFactory;
	}
	}}
