package br.com.organacode.springskills.services;

import br.com.organacode.springskills.dtos.ProductDTO;
import br.com.organacode.springskills.entities.Product;
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

    public List<ProductDTO> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        List<ProductDTO> productListDTO = new ArrayList<>();

        productList.forEach(product -> productListDTO.add(new ProductDTO(product)));
        return productListDTO;
    }

    public ProductDTO getProductById(UUID id) {
        return productRepository.findById(id).map(ProductDTO::new).orElseThrow(() -> new EntityNotFoundException("product not found"));
    }

    public UUID createProduct(ProductDTO productDTO) {
        Product product = productRepository.save(new Product(productDTO));
        return product.getId();
    }

    public ProductDTO updateProduct(UUID id, ProductDTO productDTO) {
        Product product = productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("product not found"));

        product.setDescription(productDTO.description());
        product.setPrice(productDTO.price());
        productRepository.save(product);

        return new ProductDTO(product);
    }

    public void deleteProduct(UUID id) {
        productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("product not found"));
        productRepository.deleteById(id);
    }
}
