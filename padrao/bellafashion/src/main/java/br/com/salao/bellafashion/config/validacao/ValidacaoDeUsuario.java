package br.com.salao.bellafashion.config.validacao;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.salao.bellafashion.Util.FuncoesUteis;
import br.com.salao.bellafashion.form.CadastroDeUsuarioForm;

@Component
public class ValidacaoDeUsuario implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		CadastroDeUsuarioForm user = (CadastroDeUsuarioForm) target;
		
		
		if (!user.getSenhaAcesso().equals(user.getConfirmacaoSenha())) {
            errors.rejectValue("confirmacaoSenha", "NotBlank.cadastroDeUsuarioForm.confirmacaoSenha");
            errors.rejectValue("senhaAcesso", "NotBlank.cadastroDeUsuarioForm.senhaAcesso");
        }
		
		if (!FuncoesUteis.isValidEmailAddressRegex(user.getEmail())) {
			errors.rejectValue("email", "NotBlank.cadastroDeUsuarioForm.email");
		}
		
	}
	
	

}
