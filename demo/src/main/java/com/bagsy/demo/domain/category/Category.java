package com.bagsy.demo.domain.category;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "categorias")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "categoriaId")

public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "categoria_id")
    private UUID categoriaId;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @CreationTimestamp
    @Column(name = "data_criacao", updatable = false)
    private Instant dataCriacao;

    @UpdateTimestamp
    @Column(name = "data_atualizacao")
    private Instant dataAtualizacao;

    public Category(UUID categoriaId, String nome, String descricao, Instant dataCriacao, Instant dataAtualizacao) {
        this.categoriaId = categoriaId;
        this.nome = nome;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
    }
}
