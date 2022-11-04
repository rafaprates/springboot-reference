package com.example.demoSpringBootRestAPI.Repositories;

import com.example.demoSpringBootRestAPI.Entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
