package com.academia.model.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public abstract class PersonalGenericDao <Personal, Id extends Serializable>{
	
	private EntityManager entityManager;	
	
	private final Class<Personal> classePersistencia;
	
	@SuppressWarnings("unchecked")
	public PersonalGenericDao(EntityManager entityManager) {
		this.entityManager = entityManager;
		this.classePersistencia = (Class<Personal>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public void save(Personal entity) {
		this.getEntityManager().persist(entity);
	}
	
	public void update(Personal entity) {
		this.getEntityManager().merge(entity);
	}
	
	public void remove(Personal entity) {
		this.getEntityManager().remove(entity);
	}
	
	public Personal findById(Id idpersonal) {
		return this.getEntityManager().find(getClassePersistencia(), idpersonal);
	}	
	@SuppressWarnings("unchecked")
	public List<Personal> findAll(Class<Personal> classe){
		List<Personal> lista = new ArrayList<>();
		Query query = this.getEntityManager().createQuery("SELECT o FROM "+classe.getSimpleName()+" o");
		 
		lista = query.getResultList();
		 
		return lista;		 
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Class<Personal> getClassePersistencia() {
		return classePersistencia;
	}
}

