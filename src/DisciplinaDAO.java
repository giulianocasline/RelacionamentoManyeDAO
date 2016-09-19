import javax.persistence.EntityManager;

public class DisciplinaDAO {
	
	private EntityManager manager;	
	
	public DisciplinaDAO(EntityManager manager){		
		this.manager = manager;
	}
	
	public void salvar(Disciplina disciplina){
		manager.getTransaction().begin();
		manager.persist(disciplina);
		manager.getTransaction().commit();		
	}

}
