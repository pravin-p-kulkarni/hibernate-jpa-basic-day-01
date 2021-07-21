package com.pnc.training.hibernatejpaexample.service;

import com.pnc.training.hibernatejpaexample.dao.DepartmentRepository;
import com.pnc.training.hibernatejpaexample.dao.EmployeeRepository;
import com.pnc.training.hibernatejpaexample.model.Department;
import com.pnc.training.hibernatejpaexample.model.Employee;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Transactional
public class EmployeeManagementServiceImpl implements EmployeeManagementService{

    private EmployeeRepository employeeRepository;
    private DepartmentRepository departmentRepository;

    @Override
    @Transactional(value = Transactional.TxType.NOT_SUPPORTED, rollbackOn = Exception.class)
    public Employee retrieveEmployee(Long empId) {
        return employeeRepository.findById(empId).get();
    }

    @Override
    public void saveEmployeeDetails(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long empId) {
        employeeRepository.deleteById(empId);
    }

    @Override
    public List<Employee> listAllEmployee() {
        return StreamSupport.stream(employeeRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }

    @Override
    public List<Department> retrieveAllDepartments() {
        return StreamSupport.stream(departmentRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }
}
