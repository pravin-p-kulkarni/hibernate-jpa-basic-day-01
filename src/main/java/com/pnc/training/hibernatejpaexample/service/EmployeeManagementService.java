package com.pnc.training.hibernatejpaexample.service;

import com.pnc.training.hibernatejpaexample.model.Department;
import com.pnc.training.hibernatejpaexample.model.Employee;

import java.util.List;

public interface EmployeeManagementService {
    Employee retrieveEmployee(Long empId);
    void saveEmployeeDetails(Employee employee);
    void deleteEmployee(Long empId);
    List<Employee> listAllEmployee();
    List<Department> retrieveAllDepartments();
}
