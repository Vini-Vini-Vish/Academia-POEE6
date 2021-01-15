package com.academia.model.dao.usuario;

import javax.persistence.EntityManager;

import com.academia.model.models.user.Usuario;

public class UsuarioDao extends GenericDao<Usuario, Integer>{

	public UsuarioDao(EntityManager entityManager) {
		super(entityManager);
	}

}
