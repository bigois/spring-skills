package br.com.organacode.springskills.dtos;

import java.math.BigDecimal;

public record ProductDTO(
        String description,
        BigDecimal price
) {
}
