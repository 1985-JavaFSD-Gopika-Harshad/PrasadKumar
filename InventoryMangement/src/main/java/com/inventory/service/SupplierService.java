package com.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.dto.SupplierRequest;
import com.inventory.model.Supplier;
import com.inventory.repository.SupplierRepository;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public Supplier addSupplier(SupplierRequest supplierRequest) {
        Supplier supplier =Supplier.builder()
        		.name(supplierRequest.getName())
        		.email(supplierRequest.getEmail())
        		.build();
        return supplierRepository.save(supplier);
    }

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    public Supplier getSupplierById(Long id) {
        return supplierRepository.findById(id).orElseThrow();
                
    }

    public Supplier updateSupplier(Long id, SupplierRequest supplierRequest) {
        Supplier supplier = getSupplierById(id);
        supplier.setName(supplierRequest.getName());
        supplier.setEmail(supplierRequest.getEmail());
        return supplierRepository.save(supplier);
    }

    public void deleteSupplier(Long id) {
        Supplier supplier = getSupplierById(id);
        supplierRepository.delete(supplier);
    }
}

