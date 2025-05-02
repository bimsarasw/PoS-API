package PoS.example.PoS.repo;

import PoS.example.PoS.entity.Supplier;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SupplierRepo extends MongoRepository<Supplier, String> {
}
