import javax.persistence.EntityManager;

public class PerguntaDAO {
	
	private EntityManager manager;	
	
	public PerguntaDAO(EntityManager manager){		
		this.manager = manager;
	}
	
	public Pergunta encontrarPorId(Long id){
		return manager.find(Pergunta.class, id);
	}
	
	public void salvar(Pergunta pergunta){
	
		manager.persist(pergunta);
	
	}

}
