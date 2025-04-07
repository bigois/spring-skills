package br.com.organacode.springskills.repositories;

import br.com.organacode.springskills.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
