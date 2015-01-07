package Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import biblioteca.models.classes.Autor;

public class DaoAutorImpl implements DaoAutor {

	public void save(Autor autor) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(autor);
		t.commit();
		}
	
	public Autor getAutor(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		return (Autor) session.load(Autor.class, id);
		}
	
	public List<Autor> list() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		List<Autor> lista = session.createQuery("from Autor").list();
		t.commit();
		return lista;
		}
	
	public void remove(Autor autor) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(autor);
		t.commit();
		}
	
	public void update(Autor autor) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(autor);
		t.commit();
		}
	
}
