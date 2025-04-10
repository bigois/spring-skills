package br.com.organacode.springskills.mappers;

import br.com.organacode.springskills.dtos.ProductGroupRequestDTO;
import br.com.organacode.springskills.dtos.ProductGroupResponseDTO;
import br.com.organacode.springskills.entities.ProductGroup;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductGroupMapper {
    ProductGroup toEntityFromRequest(ProductGroupRequestDTO dto);

    ProductGroupRequestDTO toRequestDTO(ProductGroup entity);

    ProductGroup toEntityFromResponse(ProductGroupResponseDTO dto);

    ProductGroupResponseDTO toResponseDTO(ProductGroup entity);
}
