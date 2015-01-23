package biblioteca.models.classes;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="livros")
public class Livro implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String titulo;
	private String codigoBarra;
	private int estante;
	private int exemplares;
	private int disponiveis;
	private int ano;
	private int volume;
	private int edicao;
	
	public Livro(){}
	
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


	@Override
	public String toString() {
		return "Livro [id=" + id + ", titulo=" + titulo + ", codigoBarra="
				+ codigoBarra + ", estante=" + estante + ", exemplares="
				+ exemplares + ", disponiveis=" + disponiveis + ", ano=" + ano
				+ ", volume=" + volume + ", edicao=" + edicao + ", autor="
			 + "]";
	}

	
}
