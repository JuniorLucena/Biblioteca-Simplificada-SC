package biblioteca.controllers;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import Dao.DaoLivros;
import Dao.DaoLivrosImpl;
import biblioteca.models.classes.Livro;

@ManagedBean
@SessionScoped
public class livroController {
	private Livro livro;
	private DataModel<Livro> listaLivros;

	public DataModel<Livro> getListarLivros() {
		List<Livro> lista = new DaoLivrosImpl().list();
		listaLivros = new ListDataModel<Livro>(lista);
		return listaLivros;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public String prepararAdicionarLivro() {
		livro = new Livro();
		return "form";
	}

	public String prepararAlterarLivro() {
		livro = (Livro) (listaLivros.getRowData());
		return "alterar";
	}

	public String excluirLivro() {
		Livro livroTemp = (Livro) (listaLivros.getRowData());
		DaoLivros dao = new DaoLivrosImpl();
		dao.remove(livroTemp);
		return "index";
	}

	public String adicionarLivro() {
		DaoLivros dao = new DaoLivrosImpl();
		dao.save(livro);
		return "listar";
	}

	public String alterarLivro() {
		DaoLivros dao = new DaoLivrosImpl();
		dao.update(livro);
		return "listar";
	}
	
	public void updateQuantidadeExemplaresDisponiveis(Livro livro, int quantidade){
		livro.setDisponiveis(quantidade);
	}
}