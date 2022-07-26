package com.yojik.spring.mvc_hibernate_aop.dao;

import com.yojik.spring.mvc_hibernate_aop.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
//    @Transactional
    public List<Employee> getAllEmployees() {
        Session session = sessionFactory.getCurrentSession();
        List<Employee> allEmployees =session.createQuery("from Employee", Employee.class).getResultList();
//        Query<Employee> query = session.createQuery("FROM Employee");
//        List<Employee> allEmployees = query.getResultList();
//        System.out.println(allEmployees);

        return allEmployees;
    }
}
