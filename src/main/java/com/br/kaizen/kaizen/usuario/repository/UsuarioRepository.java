package com.br.kaizen.kaizen.usuario.repository;

import com.br.kaizen.kaizen.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository  extends JpaRepository<Usuario,Long> {
}
