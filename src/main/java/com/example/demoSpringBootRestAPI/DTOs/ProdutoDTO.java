package com.example.demoSpringBootRestAPI.DTOs;

import com.example.demoSpringBootRestAPI.Entities.Categoria;
import com.example.demoSpringBootRestAPI.Entities.Produto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProdutoDTO {
    private Long id;
    private String descricao;
    private double preco;
    private double estoque;
    private Categoria categoria;

    public ProdutoDTO(Produto p) {
        this.id = p.getId();
        this.descricao = p.getDescricao();
        this.preco = p.getPreco();
        this.categoria = p.getCategoria();
    }


}
