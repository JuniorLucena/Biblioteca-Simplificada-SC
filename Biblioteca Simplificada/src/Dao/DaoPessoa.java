package Dao;

import java.util.List;

import biblioteca.models.classes.Pessoa;

public interface DaoPessoa {
	public void save(Pessoa pessoa);
	public Pessoa getPessoa(long id);
	public List<Pessoa> list();
	public void remove(Pessoa pessoa);
	public void update(Pessoa pessoa);
}
