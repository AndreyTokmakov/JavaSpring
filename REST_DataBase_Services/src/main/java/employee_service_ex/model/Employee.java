package employee_service_ex.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee
{
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
}


