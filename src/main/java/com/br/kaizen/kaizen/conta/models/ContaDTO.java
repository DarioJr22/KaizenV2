package com.br.kaizen.kaizen.conta.models;

import jakarta.validation.constraints.NotNull;

public record ContaDTO(
        Long id,

        @NotNull
        String nome,
        @NotNull
        String agencia,
        @NotNull
        String numeroConta
) {
}
