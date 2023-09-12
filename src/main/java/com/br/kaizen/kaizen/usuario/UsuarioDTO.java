package com.br.kaizen.kaizen.usuario;

import com.br.kaizen.kaizen.conta.models.Conta;
import com.br.kaizen.kaizen.projeto.models.Projeto;
import com.br.kaizen.kaizen.transacao.models.Transacao;
import com.br.kaizen.kaizen.usuario.encereco.Endereco;

import java.util.List;

public class UsuarioDTO {

    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String apelido;
    private Endereco endereco;
    private List<Transacao> transacoes;
    private List<Projeto> projetos;
    private List<Conta> contas;

    // Construtores, getters e setters

    // Outros métodos, se necessário
}
