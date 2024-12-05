package com.bagsy.demo.controllers;

import com.bagsy.demo.domain.category.UpdateCategoryDTO;
import com.bagsy.demo.domain.products.Product;
import com.bagsy.demo.domain.products.CreateProductDTO;
import com.bagsy.demo.domain.products.UpdateProductDTO;
import com.bagsy.demo.service.ProductService;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        if (products.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(products);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody @Valid CreateProductDTO createProductDTO){
        var productId = productService.createProduct(createProductDTO);
        return ResponseEntity.created(URI.create("/product/"+ productId.toString())).build();
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Void> updateCategoryById(@PathVariable("categoryId") String categoryId, @RequestBody UpdateProductDTO updateCategoryDTO){
        productService.updateProductById(categoryId, updateCategoryDTO);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/mochilas")
    public String getMochilas(Model model) {
        UUID categoriaUUId = UUID.fromString("482184ad-2107-416d-820c-917428dcbe6e");
        List<Product> produtos = productService.findProdutosByCategoriaId(categoriaUUId);
        model.addAttribute("produtos", produtos);
        return "mochilas";
    }

    @GetMapping("/malas")
    public String getMalas(Model model) {
        UUID categoriaUUId = UUID.fromString("da844897-c974-489a-b3c2-527d9925e9b4");
        List<Product> produtos = productService.findProdutosByCategoriaId(categoriaUUId);
        model.addAttribute("produtos", produtos);
        return "malas";
    }

    @GetMapping("/ecobags")
    public String getEcobags(Model model) {
        UUID categoriaUUId = UUID.fromString("7ca1bcde-575b-4028-9308-718aefb144c5");
        List<Product> produtos = productService.findProdutosByCategoriaId(categoriaUUId);
        model.addAttribute("produtos", produtos);
        return "ecobags";
    }

    @GetMapping("/acessorios")
    public String getAcessorios(Model model) {
        UUID categoriaUUId = UUID.fromString("07598db5-fc25-49ad-988b-3a2fbbd5e042");
        List<Product> produtos = productService.findProdutosByCategoriaId(categoriaUUId);
        model.addAttribute("produtos", produtos);
        return "acessorios";
    }
}
