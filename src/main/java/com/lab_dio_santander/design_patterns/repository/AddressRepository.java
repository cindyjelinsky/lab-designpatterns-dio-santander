package com.lab_dio_santander.design_patterns.repository;


import com.lab_dio_santander.design_patterns.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,String> {
}
