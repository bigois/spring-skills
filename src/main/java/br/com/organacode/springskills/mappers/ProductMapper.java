package br.com.organacode.springskills.mappers;

import br.com.organacode.springskills.dtos.ProductDTO;
import br.com.organacode.springskills.entities.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toEntity(ProductDTO dto);
    ProductDTO toDTO(Product entity);
}
