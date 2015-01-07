package biblioteca.controllers;

import java.util.List;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import Dao.DaoAutor;
import Dao.DaoAutorImpl;
import biblioteca.models.classes.Autor;

public class autorController {

	private Autor autor;
	private DataModel<Autor> listaAutores;
	
	public DataModel<Autor> getListarAutor() {
		List<Autor> lista = new DaoAutorImpl().list();
		listaAutores = new ListDataModel<Autor>(lista);
		return listaAutores;
		}
	
		public Autor getAutor() {
			return autor;
		}
	
		public void setLivro(Autor autor) {
			this.autor = autor;
		}
		
		public String prepararAdicionarAutor(){
			autor = new Autor();
			return "gerenciarAutor";
		}
		
		public String prepararAlterarAutor(){
			autor = (Autor)(listaAutores.getRowData());
			return "gerenciarAutor";
		}
		
		public String excluirAutor(){
			Autor autorTemp = (Autor)(listaAutores.getRowData());
			DaoAutor dao = new DaoAutorImpl();
			dao.remove(autorTemp);
			return "index";
		}
		
		public String adicionarAutor(){
			DaoAutor dao = new DaoAutorImpl();
			dao.save(autor);
			return "index";
		}
		
		public String alterarAutor(){
			DaoAutor dao = new DaoAutorImpl();
			dao.update(autor);
			return "index";
		}
}
