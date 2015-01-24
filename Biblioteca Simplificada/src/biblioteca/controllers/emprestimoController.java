package biblioteca.controllers;


import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Dao.DaoEmprestimo;
import Dao.DaoEmprestimosImpl;
import Dao.DaoLivros;
import Dao.DaoLivrosImpl;
import Dao.DaoPessoa;
import Dao.DaoPessoasImpl;
import Dao.HibernateUtil;
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
	private DataModel<Emprestimo> listarDevolucao;
	
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
	
	
	public DataModel<Emprestimo> getEmprestados() {
		DaoEmprestimo dao = new DaoEmprestimosImpl();						
		return new ListDataModel<Emprestimo>(dao.findEmprestimos());  
	}
	
	public DataModel<Emprestimo> realizarDevolucao() {
		DaoEmprestimo dao = new DaoEmprestimosImpl();						
		return new ListDataModel<Emprestimo>(dao.findDevolucoes());  
	}
	
	
	
	
	/*public Emprestimo findByIdentificador(long cpf, String codigoBarra){
		for (Emprestimo emprestimos : listaEmprestimos) {

			if(emprestimos.getPessoa().getCpf()== cpf){

				if(emprestimos.getLivro().getCodigoBarra().equals(codigoBarra)){
					return emprestimos;
				}else{
					//System.out.println("O cpf"+cpf+"n�o possui o livro"+codigoBarra+"Emprestado");
				}
			}

		}

		
		/*public String convertTime(Date time){ 
		    Date date = new Date(); 
		    Format format = new SimpleDateFormat("yyyy MM dd"); 
		    return format.format(date); 
		}*/
		
	
	}
	
