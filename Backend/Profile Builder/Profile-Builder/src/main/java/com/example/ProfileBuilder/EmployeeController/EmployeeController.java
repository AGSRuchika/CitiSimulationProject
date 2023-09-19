package com.example.ProfileBuilder.EmployeeController;

import com.example.ProfileBuilder.Dto.EmployeeDTO;
import com.example.ProfileBuilder.Dto.LoginDTO;
import com.example.ProfileBuilder.Response.LoginResponse;
import com.example.ProfileBuilder.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("ProfileBuilder")

public class EmployeeController {
@Autowired
private EmployeeService employeeService;
    @PostMapping(path="/register")
    public String registerEmployee(@RequestBody EmployeeDTO employeeDTO) {
        String id = employeeService.addEmployee(employeeDTO);
        return id;
    }

    @PostMapping(path="/login")
    public ResponseEntity<?>loginEmployee(@RequestBody LoginDTO loginDTO)
    {
        LoginResponse loginResponse=employeeService.loginEmployee(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }

    @GetMapping(path = "/employee/{email}")
    public ResponseEntity<EmployeeDTO> getEmployeeByEmail(@PathVariable String email) {
        // Use your service to fetch the employee data by email
        EmployeeDTO employeeDTO = employeeService.getEmployeeByEmail(email);

        if (employeeDTO != null) {
            return ResponseEntity.ok(employeeDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
