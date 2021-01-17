package com.academia.model.dao.usuario;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import com.academia.model.models.user.Usuario;

public class UsuarioDao extends GenericDao<Usuario, Integer>{

	public UsuarioDao(EntityManager entityManager) {
		super(entityManager);
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> listUsuarioPaginacao(int numeroPagina, Integer defaultPagina) {
		
		List<Usuario> listaUsuario = new ArrayList<Usuario>();
		
		boolean ativo = true;
		
		
		Query query = this.getEntityManager().createQuery("SELECT u FROM Usuario u WHERE u.ativo =:ativo")
											 .setParameter("ativo", ativo)
											 .setFirstResult(numeroPagina)
											 .setMaxResults(defaultPagina);
		listaUsuario = query.getResultList();
		
		return listaUsuario;
	}

}
