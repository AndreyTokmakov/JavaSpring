/****************************************************************************
* Copyright 2021 (C) Andrey Tokmakov
* ServiceException.java class
*
* @name    : ServiceException.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Jan 24, 2021
****************************************************************************/

package exception_handling_controller.exceptions;

public class ServiceException extends Exception {
	/** **/
	private static final long serialVersionUID = 1L;

	public ServiceException(String message) {
		super(message);
	}
}