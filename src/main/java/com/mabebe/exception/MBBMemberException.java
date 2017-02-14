package com.mabebe.exception;

import lombok.Getter;
import org.springframework.dao.DataAccessException;

@Getter
public class MBBMemberException extends Exception {
    private String message;

    public MBBMemberException() {
        super();
    }

    public MBBMemberException(String message) {
        super();
        this.message = message;
    }
}
