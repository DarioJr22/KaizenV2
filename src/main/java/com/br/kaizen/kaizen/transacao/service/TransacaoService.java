package com.br.kaizen.kaizen.transacao.service;

import com.br.kaizen.kaizen.conta.models.Conta;
import com.br.kaizen.kaizen.conta.repository.ContaRepository;
import com.br.kaizen.kaizen.projeto.models.Projeto;
import com.br.kaizen.kaizen.projeto.repository.ProjetoRepository;
import com.br.kaizen.kaizen.transacao.models.Transacao;
import com.br.kaizen.kaizen.transacao.repository.CategoriaRepository;
import com.br.kaizen.kaizen.transacao.repository.TransacaoRepository;
import com.br.kaizen.kaizen.usuario.Usuario;
import com.br.kaizen.kaizen.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;


@Service
public class TransacaoService {


    @Autowired
    TransacaoRepository repository;
    @Autowired
    ProjetoRepository projetoRepo;

    @Autowired
    ContaRepository contaRepo;

    @Autowired
    CategoriaRepository categoriaRepo;


    public Transacao createTransacao(Transacao t) {
       /* Optional<Projeto> projeto = projetoRepo.findById(t.getProjeto().getId());
        Optional<Conta> conta = isNull(t.getConta().getId()) ? null : contaRepo.findById(t.getConta().getId()) ;
        Optional<Usuario> usuario = usuarioRepo.findById(t.getUsuario().getId());


        //Quando for uma inclusão de um novo projeto -> Inclui na tabela projeto
        if(projeto.isEmpty()){

        }else{
        //Quando não for, pega os dados do projeto antes de salvar a transação
            t.setProjeto(projeto.get());
        }

        if(!isNull(conta) && conta.isEmpty()){

        }else{
            t.setConta(conta.get());
        }
*/
        projetoRepo.save(t.getProjeto());
        contaRepo.save(t.getConta());
        categoriaRepo.save(t.getCategoria());
        return repository.save(t);
    }


    public ArrayList<Transacao> getTransacao() {
        return (ArrayList<Transacao>) repository.findAll();
    }


    public Optional<Transacao> getTransacaoById(Long i) {
        return repository.findById(i);
    }
    public Transacao updateTransacao(Transacao t) {
      /*  Optional<Projeto> projeto = projetoRepo.findById(t.getProjeto().getId());
        Optional<Conta> conta = contaRepo.findById(t.getConta().getId());
        Optional<Usuario> usuario = usuarioRepo.findById(t.getUsuario().getId());


        //Quando for uma inclusão de um novo projeto -> Inclui na tabela projeto
        if(projeto.isEmpty()){
            projetoRepo.save(t.getProjeto());
        }else{
            //Quando não for, pega os dados do projeto antes de salvar a transação
            t.setProjeto(projeto.get());
        }

        if(conta.isEmpty()){
            contaRepo.save(t.getConta());
        }else{
            t.setConta(conta.get());
        }
*/
        projetoRepo.save(t.getProjeto());
        contaRepo.save(t.getConta());
        categoriaRepo.save(t.getCategoria());
        return repository.save(t);
    }


    public Optional<Transacao> deleteTransacao(Long id) {
        repository.deleteById(id);
        return this.getTransacaoById(id);
    }
}
