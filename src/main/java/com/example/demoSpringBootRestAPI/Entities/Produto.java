package com.example.demoSpringBootRestAPI.Entities;

import javax.persistence.*;

@Entity
public class Produto {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;
    private String descricao;
    private double preco;
    private double estoque;

    @ManyToOne
    @JoinColumn(name = "categoria_id",
                foreignKey = @ForeignKey(name = "categoria_id_fk")
    )
    private Categoria categoria;

    public Produto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getEstoque() {
        return estoque;
    }

    public void setEstoque(double estoque) {
        this.estoque = estoque;
    }
}
