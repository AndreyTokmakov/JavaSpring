/****************************************************************************
* Copyright 2021 (C) Andrey Tokmakov
* NotFoundException.java class
*
* @name    : NotFoundException.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Jan 23, 2021
****************************************************************************/

package common.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "User Not found")
public class NotFoundException extends RuntimeException {

}
 