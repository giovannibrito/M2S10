package com.example.demo.controllers;

import com.example.demo.models.Produto;
import com.example.demo.repositories.ProdutoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProdutoController {
    private final ProdutoRepository repository;

    public ProdutoController(ProdutoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/produtos")
    public ModelAndView exibeProdutos(){
        ModelAndView mav = new ModelAndView("produtos");
        List<Produto> produtos = repository.findAll();
        mav.addObject("produtos", produtos);
        return mav;
    }
}
