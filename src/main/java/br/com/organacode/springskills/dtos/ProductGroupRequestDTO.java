package br.com.organacode.springskills.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ProductGroupRequestDTO(
        @NotBlank(message = "cannot be null or empty")
        @Size(min = 5, max = 100, message = "size must be between {min} and {max}")
        String name
) {
}
