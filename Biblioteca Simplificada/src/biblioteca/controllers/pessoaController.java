package biblioteca.controllers;

import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import Dao.DaoPessoa;
import Dao.DaoPessoasImpl;
import biblioteca.models.classes.Pessoa;


public class pessoaController {
	
	private Pessoa pessoa;
	private DataModel<Pessoa> listaPessoas;
	
	public DataModel<Pessoa> getListarPessoas() {
		List<Pessoa> lista = new DaoPessoasImpl().list();
		listaPessoas = new ListDataModel<Pessoa>(lista);
		return listaPessoas;
		}
	
		public Pessoa getPessoa() {
			return pessoa;
		}
	
		public void setPessoa(Pessoa pessoa) {
			this.pessoa = pessoa;
		}
		
		public String prepararAdicionarPessoa(){
			pessoa = new Pessoa();
			return "gerenciarPessoa";
		}
		
		public String prepararAlterarPessoa(){
			pessoa = (Pessoa)(listaPessoas.getRowData());
			return "gerenciarPessoa";
		}
		
		public String excluirPessoa(){
			Pessoa pessoaTemp = (Pessoa)(listaPessoas.getRowData());
			DaoPessoa dao = new DaoPessoasImpl();
			dao.remove(pessoaTemp);
			return "index";
		}
		
		public String adicionarPessoa(){
			DaoPessoa dao = new DaoPessoasImpl();
			dao.save(pessoa);
			return "index";
		}
		
		public String alterarPessoa(){
			DaoPessoa dao = new DaoPessoasImpl();
			dao.update(pessoa);
			return "index";
		}
	
}
