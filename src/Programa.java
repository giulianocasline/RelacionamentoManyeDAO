

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Programa {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("relacionamentomany");
		EntityManager manager = factory.createEntityManager();
		


		Tipo tipo1 = new Tipo();
		tipo1.setDescricao("multipla escolha");

		Tipo tipo2 = new Tipo();
		tipo2.setDescricao("nota");

		manager.getTransaction().begin();
		manager.persist(tipo1);
		manager.persist(tipo2);
		manager.getTransaction().commit();


		

		Aluno aluno1 = new Aluno();
		aluno1.setNome("nome1");
		aluno1.setRa("ra1");

		Aluno aluno2 = new Aluno();
		aluno2.setNome("nome2");
		aluno2.setRa("ra2");

		Aluno aluno3 = new Aluno();
		aluno3.setNome("nome3");
		aluno3.setRa("ra3");

		Aluno aluno4 = new Aluno();
		aluno4.setNome("nome4");
		aluno4.setRa("ra4");

		Aluno aluno5 = new Aluno();
		aluno5.setNome("nome5");
		aluno5.setRa("ra5");

		Aluno aluno6 = new Aluno();
		aluno6.setNome("nome6");
		aluno6.setRa("ra6");

		Aluno aluno7 = new Aluno();
		aluno7.setNome("nome7");
		aluno7.setRa("ra7");

		Aluno aluno8 = new Aluno();
		aluno8.setNome("nome8");
		aluno8.setRa("ra8");

		Aluno aluno9 = new Aluno();
		aluno9.setNome("nome9");
		aluno9.setRa("ra9");

		Aluno aluno10 = new Aluno();
		aluno10.setNome("nome10");
		aluno10.setRa("ra10");

		manager.getTransaction().begin();
		manager.persist(aluno1);
		manager.persist(aluno2);
		manager.persist(aluno3);
		manager.persist(aluno4);
		manager.persist(aluno5);
		manager.persist(aluno6);
		manager.persist(aluno7);
		manager.persist(aluno8);
		manager.persist(aluno9);
		manager.persist(aluno10);
		manager.getTransaction().commit();
		


		

		Professor professor1 = new Professor();
		professor1.setNome("professor1");
		professor1.setRa("ra1");

		Professor professor2 = new Professor();
		professor2.setNome("professor2");
		professor2.setRa("ra2");

		manager.getTransaction().begin();
		manager.persist(professor1);
		manager.persist(professor2);
		manager.getTransaction().commit();


		

		Curso curso = new Curso();
		curso.setDescricao("disciplina1");
		curso.setDescricao("disciplina2");

		manager.getTransaction().begin();
		manager.persist(curso);
		manager.getTransaction().commit();
		


		
		
		OpcaoDeResposta opcao1 = new OpcaoDeResposta();
		opcao1.setDescricao("otimo");
	

		OpcaoDeResposta opcao2 = new OpcaoDeResposta();
		opcao2.setDescricao("bom");
		

		OpcaoDeResposta opcao3 = new OpcaoDeResposta();
		opcao3.setDescricao("regular");
		

		OpcaoDeResposta opcao4 = new OpcaoDeResposta();
		opcao4.setDescricao("ruim");


		OpcaoDeResposta opcao5 = new OpcaoDeResposta();
		opcao5.setDescricao("pessimo");
	

		manager.getTransaction().begin();
		manager.persist(opcao1);
		manager.persist(opcao2);
		manager.persist(opcao3);
		manager.persist(opcao4);
		manager.persist(opcao5);
		manager.getTransaction().commit();



		
		Pergunta perguntas = new Pergunta();
		perguntas.setDescricao("descricao");
		perguntas.setOpcoesDeRespostas(new ArrayList<OpcaoDeResposta>());
		perguntas.getOpcoesDeRespostas().add(opcao1);
		perguntas.getOpcoesDeRespostas().add(opcao2);
		perguntas.getOpcoesDeRespostas().add(opcao3);
		perguntas.getOpcoesDeRespostas().add(opcao4);
		perguntas.getOpcoesDeRespostas().add(opcao5);
		perguntas.setTipo(tipo1);
		
		Pergunta perguntas2 = new Pergunta();
		perguntas2.setDescricao("descricao2");
		perguntas2.setOpcoesDeRespostas(new ArrayList<OpcaoDeResposta>());
		perguntas2.getOpcoesDeRespostas().add(opcao1);
		perguntas2.getOpcoesDeRespostas().add(opcao2);
		perguntas2.getOpcoesDeRespostas().add(opcao3);
		perguntas2.getOpcoesDeRespostas().add(opcao4);
		perguntas2.getOpcoesDeRespostas().add(opcao5);
		perguntas2.setTipo(tipo2);

		manager.getTransaction().begin();
		manager.persist(perguntas);
		manager.persist(perguntas2);
		manager.getTransaction().commit();
		



		Avaliacao avaliacao = new Avaliacao();
		avaliacao.setDescricao("1");
		avaliacao.setPerguntas(new ArrayList<Pergunta>());
		avaliacao.getPerguntas().add(perguntas);
		avaliacao.getPerguntas().add(perguntas2);
		
		manager.getTransaction().begin();
		manager.persist(avaliacao);
		manager.getTransaction().commit();


		

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