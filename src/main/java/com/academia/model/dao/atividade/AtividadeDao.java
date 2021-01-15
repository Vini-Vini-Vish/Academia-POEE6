package com.academia.model.dao.atividade;

import javax.persistence.EntityManager;
import com.academia.model.models.Atividade;

public class AtividadeDao extends AtividadeGenericDao <Atividade, Integer> {

	public AtividadeDao(EntityManager entityManager) {
		super(entityManager);		
	}

}
