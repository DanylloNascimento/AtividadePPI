package br.edu.fafic.domain;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import br.edu.fafic.enums.Status;

@Entity
@DiscriminatorColumn(name = "idPessoa")
@NamedQueries({
	@NamedQuery(name = "jogadorByStatus", query = "select j from Jogador j where j.status = :status"),
	@NamedQuery(name = "jogadorByEquipe", query = "select j from Jogador j join j.time t where t.nome = :nome")
})
public class Jogador extends Pessoa{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.ORDINAL)
	private Status status;	
	
	private String posicao;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private Time time;
	
	public Jogador() {

	}

	public Jogador(Status status, String posicao, Time time) {
		super();
		this.status = status;
		this.posicao = posicao;
		this.time = time;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getPosicao() {
		return posicao;
	}

	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return 	"Jogador" + super.getNome() + "\n" +
				"Status: " + status + "\n" + 
				"Joga Em: " + time.getNome() + "\n" +
				"Posição: " + posicao;
	}

	
}
