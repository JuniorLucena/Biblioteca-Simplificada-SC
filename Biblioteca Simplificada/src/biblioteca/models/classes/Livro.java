package biblioteca.models.classes;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="livros")
public class Livro implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String titulo;
	private String codigoBarra;
	private int estante;
	private int exemplares;
	private int disponiveis;
	private int ano;
	private int volume;
	private int edicao;
	
	@ManyToMany
	private Autor autor;
	
	
	public Livro(){}
	
	public Livro(int id, String titulo, String codigoBarra, int estante,
			int exemplares, int disponiveis, int ano, int volume, int edicao) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.codigoBarra = codigoBarra;
		this.estante = estante;
		this.exemplares = exemplares;
		this.disponiveis = disponiveis;
		this.ano = ano;
		this.volume = volume;
		this.edicao = edicao;
	}
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getCodigoBarra() {
		return codigoBarra;
	}
	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}
	public int getEstante() {
		return estante;
	}
	public void setEstante(int estante) {
		this.estante = estante;
	}
	public int getExemplares() {
		return exemplares;
	}
	public void setExemplares(int exemplares) {
		this.exemplares = exemplares;
	}
	public int getDisponiveis() {
		return disponiveis;
	}
	public void setDisponiveis(int disponiveis) {
		this.disponiveis = disponiveis;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public int getEdicao() {
		return edicao;
	}
	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}

}
