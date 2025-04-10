package br.com.organacode.springskills.controllers;

import br.com.organacode.springskills.dtos.ProductGroupRequestDTO;
import br.com.organacode.springskills.dtos.ProductGroupResponseDTO;
import br.com.organacode.springskills.services.ProductGroupService;
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
@RequestMapping(path = "/v1/productGroups", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductGroupController {
    @Autowired
    private ProductGroupService productGroupService;

    @GetMapping
    public ResponseEntity<List<ProductGroupResponseDTO>> getAllProductGroups() {
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(productGroupService.getAllProductGroups());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductGroupResponseDTO> getProductGroupById(@PathVariable UUID id) {
        ProductGroupResponseDTO productGroupResponseDTO = productGroupService.getProductGroupById(id);
        return ResponseEntity.status(HttpStatusCode.valueOf(productGroupResponseDTO == null ? 204 : 200)).body(productGroupResponseDTO);
    }

    @PostMapping
    public ResponseEntity<String> createProductGroup(@RequestBody @Valid ProductGroupRequestDTO productGroupRequestDTO) {
        UUID id = productGroupService.createProductGroup(productGroupRequestDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public void updateProductGroup(@PathVariable UUID id, @RequestBody @Valid ProductGroupRequestDTO productGroupRequestDTO) {
        productGroupService.updateProductGroup(id, productGroupRequestDTO);
    }
}
