package com.Infosys.SpringRest.Controller;
import com.Infosys.SpringRest.beans.Employee;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmpAPIServices {

    @GetMapping("/{empId}")
    public Employee getEmployee(@PathVariable String empId) {
        return new Employee(empId, "John Doe", "IT", 55000.00);
    }

    @PostMapping
    public String createEmployee(@RequestBody Employee employee) {
        return "Employee created: " + employee.toString();
    }

    @PutMapping("/{empId}")
    public String updateEmployee(@PathVariable String empId, @RequestBody Employee employee) {
        return "Employee with ID " + empId + " updated to: " + employee.toString();
    }

    @DeleteMapping("/{empId}")
    public String deleteEmployee(@PathVariable String empId) {
        return "Employee with ID " + empId + " deleted.";
    }

}
