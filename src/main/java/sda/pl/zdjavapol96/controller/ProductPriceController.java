package sda.pl.zdjavapol96.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sda.pl.zdjavapol96.dto.ProductPriceDto;

import sda.pl.zdjavapol96.mapper.ProductPriceMapper;

import sda.pl.zdjavapol96.model.ProductPrice;
import sda.pl.zdjavapol96.service.ProductPriceService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/productprice")
public class ProductPriceController {
    private final ProductPriceService productPriceService;

    public ProductPriceController(ProductPriceService productPriceService) {
        this.productPriceService = productPriceService;
    }

    @PostMapping("")
    public ResponseEntity<ProductPrice> add(@Valid @RequestBody ProductPriceDto productPriceDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productPriceService.add(productPriceDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductPriceDto> findById(@PathVariable long id){
        final Optional<ProductPrice> optionalPrice = productPriceService.findById(id);
        return optionalPrice.map(price -> ResponseEntity.ok(ProductPriceMapper.mapToDto(price))).orElseGet(() -> ResponseEntity.of(Optional.empty()));
    }

    @GetMapping
    public List<ProductPriceDto> findAll(){
        return productPriceService.findAll().stream()
                .map(ProductPriceMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @DeleteMapping
    public void delete(@PathVariable long id){
        productPriceService.deleteById(id);
    }

}
