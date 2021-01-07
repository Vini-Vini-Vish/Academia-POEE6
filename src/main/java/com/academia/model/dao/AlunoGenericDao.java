package com.academia.model.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public abstract class AlunoGenericDao <Aluno, Id extends Serializable>{
	
	private EntityManager entityManager;	
	
	private final Class<Aluno> classePersistencia;
	
	@SuppressWarnings("unchecked")
	public AlunoGenericDao(EntityManager entityManager) {
		this.entityManager = entityManager;
		this.classePersistencia = (Class<Aluno>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public void save(Aluno entity) {
		this.getEntityManager().persist(entity);
	}
	
	public void update(Aluno entity) {
		this.getEntityManager().merge(entity);
	}
	
	public void remove(Aluno entity) {
		this.getEntityManager().remove(entity);
	}
	
	public Aluno findById(Id idAluno) {
		return this.getEntityManager().find(getClassePersistencia(), idAluno);
	}
	
	@SuppressWarnings("unchecked")
	 public List<Aluno> findAll(Class<Aluno> classe){
		 List<Aluno> lista = new ArrayList<>();
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
	
	public Class<Aluno> getClassePersistencia() {
		return classePersistencia;
	}

}
