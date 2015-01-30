package biblioteca.controllers;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
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

	private Emprestimo emprestimo;
	private DataModel<Emprestimo> listaEmprestimos;
	private DataModel<Emprestimo> listarDevolucao;

	public emprestimoController() {
		emprestimo = new Emprestimo();
	}

	public DataModel<Emprestimo> getListarEmprestimos() {
		List<Emprestimo> lista = new DaoEmprestimosImpl().findEmprestimos();
		listaEmprestimos = new ListDataModel<Emprestimo>(lista);
		return listaEmprestimos;
	}

	public DataModel<Emprestimo> getListarDevolucao() {
		List<Emprestimo> lista = new DaoEmprestimosImpl().findDevolucoes();
		listarDevolucao = new ListDataModel<Emprestimo>(lista);
		return listarDevolucao;
	}

	public Emprestimo getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}

	public String prepararAdicionarEmprestimo() {
		emprestimo = new Emprestimo();
		return "form";
	}

	public String prepararAlterarEmprestimo() {
		emprestimo = (Emprestimo) (listaEmprestimos.getRowData());
		return "alterar";
	}

	public String excluirEmprestimo() {
		Emprestimo emprestimoTemp = (Emprestimo) (listaEmprestimos.getRowData());
		DaoEmprestimo dao = new DaoEmprestimosImpl();
		dao.remove(emprestimoTemp);
		return "listar";
	}

	public String adicionarEmprestimo() {

		DaoEmprestimo dao = new DaoEmprestimosImpl();
		Date dataEmprestimo = new Date();

		Pessoa pessoa = daoPessoa.findByCpf(emprestimo.getPessoa().getCpf());
		Livro livro = daoLivro.findByCodigo(emprestimo.getLivro()
				.getCodigoBarra());

		if (pessoa.getCpf() != null && livro.getCodigoBarra() != null) {
			emprestimo.setPessoa(daoPessoa.findByCpf(emprestimo.getPessoa()
					.getCpf()));
			emprestimo.setLivro(daoLivro.findByCodigo(emprestimo.getLivro()
					.getCodigoBarra()));
			emprestimo.setDataEmpresto(dataEmprestimo);
			dao.save(emprestimo);

			FacesContext context = FacesContext.getCurrentInstance();

			FacesMessage mensagem = new FacesMessage(
					FacesMessage.SEVERITY_INFO, "Emprestimo efetuado",
					"com sucesso");
			context.addMessage(null, mensagem);

		} else {
			FacesContext context = FacesContext.getCurrentInstance();

			FacesMessage mensagem = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Emprestimo n�o efetuado",
					"com sucesso");
			context.addMessage(null, mensagem);

		}
		return "listar";
	}

	public String adicionarDevolucao() {

		DaoEmprestimo dao = new DaoEmprestimosImpl();

		Pessoa pessoa = daoPessoa.findByCpf(emprestimo.getPessoa().getCpf());
		Livro livro = daoLivro.findByCodigo(emprestimo.getLivro()
				.getCodigoBarra());

		if (pessoa.getCpf() != null && livro.getCodigoBarra() != null) {
			listarDevolucao = new ListDataModel<Emprestimo>( dao.findByIdentificador(pessoa.getCpf(), livro.getCodigoBarra() ));
			

			if (listarDevolucao != null) {
				emprestimo.setDataDevolucao(new Date());
				int diponiveis = emprestimo.getLivro().getDisponiveis() + 1;
				emprestimo.getLivro().setDisponiveis(diponiveis);
				
				
				
				FacesContext context = FacesContext.getCurrentInstance();
				FacesMessage mensagem = new FacesMessage("msg",
						"Devolução efetuado com sucesso");
				context.addMessage(null, mensagem);
			} else {
				FacesContext context = FacesContext.getCurrentInstance();

				FacesMessage mensagem = new FacesMessage("msg",
						"Emprestimo não existe!");
				context.addMessage(null, mensagem);

			}
		} else {
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage mensagem = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Devolução não efetuado",
					"com sucesso");
			context.addMessage(null, mensagem);
		}

		return "listarDevolucao";
	}

	public String alterarEmprestimo() {
		DaoEmprestimo dao = new DaoEmprestimosImpl();
		dao.update(emprestimo);
		return "listar";
	}

	public DataModel<Emprestimo> getEmprestados() {
		DaoEmprestimo dao = new DaoEmprestimosImpl();
		return new ListDataModel<Emprestimo>(dao.findEmprestimos());
	}

	public String prepararDevolverEmprestimo() {
		// emprestimo = new Emprestimo();
		return "formDevolucao";
	}

	/*
	 * public DataModel<Emprestimo> realizarDevolucao() { DaoEmprestimo dao =
	 * new DaoEmprestimosImpl();
	 * 
	 * Long cpf = emprestimo.getPessoa().getCpf(); String codigoBarra =
	 * emprestimo.getLivro().getCodigoBarra();
	 * 
	 * Date dataDevolucao = new Date(); Emprestimo emp =
	 * dao.findByIdentificador(cpf, codigoBarra); ((List<Emprestimo>)
	 * listarDevolucao).add(emp); emprestimo.setDataDevolucao(dataDevolucao);
	 * int diponiveis = emprestimo.getLivro().getDisponiveis();
	 * emprestimo.getLivro().setDisponiveis(diponiveis + 1);
	 * 
	 * return new ListDataModel<Emprestimo>(dao.findDevolucoes()); }
	 */

}
