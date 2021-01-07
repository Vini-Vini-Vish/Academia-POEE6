package com.academia.model.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "TAB_ALUNO")
public class Aluno {
	
	//Atributos de um aluno na academia
	private Integer idAluno;
	private String 	name;
	private String 	gender;
	private int 	age;
	private String	adress;
	private int 	number;
	private String 	neighborhood;
	private String 	city;
	private int 	telephone;
	private int 	postal_code;
	private String 	period;
	
	private boolean activity;
	
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
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	//----------------------------------------------
	@Column(name = "ALUNO_GENDER", length = 80, nullable = false)
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	//----------------------------------------------
	@Column(name = "ALUNO_AGE", length = 3, nullable = false)
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	//----------------------------------------------
	@Column(name = "ALUNO_ADRESS", length = 80, nullable = false)
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	//----------------------------------------------
	@Column(name = "ALUNO_NUMBER", length = 6, nullable = false)
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	//----------------------------------------------
	@Column(name = "ALUNO_NEIGHBORHOODE", length = 80, nullable = false)
	public String getNeighborhood() {
		return neighborhood;
	}
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	//----------------------------------------------
	@Column(name = "ALUNO_CITY", length = 70, nullable = false)
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	//----------------------------------------------
	@Column(name = "ALUNO_TELEPHONE", length = 13, nullable = false, unique = true)
	public int getTelephone() {
		return telephone;
	}
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
	//----------------------------------------------
	@Column(name = "ALUNO_CODEPOSTAL", length = 10, nullable = false)
	public int getPostal_code() {
		return postal_code;
	}
	public void setPostal_code(int postal_code) {
		this.postal_code = postal_code;
	}
	//----------------------------------------------
	@Column(name = "ALUNO_PERIOD", length = 15, nullable = false)
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
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
		return "Usuario [idAluno=" + idAluno + ", name=" + name + ", gender=" + gender + ", age=" + age
				+ ", adress=" + adress + ", number=" + number + ", neighborhood=" + neighborhood +", city=" + city +
				", telephone=" + telephone +", postal_code=" + postal_code + ", period=" + period +", activity=" + activity +"]";
	}
	//----------------------------------------------
}
