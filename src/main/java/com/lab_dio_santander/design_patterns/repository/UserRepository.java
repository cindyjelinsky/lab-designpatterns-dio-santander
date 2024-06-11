package com.lab_dio_santander.design_patterns.repository;

import com.lab_dio_santander.design_patterns.model.User;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
