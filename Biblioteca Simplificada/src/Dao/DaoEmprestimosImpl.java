package Dao;

import org.hibernate.Transaction;








import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import biblioteca.controllers.pessoaController;
import biblioteca.models.classes.Emprestimo;
import biblioteca.models.classes.Livro;
import biblioteca.models.classes.Pessoa;


public class DaoEmprestimosImpl implements DaoEmprestimo{
	
	DaoPessoa daoPessoa = new DaoPessoasImpl();
	DaoLivros daoLivros = new DaoLivrosImpl();
	
	
	public void save(Emprestimo emprestimo) {
		Session session = HibernateUtil.getSessionFactory().openSession();			 
		//Pessoa pessoa = (Pessoa) session.get(Pessoa.class, emprestimo.getPessoa().getCpf() );
		Transaction t = session.beginTransaction();
		Long cpf = emprestimo.getPessoa().getCpf();
		String cod = emprestimo.getLivro().getCodigoBarra();
		//livro = daoLivros.findByCodigo(livro.getCodigoBarra());
		int diponiveis = emprestimo.getLivro().getDisponiveis();
		emprestimo.getLivro().setDisponiveis(diponiveis - 1);
		
		session.persist(emprestimo);
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
