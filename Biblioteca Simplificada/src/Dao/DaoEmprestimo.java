package Dao;


import java.util.List;

import biblioteca.models.classes.Emprestimo;
import biblioteca.models.classes.Pessoa;


public interface DaoEmprestimo {
	public void save(Emprestimo emprestimo);
	public Emprestimo getEmprestimo(long id);
	public List<Emprestimo> list();
	public void remove(Emprestimo emprestimo);
	public void update(Emprestimo emprestimo);
	public List<Emprestimo> findEmprestimos();	
	public List<Emprestimo> findDevolucoes();
	
	public List<Emprestimo> findByIdentificador(Long cpf, String codigoBarra);
}