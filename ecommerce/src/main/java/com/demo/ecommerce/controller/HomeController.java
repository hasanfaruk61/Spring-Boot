package com.demo.ecommerce.controller;

import com.demo.ecommerce.service.CategoryService;
import com.demo.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;

    @GetMapping({"/", "/home"})
    public String home(Model model){
        return "index";
    }
    @GetMapping("/shop")
    public String shop(Model model){
      model.addAttribute("categories", categoryService.getAllCategory());
      model.addAttribute("products",productService.getAllProduct());
        return "shop";
    }

    @GetMapping("/shop/category/{id}")
    public String shopByCategory(Model model, @PathVariable long id){
        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("products",productService.getAllProductsByCategoryId(id));
        return "shop";

    }@GetMapping("/shop/viewproduct/{id}")
    public String viewProduct(Model model, @PathVariable long id){
        model.addAttribute("product", productService.getProductById(id).get());
        return "viewProduct";
    }




}
