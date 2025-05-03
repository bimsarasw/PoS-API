package PoS.example.PoS.service.Impl;

import PoS.example.PoS.dtos.SupplierDTO;
import PoS.example.PoS.entity.Category;
import PoS.example.PoS.entity.Supplier;
import PoS.example.PoS.entity.User;
import PoS.example.PoS.repo.SupplierRepo;
import PoS.example.PoS.service.SupplierService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepo supplierRepo;

    @Override
    public Supplier createSupplier(SupplierDTO supplierDTO) {
        Supplier supplier = new Supplier();

        supplier.setSupplierContact(supplierDTO.getSupplierContact());
        supplier.setSupplierName(supplierDTO.getSupplierName());
        supplier.setCompanyName(supplierDTO.getCompanyName());
        supplier.setSupplierEmail(supplierDTO.getSupplierEmail());

        return supplierRepo.save(supplier);
    }

    @Override
    public Supplier updateSupplier(@NotNull String supplierId, @NotNull SupplierDTO supplierDTO) {
        Optional<Supplier> existingSupplier = supplierRepo.findById(supplierId);
        if (existingSupplier.isPresent()) {
            Supplier supplier = existingSupplier.get();
            supplier.setSupplierName(supplierDTO.getSupplierName());
            supplier.setCompanyName(supplierDTO.getCompanyName());
            supplier.setSupplierEmail(supplierDTO.getSupplierEmail());
            supplier.setSupplierContact(supplierDTO.getSupplierContact());
            return supplierRepo.save(supplier);  // Save the updated user
        } else {
            throw new RuntimeException("User not found with ID: " + supplierId);
        }
    }

    @Override
    public Supplier deleteSupplier(String supplierId) {
        Optional<Supplier> optionalSupplier = supplierRepo.findById(supplierId);
        if (optionalSupplier.isPresent()) {
            supplierRepo.deleteById(supplierId);
            return optionalSupplier.get(); // Return the deleted admin
        }
        throw new RuntimeException("Admin not found with id: " + supplierId);
    }

    @Override
    public List<Supplier> getAllSupplier() {
        return supplierRepo.findAll();
    }


}
