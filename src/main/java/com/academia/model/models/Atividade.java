package com.academia.model.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TAB_ATIVIDADES")
public class Atividade {
	
	private Integer IdAtividade;
	private String nome;
	private String descricao;
	
	//-----------------------------------------------------------------//
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ATIVIDADE_ID")
	public Integer getIdAtividade() {
		return IdAtividade;
	}
	public void setIdAtividade(Integer idAtividade) {
		IdAtividade = idAtividade;
	}
	
	//-----------------------------------------------------------------//
	
	@Column(name = "ATIVIDADE_NAME", length = 100, nullable = false)
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	//-----------------------------------------------------------------//
	
	@Column(name = "ATIVIDADE_DESCRICAO", length = 100, nullable = false)
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	//-----------------------------------------------------------------//
}
