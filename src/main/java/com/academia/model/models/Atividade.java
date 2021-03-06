package com.academia.model.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TAB_ATIVIDADES")
public class Atividade {
	
	private Integer IdAtividade;
	private String nome;
	private String descricao;
	
	private List<Aluno> aluno;
	
	private String foto;
	
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
	
	@OneToMany(mappedBy = "atividade")
	public List<Aluno> getAluno() {
		return aluno;
	}
	public void setAluno(List<Aluno> aluno) {
		this.aluno = aluno;
	}
	
	//-----------------------------------------------------------------//
	
	@Column(name="USUARIO_FOTO", nullable = true)
	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	//-----------------------------------------------------------------//
}
