package com.br.kaizen.kaizen.conta.controller;

import com.br.kaizen.kaizen.conta.repository.ContaRepository;
import com.br.kaizen.kaizen.conta.models.Conta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/conta")
public class ContaController {
    @Autowired
    ContaRepository repository;
    @PostMapping
    public ResponseEntity<Conta> createConta(@RequestBody Conta c) {
       repository.save(c);
        return new ResponseEntity<>(c, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ArrayList<Conta>> getContas() {
        ArrayList<Conta> c = (ArrayList<Conta>) repository.findAll();
        return new ResponseEntity<>(c, HttpStatus.OK);
    }


    //Tá dando erro dar update em usuário
    @PutMapping("/{id}")
    public ResponseEntity<Conta> updateConta(@PathVariable Long id, @RequestBody Conta c) {
        Optional<Conta> existingConta =  repository.findById(id);
        if (existingConta.isPresent()) {
            Conta updatedConta = repository.save(c);
            return new ResponseEntity<>(c, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteConta(@PathVariable Long id) {
        Optional<Conta> c = repository.findById(id);
        if (c.isPresent()) {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
