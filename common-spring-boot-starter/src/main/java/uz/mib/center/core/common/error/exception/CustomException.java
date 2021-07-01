package uz.mib.center.core.common.error.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

public class CustomException extends RuntimeException{

    public CustomException(String message) {
        super(message);
    }
}
