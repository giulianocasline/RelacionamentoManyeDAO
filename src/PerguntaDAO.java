import javax.persistence.EntityManager;

public class PerguntaDAO {
	
	private EntityManager manager;	
	
	public PerguntaDAO(EntityManager manager){		
		this.manager = manager;
	}
	
	public void salvar(Pergunta pergunta){
		manager.getTransaction().begin();
		manager.persist(pergunta);
		manager.getTransaction().commit();		
	}

}
