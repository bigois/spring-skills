package br.com.organacode.springskills.controllers;

import br.com.organacode.springskills.dtos.ProductRequestDTO;
import br.com.organacode.springskills.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/v1/products", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductRequestDTO>> getAllProducts() {
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductRequestDTO> getProductById(@PathVariable UUID id) {
        ProductRequestDTO productRequestDTO = productService.getProductById(id);
        return ResponseEntity.status(HttpStatusCode.valueOf(productRequestDTO == null ? 204 : 200)).body(productRequestDTO);
    }

    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody @Valid ProductRequestDTO productRequestDTO) {
        UUID id = productService.createProduct(productRequestDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable UUID id, @RequestBody @Valid ProductRequestDTO productRequestDTO) {
        productService.updateProduct(id, productRequestDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable UUID id) {
        productService.deleteProduct(id);
    }
}
