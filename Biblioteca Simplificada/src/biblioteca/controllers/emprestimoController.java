package biblioteca.controllers;

import java.util.List;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import Dao.DaoEmprestimo;
import Dao.DaoEmprestimosImpl;
import biblioteca.models.classes.Emprestimo;

public class emprestimoController {
	
	private Emprestimo emprestimo;
	private DataModel<Emprestimo> listaEmprestimos;
	
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
			return "gerenciarEmprestimo";
		}
		
		public String prepararAlterarEmprestimo(){
			emprestimo = (Emprestimo)(listaEmprestimos.getRowData());
			return "gerenciarEmprestimo";
		}
		
		public String excluirEmprestimo(){
			Emprestimo emprestimoTemp = (Emprestimo)(listaEmprestimos.getRowData());
			DaoEmprestimo dao = new DaoEmprestimosImpl();
			dao.remove(emprestimoTemp);
			return "index";
		}
		
		public String adicionarEmprestimo(){
			DaoEmprestimo dao = new DaoEmprestimosImpl();
			dao.save(emprestimo);
			return "index";
		}
		
		public String alterarEmprestimo(){
			DaoEmprestimo dao = new DaoEmprestimosImpl();
			dao.update(emprestimo);
			return "index";
		}
	
}
