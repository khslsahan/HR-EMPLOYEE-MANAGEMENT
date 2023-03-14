package com.hsenid.headerfooterjsp.controller;

import com.hsenid.headerfooterjsp.model.Department;
import com.hsenid.headerfooterjsp.model.Employee;
import com.hsenid.headerfooterjsp.model.EmployeeId;
import com.hsenid.headerfooterjsp.model.EmployeeIdEditor;
import com.hsenid.headerfooterjsp.services.interfaces.DepartmentService;
import com.hsenid.headerfooterjsp.services.interfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.boot.web.servlet.error.ErrorController;
import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;


@Controller
public class WebViewController implements ErrorController {



    @Autowired
    DepartmentService departmentService;

    @Autowired
    EmployeeService employeeService;


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(EmployeeId.class, new EmployeeIdEditor());
    }

    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public String error(Model model) {
        model.addAttribute("content", "error.jsp");
        return "layout";
    }



    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("content", "home.jsp");
        return "layout";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("content", "about.jsp");
        return "layout";
    }

    @GetMapping(value = "/departmentList" )
    public String departmentList(Model model) {
        List<Department> departments = departmentService.fetchDepartmentList();
        Collections.sort(departments);
        model.addAttribute("departments", departments);
//        System.out.println("Departments --\n"+ departments);
        model.addAttribute("content", "department/departmentList.jsp");
        return "layout";
    }

    @RequestMapping(value = "/editDepartment/{id}", method = RequestMethod.GET)
    public String editDepartment(@PathVariable("id") long departmentId, Model model) {
        Department department = departmentService.getDepartmentById(departmentId);
        model.addAttribute("department", department);
        model.addAttribute("action", "EDIT");
        model.addAttribute("content", "department/editDepartment.jsp");
        return "layout";
    }

    @RequestMapping(value = "/addDepartment", method = RequestMethod.GET)
    public String addDepartment(Model model) {
        Department department =  new Department();
        model.addAttribute("department", department);
        model.addAttribute("action", "ADD");
        model.addAttribute("content", "department/editDepartment.jsp");
        return "layout";
    }

    @RequestMapping(value = "/viewDepartment/{id}", method = RequestMethod.GET)
    public String viewDepartment(@PathVariable("id") long departmentId, Model model) {
        Department department = departmentService.getDepartmentById(departmentId);
        model.addAttribute("department", department);
        model.addAttribute("action", "VIEW");

        List<Employee> employees = employeeService.getEmployeesByDepartmentName(department.getName());
        Collections.sort(employees);
        model.addAttribute("employees", employees);


        model.addAttribute("content", "department/editDepartment.jsp");
        return "layout";
    }


    @RequestMapping(value = "/saveDepartment", method = RequestMethod.POST)
    public String saveDepartment(@ModelAttribute("department") Department department, Model model) {
        departmentService.saveDepartment(department);
        model.addAttribute("content", "department/departmentList.jsp");
        return "redirect:/departmentList";
    }

    @RequestMapping(value = "/deleteDepartment/{id}", method = RequestMethod.GET)
    public String deleteDepartment(@PathVariable("id") long departmentId, Model model, HttpServletRequest request) {
        departmentService.deleteDepartmentById(departmentId);
        String referer = request.getHeader("referer");
        return "redirect:" + referer;
    }

    //////////////////////////////////////
    //    Employee Controllers         //
    /////////////////////////////////////

    @GetMapping(value = "/employeeList" )
    public String employeeList(Model model) {
        List<Employee> employees = employeeService.fetchEmployeeList();
        Collections.sort(employees);
        model.addAttribute("employees", employees);
//        System.out.println("Employees--\n"+ employees);
        model.addAttribute("content", "employee/employeeList.jsp");
        return "layout";
    }

    @RequestMapping(value = "/editEmployee/{id}", method = RequestMethod.GET)
    public String editEmployee(@PathVariable("id") long employeeId, Model model) {
        Employee employee = employeeService.findEmployeeById(employeeId);
        model.addAttribute("employee", employee);

        List<Department> departments = departmentService.fetchDepartmentList();
        model.addAttribute("departments", departments);

        model.addAttribute("action", "EDIT");
        model.addAttribute("content", "employee/editEmployee.jsp");
        return "layout";
    }

    @RequestMapping(value = "/viewEmployee/{id}", method = RequestMethod.GET)
    public String viewEmployee(@PathVariable("id") long employeeId, Model model) {
        Employee employee = employeeService.findEmployeeById(employeeId);
        model.addAttribute("employee", employee);

        List<Department> departments = departmentService.fetchDepartmentList();
        model.addAttribute("departments", departments);

        model.addAttribute("action", "VIEW");
        model.addAttribute("content", "employee/editEmployee.jsp");
        return "layout";
    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
    public String addEmployee( Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);

        List<Department> departments = departmentService.fetchDepartmentList();
        model.addAttribute("departments", departments);

        model.addAttribute("action", "ADD");
        model.addAttribute("content", "employee/editEmployee.jsp");
        return "layout";
    }




    @RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
    public String saveEmployee(@ModelAttribute("employee") Employee employee, @ModelAttribute("action") String action, Model model) {

//        System.out.println("The Employee Object"+ employee);
        if(action.equals("ADD")){
            long id;
            if(employeeService.fetchEmployeeList().size()!=0){
                id =employeeService.getLastEmployeeId();
            }else {
                id =0;
            }
            employee.setId(new EmployeeId(id+1,employee.getId().getDepartmentId()));
            employeeService.addEmployee(employee);
        }

        if (action.equals("EDIT")){
            employee.setDepartment(departmentService.getDepartmentById(employee.getId().getDepartmentId()));
            System.out.println(employee);
            System.out.println(employee.getId());
            employeeService.editEmployee(employee,employee.getId());
        }

        model.addAttribute("content", "department/departmentList.jsp");
        return "redirect:/employeeList";
    }

    @RequestMapping(value = "/deleteEmployee/{id}", method = RequestMethod.GET)
    public String deleteEmployee(@PathVariable("id") long employeeId, Model model, HttpServletRequest request) {
        employeeService.deleteEmployeeByEmployeeId(employeeId);
        String referer = request.getHeader("referer");
        return "redirect:" + referer;
    }

}
