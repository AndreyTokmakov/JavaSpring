/****************************************************************************
* Copyright 2021 (C) Andrey Tokmakov
* TestException.java class
*
* @name    : TestException.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Jan 23, 2021
****************************************************************************/

package common.exceptions;

public class TestException extends Exception {
	/** **/
	private static final long serialVersionUID = 1L;

	public TestException(String message) {
		super(message);
	}
}