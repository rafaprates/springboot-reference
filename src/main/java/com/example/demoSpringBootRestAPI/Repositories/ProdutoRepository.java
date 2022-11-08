package com.example.demoSpringBootRestAPI.Repositories;

        import com.example.demoSpringBootRestAPI.Entities.Categoria;
        import com.example.demoSpringBootRestAPI.Entities.Produto;
        import org.springframework.data.domain.Example;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Component;
        import org.springframework.stereotype.Repository;

        import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
        List<Produto> findByCategoria(Categoria categoria);
}
