package com.academia.model.dao.personal;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import com.academia.model.models.Personal;

public class PersonalDao extends PersonalGenericDao<Personal, Integer>{
	
	public PersonalDao(EntityManager entityManager) {
		super(entityManager);
	}

	@SuppressWarnings("unchecked")
	public List<Personal> listPersonalPaginacao(int numeroPagina, Integer defaultPagina) {
		
		List<Personal> listaPersonal = new ArrayList<Personal>();
		
		boolean ativo = true;
		
		
		Query query = this.getEntityManager().createQuery("SELECT u FROM Usuario u WHERE u.ativo =:ativo")
											 .setParameter("ativo", ativo)
											 .setFirstResult(numeroPagina)
											 .setMaxResults(defaultPagina);
		listaPersonal = query.getResultList();
		
		return listaPersonal;
	}
}
