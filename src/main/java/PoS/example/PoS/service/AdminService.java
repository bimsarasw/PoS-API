package PoS.example.PoS.service;



import PoS.example.PoS.dtos.AdminDTO;
import PoS.example.PoS.entity.Admin;

public interface AdminService {
    Admin createAdmin(AdminDTO adminDTO);  // Method to create an admin
    Admin updateAdmin(String adminId ,AdminDTO adminDTO);
}
