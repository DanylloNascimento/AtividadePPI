package br.edu.fafic.persistence;

import java.util.List;
import br.edu.fafic.domain.Campeonato;
import br.edu.fafic.domain.Jogador;
import br.edu.fafic.domain.Pessoa;
import br.edu.fafic.domain.Time;
import br.edu.fafic.enums.Status;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JpaPersistence {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Exemplo_PU");
	private EntityManager em = emf.createEntityManager();

	public void getEm() {
		if (em == null || !em.isOpen()) {
			em = emf.createEntityManager();
		}
	}

	public void save(Object object) {
		getEm();
		em.getTransaction().begin();
		em.persist(object);
		em.getTransaction().commit();
		em.close();
	}

	public Object findById(Class clazz, Long id) {
		getEm();
		em.getTransaction().begin();
		Object obj = em.find(clazz, id);
		em.getTransaction().commit();
		em.close();
		return obj;
	}

	public void update(Object object) {
		getEm();
		em.getTransaction().begin();
		em.merge(object);
		em.getTransaction().commit();
		em.close();
	}

	public Pessoa pessoaByNome(String nome) {

		getEm();
		try {

			Query query = em.createNamedQuery("pessoaByNome");
			query.setParameter("nome", nome);
			return (Pessoa) query.getSingleResult();

		} catch (NoResultException nre) {
			return null;
		}
	}

	public List<Jogador> jogadorByStatus(int codigo) {
		em = emf.createEntityManager();
		Status status = (Status) Status.toEnum(codigo);
		Query query = em.createNamedQuery("jogadorByStatus");
		query.setParameter("status", status);
		return query.getResultList();
	}

	public Jogador jogadorByEquipe(String nome) {
		getEm();
		try {

			Query query = em.createNamedQuery("jogadorByEquipe");
			query.setParameter("nome", nome);
			return (Jogador) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;

		}

	}

	public Campeonato campeonatoByNome(String nome) {

		getEm();

		try {
			Query query = em.createNamedQuery("timeByCampeonato");
			query.setParameter("nome", nome);
			return (Campeonato) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;

		}

	}

	public Time timeByNome(String nome) {
		getEm();

		try {
			Query query = em.createNamedQuery("timeByNome");
			query.setParameter("nome", nome);
			return (Time) query.getSingleResult();

		} catch (NoResultException nre) {
			return null;

		}
	}

	public Time timeByJogador(String nome) {
		getEm();

		try {
			Query query = em.createNamedQuery("timeByJogador");
			query.setParameter("nome", nome);
			return (Time) query.getSingleResult();

		} catch (NoResultException nre) {
			return null;

		}

	}

	public List<Time> timeByCampeonato(String nome) {
		getEm();
		Query query = em.createNamedQuery("timeByCampeonatoByNome");
		query.setParameter("nome", nome);
		return query.getResultList();
	}
}
