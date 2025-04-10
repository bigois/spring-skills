package br.com.organacode.springskills.mappers;

import br.com.organacode.springskills.dtos.ProductDTO;
import br.com.organacode.springskills.entities.Product;
import br.com.organacode.springskills.entities.ProductGroup;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(source = "group", target = "group")
    Product toEntity(ProductDTO dto);

    @Mapping(source = "group", target = "group")
    ProductDTO toDTO(Product entity);

    default ProductGroup fromId(UUID id) {
        if (id == null) {
            return null;
        }

        ProductGroup productGroup = new ProductGroup();
        productGroup.setId(id);
        return productGroup;
    }

    default UUID toId(ProductGroup group) {
        return group != null ? group.getId() : null;
    }
}
