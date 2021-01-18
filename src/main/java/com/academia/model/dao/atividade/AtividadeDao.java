package com.academia.model.dao.atividade;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import com.academia.model.models.Atividade;

public class AtividadeDao extends AtividadeGenericDao <Atividade, Integer> {

	public AtividadeDao(EntityManager entityManager) {
		super(entityManager);		
	}

	@SuppressWarnings("unchecked")
	public List<Atividade> listAtividadePaginacao(int numeroPagina, Integer defaultPagina) {
		List<Atividade> listaAtividade = new ArrayList<Atividade>();
		
		boolean ativo = true;
		
		
		Query query = this.getEntityManager().createQuery("SELECT u FROM Usuario u WHERE u.ativo =:ativo")
											 .setParameter("ativo", ativo)
											 .setFirstResult(numeroPagina)
											 .setMaxResults(defaultPagina);
		listaAtividade = query.getResultList();
		
		return listaAtividade;
	}

}
