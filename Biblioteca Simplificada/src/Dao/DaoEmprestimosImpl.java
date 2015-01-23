package Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import biblioteca.models.classes.Emprestimo;

public class DaoEmprestimosImpl implements DaoEmprestimo {
	
	Session session;
	
	public DaoEmprestimosImpl() {
		session = HibernateUtil.getSessionFactory().openSession();
	}

	public void save(Emprestimo emprestimo) {
		Transaction t = session.beginTransaction();
		session.save(emprestimo);
		t.commit();
	}

	public Emprestimo getEmprestimo(long id) {
		return (Emprestimo) session.load(Emprestimo.class, id);
	}

	public List<Emprestimo> list() {		
		return session.createCriteria(Emprestimo.class).list();
	}

	public void remove(Emprestimo emprestimo) {
		Transaction t = session.beginTransaction();
		session.delete(emprestimo);
		t.commit();
	}

	public void update(Emprestimo emprestimo) {
		Transaction t = session.beginTransaction();
		session.update(emprestimo);
		t.commit();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Emprestimo> findDevolucoes() {		
		return session.createCriteria(Emprestimo.class)
				.add(Restrictions.isNotNull("dataDevolucao"))
				.list();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Emprestimo> findEmprestimos() {
		return session.createCriteria(Emprestimo.class)
				.add(Restrictions.isNull("dataDevolucao"))
				.list();
	}

}
