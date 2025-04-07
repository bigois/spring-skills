package br.com.organacode.springskills.dtos;

import br.com.organacode.springskills.entities.Product;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record ProductDTO(
        @NotBlank(message = "cannot be null or empty")
        @Size(min = 1, message = "size must be between {min} and {max}")
        String description,

        @NotNull(message = "cannot be null")
        @Positive(message = "must be greater than zero")
        BigDecimal price
) {
    public ProductDTO(Product product) {
        this(product.getDescription(), product.getPrice());
    }
}
