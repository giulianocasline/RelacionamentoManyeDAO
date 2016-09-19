import javax.persistence.EntityManager;

public class CursoDAO {
	
	private EntityManager manager;	
	
	public CursoDAO(EntityManager manager){		
		this.manager = manager;
	}
	
	public void salvar(Curso curso){
		manager.getTransaction().begin();
		manager.persist(curso);
		manager.getTransaction().commit();		
	}

}
