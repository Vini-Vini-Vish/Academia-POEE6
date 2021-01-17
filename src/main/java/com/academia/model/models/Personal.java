package com.academia.model.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "TAB_PERSONAL")
public class Personal {
	
	private Integer idpersonal;
	private String 	nome;
	private int 	idade;
	private String 	endereco;
	private int 	numero;
	private String 	bairro;
	private String 	cidade;
	private int		telefone;
	private int 	codigo_postal;
	private String 	genero;
	private String 	periodo;
	private String 	cref;
		
	private boolean activity = false;
	
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
		return nome;
	}
	public void setName(String name) {
		this.nome = name;
	}
	//----------------------------------------------
	@Column(name = "PERSONAL_AGE", length = 3, nullable = false)
	public int getAge() {
		return idade;
	}
	public void setAge(int age) {
		this.idade = age;
	}
	//----------------------------------------------
	@Column(name = "PERSONAL_ADRESS", length = 80, nullable = false)
	public String getAdress() {
		return endereco;
	}
	public void setAdress(String adress) {
		this.endereco = adress;
	}
	//----------------------------------------------
	@Column(name = "PERSONAL_NUMBER", length = 6, nullable = false)
	public int getNumber() {
		return numero;
	}
	public void setNumber(int number) {
		this.numero = number;
	}
	//----------------------------------------------
	@Column(name = "PERSONAL_NEIGHBORHOODE", length = 80, nullable = false)
	public String getNeighborhood() {
		return bairro;
	}	
	public void setNeighborhood(String neighborhood) {
		this.bairro = neighborhood;
	}
	//----------------------------------------------
	@Column(name = "PERSONAL_CITY", length = 70, nullable = false)
	public String getCity() {
		return cidade;
	}
	public void setCity(String city) {
		this.cidade = city;
	}
	//----------------------------------------------
	@Column(name = "PERSONAL_TELEPHONE", length = 13, nullable = false, unique = true)
	public int getTelephone() {
		return telefone;
	}
	public void setTelephone(int telephone) {
		this.telefone = telephone;
	}
	//----------------------------------------------
	@Column(name = "PERSONAL_CODEPOSTAL", length = 10, nullable = false)
	public int getCodeposte() {
		return codigo_postal;
	}
	public void setCodeposte(int postecode) {
		this.codigo_postal = postecode;
	}
	//----------------------------------------------
	@Column(name = "PERSONAL_GENDER", length = 80, nullable = false)
	public String getGender() {
		return genero;
	}
	public void setGender(String gender) {
		this.genero = gender;
	}
	//----------------------------------------------
	@Column(name = "PERSONAL_PERIOD", length = 15, nullable = false)
	public String getPeriod() {
		return periodo;
	}
	public void setPeriod(String period) {
		this.periodo = period;
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
		return "Usuario [idpersonal=" + idpersonal + ", name=" + nome + ", age=" + idade + ", adress=" + endereco
				+ ", number=" + numero + ", neighborhood=" + bairro + ", city=" + cidade +", telephone=" + telefone +
				", codeposte=" + codigo_postal +", gender=" + genero + ", period=" + periodo +", cref=" + cref +""
				+ ", activity=" + activity +"]";
	}
	//----------------------------------------------
}
