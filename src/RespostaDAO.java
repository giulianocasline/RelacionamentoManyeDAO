import javax.persistence.EntityManager;

public class RespostaDAO {
	private EntityManager manager;	
	
	public RespostaDAO(EntityManager manager){		
		this.manager = manager;
	}
	
	public void salvar(Resposta resposta){

		manager.persist(resposta);
		
	}

}
