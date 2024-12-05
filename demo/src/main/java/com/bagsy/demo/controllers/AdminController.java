package com.bagsy.demo.controllers;

import com.bagsy.demo.service.UserService;
import com.bagsy.demo.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService usuarioService;
    private final ProductService productService;
    public AdminController(UserService usuarioService, ProductService productService) {
        this.usuarioService = usuarioService;
        this.productService = productService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "Login";
    }

    @PostMapping("/login")
    public String loginAdmin(@RequestParam String email, @RequestParam String senha, Model model) {
        boolean isAuthenticated = usuarioService.authenticateAdmin(email, senha);
        if (isAuthenticated) {
            String token = usuarioService.generateToken(email);
            model.addAttribute("token", token);
            return "redirect:/admin/dashboard";
        } else {
            model.addAttribute("error", "Credenciais inválidas");
            return "login";
        }
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        var produtos = productService.getAllProducts();
        model.addAttribute("produtos", produtos);
        return "HomePage";
    }

}
