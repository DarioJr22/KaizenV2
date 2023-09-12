package com.br.kaizen.kaizen.conta.repository;

import com.br.kaizen.kaizen.conta.models.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta,Long> {
}
