package Dao;

import org.hibernate.Transaction;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import biblioteca.models.classes.Livro;
import biblioteca.models.classes.Pessoa;

public class DaoLivrosImpl implements DaoLivros{
	
	public void save(Livro livro) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(livro);
		t.commit();
		}
	
	public Livro getLivro(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		return (Livro) session.load(Livro.class, id);
		}
	
	public List<Livro> list() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		List<Livro> lista = session.createQuery("from Livro").list();
		t.commit();
		return lista;
		}
	
	public Livro findByCodigo(String codigoBarra){
		Session session = HibernateUtil.getSessionFactory().openSession();
		return (Livro) session.createCriteria(Livro.class)
				.add(Restrictions.eq("codigoBarra", codigoBarra)).uniqueResult();
	}
	
	
	public void remove(Livro livro) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(livro);
		t.commit();
		}
	
	public void update(Livro livro) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(livro);
		t.commit();
		}
}
