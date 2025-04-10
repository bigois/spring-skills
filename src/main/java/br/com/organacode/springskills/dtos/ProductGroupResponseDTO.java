package br.com.organacode.springskills.dtos;

import java.util.UUID;

public record ProductGroupResponseDTO(
        UUID id,
        String name
) {
}
