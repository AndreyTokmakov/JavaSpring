/****************************************************************************
* Copyright 2021 (C) Andrey Tokmakov
* ServiceUnavailableException.java class
*
* @name    : ServiceUnavailableException.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Jan 24, 2021
****************************************************************************/

package common.exceptions;

public class ServiceUnavailableException extends ServiceException {
	/** **/
	private static final long serialVersionUID = 1L;

	public ServiceUnavailableException(String message) {
		super(message);
	}
}