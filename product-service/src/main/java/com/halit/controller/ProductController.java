package com.halit.controller;


import com.halit.dto.request.ProductSaveRequestDto;

import com.halit.repository.entity.Product;
import com.halit.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.halit.constants.ApiUrls.*;

@RestController
@RequestMapping(PRODUCT)
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping(SAVE)
    public ResponseEntity<Void> save(@RequestBody ProductSaveRequestDto dto){
        productService.save(dto);
        return ResponseEntity.ok().build();
    }
    @GetMapping(GETALL)
    public ResponseEntity<List<Product>> getList(){
        return ResponseEntity.ok(productService.findAll());
    }
}