package com.example.demoSpringBootRestAPI.Controllers;

import com.example.demoSpringBootRestAPI.Entities.Produto;
import com.example.demoSpringBootRestAPI.Repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    ProdutoRepository repo;

    @PostMapping
    public ResponseEntity<Produto> salvar(@RequestBody Produto p) {
        Produto returnedProduto = repo.save(p);
        return ResponseEntity.status(HttpStatus.CREATED).body(p);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> consultarProdutos(){
        return ResponseEntity.status(HttpStatus.OK).body(repo.findAll());
    }

}
