package uz.mib.center.core.common.service.impl;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.context.request.WebRequest;
import uz.mib.center.core.common.error.ApiError;
import uz.mib.center.core.common.service.ErrorService;

import java.time.LocalDateTime;

public class ProdErrorService implements ErrorService {

    @Override
    public ApiError makeError(int code, String message, Throwable t, WebRequest request) {
        return ProductionError.builder()
                .code(code)
                .message(message)
                .timestamp(LocalDateTime.now())
                .build();
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class ProductionError implements ApiError {

        private Integer code;
        private String message;
        private LocalDateTime timestamp;

    }
}
