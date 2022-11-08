package com.example.demoSpringBootRestAPI.Repositories;

import com.example.demoSpringBootRestAPI.Entities.Categoria;
import com.example.demoSpringBootRestAPI.Enums.CategoriaStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    @Query("SELECT c FROM Categoria c WHERE c.status = ?1")
    List<Categoria> findAllAtivo(CategoriaStatus status);

    List<Categoria> findAllByStatus(CategoriaStatus status);
}
