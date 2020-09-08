package br.edu.fafic.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
	@NamedQuery(name = "timeByCampeonato", query = "select c from Campeonato c where c.nome = :nome")
})
public class Campeonato implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nome", nullable = false, length = 50)
	private String nome;
	
	
	@ManyToMany(mappedBy = "campeonatos")
	private List<Time> timesCampeonato;
	
	@Temporal(TemporalType.DATE)
	private Date dataInicial;

	@Temporal(TemporalType.DATE)
	private Date dataFinal;
	
	public Campeonato() {

	}

	public Campeonato(String nome, List<Time> timesCampeonato, Date dataInicial, Date dataFinal) {
		this.nome = nome;
		this.timesCampeonato = timesCampeonato;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
	}



	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Time> getTimesCampeonato() {
		return timesCampeonato;
	}

	public void setTimesCampeonato(List<Time> timesCampeonato) {
		this.timesCampeonato = timesCampeonato;
	}

	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	@Override
	public String toString() {
		return 	"\n" +
				"Campeonato: " + nome + "\n" +
				"Data Inicial: " + dataInicial + "\n" +
				"Data Final: " + dataFinal + "\n";
	}
}
