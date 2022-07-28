package com.yojik.spring.mvc_hibernate_aop.dao;

import com.yojik.spring.mvc_hibernate_aop.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAllEmployees();
    List<String> getDepartments();

    void saveEmployee(Employee employee);
}
