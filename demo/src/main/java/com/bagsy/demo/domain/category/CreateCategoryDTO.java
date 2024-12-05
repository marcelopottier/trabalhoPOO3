package com.bagsy.demo.domain.category;

import com.bagsy.demo.domain.category.Category;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record CreateCategoryDTO(String nome, String descricao, Instant dataCriacao, Instant dataAtualizacao) {
}
