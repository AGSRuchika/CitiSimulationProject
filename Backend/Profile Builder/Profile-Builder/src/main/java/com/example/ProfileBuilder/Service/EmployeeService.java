package com.example.ProfileBuilder.Service;

import com.example.ProfileBuilder.Dto.EmployeeDTO;
import com.example.ProfileBuilder.Dto.LoginDTO;
import com.example.ProfileBuilder.Response.LoginResponse;

public interface EmployeeService {
    String addEmployee(EmployeeDTO employeeDTO);

    LoginResponse loginEmployee(LoginDTO loginDTO);
    EmployeeDTO getEmployeeByEmail(String email);

}
