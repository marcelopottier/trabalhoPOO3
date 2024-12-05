package com.bagsy.demo.domain.clients;

import java.util.UUID;

public record UpdateClientDTO(
        String nome,
        String email,
        String telefone,
        String endereco
) {
}
