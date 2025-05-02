package PoS.example.PoS.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Document(collection = "Supplier")  // This indicates the MongoDB collection
@Data

public class Supplier {
    @Id
    private String supplierId;
    private String supplierName;
    private String supplierContact;
    private String companyName;
    private String supplierEmail;
}
