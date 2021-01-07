package com.academia.model.service;

import java.util.List;
import javax.persistence.EntityTransaction;
import com.academia.estrutura.util.VariaveisProjeto;
import com.academia.model.dao.PersonalDao;
import com.academia.model.models.Personal;

public class PersonalService extends ConexaoBancoService {
	
	private PersonalDao personalDao;
	
	//-------------------------------------------------------------------
	public PersonalService() {
		this.personalDao = new PersonalDao(this.getEntityManager());
	}
	//-------------------------------------------------------------------
	public Integer save(Personal personal) {
		
		Integer toReturn = 0;
		
		EntityTransaction trx = this.getTransaction();
		
		if(validarDigitacao(personal) == VariaveisProjeto.DIGITACAO_OK) {
		
			try {
				trx.begin();
				this.getPersonalDao().save(personal);
				trx.commit();
				
			}catch(Exception ex) {
				ex.printStackTrace();
				if(trx.isActive()) {
					trx.rollback();
				}
				toReturn = VariaveisProjeto.ERRO_INCLUSAO;
			}finally {
				this.close();
			}
		} else {
			toReturn = VariaveisProjeto.CAMPO_VAZIO;
		}
		
		return toReturn;
	}
	//-------------------------------------------------------------------
	public Integer update(Personal personal) {
		
		Integer toReturn =0;
		
		EntityTransaction trx = this.getTransaction();
		
		if(validarDigitacao(personal)== VariaveisProjeto.DIGITACAO_OK) {
		
			try {
				trx.begin();
				this.getPersonalDao().update(personal);
				trx.commit();
				
			}catch(Exception ex) {
				ex.printStackTrace();
				if(trx.isActive()) {
					trx.rollback();
				}
				toReturn = VariaveisProjeto.ERRO_ALTERACAO;
			}finally {
				this.close();
			}
		} else {
			toReturn = VariaveisProjeto.CAMPO_VAZIO;
		}
		
		return toReturn;
	}
	//-------------------------------------------------------------------
	public Integer delete(Personal personal) {
		
		Integer toReturn =0;
		
		EntityTransaction trx = this.getTransaction();
		
		
			try {
				trx.begin();
				Personal usuarioEncontrado = this.getPersonalDao().findById(personal.getIdpersonal());
				this.getPersonalDao().remove(usuarioEncontrado);
				trx.commit();
				
			}catch(Exception ex) {
				ex.printStackTrace();
				if(trx.isActive()) {
					trx.rollback();
				}
				toReturn = VariaveisProjeto.ERRO_ALTERACAO;
			}finally {
				this.close();
			}
		
		return toReturn;
	}
	//-------------------------------------------------------------------
	public Personal findById(Integer idpersonal) {
		return this.getPersonalDao().findById(idpersonal);
	}
	
	public List<Personal> findAll(){
		return this.getPersonalDao().findAll(Personal.class);
	}
	
	public Integer validarDigitacao(Personal personal) {
		if(VariaveisProjeto.digitacaoCampo(personal.getName())) {
			return VariaveisProjeto.CAMPO_VAZIO;
		}		
		return VariaveisProjeto.DIGITACAO_OK;
	}	

	public PersonalDao getPersonalDao() {
		return personalDao;
	}
}
