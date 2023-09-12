package com.br.kaizen.kaizen.transacao.controller;


import com.br.kaizen.kaizen.transacao.models.Transacao;
import com.br.kaizen.kaizen.transacao.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("transactions")
public class TransacaoController {

    @Autowired
    TransacaoService TransacaoService;
    //
    @PostMapping
    public ResponseEntity<Transacao> createTransacao(@RequestBody Transacao t) {
        //Inicializar projetos
        TransacaoService.createTransacao(t);
        return new ResponseEntity<>(t, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ArrayList<Transacao>> getTransacaos() {
        ArrayList<Transacao> Transacaos = TransacaoService.getTransacao();
        return new ResponseEntity<>(Transacaos, HttpStatus.OK);
    }


    //Tá dando erro dar update em usuário
    @PutMapping("/{id}")
    public ResponseEntity<Transacao> updateTransacao(@PathVariable Long id, @RequestBody Transacao Transacao) {
        Optional<Transacao> existingTransacao =  TransacaoService.getTransacaoById(id);
        if (existingTransacao.isPresent()) {
            Transacao.setId(id);
            Transacao updatedTransacao = TransacaoService.updateTransacao(Transacao);
            return new ResponseEntity<>(updatedTransacao, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTransacao(@PathVariable Long id) {
        Optional<Transacao> Transacao = TransacaoService.deleteTransacao(id);
        if (Transacao.isPresent()) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
