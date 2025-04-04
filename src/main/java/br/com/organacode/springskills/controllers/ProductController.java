package br.com.organacode.springskills.controllers;

import br.com.organacode.springskills.dtos.ProductDTO;
import br.com.organacode.springskills.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/products", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(productService.getAllProducts());
    }
}
