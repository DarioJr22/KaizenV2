package com.br.kaizen.kaizen.transacao.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name="categoria")
@Entity(name = "categoria")
@AllArgsConstructor
@NoArgsConstructor
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String Nome;

    @Column
    private String Descricao;

    @Column
    private String Icon;
}
