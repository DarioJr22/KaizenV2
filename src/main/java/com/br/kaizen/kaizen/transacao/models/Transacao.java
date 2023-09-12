package com.br.kaizen.kaizen.transacao.models;



import com.br.kaizen.kaizen.conta.models.Conta;
import com.br.kaizen.kaizen.projeto.models.Projeto;
import com.br.kaizen.kaizen.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@Table(name="tansacao")
@Entity(name = "transacao")
@AllArgsConstructor
@NoArgsConstructor
public class Transacao {


    public Transacao(Transacao T) {
        this.id = T.getId();
        this.descricao = T.getDescricao();
        this.data = T.getData();
        this.usuario = T.getUsuario();
        this.projeto = new Projeto(T.getProjeto());
        this.conta = T.getConta();
        this.tipo = T.getTipo();
        this.categoria = T.getCategoria();
        this.valor = T.getValor();
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "data")
    private Date data;

    @ManyToOne
    @JoinColumn(name="usuario_id")
    private Usuario usuario;

    @ManyToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name="projeto_id")
    private Projeto projeto;

    @ManyToOne
    @JoinColumn(name = "conta_id")
    private Conta conta;

    @Enumerated(EnumType.STRING)
    private TipoTransac tipo;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @Column(name="valor")
    private Float valor;
}
