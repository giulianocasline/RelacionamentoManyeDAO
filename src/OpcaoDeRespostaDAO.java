import javax.persistence.EntityManager;

public class OpcaoDeRespostaDAO {

	private EntityManager manager;	
	
	public OpcaoDeRespostaDAO(EntityManager manager){		
		this.manager = manager;
	}
	
	public void salvar(OpcaoDeResposta opcaoderesposta){
		
		manager.persist(opcaoderesposta);
	
	}
}
