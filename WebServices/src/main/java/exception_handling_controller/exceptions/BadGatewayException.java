/****************************************************************************
* Copyright 2021 (C) Andrey Tokmakov
* RuntimeException502.java class
*
* @name    : RuntimeException502.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Jan 23, 2021
****************************************************************************/

package exception_handling_controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public @ResponseStatus(value = HttpStatus.BAD_GATEWAY, reason = "BAD_GATEWAY")
class BadGatewayException extends RuntimeException {

}