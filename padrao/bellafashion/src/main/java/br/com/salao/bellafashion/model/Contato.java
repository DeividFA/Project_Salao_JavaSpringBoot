package br.com.salao.bellafashion.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	private String email;
	private String celular;

	public Contato() {
	}

	public Contato(Integer id, String email, String celular) {
		super();
		Id = id;
		this.email = email;
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {

		this.email = email;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	@Override
	public String toString() {
		return "Contato [Id=" + Id + ", email=" + email + ", celular=" + celular + "]";
	}
	
	

}
