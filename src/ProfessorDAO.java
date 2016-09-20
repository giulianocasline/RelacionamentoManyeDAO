import javax.persistence.EntityManager;

public class ProfessorDAO {
	
	private EntityManager manager;	
	
	public ProfessorDAO(EntityManager manager){		
		this.manager = manager;
	}
	
	public void salvar(Professor professor){
	
		manager.persist(professor);
	
	}

}
