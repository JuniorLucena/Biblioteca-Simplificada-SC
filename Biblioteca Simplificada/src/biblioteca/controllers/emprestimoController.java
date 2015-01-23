package biblioteca.controllers;


import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import Dao.DaoEmprestimo;
import Dao.DaoEmprestimosImpl;
import Dao.DaoLivros;
import Dao.DaoLivrosImpl;
import Dao.DaoPessoa;
import Dao.DaoPessoasImpl;
import biblioteca.models.classes.Emprestimo;
import biblioteca.models.classes.Livro;
import biblioteca.models.classes.Pessoa;

@ManagedBean
@SessionScoped
public class emprestimoController {

   
	private DaoPessoa daoPessoa = new DaoPessoasImpl();
	private DaoLivros daoLivro = new DaoLivrosImpl();
	public Pessoa pessoa;
	public Livro livro;
	
	
	private Emprestimo emprestimo;
	private DataModel<Emprestimo> listaEmprestimos;
	
	public emprestimoController() {}
	

	public DataModel<Emprestimo> getListarEmprestimos() {
		List<Emprestimo> lista = new DaoEmprestimosImpl().list();
		listaEmprestimos = new ListDataModel<Emprestimo>(lista);
		return listaEmprestimos;
	}
		
	
	public Emprestimo getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}

	public String prepararAdicionarEmprestimo(){
		emprestimo = new Emprestimo();
		return "form";
	}

	public String prepararAlterarEmprestimo(){
		emprestimo = (Emprestimo)(listaEmprestimos.getRowData());
		return "alterar";
	}

	public String excluirEmprestimo(){
		Emprestimo emprestimoTemp = (Emprestimo)(listaEmprestimos.getRowData());
		DaoEmprestimo dao = new DaoEmprestimosImpl();
		dao.remove(emprestimoTemp);
		return "listar";
	}

	public String adicionarEmprestimo(){
		DaoEmprestimo dao = new DaoEmprestimosImpl();
		
		Date dataEmprestimo = new Date();
				
		emprestimo.setDataEmpresto(dataEmprestimo);
								
		dao.save(emprestimo);
		return "listar";
	}
	
	
	public String alterarEmprestimo(){
		DaoEmprestimo dao = new DaoEmprestimosImpl();
		dao.update(emprestimo);
		return "listar";
	}


	/*public Emprestimo findByIdentificador(long cpf, String codigoBarra){
		for (Emprestimo emprestimos : listaEmprestimos) {

			if(emprestimos.getPessoa().getCpf()== cpf){

				if(emprestimos.getLivro().getCodigoBarra().equals(codigoBarra)){
					return emprestimos;
				}else{
					//System.out.println("O cpf"+cpf+"não possui o livro"+codigoBarra+"Emprestado");
				}
			}

		}

		return null;
	}*/
	
	

}
