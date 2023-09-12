package com.br.kaizen.kaizen.projeto.models;

import com.br.kaizen.kaizen.projeto.repository.ProjetoRepository;
import com.br.kaizen.kaizen.projeto.service.ProjetoService;
import com.br.kaizen.kaizen.transacao.models.Transacao;
import com.br.kaizen.kaizen.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

@Data
@Table(name="projeto")
@Entity(name = "projeto")
@NoArgsConstructor
public class Projeto {




    public Projeto(Projeto p){
        setId(p.id);
        this.descricao = p.getDescricao();
        this.dataInicio = p.getDataInicio();
        this.dataTermino = p.getDataTermino();
        this.usuario = p.getUsuario();
        this.transacao = p.getTransacao();
        this.orcamento = p.getOrcamento();
        this.realizado = p.getRealizado();
        this.saldo = p.getSaldo();
    }

    public void setId(Long id){
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descricao")
    private String descricao;


    @Column(name = "data_inicio")
    private Date dataInicio;


    @Column(name = "data_termino")
    private Date dataTermino;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "projeto")
    @JsonIgnore
    List<Transacao> transacao;


    @Column(name="orcamento")
    private Double orcamento;

    @Column(name = "realizado")
    private Double realizado;

    @Column(name = "saldo")
    private Double saldo;


}
