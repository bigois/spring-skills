package br.com.organacode.springskills.entities;

import br.com.organacode.springskills.dtos.ProductDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 100)
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    public Product(String description, BigDecimal price) {
        this.description = description;
        this.price = price;
    }

    public Product(ProductDTO productDTO) {
        this.description = productDTO.description();
        this.price = productDTO.price();
    }
}
