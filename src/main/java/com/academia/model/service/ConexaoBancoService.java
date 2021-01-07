package com.academia.model.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import com.academia.estrutura.persistencia.ConexaoBancoDados;
import com.academia.estrutura.util.VariaveisProjeto;

public abstract class ConexaoBancoService {
	
	@PersistenceContext(unitName = VariaveisProjeto.PERSISTENCE_UNIT_NAME)
	private final EntityManager entityManager;
	
	public ConexaoBancoService() {
		this.entityManager = ConexaoBancoDados.getConexaoBancoDados().getEntityManager();
	}
	
	public EntityTransaction getTransaction() {
		return this.getEntityManager().getTransaction();
	}
	
	public void close() {
		if(this.getEntityManager().isOpen()) {
			this.getEntityManager().close();
		}		
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}	
}
