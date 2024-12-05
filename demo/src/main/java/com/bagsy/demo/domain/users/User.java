package com.bagsy.demo.domain.users;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "usuarioId")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "usuario_id")
    private UUID usuarioId;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "email", nullable = false, unique = true, length = 150)
    private String email;

    @Column(name = "senha", nullable = false, length = 255)
    private String senha;

    @Column(name = "telefone", length = 20)
    private String telefone;

    @Column(name = "is_admin", nullable = false)
    private boolean isAdmin;

    @CreationTimestamp
    @Column(name = "data_criacao", updatable = false)
    private Instant dataCriacao;

    @UpdateTimestamp
    @Column(name = "data_atualizacao")
    private Instant dataAtualizacao;

    public User(UUID usuarioId, String nome, String email, String senha, String telefone, boolean isAdmin, Instant dataCriacao, Instant dataAtualizacao) {
        this.usuarioId = usuarioId;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.isAdmin = isAdmin;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
    }
}
