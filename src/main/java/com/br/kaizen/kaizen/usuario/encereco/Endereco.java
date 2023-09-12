package com.br.kaizen.kaizen.usuario.encereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Endereco {
    private String lagradouro;
    private String bairro;
    private String cep;
    private String cidade;
    private String complemento;
    private String num;
}
