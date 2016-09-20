import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Avaliacao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String descricao;
		
	@ManyToMany(cascade=CascadeType.ALL)
	private List<Pergunta> perguntas = new ArrayList<Pergunta>();
	
	@OneToMany(mappedBy = "avaliacao")
	private List<Resposta> respostas = new ArrayList<Resposta>();
		
	public List<Resposta> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<Resposta> respostas) {
		this.respostas = respostas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Pergunta> getPerguntas() {
		return perguntas;
	}

	public void setPerguntas(List<Pergunta> perguntas) {
		this.perguntas = perguntas;
	}
	
	public Avaliacao(String descricao){
		this.descricao=descricao;
	}

	public Double media(){
		
		Double avaliacaoTotal = 0d;
		Double media = 0d;
		
		for (Resposta avaliacaoReposta : getRespostas()) {
		
			if(avaliacaoReposta.getAvaliacao().getId().equals(getId())){
				
				avaliacaoTotal =+ avaliacaoReposta.getNota();
			}
				
		}
			 media = avaliacaoTotal / getRespostas().size();
				return media;
	}
	
}
