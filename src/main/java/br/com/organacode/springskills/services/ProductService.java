package br.com.organacode.springskills.services;

import br.com.organacode.springskills.dtos.ProductDTO;
import br.com.organacode.springskills.entities.Product;
import br.com.organacode.springskills.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<ProductDTO> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        List<ProductDTO> productListDTO = new ArrayList<>();

        productList.forEach(product -> productListDTO.add(new ProductDTO(product.getDescription(), product.getPrice())));
        return productListDTO;
    }
}
