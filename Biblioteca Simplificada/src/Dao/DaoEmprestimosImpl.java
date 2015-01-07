package Dao;

import org.hibernate.Transaction;
import java.util.List;
import org.hibernate.Session;


import biblioteca.models.classes.Emprestimo;

public class DaoEmprestimosImpl implements DaoEmprestimo{
	
	public void save(Emprestimo emprestimo) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(emprestimo);
		t.commit();
		}
	
	public Emprestimo getEmprestimo(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		return (Emprestimo) session.load(Emprestimo.class, id);
		}
	
	public List<Emprestimo> list() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		List<Emprestimo> lista = session.createQuery("from Emprestimo").list();
		t.commit();
		return lista;
		}
	
	public void remove(Emprestimo emprestimo) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(emprestimo);
		t.commit();
		}
	
	public void update(Emprestimo emprestimo) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(emprestimo);
		t.commit();
		}
}
