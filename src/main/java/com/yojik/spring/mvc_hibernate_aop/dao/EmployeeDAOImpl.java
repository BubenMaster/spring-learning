package com.yojik.spring.mvc_hibernate_aop.dao;

import com.yojik.spring.mvc_hibernate_aop.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.type.InstantType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.Type;
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
        List<Employee> allEmployees =session.createQuery("SELECT emplyee from Employee emplyee", Employee.class).getResultList();
//        Query<Employee> query = session.createQuery("FROM Employee");
//        List<Employee> allEmployees = query.getResultList();
       System.out.println(allEmployees);

        return allEmployees;
    }

    public List<String> getDepartments() {
        Session session = sessionFactory.getCurrentSession();
        List<String> departments = session.createQuery("Select distinct department from Employee",String.class).getResultList();
        System.out.println(departments);
        return departments;
    }

    @Override
    public void saveOrUpdateEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Employee.class, id);
    }

    @Override
    public void deleteEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
//        Employee employee = session.get(Employee.class, id);
//        session.delete(employee);
        Query<Employee> query= session.createQuery("delete from Employee " +
                "where id =:employeeId", Employee.class);
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}
