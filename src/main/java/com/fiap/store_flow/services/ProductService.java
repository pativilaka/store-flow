package com.fiap.store_flow.services;

import com.fiap.store_flow.dto.CategoryDTO;
import com.fiap.store_flow.dto.ProductDTO;
import com.fiap.store_flow.dto.ProductMinDTO;
import com.fiap.store_flow.entities.Category;
import com.fiap.store_flow.entities.Product;
import com.fiap.store_flow.repositories.ProductRepository;
import com.fiap.store_flow.services.exceptions.DataBaseException;
import com.fiap.store_flow.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional
    public ProductDTO findById(Long id){

        Optional<Product> result = repository.findById(id);
        Product product = result.orElseThrow(()-> new ResourceNotFoundException("Recurso não encontrado!"));

        ProductDTO dto = new ProductDTO(product);
        return dto;
    }

//    @Transactional
//    public List<ProductDTO> findAll(){
//        List<Product> products = repository.findAll();
//        List<ProductDTO> productsDto = products.stream().map(ProductDTO::new).toList();
//        return productsDto;
//    }

    @Transactional
    public Page<ProductMinDTO> findAllPage(String name, Pageable pageable){
        Page<Product> products = repository.searchByName(name, pageable);
        Page<ProductMinDTO> pagesDTOS = products.map(ProductMinDTO::new);
        return pagesDTOS;
    }


    @Transactional
    public ProductDTO insert(ProductDTO dto){
        Product entity = new Product();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new ProductDTO(entity);
    }

    @Transactional
    public ProductDTO update(Long id, ProductDTO dto){
        try {
            Product entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new ProductDTO(entity);
        } catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Recurso não encontrado!");
        }
    }


    //@Transactional(propagation = Propagation.SUPPORTS)
    //Transactional(Transactional.TxType.SUPPORTS)
    @org.springframework.transaction.annotation.Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id){
        if(!repository.existsById(id)){
            throw new ResourceNotFoundException("Recurso não encontrado!");
        }
        try{
            repository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DataBaseException("Falha de integridade referêncial!");
        }
    }

    private void copyDtoToEntity(ProductDTO dto, Product entity) {
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setImgUrl(dto.getImgURL());

        entity.getCategories().clear();
        for (CategoryDTO catDto : dto.getCategories()){
            Category cat = new Category();
            cat.setId(catDto.getId());
            entity.getCategories().add(cat);
        }
    }

}