package com.example.ProfileBuilder.Repo;

import com.example.ProfileBuilder.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
    Optional<Employee> findOneByEmailAndPassword(String email, String password);
    Employee findByEmail(String email);
}

