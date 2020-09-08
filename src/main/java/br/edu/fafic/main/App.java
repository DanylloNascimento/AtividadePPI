package br.edu.fafic.main;

import java.util.Arrays;
import java.util.Date;

import br.edu.fafic.domain.Campeonato;
import br.edu.fafic.domain.Jogador;
import br.edu.fafic.domain.Tecnico;
import br.edu.fafic.domain.Time;
import br.edu.fafic.enums.Status;
import br.edu.fafic.persistence.JpaPersistence;

public class App {
	public static void main(String[]args) {
		
		JpaPersistence persistence = new JpaPersistence();
		
		//criando joagador 1
		Jogador jogador1 = new Jogador();
		jogador1.setNome("Ronaldo");
		jogador1.setStatus(Status.TITULAR);
		jogador1.setPosicao("Atacante");
		persistence.save(jogador1);
		
		//criando Tecnico
		Tecnico tecnico1 = new Tecnico();
		tecnico1.setNome("Zidane");
		persistence.save(tecnico1);
		
		//criando Time
		Time time1 = new Time();
		time1.setNome("RealMadrid");
		time1.setJogadores(Arrays.asList((Jogador)persistence.
				findById(Jogador.class, 1l)));
		time1.setTecnico((Tecnico)persistence.findById(Tecnico.class, 2l));
		persistence.save(time1);
		
		//criando campeonato
		Campeonato campeonato1 = new Campeonato();
		campeonato1.setNome("ChampionsLeague");
		campeonato1.setTimesCampeonato(Arrays.asList((Time)persistence.
				findById(Time.class, 1l)));
		campeonato1.setDataInicial(new Date());
		campeonato1.setDataFinal(new Date());
		persistence.save(campeonato1);
		
		//Updade de tecnico para time
		Tecnico t1 = (Tecnico)persistence.findById(Tecnico.class, 2l);
		t1.setTimeTecnico((Time)persistence.findById(Time.class, 1l));
		persistence.update(t1);
		
		//update de time no campeonato
		Time time2 = ((Time)persistence.findById(Time.class, 1l));
		time2.setCampeonatos(Arrays.asList((Campeonato)persistence.findById(Campeonato.class, 1l)));
		persistence.update(time2);
		
		//update de jogador para time
		Jogador jogadotor2 = (Jogador)persistence.findById(Jogador.class, 1l);
		jogadotor2.setTime((Time)persistence.findById(Time.class, 1l));
		persistence.update(jogadotor2);
		
		
		
		
		
		
		
	}
}
