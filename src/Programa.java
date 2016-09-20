

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Programa {

	public static void main(String[] args) {
		
		JPAUtil util = new JPAUtil();
		
		//criando todos os daos
		AlunoDAO alunoDAO = new AlunoDAO(util.criarEntityManager());
		AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO(util.criarEntityManager());
		CursoDAO cursoDAO = new CursoDAO(util.criarEntityManager());
		DisciplinaDAO disciplinaDAO = new DisciplinaDAO(util.criarEntityManager());
		OpcaoDeRespostaDAO opcaoderespostaDAO = new OpcaoDeRespostaDAO(util.criarEntityManager());
		PerguntaDAO perguntaDAO = new PerguntaDAO(util.criarEntityManager());
		ProfessorDAO professorDAO = new ProfessorDAO(util.criarEntityManager());
		RespostaDAO respostaDAO = new RespostaDAO(util.criarEntityManager());
		TipoDAO tipoDAO = new TipoDAO(util.criarEntityManager());
		
		util.abrirTransacao();				
		
		Tipo multiplaescolha = new Tipo("Multipla Escolha");
		Tipo multiplaescolha2 = new Tipo("nota");
		
		//salvando os objetos
	
		tipoDAO.salvar(multiplaescolha);
		tipoDAO.salvar(multiplaescolha2);



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
		
		//salvando os objetos
	
				alunoDAO.salvar(aluno1);
				alunoDAO.salvar(aluno2);
				alunoDAO.salvar(aluno3);
				alunoDAO.salvar(aluno4);
				alunoDAO.salvar(aluno5);
				alunoDAO.salvar(aluno6);
				alunoDAO.salvar(aluno7);
				alunoDAO.salvar(aluno8);
				alunoDAO.salvar(aluno9);
				alunoDAO.salvar(aluno10);
				
		

		Professor professor1 = new Professor("professor1", "ra1");
		Professor professor2 = new Professor("professor2", "ra2");
		
		//salvando os objetos
			
				professorDAO.salvar(professor1);
				professorDAO.salvar(professor2);
			
		

		Curso curso1 = new Curso("disciplina1");
		Curso curso2 = new Curso("disciplina2");
		
		//salvando os objetos
			
				cursoDAO.salvar(curso1);
				cursoDAO.salvar(curso2);

		
		OpcaoDeResposta opcao1 = new OpcaoDeResposta("Otimo");
		OpcaoDeResposta opcao2 = new OpcaoDeResposta("Bom");
		OpcaoDeResposta opcao3 = new OpcaoDeResposta("Regular");
		OpcaoDeResposta opcao4 = new OpcaoDeResposta("Ruim");
		OpcaoDeResposta opcao5 = new OpcaoDeResposta("Pessimo");
		
		//salvando os objetos
			
				opcaoderespostaDAO.salvar(opcao1);
				opcaoderespostaDAO.salvar(opcao2);
				opcaoderespostaDAO.salvar(opcao3);
				opcaoderespostaDAO.salvar(opcao4);
				opcaoderespostaDAO.salvar(opcao5);
	
	
		
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
		
		//salvando os objetos
				
				perguntaDAO.salvar(perguntas);
				perguntaDAO.salvar(perguntas2);
			

		Avaliacao avaliacao = new Avaliacao("1");
		avaliacao.setPerguntas(new ArrayList<Pergunta>());
		avaliacao.getPerguntas().add(perguntas);
		avaliacao.getPerguntas().add(perguntas2);
		
		avaliacaoDAO.salvar(avaliacao);
		perguntaDAO.salvar(perguntas2);

		Disciplina disciplina1 = new Disciplina();
		disciplina1.setDescricao("descricao");
		disciplina1.setCurso(curso1);
		disciplina1.setProfessor(professor1);

		Disciplina disciplina2 = new Disciplina();
		disciplina2.setDescricao("descricao");
		disciplina2.setCurso(curso2);
		disciplina2.setProfessor(professor2);
		
		disciplinaDAO.salvar(disciplina1);
		disciplinaDAO.salvar(disciplina2);


		Resposta resposta = new Resposta();
		resposta.setNota(10);
		resposta.setAluno(aluno1);
		resposta.setAvaliacao(avaliacao);
		resposta.setDisciplina(disciplina1);
		resposta.setOpcaoDeResposta(opcao1);
		resposta.setPergunta(perguntas);
		
		respostaDAO.salvar(resposta);
		
		Aluno aluno = alunoDAO.encontrarPorId(50l);               
		Avaliacao avaliacaoFinal = avaliacaoDAO.encontrarPorId(63l); 
		
		System.out.println("A média do aluno é: " + aluno.media(avaliacaoFinal));
		
		
		Disciplina disciplina = disciplinaDAO.encontrarPorId(65l);
				
		System.out.println("A média do aluno na disciplina é " + disciplina.media(avaliacao, disciplina));
		
		System.out.println("A média do aluno na avaliação é " + avaliacao.media());
		
		Pergunta pergunta = perguntaDAO.encontrarPorId(88l);
		
		System.out.println("A média do aluno na pergunta é " + pergunta.media(avaliacao));
		
		
		
		util.commitarTransacao();
		util.fecharManager();
		util.fecharFactory();

		

	}

}