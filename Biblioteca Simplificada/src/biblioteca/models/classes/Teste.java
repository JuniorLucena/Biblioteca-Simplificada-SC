package biblioteca.models.classes;

import org.hibernate.Session;

import Dao.HibernateUtil;

public class Teste {
	public static void main(String[] args) {
		 
		Session session =  HibernateUtil.getSessionFactory().openSession();
 
		Livro livro = new Livro();
		livro.setTitulo("dom casmurro"); 
		livro.setVolume(4);
		livro.setExemplares(100);
		livro.setCodigoBarra("234323543");
		livro.setAno(2015);
		livro.setDisponiveis(2);
		livro.setEdicao(3);
		livro.setEstante(10);
		
		//realizando operação para salvar no banco
		session.beginTransaction();
		session.save(livro);
		session.getTransaction().commit();
		session.close();
	}
}
