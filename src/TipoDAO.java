import javax.persistence.EntityManager;

public class TipoDAO {
	
	private EntityManager manager;	
	
	public TipoDAO(EntityManager manager){		
		this.manager = manager;
	}
	
	public void salvar(Tipo tipo){
	
		manager.persist(tipo);
	
	}

}
