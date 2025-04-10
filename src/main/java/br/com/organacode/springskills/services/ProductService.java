package br.com.organacode.springskills.services;

import br.com.organacode.springskills.dtos.ProductRequestDTO;
import br.com.organacode.springskills.entities.Product;
import br.com.organacode.springskills.mappers.ProductMapper;
import br.com.organacode.springskills.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    private final ProductMapper productMapper;
    @Autowired
    private ProductRepository productRepository;

    public ProductService(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    public List<ProductRequestDTO> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        List<ProductRequestDTO> productListDTO = new ArrayList<>();

        productList.forEach(product -> productListDTO.add(productMapper.toDTO(product)));
        return productListDTO;
    }

    public ProductRequestDTO getProductById(UUID id) {
        return productRepository.findById(id).map(productMapper::toDTO).orElseThrow(() -> new EntityNotFoundException("product not found"));
    }

    public UUID createProduct(ProductRequestDTO productRequestDTO) {
        Product product = productRepository.save(productMapper.toEntity(productRequestDTO));
        return product.getId();
    }

    public ProductRequestDTO updateProduct(UUID id, ProductRequestDTO productRequestDTO) {
        Product product = productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("product not found"));

        product.setDescription(productRequestDTO.description());
        product.setPrice(productRequestDTO.price());
        productRepository.save(product);

        return productMapper.toDTO(product);
    }

    public void deleteProduct(UUID id) {
        productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("product not found"));
        productRepository.deleteById(id);
    }
}
