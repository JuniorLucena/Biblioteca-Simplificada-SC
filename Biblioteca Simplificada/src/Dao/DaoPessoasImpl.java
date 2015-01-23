package Dao;

import org.hibernate.Transaction;

import java.util.List;

import org.hibernate.Session;

import org.hibernate.criterion.Restrictions;

import biblioteca.models.classes.Pessoa;

public class DaoPessoasImpl implements DaoPessoa {

	public void save(Pessoa pessoa) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(pessoa);
		t.commit();
	}

	public Pessoa getPessoa(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		return (Pessoa) session.load(Pessoa.class, id);
	}
	
	public Pessoa findByCpf(Long cpf) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		return (Pessoa) session.createCriteria(Pessoa.class)
				.add(Restrictions.eq("cpf", cpf)).uniqueResult();
	}

	public List<Pessoa> list() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		List<Pessoa> lista = session.createQuery("from Pessoa").list();
		t.commit();
		return lista;
	}

	public void remove(Pessoa pessoa) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(pessoa);
		t.commit();
	}

	public void update(Pessoa pessoa) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(pessoa);
		t.commit();
	}
}
