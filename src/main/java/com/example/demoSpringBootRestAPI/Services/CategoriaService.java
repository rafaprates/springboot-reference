package com.example.demoSpringBootRestAPI.Services;

import com.example.demoSpringBootRestAPI.Entities.Categoria;
import com.example.demoSpringBootRestAPI.Repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    CategoriaRepository categoriaRepository;

    @Transactional
    public Categoria save(Categoria c) {
        return categoriaRepository.save(c);
    }

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Categoria findById(Long id) {
        Optional<Categoria> object = categoriaRepository.findById(id);
        Categoria c = object.orElseThrow(() -> new EntityNotFoundException("Category was not found."));
        return c;
    }

    public Categoria update(Long id, Categoria afterCategoria) {
        Categoria beforeCategoria = (Categoria) this.findById(id);
        beforeCategoria.setDescricao(afterCategoria.getDescricao());
        beforeCategoria.setStatus(afterCategoria.getStatus());
        return categoriaRepository.save(beforeCategoria);
    }

    @Transactional
    public void delete(Long id) {
        Categoria c = this.findById(id);
        categoriaRepository.delete(c);
    }
}
