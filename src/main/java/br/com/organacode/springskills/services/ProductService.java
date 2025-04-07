package br.com.organacode.springskills.services;

import br.com.organacode.springskills.dtos.ProductDTO;
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
    @Autowired
    private ProductRepository productRepository;

    private final ProductMapper productMapper;

    public ProductService(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    public List<ProductDTO> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        List<ProductDTO> productListDTO = new ArrayList<>();

        productList.forEach(product -> productListDTO.add(productMapper.toDTO(product)));
        return productListDTO;
    }

    public ProductDTO getProductById(UUID id) {
        return productRepository.findById(id).map(productMapper::toDTO).orElseThrow(() -> new EntityNotFoundException("product not found"));
    }

    public UUID createProduct(ProductDTO productDTO) {
        Product product = productRepository.save(productMapper.toEntity(productDTO));
        return product.getId();
    }

    public ProductDTO updateProduct(UUID id, ProductDTO productDTO) {
        Product product = productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("product not found"));

        product.setDescription(productDTO.description());
        product.setPrice(productDTO.price());
        productRepository.save(product);

        return productMapper.toDTO(product);
    }

    public void deleteProduct(UUID id) {
        productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("product not found"));
        productRepository.deleteById(id);
    }
}
