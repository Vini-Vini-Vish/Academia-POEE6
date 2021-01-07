package com.academia.model.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "TAB_PERSONAL")
public class Personal {
	
	private Integer idpersonal;
	private String 	name;
	private int 	age;
	private String 	adress;
	private int 	number;
	private String 	neighborhood;
	private String 	city;
	private int		telephone;
	private int 	codeposte;
	private String 	gender;
	private String 	period;
	private String 	cref;
		
	private boolean activity;
	
	//----------------------------------------------
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PERSONAL_ID")
	public Integer getIdpersonal() {
		return idpersonal;
	}
	public void setIdpersonal(Integer idpersonal) {
		this.idpersonal = idpersonal;
	}
	//----------------------------------------------
	@Column(name = "PERSONAL_NAME", length = 100, nullable = false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	//----------------------------------------------
	@Column(name = "PERSONAL_AGE", length = 3, nullable = false)
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	//----------------------------------------------
	@Column(name = "PERSONAL_ADRESS", length = 80, nullable = false)
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	//----------------------------------------------
	@Column(name = "PERSONAL_NUMBER", length = 6, nullable = false)
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	//----------------------------------------------
	@Column(name = "PERSONAL_NEIGHBORHOODE", length = 80, nullable = false)
	public String getNeighborhood() {
		return neighborhood;
	}	
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	//----------------------------------------------
	@Column(name = "PERSONAL_CITY", length = 70, nullable = false)
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	//----------------------------------------------
	@Column(name = "PERSONAL_TELEPHONE", length = 13, nullable = false, unique = true)
	public int getTelephone() {
		return telephone;
	}
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
	//----------------------------------------------
	@Column(name = "PERSONAL_CODEPOSTAL", length = 10, nullable = false)
	public int getCodeposte() {
		return codeposte;
	}
	public void setCodeposte(int postecode) {
		this.codeposte = postecode;
	}
	//----------------------------------------------
	@Column(name = "PERSONAL_GENDER", length = 80, nullable = false)
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	//----------------------------------------------
	@Column(name = "PERSONAL_PERIOD", length = 15, nullable = false)
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	//----------------------------------------------
	@Column(name = "PERSONAL_CREF", nullable = false)
	public String getCref() {
		return cref;
	}
	public void setCref(String cref) {
		this.cref = cref;
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
		result = prime * result + ((idpersonal == null) ? 0 : idpersonal.hashCode());
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
		Personal other = (Personal) obj;
		if (idpersonal == null) {
			if (other.idpersonal!= null)
				return false;
		} else if (!idpersonal.equals(other.idpersonal))
			return false;
		return true;
	}	
	//----------------------------------------------
	@Override
	public String toString() {
		return "Usuario [idpersonal=" + idpersonal + ", name=" + name + ", age=" + age + ", adress=" + adress
				+ ", number=" + number + ", neighborhood=" + neighborhood + ", city=" + city +", telephone=" + telephone +
				", codeposte=" + codeposte +", gender=" + gender + ", period=" + period +", cref=" + cref +""
				+ ", activity=" + activity +"]";
	}
	//----------------------------------------------
}
