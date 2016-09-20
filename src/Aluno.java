import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Aluno {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String ra;
	private String nome;
	
	@OneToMany(mappedBy = "aluno")
	private List<Resposta> respostas = new ArrayList<Resposta>();
			
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRa() {
		return ra;
	}
	public void setRa(String ra) {
		this.ra = ra;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Aluno(String nome,String ra){
		this.nome=nome;
		this.ra=ra;
				
	}
	
	public List<Resposta> getRespostas() {
		return respostas;
	}
	public void setRespostas(List<Resposta> respostas) {
		this.respostas = respostas;
	}
	
	public Aluno(){
		
	}
	
	public Double media(Avaliacao avaliacao){
		
		Double media = 0d;
		Double mediaAluno = 0d;
		
	for (Resposta alunoReposta : getRespostas()) {
			
		if(alunoReposta.getAvaliacao().equals(avaliacao)){
				
			mediaAluno =+ alunoReposta.getNota();
		}
			
	}
		 media = mediaAluno / getRespostas().size();
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
		Aluno other = (Aluno) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
