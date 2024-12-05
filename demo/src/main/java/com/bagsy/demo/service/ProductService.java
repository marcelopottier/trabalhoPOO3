package com.bagsy.demo.service;

import com.bagsy.demo.domain.category.UpdateCategoryDTO;
import com.bagsy.demo.domain.products.CreateProductDTO;
import com.bagsy.demo.domain.products.Product;
import com.bagsy.demo.domain.products.ProductRepository;
import com.bagsy.demo.domain.products.UpdateProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public UUID createProduct(CreateProductDTO createProductDTO){
        var entity = new Product(
                UUID.randomUUID(),
                createProductDTO.nome(),
                createProductDTO.descricao(),
                createProductDTO.preco(),
                createProductDTO.estoque(),
                createProductDTO.marca(),
                createProductDTO.cor(),
                createProductDTO.tamanho(),
                createProductDTO.peso(),
                createProductDTO.material(),
                createProductDTO.dataCriacao(),
                createProductDTO.dataAtualizacao(),
                createProductDTO.categoria(),
                createProductDTO.imagem()
        );
        var productSaved = productRepository.save(entity);
        return productSaved.getProdutoId();
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> findProdutosByCategoriaId(UUID categoriaId) {
        return productRepository.findByCategoria_CategoriaId(categoriaId);
    }

    public void updateProductById(String productId, UpdateProductDTO updateProductDTO){
        var id = UUID.fromString(productId);
        var productEntity = productRepository.findById(id);
        if (productEntity.isPresent()){
            var newProduct = productEntity.get();
            if (updateProductDTO.categoria() != null){
                newProduct.setNome(updateProductDTO.nome());
            }
            if (updateProductDTO.descricao() != null){
                newProduct.setNome(updateProductDTO.descricao());
            }
            productRepository.save(newProduct);
        }
    }
}
