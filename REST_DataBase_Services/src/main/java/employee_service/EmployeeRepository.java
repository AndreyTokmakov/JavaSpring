/****************************************************************************
* Copyright 2020 (C) Andrey Tokmakov
* EmployeeRepository.java class
*
* @name    : EmployeeRepository.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Dec 12, 2020
****************************************************************************/

package employee_service;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}