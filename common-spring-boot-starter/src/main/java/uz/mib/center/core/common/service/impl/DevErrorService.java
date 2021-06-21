package uz.mib.center.core.common.service.impl;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.context.request.WebRequest;
import uz.mib.center.core.common.error.ApiError;
import uz.mib.center.core.common.service.ErrorService;

import java.time.LocalDateTime;

public class DevErrorService implements ErrorService {

    @Override
    public ApiError makeError(int code, String message, Throwable t, WebRequest request) {
        return DevelopmentError.builder()
                .code(code)
                .message(message)
                .timestamp(LocalDateTime.now())
                .address(request.getDescription(false))
                .stacktrace(t.getMessage())
                .build();
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class DevelopmentError implements ApiError {

        private Integer code;
        private String message;
        private LocalDateTime timestamp;

        // only for dev profile
        private String address;
        private String stacktrace;

    }

}
