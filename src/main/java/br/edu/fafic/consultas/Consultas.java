package br.edu.fafic.consultas;

import br.edu.fafic.persistence.JpaPersistence;

public class Consultas {

	public static void main(String[] args) {
	
		
		JpaPersistence persistence = new JpaPersistence();
		
     	System.out.println("Buscar Jogador pelo nome: " + persistence.pessoaByNome("Ronaldo"));
		System.out.println("Buscar Jogador por status: " + persistence.jogadorByStatus(1));
		System.out.println("buscar Jogador pelo time: " + persistence.jogadorByEquipe("RealMadrid"));
	
		
		System.out.println("Buscar Time pelo nome: " + persistence.timeByNome("RealMadrid"));
		System.out.println("Buscar Time por jogador: " + persistence.timeByJogador("Ronaldo"));
		System.out.println("Buscar Time por campeonato: " + persistence.timeByCampeonato("ChampionsLeague"));
		
		
		System.out.println("Buscar Tecnico pelo nome: " + persistence.pessoaByNome("Zidane"));

		System.out.println("Buscar Campeonato pelo nome: " + persistence.campeonatoByNome("ChampionsLeague"));
	}

}
