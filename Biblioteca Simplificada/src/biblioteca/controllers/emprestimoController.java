package biblioteca.controllers;


import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import Dao.DaoEmprestimo;
import Dao.DaoEmprestimosImpl;
import biblioteca.models.classes.Emprestimo;

@ManagedBean
@SessionScoped
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
			dao.save(emprestimo);
			return "listar";
		}
		
		public String alterarEmprestimo(){
			DaoEmprestimo dao = new DaoEmprestimosImpl();
			dao.update(emprestimo);
			return "listar";
		}
		
		/*public String convertTime(Date time){ 
		    Date date = new Date(); 
		    Format format = new SimpleDateFormat("yyyy MM dd"); 
		    return format.format(date); 
		}*/
	
		
}
