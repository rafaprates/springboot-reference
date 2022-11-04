package com.example.demoSpringBootRestAPI.Services;

import com.example.demoSpringBootRestAPI.Entities.Produto;
import com.example.demoSpringBootRestAPI.Repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    ProdutoRepository produtoRepository;

    @Transactional
    public Produto save(Produto p) {
        return produtoRepository.save(p);
    }

    public Produto getById(Long id) {
        Optional<Produto> object = produtoRepository.findById(id);
        Produto p = object.orElseThrow(() -> new EntityNotFoundException("Product was not found."));
        return p;
    }

    public List<Produto> getAll() {
        return produtoRepository.findAll();
    }

    public Produto update(Long id, Produto newProduto) {
        Produto alteredProduto = this.getById(id);
        alteredProduto.setDescricao(newProduto.getDescricao());
        alteredProduto.setPreco(newProduto.getPreco());
        alteredProduto.setEstoque(newProduto.getEstoque());
        return produtoRepository.save(alteredProduto);
    }

    @Transactional
    public void excluir(long id) {
        Produto p = this.getById(id);
        produtoRepository.delete(p);
    }
}
