package Dao;

import java.util.List;

import biblioteca.models.classes.Emprestimo;


public interface DaoEmprestimo {
	public void save(Emprestimo emprestimo);
	public Emprestimo getEmprestimo(long id);
	public List<Emprestimo> list();
	public void remove(Emprestimo emprestimo);
	public void update(Emprestimo emprestimo);
}