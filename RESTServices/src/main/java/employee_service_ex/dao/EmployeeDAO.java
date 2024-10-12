package employee_service_ex.dao;

import employee_service_ex.model.Employee;
import employee_service_ex.model.Employees;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;


@Log4j2
@Repository
public class EmployeeDAO 
{
    private static final Employees list = new Employees();

    static 
    {
        list.getEmployeeList().add(new Employee(1, "Lokesh", "Gupta", "howtodoinjava@gmail.com"));
        list.getEmployeeList().add(new Employee(2, "Alex", "Kolenchiskey", "abc@gmail.com"));
        list.getEmployeeList().add(new Employee(3, "David", "Kameron", "titanic@gmail.com"));
    }

    public EmployeeDAO()
    {
        log.info("{} created!", this.getClass().getSimpleName());
    }
    
    public Employees getAllEmployees() 
    {
        return list;
    }
    
    public void addEmployee(Employee employee) {
        list.getEmployeeList().add(employee);
    }
}
