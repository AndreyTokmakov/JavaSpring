package employee_service_ex.exception;

import java.io.Serial;

public class MissingHeaderException extends RuntimeException
{
    @Serial
    private static final long serialVersionUID = 1L;

    public MissingHeaderException(String exception) {
        super(exception);
    }
}
