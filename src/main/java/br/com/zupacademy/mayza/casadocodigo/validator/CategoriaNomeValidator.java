package br.com.zupacademy.mayza.casadocodigo.validator;

import br.com.zupacademy.mayza.casadocodigo.dto.request.NovaCategoriaRequest;
import br.com.zupacademy.mayza.casadocodigo.dto.request.NovoAutorRequest;
import br.com.zupacademy.mayza.casadocodigo.modelo.Autor;
import br.com.zupacademy.mayza.casadocodigo.modelo.Categoria;
import br.com.zupacademy.mayza.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.mayza.casadocodigo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class CategoriaNomeValidator implements Validator {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return NovaCategoriaRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        if(errors.hasErrors()) {
            return;
        }

        NovaCategoriaRequest request = (NovaCategoriaRequest) target;
        Optional<Categoria> categoriaNome = categoriaRepository.findByNome(request.getNome());

        if(categoriaNome.isPresent()) {
            errors.rejectValue("nome", null, "Já existe a categoria de nome: '" + request.getNome() + "' cadastrada."
            );
        }
    }
}
