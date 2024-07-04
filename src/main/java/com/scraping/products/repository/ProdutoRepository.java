package com.scraping.products.repository;

import com.scraping.products.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Produto getReferenceByCodigoKabum(int codigoKabum);
}
