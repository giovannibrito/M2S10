package com.example.demo.services;

import com.example.demo.models.Produto;
import com.example.demo.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;
    public List<Produto> buscarTodos(){
        return repository.findAll();
    }

    public Produto cadastrar(Produto produto) {
        return repository.save(produto);
    }
}
