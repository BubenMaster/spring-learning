package com.yojik.spring.mvc_hibernate_aop.controller;

import com.yojik.spring.mvc_hibernate_aop.entity.Employee;
import com.yojik.spring.mvc_hibernate_aop.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/")
    public String firstPage() {
        return "first-page";
    }

    @RequestMapping("/show-all-employees/")
    public  String showAllEmployees(Model model) {

        List<Employee> allEmployees = employeeService.getAllEmployees();
        model.addAttribute("allEmps", allEmployees);
        return "all-employees";
    }

    @RequestMapping("/add-new-employee/")
    public String addNewEmployee(Model model){
        Employee employee = new Employee();
        List<String> departments = employeeService.getDepartments();
        model.addAttribute("addedEmployee", employee);
        model.addAttribute("departments", departments);
        return "employee-info";
    }

    @RequestMapping("/update-employee/")
    public String updateEmployee(@RequestParam("empId") int id, Model model){

        Employee employee = employeeService.getEmployee(id);
        List<String> departments = employeeService.getDepartments();
        model.addAttribute("addedEmployee", employee);
        model.addAttribute("departments", departments);
        return "employee-info";
    }

   @RequestMapping ("/delete-employee/")
    public String deleteEmployee(@RequestParam("empId") int id){
        employeeService.deleteEmployee(id);
        return "redirect:/show-all-employees/";
    }

    @RequestMapping("/save-employee/")
    public String saveEmployee(@ModelAttribute("addedEmployee") Employee employee){
        employeeService.saveOrUpdateEmployee(employee);
        return "redirect:/show-all-employees/";
    }


}
