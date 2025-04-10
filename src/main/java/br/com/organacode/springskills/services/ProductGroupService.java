package br.com.organacode.springskills.services;

import br.com.organacode.springskills.dtos.ProductGroupRequestDTO;
import br.com.organacode.springskills.dtos.ProductGroupResponseDTO;
import br.com.organacode.springskills.entities.ProductGroup;
import br.com.organacode.springskills.mappers.ProductGroupMapper;
import br.com.organacode.springskills.repositories.ProductGroupRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProductGroupService {
    private final ProductGroupMapper productGroupMapper;
    @Autowired
    private ProductGroupRepository productGroupRepository;

    public ProductGroupService(ProductGroupMapper productGroupMapper) {
        this.productGroupMapper = productGroupMapper;
    }

    public List<ProductGroupResponseDTO> getAllProductGroups() {
        List<ProductGroup> productGroupList = productGroupRepository.findAll();
        List<ProductGroupResponseDTO> productGroupListDTO = new ArrayList<>();

        productGroupList.forEach(productGroup -> productGroupListDTO.add(productGroupMapper.toResponseDTO(productGroup)));
        return productGroupListDTO;
    }

    public ProductGroupResponseDTO getProductGroupById(UUID id) {
        return productGroupRepository.findById(id).map(productGroupMapper::toResponseDTO).orElseThrow(() -> new EntityNotFoundException("product group not found"));
    }

    public UUID createProductGroup(ProductGroupRequestDTO productGroupRequestDTO) {
        ProductGroup productGroup = productGroupRepository.save(productGroupMapper.toEntityFromRequest(productGroupRequestDTO));
        return productGroup.getId();
    }

    public ProductGroupResponseDTO updateProductGroup(UUID id, ProductGroupRequestDTO productGroupRequestDTO) {
        ProductGroup productGroup = productGroupRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("product group not found"));

        productGroup.setName(productGroupRequestDTO.name());
        productGroupRepository.save(productGroup);

        return productGroupMapper.toResponseDTO(productGroup);
    }
}
