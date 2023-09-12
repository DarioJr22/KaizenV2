package com.br.kaizen.kaizen.transacao.controller;


import com.br.kaizen.kaizen.transacao.models.Categoria;
import com.br.kaizen.kaizen.transacao.models.Transacao;
import com.br.kaizen.kaizen.transacao.repository.CategoriaRepository;
import com.br.kaizen.kaizen.transacao.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    CategoriaService service;

    @Autowired
    CategoriaRepository repository;
    @PostMapping
    public ResponseEntity<Categoria> createCategoria(@RequestBody Categoria t){
       Categoria c =  service.createCategoria(t);
       return new ResponseEntity<>(c, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ArrayList<Categoria>> getCategoria(){
        ArrayList<Categoria> c = (ArrayList<Categoria>) service.getCategoria();
        return new ResponseEntity<>(c,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> updateTransacao(@RequestBody Categoria c) {
        Optional<Categoria> existingTransacao = repository.findById(c.getId());
        if (existingTransacao.isPresent()) {
            Categoria updatedTransacao = service.putCategoria(c);
            return new ResponseEntity<>(updatedTransacao, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTransacao(@PathVariable Long id) {
        Optional<Categoria> c = service.deleteCategoria(id);
        if (c.isPresent()) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
