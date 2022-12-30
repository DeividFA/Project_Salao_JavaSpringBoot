package br.com.salao.bellafashion.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class ContatoDTO {


	    @NotBlank(message = "{email.not.blank}")
        @Email(message = "{email.not.valid}")
		private String email;
		private String celular;
		
		
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
		
	
	

}
