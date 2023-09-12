package com.br.kaizen.kaizen.transacao.models;

import com.br.kaizen.kaizen.conta.models.ContaDTO;
import com.br.kaizen.kaizen.projeto.models.ProjetoDTO;
import com.br.kaizen.kaizen.usuario.encereco.EnderecoDTO;
import com.br.kaizen.kaizen.usuario.UsuarioDTO;

import java.util.Date;

public record TransacaoDTO(
        Long id,
        String descricao,
        Date data,
        Long usuarioId,
        Long projetoId,
        Long contaId,
        TipoTransac tipo,
        Long categoriaId,
        Float valor
) {

}

