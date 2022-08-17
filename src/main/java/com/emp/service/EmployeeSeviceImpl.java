package com.emp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.exception.ResourceNotFoundException;
import com.emp.model.Employee;

@Service
public class EmployeeSeviceImpl implements IEmployeeService {
	
	@Autowired
	IEmployeeRepository employeerepository;

	public Integer saveEmployee(Employee employee) {
		Employee savedEmployee = employeerepository.save(employee);
		return savedEmployee.getId();
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeerepository.findAll();
	}

	@Override
	public Optional<Employee> getEmployee(Integer id) {
		return employeerepository.findById(id);
	}

	@Override
	public void deleteEmployee(Integer id) {
		employeerepository.deleteById(id);
	}

	@Override
	public void deleteAllEmployee() {

		employeerepository.deleteAll();
	}

	@Override
	public Employee updateEmployee(Employee employee, Integer id) {
		Employee existingEmployee = employeerepository.findById(id).orElseThrow(()
				-> new ResourceNotFoundException("Employee","id",id));
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		
		employeerepository.save(existingEmployee);
		return existingEmployee;
	}

}
