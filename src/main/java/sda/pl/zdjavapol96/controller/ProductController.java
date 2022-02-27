package sda.pl.zdjavapol96.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import sda.pl.zdjavapol96.dto.ProductDto;
import sda.pl.zdjavapol96.mapper.ProductMapper;

import sda.pl.zdjavapol96.model.Product;

import sda.pl.zdjavapol96.service.ProductService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("")
    public ResponseEntity<Product> add(@Valid @RequestBody ProductDto productDto) {
        final Product product = productService.add(productDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(product);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> findById(@PathVariable long id) {
        final Optional<Product> optionalProduct = productService.findById(id);
        return optionalProduct.map(product -> ResponseEntity.ok(ProductMapper.mapToDto(product))).orElseGet(() -> ResponseEntity.of(Optional.empty()));
    }

    @GetMapping("")
    public List<ProductDto> findAll(){
        return productService.findAll().stream()
                .map(ProductMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @DeleteMapping
    public void delete(@PathVariable long id){
        productService.deleteById(id);
    }

}