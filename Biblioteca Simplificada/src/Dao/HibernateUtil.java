package Dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import biblioteca.models.classes.Autor;
import biblioteca.models.classes.Editora;
import biblioteca.models.classes.Emprestimo;
import biblioteca.models.classes.Livro;
import biblioteca.models.classes.Pessoa;

public class HibernateUtil {
private static final SessionFactory sessionFactory;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
