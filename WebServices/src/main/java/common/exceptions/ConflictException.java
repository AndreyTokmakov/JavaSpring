/****************************************************************************
* Copyright 2021 (C) Andrey Tokmakov
* ConflictException.java class
*
* @name    : ConflictException.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Jan 23, 2021
****************************************************************************/

package common.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Some_Custom_Reason_for_CONFLICT")
public class ConflictException extends RuntimeException {

}