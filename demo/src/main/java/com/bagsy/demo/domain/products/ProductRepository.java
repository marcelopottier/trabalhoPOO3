package com.bagsy.demo.domain.products;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

    List<Product> findByCategoria_CategoriaId(UUID categoriaId);
}
