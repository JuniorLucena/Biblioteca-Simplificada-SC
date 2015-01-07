package biblioteca.controllers;

import java.util.List;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import Dao.DaoEditora;
import Dao.DaoEditorasImpl;
import biblioteca.models.classes.Editora;

public class editoraController {
	
	private Editora editora;
	private DataModel<Editora> listaEditoras;
	
	public DataModel<Editora> getListarEditoras() {
		List<Editora> lista = new DaoEditorasImpl().list();
		listaEditoras = new ListDataModel<Editora>(lista);
		return listaEditoras;
		}
	
		public Editora getEditora() {
			return editora;
		}
	
		public void setEditora(Editora editora) {
			this.editora = editora;
		}
		
		public String prepararAdicionarEditora(){
			editora = new Editora();
			return "gerenciarEditora";
		}
		
		public String prepararAlterarEditora(){
			editora = (Editora)(listaEditoras.getRowData());
			return "gerenciarEditoras";
		}
		
		public String excluirEditora(){
			Editora editoraTemp = (Editora)(listaEditoras.getRowData());
			DaoEditora dao = new DaoEditorasImpl();
			dao.remove(editoraTemp);
			return "index";
		}
		
		public String adicionarEditora(){
			DaoEditora dao = new DaoEditorasImpl();
			dao.save(editora);
			return "index";
		}
		
		public String alterarEditora(){
			DaoEditora dao = new DaoEditorasImpl();
			dao.update(editora);
			return "index";
		}
	
}
