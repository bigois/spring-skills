package br.com.organacode.springskills.dtos;

import br.com.organacode.springskills.entities.Product;

import java.math.BigDecimal;

public record ProductDTO(
        String description,
        BigDecimal price
) {
    public ProductDTO(Product product) {
        this(product.getDescription(), product.getPrice());
    }
}
