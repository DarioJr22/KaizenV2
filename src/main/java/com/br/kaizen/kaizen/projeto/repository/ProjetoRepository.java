package com.br.kaizen.kaizen.projeto.repository;

import com.br.kaizen.kaizen.projeto.models.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto,Long> {
}
