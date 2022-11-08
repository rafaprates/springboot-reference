package com.example.demoSpringBootRestAPI.Services;

import com.example.demoSpringBootRestAPI.DTOs.ProdutoDTO;
import com.example.demoSpringBootRestAPI.Entities.Categoria;
import com.example.demoSpringBootRestAPI.Entities.Produto;
import com.example.demoSpringBootRestAPI.Enums.CategoriaStatus;
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

    @Autowired
    CategoriaService categoriaService;

    @Transactional
    public ProdutoDTO save(ProdutoDTO produtoDTO) {
        Categoria c = categoriaService.findById(produtoDTO.getCategoria().getId());
        if (c.getStatus() == CategoriaStatus.INATIVO) {
            throw new RuntimeException("Categoria inativa");
        }

        // TODO: Extrair para um método Produto.fromProdutoDTO(ProdutoDTO produtoDTO);
//        Produto produto = new Produto();
//        produto.setId(produtoDTO.getId());
//        produto.setDescricao(produtoDTO.getDescricao());
//        produto.setPreco(produtoDTO.getPreco());
//        produto.setEstoque(produtoDTO.getEstoque());

        Produto produto = new Produto();
        produto.fromProdutoDTO(produtoDTO);

        Produto entidadeProduto = produtoRepository.save(produto);
        ProdutoDTO retornoDTO = new ProdutoDTO(entidadeProduto);

        return null;
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
        Produto modifiedProduto = this.getById(id);
        modifiedProduto.setDescricao(newProduto.getDescricao());
        modifiedProduto.setPreco(newProduto.getPreco());
        modifiedProduto.setEstoque(newProduto.getEstoque());
        return produtoRepository.save(modifiedProduto);
    }

    @Transactional
    public void excluir(long id) {
        Produto p = this.getById(id);
        produtoRepository.delete(p);
    }
}
