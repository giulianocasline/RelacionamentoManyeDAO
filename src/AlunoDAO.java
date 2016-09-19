import javax.persistence.EntityManager;

public class AlunoDAO {
	
	private EntityManager manager;	
	
	public AlunoDAO(EntityManager manager){		
		this.manager = manager;
	}
	
	public void salvar(Aluno aluno){
		manager.getTransaction().begin();
		manager.persist(aluno);
		manager.getTransaction().commit();		
	}
	

}
