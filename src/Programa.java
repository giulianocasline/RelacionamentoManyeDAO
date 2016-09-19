

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Programa {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("relacionamentomany");
		EntityManager manager = factory.createEntityManager();
		
		Tipo multiplaescolha = new Tipo("Multipla Escolha");
		Tipo multiplaescolha2 = new Tipo("nota");


		Aluno aluno1 = new Aluno("nome1", "ra1");
		Aluno aluno2 = new Aluno("nome2", "ra2");
		Aluno aluno3 = new Aluno("nome3", "ra3");
		Aluno aluno4 = new Aluno("nome4", "ra4");
		Aluno aluno5 = new Aluno("nome5", "ra5");
		Aluno aluno6= new Aluno("nome6", "ra6");
		Aluno aluno7 = new Aluno("nome7", "ra7");
		Aluno aluno8 = new Aluno("nome8", "ra8");
		Aluno aluno9 = new Aluno("nome9", "ra9");
		Aluno aluno10 = new Aluno("nome10", "ra10");
		

		Professor professor1 = new Professor("professor1", "ra1");
		Professor professor2 = new Professor("professor2", "ra2");
		

		Curso curso1 = new Curso("disciplina1");
		Curso curso2 = new Curso("disciplina2");
		

		
		OpcaoDeResposta opcao1 = new OpcaoDeResposta("Otimo");
		OpcaoDeResposta opcao2 = new OpcaoDeResposta("Bom");
		OpcaoDeResposta opcao3 = new OpcaoDeResposta("Regular");
		OpcaoDeResposta opcao4 = new OpcaoDeResposta("Ruim");
		OpcaoDeResposta opcao5 = new OpcaoDeResposta("Pessimo");
	

		


		
		Pergunta perguntas = new Pergunta("descricao");
		perguntas.setOpcoesDeRespostas(new ArrayList<OpcaoDeResposta>());
		perguntas.getOpcoesDeRespostas().add(opcao1);
		perguntas.getOpcoesDeRespostas().add(opcao2);
		perguntas.getOpcoesDeRespostas().add(opcao3);
		perguntas.getOpcoesDeRespostas().add(opcao4);
		perguntas.getOpcoesDeRespostas().add(opcao5);
		perguntas.setTipo(multiplaescolha);
		
		Pergunta perguntas2 = new Pergunta("descricao2");
		perguntas2.setOpcoesDeRespostas(new ArrayList<OpcaoDeResposta>());
		perguntas2.getOpcoesDeRespostas().add(opcao1);
		perguntas2.getOpcoesDeRespostas().add(opcao2);
		perguntas2.getOpcoesDeRespostas().add(opcao3);
		perguntas2.getOpcoesDeRespostas().add(opcao4);
		perguntas2.getOpcoesDeRespostas().add(opcao5);
		perguntas2.setTipo(multiplaescolha);

		Avaliacao avaliacao = new Avaliacao("1");
		
		avaliacao.setPerguntas(new ArrayList<Pergunta>());
		avaliacao.getPerguntas().add(perguntas);
		avaliacao.getPerguntas().add(perguntas2);
		


		Disciplina disciplina1 = new Disciplina();
		disciplina1.setDescricao("descricao");
		disciplina1.setCurso(curso);
		disciplina1.setProfessor(professor1);

		Disciplina disciplina2 = new Disciplina();
		disciplina2.setDescricao("descricao");
		disciplina2.setCurso(curso);
		disciplina2.setProfessor(professor2);

		manager.getTransaction().begin();
		manager.persist(disciplina1);
		manager.persist(disciplina2);
		manager.getTransaction().commit();

	


		Resposta resposta = new Resposta();
	    
		resposta.setNota(10);
		resposta.setAluno(aluno1);
		resposta.setAvaliacao(avaliacao);
		resposta.setDisciplina(disciplina1);
		resposta.setOpcaoDeResposta(opcao1);
		resposta.setPerguta(perguntas);
		

		manager.getTransaction().begin();
		manager.persist(resposta);
		manager.getTransaction().commit();
	}

}