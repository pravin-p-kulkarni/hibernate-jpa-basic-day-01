package com.pnc.training.hibernatejpaexample.dao;

import com.pnc.training.hibernatejpaexample.model.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department,Long> {
}
