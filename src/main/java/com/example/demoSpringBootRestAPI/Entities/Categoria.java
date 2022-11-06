package com.example.demoSpringBootRestAPI.Entities;

import com.example.demoSpringBootRestAPI.Enums.CategoriaStatus;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

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
