package com.br.kaizen.kaizen.usuario.service;

import com.br.kaizen.kaizen.usuario.Usuario;
import com.br.kaizen.kaizen.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UsuarioService {


    @Autowired
    UsuarioRepository repository;

    public Usuario createUsuario(Usuario E) {
        return repository.save(E);
    }


    public List<Usuario> getUsuarios() {
        return repository.findAll();
    }


    public Optional<Usuario> getUsuarioById(Usuario E) {
        return repository.findById(E.getId());
    }
    public Usuario updateUsuario(Usuario E) {
        return repository.save(E);
    }


    public Optional<Usuario> deleteUsuario(Long id) {
        Optional<Usuario> e = repository.findById(id);
        repository.deleteById(id);
        return e;
    }
}
