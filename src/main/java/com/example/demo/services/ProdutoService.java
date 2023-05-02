package com.example.demo.services;

import com.example.demo.models.Produto;
import com.example.demo.repositories.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
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

    public Produto buscarPorId(Integer id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public void excluirPorId(Integer id) {
        repository.deleteById(id);
    }
}
