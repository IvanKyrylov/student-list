package com.vannsha.studentlist.exception.student;

import com.vannsha.studentlist.exception.ApplicationException;

public class StudentException extends ApplicationException {
    public StudentException() {
        super();
    }

    public StudentException(String message) {
        super(message);
    }

    public StudentException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentException(Throwable cause) {
        super(cause);
    }
}
