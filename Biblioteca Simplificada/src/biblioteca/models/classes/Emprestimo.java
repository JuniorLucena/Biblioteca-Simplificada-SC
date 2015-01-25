package biblioteca.models.classes;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="emprestimos")
public class Emprestimo {
	private int id;
	@Temporal(TemporalType.DATE)
	private Date dataEmpresto;
	private Date dataDevolucao;
	
		
	@ManyToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
	@JoinColumn(name="pessoa_id")
	private Pessoa pessoa = new Pessoa();
	
	@ManyToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST}, optional=true)
	@JoinColumn(name="livro_id")
	private Livro livro = new Livro();
	
	public Emprestimo(){
		
	}
		
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getDataEmpresto() {
		return dataEmpresto;
	}
	public void setDataEmpresto(Date dataEmpresto) {
		this.dataEmpresto = dataEmpresto;
	}
	public Date getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	@ManyToOne()
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	@ManyToOne()
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	
	@Override
	public String toString() {
		return "Emprestimo [id=" + id + ", dataEmpresto=" + dataEmpresto
				+ ", dataDevolucao=" + dataDevolucao + ", pessoa=" + pessoa
				+ ", livro=" + livro + ", dataString=" + "]";
	}
	
	
	
	
}
