package com.br.kaizen.kaizen.usuario.encereco;

public record EnderecoDTO(
        String lagradouro,
        String bairro,

        String cep,
        String cidade,

        String complemento,

        String num
        ) {
}
