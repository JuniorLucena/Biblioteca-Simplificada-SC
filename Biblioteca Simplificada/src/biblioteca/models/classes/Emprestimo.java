package biblioteca.models.classes;


import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="emprestimos")
public class Emprestimo {
	private int id;
	private Date dataEmpresto;
	private Date dataDevolucao;
	
	@Id
	@GeneratedValue
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
	 
	
	
	
}
