package com.br.kaizen.kaizen.usuario.controller;

import com.br.kaizen.kaizen.usuario.Usuario;
import com.br.kaizen.kaizen.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class usuarioController {

    @Autowired
    UsuarioService usuarioService;
//
    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
        Usuario createdUsuario = usuarioService.createUsuario(usuario);
        return new ResponseEntity<>(createdUsuario, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getUsuarios() {
        List<Usuario> usuarios = usuarioService.getUsuarios();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }


    //Tá dando erro dar update em usuário
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        Optional<Usuario> existingUsuario =  usuarioService.getUsuarioById(usuario);
        if (existingUsuario.isPresent()) {
            usuario.setId(id);
            Usuario updatedUsuario = usuarioService.updateUsuario(usuario);
            return new ResponseEntity<>(updatedUsuario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteUsuario(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioService.deleteUsuario(id);
        if (usuario.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}


