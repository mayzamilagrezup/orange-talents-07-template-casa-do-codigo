package br.com.zupacademy.mayza.casadocodigo.dto.response;

import br.com.zupacademy.mayza.casadocodigo.modelo.Cliente;

public class NovoClienteResponse {

    private Long id;

    public NovoClienteResponse(Cliente cliente) {
        this.id = cliente.getId();
    }

    public Long getId() {
        return id;
    }
}
