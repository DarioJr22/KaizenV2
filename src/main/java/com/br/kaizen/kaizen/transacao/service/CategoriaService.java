package com.br.kaizen.kaizen.transacao.service;

import com.br.kaizen.kaizen.transacao.models.Categoria;
import com.br.kaizen.kaizen.transacao.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository repository;

    public Categoria createCategoria(Categoria c){
      return repository.save(c);
    }

    public List<Categoria> getCategoria(){
        List<Categoria> l = repository.findAll();
        return l;
    }

    public Categoria putCategoria(Categoria c){
        return repository.save(c);
    }

    public Optional<Categoria> deleteCategoria(Long id){
        repository.deleteById(id);
        return repository.findById(id);
    };

}
