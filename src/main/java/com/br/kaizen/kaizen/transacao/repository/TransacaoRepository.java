package com.br.kaizen.kaizen.transacao.repository;

import com.br.kaizen.kaizen.transacao.models.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao,Long> {
}
