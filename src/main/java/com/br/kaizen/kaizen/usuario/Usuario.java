package com.br.kaizen.kaizen.usuario;


import com.br.kaizen.kaizen.conta.models.Conta;
import com.br.kaizen.kaizen.projeto.models.Projeto;
import com.br.kaizen.kaizen.transacao.models.Transacao;
import com.br.kaizen.kaizen.usuario.encereco.Endereco;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Table(name="usuario")
@Entity(name = "usuario")
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @Column(name = "nome",length = 60)
    private String nome;

    @Column(name = "idade",length = 60)
    private int idade;

    @Column(name = "sexo",length = 60)
    private String sexo;

    @Column(name= "cpf",unique = true)
    private String cpf;

    @Column(name= "email",unique = true)
    private String email;

    @Column(name= "telefone",unique = true)
    private String telefone;

    @Column(name= "apelido",unique = true)
    private String apelido;

    @Embedded
    private Endereco endereco;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<Transacao> transacoes;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<Projeto> projetos;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<Conta> contas;

}
