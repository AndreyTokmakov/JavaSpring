/****************************************************************************
* Copyright 2020 (C) Andrey Tokmakov
* Employee.java class
*
* @name    : Employee.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Dec 12, 2020
****************************************************************************/

package employee_service;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Setter
@Getter
@Entity
public class Employee
{
	@Id                                             // Specifies the primary key of the entity.
	@GeneratedValue(strategy = GenerationType.AUTO) // Auto-generates the primary key value.
	private Long id;

	private String name;
	private String role;

	Employee() {}

	Employee(String name, String role) {
		this.name = name;
		this.role = role;
	}

    @Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Employee))
			return false;
		Employee employee = (Employee) o;
		return Objects.equals(this.id, employee.id) && Objects.equals(this.name, employee.name)
			&& Objects.equals(this.role, employee.role);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.name, this.role);
	}

	@Override
	public String toString() {
		return "Employee{" + "id=" + this.id + ", name='" + this.name + '\'' + ", role='" + this.role + '\'' + '}';
	}
}