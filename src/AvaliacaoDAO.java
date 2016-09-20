import javax.persistence.EntityManager;

public class AvaliacaoDAO {
	
	private EntityManager manager;	
	
	public AvaliacaoDAO(EntityManager manager){		
		this.manager = manager;
	}
	
	public Avaliacao encontrarPorId(Long id){
		return manager.find(Avaliacao.class, id);
	}
	
	public void salvar(Avaliacao avaliacao){

		manager.persist(avaliacao);
	
	}

}
