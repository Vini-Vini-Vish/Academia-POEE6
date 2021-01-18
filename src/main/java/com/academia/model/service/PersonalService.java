package com.academia.model.service;

import java.util.List;
import javax.persistence.EntityTransaction;
import com.academia.estrutura.util.VariaveisProjeto;
import com.academia.model.dao.personal.PersonalDao;
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
		
		toReturn = validarDigitacao(personal);
		
		if(toReturn == VariaveisProjeto.DIGITACAO_OK) {
		
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
			toReturn = VariaveisProjeto.USUARIO_USER_NAME;
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
		
		if ( VariaveisProjeto.digitacaoCampo(personal.getName())) {
			return VariaveisProjeto.NOME;
		}	
		if ( VariaveisProjeto.digitacaoCampo(personal.getGender())) {
			return VariaveisProjeto.GENERO;
		}	
		if ( VariaveisProjeto.digitacaoCampo(personal.getAge())) {
			return VariaveisProjeto.IDADE;
		}
		if ( VariaveisProjeto.digitacaoCampo(personal.getAdress())) {
			return VariaveisProjeto.ENDERECO;
		}
		if ( VariaveisProjeto.digitacaoCampo(personal.getNumber())) {
			return VariaveisProjeto.NUMERO;
		}
		if ( VariaveisProjeto.digitacaoCampo(personal.getNeighborhood())) {
			return VariaveisProjeto.BAIRRO;
		}
		if ( VariaveisProjeto.digitacaoCampo(personal.getCity())) {
			return VariaveisProjeto.CIDADE;
		}
		if ( VariaveisProjeto.digitacaoCampo(personal.getTelephone())) {
			return VariaveisProjeto.TELEFONE;
		}
		if ( VariaveisProjeto.digitacaoCampo(personal.getCodeposte())) {
			return VariaveisProjeto.CODIGO_POSTAL;
		}
		if ( VariaveisProjeto.digitacaoCampo(personal.getPeriod())) {
			return VariaveisProjeto.PERIODO;
		}
		if ( VariaveisProjeto.digitacaoCampo(personal.getCref())) {
			return VariaveisProjeto.CREF;
		}	
		
		return VariaveisProjeto.DIGITACAO_OK;
	}	

	public PersonalDao getPersonalDao() {
		return personalDao;
	}

	public Integer countTotalRegister() {
		return personalDao.countTotalRegister(Personal.class);
	}

	public List<Personal> listPersonalPaginacao(int numeroPagina, Integer defaultPagina) {
		return personalDao.listPersonalPaginacao(numeroPagina,defaultPagina);
	}
}
