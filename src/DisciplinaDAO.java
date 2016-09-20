import javax.persistence.EntityManager;

public class DisciplinaDAO {
	
	private EntityManager manager;	
	
	public DisciplinaDAO(EntityManager manager){		
		this.manager = manager;
	}
	
	public Disciplina encontrarPorId(Long id){
		return manager.find(Disciplina.class, id);
	}
	

	
	public void salvar(Disciplina disciplina){
	
		manager.persist(disciplina);
		
	}

}
