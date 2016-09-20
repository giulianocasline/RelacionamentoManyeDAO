import javax.persistence.EntityManager;

public class AlunoDAO {
	
	private EntityManager manager;	
	
	public AlunoDAO(EntityManager manager){		
		this.manager = manager;
	}
	
	public Aluno encontrarPorId(Long id){
		return manager.find(Aluno.class, id);
	}
	
	public void salvar(Aluno aluno){
	
		manager.persist(aluno);
			
	}
	

}
