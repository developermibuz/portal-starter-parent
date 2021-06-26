package uz.mib.center.core.common.service;

import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;
import uz.mib.center.core.common.error.ApiError;

public interface ErrorService {

    ApiError makeError(int code, String message, Throwable t, NativeWebRequest request);

    ApiError makeError(int code, String message, String sysMessage, Throwable t, NativeWebRequest request);
}
