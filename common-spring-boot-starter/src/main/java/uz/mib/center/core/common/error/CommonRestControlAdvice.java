package uz.mib.center.core.common.error;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import uz.mib.center.core.common.service.ErrorService;

@RestControllerAdvice
@RequiredArgsConstructor
public class CommonRestControlAdvice {

    private final ErrorService errorService;

    @ExceptionHandler(value = {BindException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ApiError bindException(BindException ex, WebRequest request) {
        return errorService.makeError(101, "Required data topilmadi", ex, request);
    }
}
