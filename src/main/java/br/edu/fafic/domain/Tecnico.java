package br.edu.fafic.domain;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorColumn(name = "idPessoa")
public class Tecnico extends Pessoa{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(cascade = CascadeType.MERGE)
	private Time timeTecnico;
	
	public Tecnico() {
		
	}

	public Tecnico(Time timeTecnico) {
		this.timeTecnico = timeTecnico;
	}

	public Time getTimeTecnico() {
		return timeTecnico;
	}

	public void setTimeTecnico(Time timeTecnico) {
		this.timeTecnico = timeTecnico;
	}

	@Override
	public String toString() {
		return "Tecnico "+ super.getNome() + "treinaTime=" + getTimeTecnico() + "]";
	}

}
