package uz.mib.center.core.common.error.exception;

import lombok.Getter;

@Getter
public class AppMessageException extends RuntimeException {

    private final String messageKey;

    public AppMessageException(String messageKey) {
        this.messageKey = messageKey;
    }

}
