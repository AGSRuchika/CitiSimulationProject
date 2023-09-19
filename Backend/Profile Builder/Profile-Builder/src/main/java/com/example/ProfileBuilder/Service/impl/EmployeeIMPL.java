package com.example.ProfileBuilder.Service.impl;

import com.example.ProfileBuilder.Dto.EmployeeDTO;
import com.example.ProfileBuilder.Dto.LoginDTO;
import com.example.ProfileBuilder.Entity.Employee;
import com.example.ProfileBuilder.Repo.EmployeeRepo;
import com.example.ProfileBuilder.Response.LoginResponse;
import com.example.ProfileBuilder.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class EmployeeIMPL implements EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(
                employeeDTO.getEmployee_id(),
                employeeDTO.getEmployee_name(),
                employeeDTO.getEmail(),
                this.passwordEncoder.encode(employeeDTO.getPassword())
        );
        employeeRepo.save(employee);
        return employee.getEmployee_name();
    }

    EmployeeDTO employeeDTO;
    @Override
    public LoginResponse loginEmployee(LoginDTO loginDTO){
        String message="";
        Employee employee1=employeeRepo.findByEmail(loginDTO.getEmail());
        if(employee1!=null){
            String password=loginDTO.getPassword();
            String encodedPassword = employee1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<Employee> employee = employeeRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (employee.isPresent()) {
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {
                return new LoginResponse("password Not Match", false);
            }
        }else {
            return new LoginResponse("Email not exits", false);
        }
    }

    public EmployeeDTO getEmployeeByEmail(String email) {
        // Use your repository to fetch the employee by email
        Employee employee = employeeRepo.findByEmail(email);

        if (employee != null) {
            // Map the Employee entity to the EmployeeDTO if needed
            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setEmployee_id(employee.getEmployee_id());
            employeeDTO.setEmployee_name(employee.getEmployee_name());
            employeeDTO.setEmail(employee.getEmail());

            // Return the EmployeeDTO
            return employeeDTO;
        } else {
            return null; // Return null if the employee is not found
        }
    }
}
