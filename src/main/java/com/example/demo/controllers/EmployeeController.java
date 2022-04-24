package com.example.demo.controllers;

import com.example.demo.models.Employee;
import com.example.demo.repositories.CRUDInterface;
import com.example.demo.repositories.EmployeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import java.sql.Date;

@Controller
public class EmployeeController {
    private CRUDInterface<Employee> employeeRepository = new EmployeeRepository();

    @GetMapping("/employee")
    public String singleEmployee(@RequestParam String id, Model model) {
        Employee employee = employeeRepository.getSingleEntityById(id);
        model.addAttribute("employee", employee.toString());
        return "employee";
    }

    @GetMapping("/employees")
    public String allEmployees(Model model){
        model.addAttribute("employees", employeeRepository.getAllEntities());

        return "employees";
    }

    @GetMapping("/create-new-employee")
    public String createNewEmployeePage() {
        return "create-new-employee";
    }

    @PostMapping("/create-new-employee")
    public String createEmployee(WebRequest dataFromForm) {
        int id = Integer.parseInt(dataFromForm.getParameter("id"));
        String employeeName = dataFromForm.getParameter("name");
        String job = dataFromForm.getParameter("job");
        int manager = Integer.parseInt(dataFromForm.getParameter("manager"));
        Date hiredate = Date.valueOf(dataFromForm.getParameter("hiredate"));
        int salary = Integer.parseInt(dataFromForm.getParameter("salary"));
        int commission = Integer.parseInt(dataFromForm.getParameter("commission"));
        int deptNo = Integer.parseInt(dataFromForm.getParameter("deptno"));
        employeeRepository.create(new Employee(id,employeeName,job,manager,hiredate,salary,commission,deptNo));
        return "redirect:/create-new-employee";
    }
}
