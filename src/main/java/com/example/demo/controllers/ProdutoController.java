package com.example.demo.controllers;

import com.example.demo.models.Produto;
import com.example.demo.services.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProdutoController {
    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping({"/produtos","","/"})
    public ModelAndView exibeProdutos(){
        ModelAndView mav = new ModelAndView("produtos");
        List<Produto> produtos = service.buscarTodos();
        mav.addObject("produtos", produtos);
        return mav;
    }

    @GetMapping("/adicionar-produto")
    public ModelAndView adicionarProduto(){
        ModelAndView mav = new ModelAndView("adicionar-produto");
        Produto produto = new Produto();
        mav.addObject("produto", produto);
        return mav;
    }

    @PostMapping("/salvar-produto")
    public String salvarProduto(@ModelAttribute Produto produto){
        service.cadastrar(produto);
        return "redirect:/produtos";
    }
}
