package com.bagsy.demo.domain.products;

import com.bagsy.demo.domain.category.Category;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "produtos")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "produtoId")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "produto_id", unique = true, updatable = false, nullable = false)
    private UUID produtoId;

    @Column(name = "nome", nullable = false, length = 255)
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "preco", nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;

    @Column(name = "estoque", nullable = false, columnDefinition = "integer default 0")
    private Integer estoque = 0;

    @Column(name = "marca", length = 100)
    private String marca;

    @Column(name = "cor", length = 50)
    private String cor;

    @Column(name = "tamanho", length = 50)
    private String tamanho;

    @Column(name = "peso", precision = 5, scale = 2)
    private BigDecimal peso;

    @Column(name = "material", length = 100)
    private String material;

    @CreationTimestamp
    @Column(name = "data_criacao", updatable = false)
    private Instant dataCriacao;

    @UpdateTimestamp
    @Column(name = "data_atualizacao")
    private Instant dataAtualizacao;

    @Column(name = "imagem")
    private String imagem;

    @ManyToOne
    @JoinColumn(name = "categoria_id", foreignKey = @ForeignKey(name = "produtos_categoria_id_fkey"),
            referencedColumnName = "categoria_id", nullable = true)
    private Category categoria;

    public Product(UUID produtoId, String nome, String descricao, BigDecimal preco, Integer estoque, String marca, String cor, String tamanho, BigDecimal peso, String material, Instant dataCriacao, Instant dataAtualizacao, Category categoria, String imagem) {
        this.produtoId = produtoId;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.estoque = estoque;
        this.marca = marca;
        this.cor = cor;
        this.tamanho = tamanho;
        this.peso = peso;
        this.material = material;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
        this.categoria = categoria;
        this.imagem = imagem;
    }
}
