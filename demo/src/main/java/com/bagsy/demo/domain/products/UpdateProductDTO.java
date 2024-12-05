package com.bagsy.demo.domain.products;

import com.bagsy.demo.domain.category.Category;

import java.math.BigDecimal;
import java.time.Instant;

public record UpdateProductDTO(
        String nome,
        String descricao,
        BigDecimal preco,
        Integer estoque,
        String marca,
        String cor,
        String tamanho,
        BigDecimal peso,
        String material,
        Instant dataCriacao,
        Instant dataAtualizacao,
        Category categoria,
        String imagem
    ) {
}
