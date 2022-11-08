package com.example.demoSpringBootRestAPI.Controllers;

import com.example.demoSpringBootRestAPI.Entities.Categoria;
import com.example.demoSpringBootRestAPI.Services.CategoriaService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<Categoria> save(@Valid @RequestBody Categoria c) {
        Categoria cSaved = categoriaService.save(c);
        return ResponseEntity.status(HttpStatus.CREATED).body(cSaved);
    }


    @GetMapping
    public ResponseEntity<List<Categoria>> findAll(@RequestParam(value = "status", defaultValue = "all") String status) {
        return ResponseEntity.status(HttpStatus.FOUND).body(categoriaService.findAll(status));
    }


    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(categoriaService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Categoria updatedCategoria) {
        Object responseBody = categoriaService.update(id, updatedCategoria);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
