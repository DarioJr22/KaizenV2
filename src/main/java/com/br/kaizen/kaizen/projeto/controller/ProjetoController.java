package com.br.kaizen.kaizen.projeto.controller;

import com.br.kaizen.kaizen.projeto.repository.ProjetoRepository;
import com.br.kaizen.kaizen.projeto.models.Projeto;
import com.br.kaizen.kaizen.projeto.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/projeto")
public class ProjetoController {
    @Autowired ProjetoRepository repository;
    @Autowired
    ProjetoService service;
    @PostMapping
    public ResponseEntity<Projeto> createProjeto(@RequestBody Projeto project) {
        Projeto createdProjeto = repository.save(project);
        return new ResponseEntity<>(createdProjeto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ArrayList<Projeto>> getProjetos() {
        ArrayList<Projeto> c = (ArrayList<Projeto>) repository.findAll();
        return new ResponseEntity<>(c, HttpStatus.OK);
    }


    //Tá dando erro dar update em usuário
    @PutMapping("/{id}")
    public ResponseEntity<Projeto> updateProjeto(@PathVariable Long id, @RequestBody Projeto projeto) {
        Optional<Projeto> existingProjeto =  repository.findById(id);
        if (existingProjeto.isPresent()) {
            Projeto updatedProjeto = repository.save(projeto);
            return new ResponseEntity<>(updatedProjeto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteProjeto(@PathVariable Long id) {
        Optional<Projeto> usuario = repository.findById(id);
        if (usuario.isPresent()) {
            service.deleteTransacoesProjeto(id);
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
