package com.fiap.store_flow.controllers;

import com.fiap.store_flow.dto.ProductDTO;
import com.fiap.store_flow.dto.ProductMinDTO;
import com.fiap.store_flow.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id){
        ProductDTO productDto = service.findById(id);
        return ResponseEntity.ok(productDto);
    }

//    @GetMapping
//    public List<ProductDTO> findAll(){
//        List<ProductDTO> listDTO = service.findAll();
//        return listDTO;
//    }

    @GetMapping
    public ResponseEntity<Page<ProductMinDTO>> findAllPage(
            @RequestParam(name = "name", defaultValue = "") String name,
            Pageable pageable){
        Page<ProductMinDTO> allPage = service.findAllPage(name, pageable);
        return ResponseEntity.ok(allPage);
    }


    @PostMapping
    public ResponseEntity<ProductDTO> insert(@Valid @RequestBody ProductDTO dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> update(@PathVariable Long id, @Valid @RequestBody ProductDTO dto){
        dto = service.update(id, dto);
        return ResponseEntity.ok(dto);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


}
