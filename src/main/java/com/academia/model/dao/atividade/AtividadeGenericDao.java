package com.academia.model.dao.atividade;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public abstract class AtividadeGenericDao <Atividade, IdAtividade extends Serializable>{
	
	private EntityManager entityManager;	
	
	private final Class<Atividade> classePersistencia;
	
	//-----------------------------------------------------------------//
	
	@SuppressWarnings("unchecked")
	public AtividadeGenericDao(EntityManager entityManager) {
		this.entityManager = entityManager;
		this.classePersistencia = (Class<Atividade>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	//-----------------------------------------------------------------//
	
	public void save(Atividade entity) {
		this.getEntityManager().persist(entity);
	}
	
	public void update(Atividade entity) {
		this.getEntityManager().merge(entity);
	}
	
	public void remove(Atividade entity) {
		this.getEntityManager().remove(entity);
	}
	
	public Atividade findById(IdAtividade IdAtividade) {
		return this.getEntityManager().find(getClassePersistencia(), IdAtividade);
	}

	//-----------------------------------------------------------------//
	
	@SuppressWarnings("unchecked")
	 public List<Atividade> findAll(Class<Atividade> classe){
		 List<Atividade> lista = new ArrayList<>();
		 Query query = this.getEntityManager().createQuery("SELECT o FROM "+classe.getSimpleName()+" o");
		 
		 lista = query.getResultList();
		 
		 return lista;		 
	 }
	
	//-----------------------------------------------------------------//
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	//-----------------------------------------------------------------//
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	//-----------------------------------------------------------------//
		
	public Class<Atividade> getClassePersistencia() {
		return classePersistencia;
	}
	
	//-----------------------------------------------------------------//
	
	public Integer countTotalRegister(Class<Atividade> classe) {
		Query query = this.getEntityManager().createNativeQuery("SELECT count(o) FROM "+classe.getSimpleName()+" o");		
		Long total = (Long) query.getSingleResult();
		return total.intValue();
	}
}
