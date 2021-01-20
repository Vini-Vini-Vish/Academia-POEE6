package com.academia.model.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TAB_ALUNO")
public class Aluno {
	
	//Atributos de um aluno na academia
	private Integer idAluno;
	private String 	nome;
	private String 	genero;
	private int 	idade;
	private String	endereco;
	private int 	numero;
	private String 	bairro;
	private String 	cidade;
	private int 	telefone;
	private int 	codigo_postal;
	private String 	periodo;
	
	private boolean activity = false;
	
	//----------------------------------------------
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ALUNO_ID")
	public Integer getIdAluno() {
		return idAluno;
	}
	public void setIdAluno(Integer idAluno) {
		this.idAluno = idAluno;
	} 
	//----------------------------------------------
	@Column(name = "ALUNO_NAME", length = 100, nullable = false)
	public String getName() {
		return nome;
	}
	public void setName(String name) {
		this.nome = name;
	}
	//----------------------------------------------
	@Column(name = "ALUNO_GENDER", length = 80, nullable = false)
	public String getGender() {
		return genero;
	}
	public void setGender(String gender) {
		this.genero = gender;
	}
	//----------------------------------------------
	@Column(name = "ALUNO_AGE", length = 3, nullable = false)
	public int getAge() {
		return idade;
	}
	public void setAge(int age) {
		this.idade = age;
	}
	//----------------------------------------------
	@Column(name = "ALUNO_ADRESS", length = 80, nullable = false)
	public String getAdress() {
		return endereco;
	}
	public void setAdress(String adress) {
		this.endereco = adress;
	}
	//----------------------------------------------
	@Column(name = "ALUNO_NUMBER", length = 6, nullable = false)
	public int getNumber() {
		return numero;
	}
	public void setNumber(int number) {
		this.numero = number;
	}
	//----------------------------------------------
	@Column(name = "ALUNO_NEIGHBORHOODE", length = 80, nullable = false)
	public String getNeighborhood() {
		return bairro;
	}
	public void setNeighborhood(String neighborhood) {
		this.bairro = neighborhood;
	}
	//----------------------------------------------
	@Column(name = "ALUNO_CITY", length = 70, nullable = false)
	public String getCity() {
		return cidade;
	}
	public void setCity(String city) {
		this.cidade = city;
	}
	//----------------------------------------------
	@Column(name = "ALUNO_TELEPHONE", length = 13, nullable = false, unique = true)
	public int getTelephone() {
		return telefone;
	}
	public void setTelephone(int telephone) {
		this.telefone = telephone;
	}
	//----------------------------------------------
	@Column(name = "ALUNO_CODEPOSTAL", length = 10, nullable = false)
	public int getPostal_code() {
		return codigo_postal;
	}
	public void setPostal_code(int postal_code) {
		this.codigo_postal = postal_code;
	}
	//----------------------------------------------
	@Column(name = "ALUNO_PERIOD", length = 15, nullable = false)
	public String getPeriod() {
		return periodo;
	}
	public void setPeriod(String period) {
		this.periodo = period;
	}
	//----------------------------------------------
	@Column(nullable = false)
	public boolean isActivity() {
		return activity;
	}
	public void setActivity(boolean activity) {
		this.activity = activity;
	}
	//----------------------------------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAluno == null) ? 0 : idAluno.hashCode());
		return result;
	}
	//----------------------------------------------
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (idAluno == null) {
			if (other.idAluno!= null)
				return false;
		} else if (!idAluno.equals(other.idAluno))
			return false;
		return true;
	}	
	//----------------------------------------------
	@Override
	public String toString() {
		return "Usuario [idAluno=" + idAluno + ", name=" + nome + ", gender=" + genero + ", age=" + idade
				+ ", adress=" + endereco + ", number=" + numero + ", neighborhood=" + bairro +", city=" + cidade +
				", telephone=" + telefone +", postal_code=" + codigo_postal + ", period=" + periodo +", activity=" + activity +"]";
	}
	//----------------------------------------------
}
