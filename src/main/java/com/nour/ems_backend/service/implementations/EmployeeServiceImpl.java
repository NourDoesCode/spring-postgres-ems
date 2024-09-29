package com.nour.ems_backend.service.implementations;

import org.springframework.stereotype.Service;

import com.nour.ems_backend.dto.EmployeeDTO;
import com.nour.ems_backend.entity.Employee;
import com.nour.ems_backend.mapper.EmployeeMapper;
import com.nour.ems_backend.repository.EmployeeRepository;
import com.nour.ems_backend.service.EmployeeService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeServiceImpl
        implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

}
