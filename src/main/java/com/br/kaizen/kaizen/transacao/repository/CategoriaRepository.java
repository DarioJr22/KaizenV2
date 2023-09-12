package com.br.kaizen.kaizen.transacao.repository;

import com.br.kaizen.kaizen.transacao.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
}
