import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Pergunta {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String descricao;
	
	@ManyToOne
	private Tipo tipo;
	
	@ManyToMany
	private List<OpcaoDeResposta> opcoesDeRespostas;
	
	@ManyToMany(mappedBy = "perguntas")
	private List<Avaliacao> avaliacoes ;
	
	
	@OneToMany(mappedBy = "pergunta")
	private List<Resposta> respostas;
	
	public List<Resposta> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<Resposta> respostas) {
		this.respostas = respostas;
	}

	public Pergunta(){
				
	}

	public Pergunta(String descricao,Tipo tipo) {		
		this.descricao = descricao;
		this.tipo = tipo;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public List<OpcaoDeResposta> getOpcoesDeRespostas() {
		return opcoesDeRespostas;
	}

	public void setOpcoesDeRespostas(List<OpcaoDeResposta> opcoesDeRespostas) {
		this.opcoesDeRespostas = opcoesDeRespostas;
	}

	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}
	
	public Double mediaPergunta(Avaliacao avaliacao){
		Double valorNota = 0d;
		Double mediap = 0d;
		
		for (Resposta resposta : getRespostas()) {
			if(resposta.getAvaliacao().equals(avaliacao)){
			valorNota += resposta.getNota();}
		}
		mediap = valorNota/ getRespostas().size();
		return mediap;
	}
	
	public Pergunta(String descricao){
		this.descricao=descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		if (id != other.id)
			return false;
		return true;
	}
	
	
}