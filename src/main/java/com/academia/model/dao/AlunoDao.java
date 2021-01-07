package com.academia.model.dao;

import javax.persistence.EntityManager;
import com.academia.model.models.Aluno;

public class AlunoDao extends AlunoGenericDao <Aluno, Integer> {
	
	public AlunoDao(EntityManager entityManager) {
		super(entityManager);
	}

}
