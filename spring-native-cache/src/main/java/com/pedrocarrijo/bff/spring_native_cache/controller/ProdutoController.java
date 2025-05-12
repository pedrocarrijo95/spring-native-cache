package com.pedrocarrijo.bff.spring_native_cache.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pedrocarrijo.bff.spring_native_cache.model.Produto;
import com.pedrocarrijo.bff.spring_native_cache.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Produto get(@PathVariable String id) {
        return service.getProduto(id);
    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable String id, @RequestParam double preco) {
        service.atualizarProduto(id, preco);
    }
}
