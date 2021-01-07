package com.academia.model.dao;

import javax.persistence.EntityManager;

import com.academia.model.models.Usuario;

public class UsuarioDao extends GenericDao<Usuario, Integer>{

	public UsuarioDao(EntityManager entityManager) {
		super(entityManager);
	}

}
