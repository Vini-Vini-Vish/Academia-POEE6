package com.academia.model.models;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TAB_ROLE")
public class Role {
	
	private Long id;
	private String nome;
	
	private List<Usuario> usuarios;
	
	//-----------------------------------------------------------------//
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ROLE_ID", nullable = false)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	//-----------------------------------------------------------------//
	
	@Column(name = "ROLE_NOME", length = 50, nullable = false)
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	//-----------------------------------------------------------------//

	public Role() {
		super();
	}

	//-----------------------------------------------------------------//
	
	public Role(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	//-----------------------------------------------------------------//
	
	@ManyToMany(mappedBy = "roles")
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	//-----------------------------------------------------------------//
	
	@Override
	public String toString() {
		return "Role [id=" + id + ", nome=" + nome + "]";
	}

	//-----------------------------------------------------------------//
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}