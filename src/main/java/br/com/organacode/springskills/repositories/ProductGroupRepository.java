package br.com.organacode.springskills.repositories;

import br.com.organacode.springskills.entities.ProductGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductGroupRepository extends JpaRepository<ProductGroup, UUID> {
}
