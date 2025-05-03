package PoS.example.PoS.service;

import PoS.example.PoS.dtos.SupplierDTO;
import PoS.example.PoS.entity.Supplier;
import PoS.example.PoS.entity.User;

import java.util.List;

public interface SupplierService {
    List<Supplier> getAllSupplier();
    Supplier createSupplier(SupplierDTO supplierDTO);
    Supplier updateSupplier(String supplierId,SupplierDTO supplierDTO);
    Supplier deleteSupplier(String supplierId);

}
