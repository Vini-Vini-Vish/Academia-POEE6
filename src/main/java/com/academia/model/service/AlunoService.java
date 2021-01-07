package com.academia.model.service;

import java.util.List;
import javax.persistence.EntityTransaction;
import com.academia.estrutura.util.VariaveisProjeto;
import com.academia.model.dao.AlunoDao;
import com.academia.model.models.Aluno;

public class AlunoService extends ConexaoBancoService{

	private AlunoDao alunoDao;
	
	public AlunoService() {
		this.alunoDao = new AlunoDao(this.getEntityManager());
	}
	//-------------------------------------------------------------------
	public Integer save(Aluno aluno) {
		
		Integer toReturn = 0;
		
		EntityTransaction trx = this.getTransaction();
		
		if(validarDigitacao(aluno) == VariaveisProjeto.DIGITACAO_OK) {
		
			try {
				trx.begin();
				this.getAlunoDao().save(aluno);
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
	public Integer update(Aluno aluno) {
		
		Integer toReturn =0;
		
		EntityTransaction trx = this.getTransaction();
		
		if(validarDigitacao(aluno)== VariaveisProjeto.DIGITACAO_OK) {
		
			try {
				trx.begin();
				this.getAlunoDao().update(aluno);
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
	public Integer delete(Aluno aluno) {
		
		Integer toReturn =0;
		
		EntityTransaction trx = this.getTransaction();
		
		
			try {
				trx.begin();
				Aluno usuarioEncontrado = this.getAlunoDao().findById(aluno.getIdAluno());
				this.getAlunoDao().remove(usuarioEncontrado);
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
	public Aluno findById(Integer idaluno) {
		return this.getAlunoDao().findById(idaluno);
	}
	
	public List<Aluno> findAll(){
		return this.getAlunoDao().findAll(Aluno.class);
	}
	
	public Integer validarDigitacao(Aluno aluno) {
		if(VariaveisProjeto.digitacaoCampo(aluno.getName())) {
			return VariaveisProjeto.CAMPO_VAZIO;
		}		
		return VariaveisProjeto.DIGITACAO_OK;
	}	

	public AlunoDao getAlunoDao() {
		return alunoDao;
	}
}
