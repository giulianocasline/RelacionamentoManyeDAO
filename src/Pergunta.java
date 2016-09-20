import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Pergunta {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String descricao;
	
	@ManyToMany(mappedBy = "perguntas")
	private List<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();

	@ManyToMany(cascade=CascadeType.ALL)
	private List<OpcaoDeResposta> opcoesDeRespostas = new ArrayList<OpcaoDeResposta>();
	
	@ManyToOne
	private Tipo tipo; 
	
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

	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

	public List<OpcaoDeResposta> getOpcoesDeRespostas() {
		return opcoesDeRespostas;
	}

	public void setOpcoesDeRespostas(List<OpcaoDeResposta> opcoesDeRespostas) {
		this.opcoesDeRespostas = opcoesDeRespostas;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	public Double media(Avaliacao avaliacao){
		
		Double media = 0d;
		
		for (Resposta resposta : avaliacao.getRespostas()) {
						
			if(resposta.getPergunta().getId().equals(getId())){
			media += resposta.getNota();	
			
			}
		}

		return media / avaliacao.getRespostas().size();
		
		
	}
	
	public Pergunta(String descricao){
		this.descricao=descricao;
	}

	
	public Pergunta(){}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pergunta other = (Pergunta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
