package com.pedrocarrijo.bff.spring_native_cache.service;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.github.benmanes.caffeine.cache.Cache;
import com.pedrocarrijo.bff.spring_native_cache.model.Produto;

@Service
public class ProdutoService {

    private final CacheManager cacheManager;

    public ProdutoService(CacheManager cacheManager){
        this.cacheManager = cacheManager;
    }

    @Cacheable("produtoCache")
    public Produto getProduto(String id) {
        simulateLatency();
        return new Produto(id, "Produto X", 99.90);
    }

    public void atualizarProduto(String id, double novoPreco) {
        Produto atualizado = new Produto(id, "Produto X", novoPreco);

        // Atualiza o cache diretamente
        Cache cache = (Cache) cacheManager.getCache("produtoCache");
        if (cache != null) {
            cache.put(id, atualizado);
        }
    }

    private void simulateLatency() {
        try { Thread.sleep(1500); } catch (InterruptedException ignored) {}
    }
}
