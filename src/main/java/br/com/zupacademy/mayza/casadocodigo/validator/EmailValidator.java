package br.com.zupacademy.mayza.casadocodigo.validator;

import br.com.zupacademy.mayza.casadocodigo.dto.request.NovoAutorRequest;
import br.com.zupacademy.mayza.casadocodigo.modelo.Autor;
import br.com.zupacademy.mayza.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class EmailValidator implements Validator {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return NovoAutorRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        if(errors.hasErrors()) {
            return;
        }

        NovoAutorRequest request = (NovoAutorRequest) target;
        Optional<Autor> autorEmail = autorRepository.findByEmail(request.getEmail());

        if(autorEmail.isPresent()) {
            errors.rejectValue("email", null, "Já existe um autor com o email: '" + request.getEmail() + "' cadastrado."
            );
        }
    }
}
