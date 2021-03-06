package com.academia.model.dao.aluno;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.academia.model.dao.usuario.GenericDao;
import com.academia.model.models.Aluno;

public class AlunoDao extends GenericDao <Aluno, Integer> {
	
	public AlunoDao(EntityManager entityManager) {
		super(entityManager);
	}

	@SuppressWarnings("unchecked")
	public List<Aluno> listAlunoPaginacao(int numeroPagina, Integer defaultPagina) {
		
		List<Aluno> listaAluno = new ArrayList<Aluno>();
		
		boolean ativo = true;
		
		
		Query query = this.getEntityManager().createQuery("SELECT u FROM Atividade u WHERE u.ativo =:ativo")								
											 .setParameter("ativo", ativo)
											 .setFirstResult(numeroPagina)
											 .setMaxResults(defaultPagina);
		listaAluno = query.getResultList();
		
		return listaAluno;
	}
}
