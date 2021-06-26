package uz.mib.center.core.common.service.impl;

import lombok.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import uz.mib.center.core.common.error.ApiError;
import uz.mib.center.core.common.service.ErrorService;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

public class DevErrorService implements ErrorService {

    @Override
    public ApiError makeError(int code, String message, Throwable t, NativeWebRequest request) {
        return makeError(code, message, "", t, request);
    }

    @Override
    public ApiError makeError(int code, String message, String sysMessage, Throwable t, NativeWebRequest request) {
        val servlet = request.getNativeRequest(HttpServletRequest.class);
        val address = servlet == null ? request.getDescription(false) : servlet.getRequestURL();
        return DevelopmentError.builder()
                .code(code)
                .message(message)
                .timestamp(LocalDateTime.now())
                .sysMessage(StringUtils.defaultIfBlank(sysMessage, message))
                .address(address.toString())
                .stacktrace(ExceptionUtils.getStackTrace(t))
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
        private String sysMessage;
        private String address;
        private String stacktrace;

    }

}
