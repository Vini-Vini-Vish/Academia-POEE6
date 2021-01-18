package com.academia.model.service;

import java.util.List;
import javax.persistence.EntityTransaction;
import com.academia.estrutura.util.VariaveisProjeto;
import com.academia.model.dao.atividade.AtividadeDao;
import com.academia.model.models.Atividade;

public class AtividadeService extends ConexaoBancoService{
	
	private AtividadeDao atividadeDao;

	public AtividadeService() {
		this.atividadeDao = new AtividadeDao(this.getEntityManager());
	}
	
	//-------------------------------------------------------------------
	
		public Integer save(Atividade atividade) {
			
			Integer toReturn = 0;
			
			EntityTransaction trx = this.getTransaction();
			
			toReturn = validarDigitacao(atividade);
			
			if(toReturn == VariaveisProjeto.DIGITACAO_OK) {
			
				try {
					trx.begin();
					this.getAtividadeDao().save(atividade);
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
		
		public Integer update(Atividade atividade) {
			
			Integer toReturn =0;
			
			EntityTransaction trx = this.getTransaction();
			
			if(validarDigitacao(atividade)== VariaveisProjeto.DIGITACAO_OK) {
			
				try {
					trx.begin();
					this.getAtividadeDao().update(atividade);
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
			}
			
			return toReturn;
		}
		
		//-------------------------------------------------------------------
		
		public Integer delete(Atividade atividade) {
			
			Integer toReturn =0;
			
			EntityTransaction trx = this.getTransaction();			
			
				try {
					trx.begin();
					Atividade altiviadadeEncontrada = this.getAtividadeDao().findById(atividade.getIdAtividade());
					this.getAtividadeDao().remove(altiviadadeEncontrada);
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
		
		public Atividade findById(Integer idAtividade) {
			return this.getAtividadeDao().findById(idAtividade);
		}
		
		public List<Atividade> findAll(){
			return this.getAtividadeDao().findAll(Atividade.class);
		}
		
		public Integer validarDigitacao(Atividade atividade) {
			if(VariaveisProjeto.digitacaoCampo(atividade.getNome())) {
				return VariaveisProjeto.USUARIO_USER_NAME;
			}		
			return VariaveisProjeto.DIGITACAO_OK;
		}	

		public AtividadeDao getAtividadeDao() {
			return atividadeDao;
		}

		public Integer countTotalRegister() {
			return atividadeDao.countTotalRegister(Atividade.class);
		}

		public List<Atividade> listAtividadePaginacao(int numeroPagina, Integer defaultPagina) {
			return atividadeDao.listAtividadePaginacao(numeroPagina,defaultPagina);
		}
	
}
