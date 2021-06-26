package uz.mib.center.core.common.error;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.NativeWebRequest;
import uz.mib.center.core.common.error.exception.*;
import uz.mib.center.core.common.model.ProcedureResult;
import uz.mib.center.core.common.service.ErrorService;
import uz.mib.center.core.common.service.IMessages;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class CommonRestControlAdvice {

    private final ErrorService errorService;
    private final IMessages iMessages;

    @ExceptionHandler(value = {AppMessageException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ApiError bindException(AppMessageException ex, NativeWebRequest request) {
        String message = iMessages.getString(ex.getMessageKey(), "Message not found");
        log.error(message, ex);
        return errorService.makeError(100, message, ex, request);
    }

    @ExceptionHandler(value = {AppSystemException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ApiError bindException(AppSystemException ex, NativeWebRequest request) {
        String message = iMessages.getString(AppSystemException.CODE, "System error");
        log.error(message, ex);
        return errorService.makeError(101, message, ex, request);
    }

    @ExceptionHandler(value = {AppParameterNotFoundException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ApiError bindException(AppParameterNotFoundException ex, NativeWebRequest request) {
        String message = iMessages.getString(AppParameterNotFoundException.CODE, ex.allInOne(), "Parameter not found");
        log.error(message, ex);
        return errorService.makeError(102, message, ex, request);
    }

    @ExceptionHandler(value = {AppNoDataFoundException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ApiError bindException(AppNoDataFoundException ex, NativeWebRequest request) {
        String message = iMessages.getString(AppNoDataFoundException.CODE, "No data found");
        log.error(message, ex);
        return errorService.makeError(103, message, ex, request);
    }

    @ExceptionHandler(value = {BindException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ApiError bindException(BindException ex, NativeWebRequest request) {
        log.error(ex.getMessage(), ex);
        return errorService.makeError(104, "Required data topilmadi", ex, request);
    }

    @ExceptionHandler(value = {AppProcedureException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ApiError bindException(AppProcedureException ex, NativeWebRequest request) {
        ProcedureResult result = ex.getResult();
        log.error(result.getSysMsg(), ex);
        return errorService.makeError(result.getResult(), result.getResMsg(), result.getSysMsg(), ex, request);
    }
}
