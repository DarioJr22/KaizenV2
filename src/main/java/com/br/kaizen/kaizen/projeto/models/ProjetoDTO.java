package com.br.kaizen.kaizen.projeto.models;

import java.util.Date;

public record ProjetoDTO (
        Long id,
        String descricao,
        Date dataInicio,
        Date dataTermino,
        Double orcamento,
        Double realizado             ){


}
