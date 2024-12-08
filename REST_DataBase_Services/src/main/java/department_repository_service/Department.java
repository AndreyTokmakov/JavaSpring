package department_repository_service;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data               // Generates getters, setters, toString, equals, and hashCode methods.
@NoArgsConstructor  // Generates a no-args constructor.
@AllArgsConstructor // Generates a constructor with all arguments.
@Builder            // Generates a builder pattern for creating instances.
public class Department
{
    @Id                                             // Specifies the primary key of the entity.
    @GeneratedValue(strategy = GenerationType.AUTO) // Auto-generates the primary key value.
    private Long departmentId;                      // Unique identifier for the department.
    private String departmentName;                  // Name of the department.
    private String departmentAddress;               // Address of the department.
    private String departmentCode;                  // Code representing the department.
}