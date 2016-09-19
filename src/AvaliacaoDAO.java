import javax.persistence.EntityManager;

public class AvaliacaoDAO {
	
	private EntityManager manager;	
	
	public AvaliacaoDAO(EntityManager manager){		
		this.manager = manager;
	}
	
	public void salvar(Avaliacao avaliacao){
		manager.getTransaction().begin();
		manager.persist(avaliacao);
		manager.getTransaction().commit();		
	}

}
