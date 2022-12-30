package br.com.salao.bellafashion.config.validacao;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.salao.bellafashion.Util.FuncoesUteis;
import br.com.salao.bellafashion.form.CadastroDePessoasForm;

@Component
public class ValidacaoDePessoa implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		CadastroDePessoasForm pessoa = (CadastroDePessoasForm) target;

		if (pessoa.getNomePessoa().isEmpty()) {
			errors.rejectValue("nomePessoa", "NotBlank.cadastroDePessoasForm.nomePessoa");
		}
		
		if (pessoa.getTelefone().isEmpty()) {
			errors.rejectValue("telefone", "NotBlank.cadastroDePessoasForm.telefone");
		}
		
		if (!(pessoa.getCliente())) {
			if(!pessoa.getFornecedor() ) {
				if( !pessoa.getFuncionario()) {
					errors.rejectValue("cliente", "NotBlank.cadastroDePessoasForm.Pessoa");
				}
			}
		}
		
//		if (!pessoa.getDtNasc().isEmpty()) {
//			
//			Date date = new Date();
//			
//		
//			
//			
//		}
	

		if (!(pessoa.getEmail().isEmpty())) {
			if (!FuncoesUteis.isValidEmailAddressRegex(pessoa.getContato().getEmail())) {
				System.out.println(
						"valida email => " + FuncoesUteis.isValidEmailAddressRegex(pessoa.getContato().getEmail()));
				errors.rejectValue("email", "NotBlank.cadastroDePessoasForm.email");
			}
		}
		
		
		if(pessoa.getEstadoCivil() == null) {
			errors.rejectValue("estadoCivil", "NotBlank.cadastroDePessoasForm.estadoCivil");
		}
		
		Integer qdtePreenchido = verifEndPessQtdePreenc(pessoa);
		
		if (qdtePreenchido>0 && qdtePreenchido<6) {
			errors.rejectValue("cep", "NotBlank.cadastroDePessoasForm.cep");
			errors.rejectValue("rua", "NotBlank.cadastroDePessoasForm.rua");
			errors.rejectValue("bairro", "NotBlank.cadastroDePessoasForm.bairro");
			errors.rejectValue("numero", "NotBlank.cadastroDePessoasForm.numero");
			errors.rejectValue("cidade", "NotBlank.cadastroDePessoasForm.cidade");
			errors.rejectValue("estado", "NotBlank.cadastroDePessoasForm.estado");

		}

	}

	

	private Integer verifEndPessQtdePreenc(CadastroDePessoasForm pessoa) {
		Integer qtde = 0;

		if (!pessoa.getRua().isEmpty()) {
			qtde = qtde + 1;
		}
		if (!pessoa.getCep().isEmpty()) {
			qtde = qtde + 1;
		}
		if (!pessoa.getBairro().isEmpty()) {
			qtde = qtde + 1;
		}
		if (!pessoa.getNumero().isEmpty()) {
			qtde = qtde + 1;
		}
		if (!pessoa.getEstado().isEmpty()) {
			qtde = qtde + 1;
		}
		if (!pessoa.getCidade().isEmpty()) {
			qtde = qtde + 1;
		}

		return qtde;
	}

}
