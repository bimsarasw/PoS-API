package PoS.example.PoS.service;

import PoS.example.PoS.dtos.SupplierDTO;
import PoS.example.PoS.entity.Supplier;
import java.util.List;

public interface SupplierService {
    Supplier createSupplier(SupplierDTO supplierDTO);
    Supplier updateSupplier(String supplierId,SupplierDTO supplierDTO);

}
