import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Disciplina {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String descricao;
	
	@ManyToOne
	private Professor professor; 
	
	@ManyToOne
	private Curso curso; 
	
	@OneToMany(mappedBy = "disciplina")
	private List<Resposta> respostas = new ArrayList<Resposta>();

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

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	
	public List<Resposta> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<Resposta> respostas) {
		this.respostas = respostas;
	}
	
	public Disciplina(){}

	
	public Double media(Avaliacao avaliacao, Disciplina disciplina){
		
		Double media = 0d;
		Double mediaDisciplina = 0d;
		
		for (Resposta resposta : getRespostas()) {
			
			if(resposta.getAvaliacao().equals(avaliacao) && resposta.getDisciplina().equals(disciplina)){
					
				mediaDisciplina =+ resposta.getNota();
			}
				
		}
	
		media = mediaDisciplina / getRespostas().size();
		return media;
	}
	
	
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
		Disciplina other = (Disciplina) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}

	
