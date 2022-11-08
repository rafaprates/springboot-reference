package com.example.demoSpringBootRestAPI.Entities;

import com.example.demoSpringBootRestAPI.Enums.CategoriaStatus;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Categoria {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;

    private String descricao;
    private CategoriaStatus status = CategoriaStatus.ATIVO;

    public Categoria() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @NotBlank(message = "O campo descrição não pode ser vazio.")
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public CategoriaStatus getStatus() {
        return status;
    }

    public void setStatus(CategoriaStatus status) {
        this.status = status;
    }
}
