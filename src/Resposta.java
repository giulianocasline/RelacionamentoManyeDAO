import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Resposta {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private double nota;
	
	@ManyToOne
	private Pergunta pergunta;
	
	@ManyToOne
	private Avaliacao avaliacao;
	
	@ManyToOne
	private Disciplina disciplina;
	
	@ManyToOne
	private Aluno aluno;
	
	@ManyToOne
	private OpcaoDeResposta opcaoDeResposta;

	public Resposta(){
		
		
	}
	public Resposta(Double nota,Pergunta pergunta, Avaliacao avaliacao, Disciplina disciplina, Aluno aluno, OpcaoDeResposta opcaoDeResposta) {		
		this.nota = nota;
		this.pergunta = pergunta;
		this.avaliacao = avaliacao;
		this.disciplina = disciplina;
		this.aluno = aluno;
		this.opcaoDeResposta = opcaoDeResposta;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public OpcaoDeResposta getOpcaoDeResposta() {
		return opcaoDeResposta;
	}

	public void setOpcaoDeResposta(OpcaoDeResposta opcaoDeResposta) {
		this.opcaoDeResposta = opcaoDeResposta;
	}
	

	
}