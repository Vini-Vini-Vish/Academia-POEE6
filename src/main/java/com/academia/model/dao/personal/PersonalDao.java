package com.academia.model.dao.personal;

import javax.persistence.EntityManager;

import com.academia.model.models.Personal;

public class PersonalDao extends PersonalGenericDao<Personal, Integer>{
	
	public PersonalDao(EntityManager entityManager) {
		super(entityManager);
	}	
}
