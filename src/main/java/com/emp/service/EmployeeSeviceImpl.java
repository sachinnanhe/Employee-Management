package com.emp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
