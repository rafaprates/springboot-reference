package com.example.demoSpringBootRestAPI.Entities;

import com.example.demoSpringBootRestAPI.DTOs.ProdutoDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.procedure.spi.ParameterRegistrationImplementor;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Produto {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;
    private String descricao;
    private double preco;
    private double estoque;

    // Produto is the child entity
    @ManyToOne
    private Categoria categoria;

    @Column(columnDefinition = "DATETIME")
    private Instant updatedAt;

    @Column(columnDefinition = "DATETIME")
    private Instant createdAt;

    @PrePersist
    public void prePresist() {
        createdAt = Instant.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = Instant.now();
    }

    public Produto fromProdutoDTO(ProdutoDTO produtoDTO) {
        Produto produto = new Produto();
        produto.setId(produtoDTO.getId());
        produto.setDescricao(produtoDTO.getDescricao());
        produto.setPreco(produtoDTO.getPreco());
        produto.setEstoque(produtoDTO.getEstoque());
        return produto;
    }
}
