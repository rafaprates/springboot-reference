package com.example.demoSpringBootRestAPI.Controllers;

import com.example.demoSpringBootRestAPI.Entities.Produto;
import com.example.demoSpringBootRestAPI.Services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produto> save(@RequestBody Produto p) {
        Produto pSaved = produtoService.save(p);
        return ResponseEntity.status(HttpStatus.CREATED).body(p);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> getAll() {
        return ResponseEntity.ok().body(produtoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(produtoService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") Long id,
                                         @RequestBody Produto produto) {
        return ResponseEntity.ok().body(produtoService.update(id, produto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        produtoService.excluir(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
