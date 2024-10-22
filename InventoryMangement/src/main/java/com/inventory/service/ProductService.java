package com.inventory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.dto.ProductRequest;
import com.inventory.model.Category;
import com.inventory.model.Products;
import com.inventory.model.Supplier;
import com.inventory.repository.CategoryRepository;
import com.inventory.repository.ProductRepository;
import com.inventory.repository.SupplierRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    public Products addProduct(ProductRequest productRequest) {
        Category category = categoryRepository.findById(productRequest.getCategory()).orElseThrow();

        Supplier supplier = supplierRepository.findById(productRequest.getSupplier()).orElseThrow();
        
        Products product=Products.builder()
        		.name(productRequest.getName())
        		.description(productRequest.getDescription())
        		.price(productRequest.getPrice())
        		.quantity(productRequest.getQuantity())
        		.category(category)
        		.supplier(supplier)
        		.build();

        return productRepository.save(product);
    }

    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }

    public Products getProductById(Long id) {
        return productRepository.findById(id) .orElseThrow();
    }

    public Products updateProduct(Long id, ProductRequest productRequest) {
        Products product = getProductById(id);

        Category category = categoryRepository.findById(productRequest.getCategory()).orElseThrow();

        Supplier supplier = supplierRepository.findById(productRequest.getSupplier()).orElseThrow();

        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());
        product.setQuantity(productRequest.getQuantity());
        product.setCategory(category);
        product.setSupplier(supplier);

        return productRepository.save(product);
    }
    
    public boolean checkQuantity(Long id,int quantity) {
    	Optional<Products> Oproduct=productRepository.findById(id);
    	if(Oproduct.isPresent()) {
    		Products product=Oproduct.get();
    		return product.getQuantity()>=quantity;
    	}
    	return false;
    }

    public void deleteProduct(Long id) {
        Products product = getProductById(id);
        productRepository.delete(product);
    }
}
