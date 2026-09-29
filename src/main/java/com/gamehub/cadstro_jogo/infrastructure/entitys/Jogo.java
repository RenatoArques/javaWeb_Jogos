package com.gamehub.cadstro_jogo.infrastructure.entitys;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "jogo")

public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "plataforma")
    private String plataforma;

    @Column(name = "genero")
    private String genero;

    @Column(name = "preco")
    private Double preco;
}
