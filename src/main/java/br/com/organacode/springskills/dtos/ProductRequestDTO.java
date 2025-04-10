package br.com.organacode.springskills.dtos;

import br.com.organacode.springskills.enums.ProductType;
import br.com.organacode.springskills.validations.ValidEnum;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductRequestDTO(
        @NotBlank(message = "cannot be null or empty")
        @Size(min = 5, max = 100, message = "size must be between {min} and {max}")
        String description,

        @NotNull(message = "cannot be null")
        @Positive(message = "must be greater than zero")
        BigDecimal price,

        @NotNull(message = "cannot be null")
        @ValidEnum(enumClass = ProductType.class, message = "should be KT, LP, RW, FP, IP, SV or GN")
        ProductType type,

        @NotNull(message = "cannot be null")
        UUID group
) {
}
