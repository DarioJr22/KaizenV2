package com.br.kaizen.kaizen.projeto.service;


import com.br.kaizen.kaizen.projeto.models.Projeto;
import com.br.kaizen.kaizen.projeto.repository.ProjetoRepository;
import com.br.kaizen.kaizen.transacao.models.Transacao;
import com.br.kaizen.kaizen.transacao.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static java.util.Objects.isNull;

import java.util.*;

@Service
public class ProjetoService {

    @Autowired
    ProjetoRepository repository;

    @Autowired
    TransacaoRepository transacaoRepo;
    public Projeto saveProjeto(Projeto i){
        return repository.save(i);
    };

    public List<Transacao> deleteTransacoesProjeto(Long id){
            List<Transacao> ps = (List<Transacao>) transacaoRepo.findAll();
                for(Transacao i:ps){
                    if (!isNull(i.getProjeto()) && i.getProjeto().getId().equals(id)){
                        transacaoRepo.deleteById(i.getId());
                    }
                }
     return ps;
    }
}
