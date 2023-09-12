package com.br.kaizen.kaizen.conta.models;

import com.br.kaizen.kaizen.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@Table(name="conta")
@Entity(name = "conta")
@AllArgsConstructor
@NoArgsConstructor
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String agencia;
    private String numeroConta;
    private BigDecimal totalSaidas;
    private BigDecimal totalEntradas;
    private BigDecimal saldoTotal;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    public Usuario usuario;
}
