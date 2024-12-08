/****************************************************************************
* Copyright 2020 (C) Andrey Tokmakov
* EmployeeNotFoundException.java class
*
* @name    : EmployeeNotFoundException.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Dec 12, 2020
****************************************************************************/

package employee_service.exceptions;

import java.io.Serial;

public class EmployeeNotFoundException extends RuntimeException
{
	@Serial
	private static final long serialVersionUID = 4866256793581067814L;

	public EmployeeNotFoundException(Long id) {
		super("Could not find employee " + id);
	}
}
