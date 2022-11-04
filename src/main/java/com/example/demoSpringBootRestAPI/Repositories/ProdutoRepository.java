package com.example.demoSpringBootRestAPI.Repositories;

        import com.example.demoSpringBootRestAPI.Entities.Produto;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Component;
        import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
