package Dao;

import org.hibernate.Transaction;
import java.util.List;
import org.hibernate.Session;


import biblioteca.models.classes.Editora;

public class DaoEditorasImpl implements DaoEditora{
	
	public void save(Editora editora) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(editora);
		t.commit();
		}
	
	public Editora getEditora(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		return (Editora) session.load(Editora.class, id);
		}
	
	public List<Editora> list() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		List<Editora> lista = session.createQuery("from Editora").list();
		t.commit();
		return lista;
		}
	
	public void remove(Editora editora) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(editora);
		t.commit();
		}
	
	public void update(Editora editora) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(editora);
		t.commit();
		}
}
