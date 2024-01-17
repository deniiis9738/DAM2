package com.paracasa.spring.app.controller;


import com.paracasa.spring.app.model.Menu;
import com.paracasa.spring.app.model.Product;
import com.paracasa.spring.app.service.menuService.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ProductController {
    @Autowired
    private ProductService ProductService;

    @GetMapping("/product")
    public String products(Model model){
        model.addAttribute("product",ProductService.findAll());
        model.addAttribute("currentPage", "product");
        return "product";
    }

    @GetMapping("/product/create")
    public String createProduct(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("currentPage", "product");
        return "create_product";
    }

    @PostMapping("/product/save")
    public String newMenu(Model model, @ModelAttribute("product") Product product) {
        ProductService.create(product);
        return "redirect:/product";
    }

}
