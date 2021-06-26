package uz.mib.center.core.common.error.exception;

import lombok.Getter;
import uz.mib.center.core.common.model.ProcedureResult;

@Getter
public class AppProcedureException extends RuntimeException {

    private final ProcedureResult result;

    public AppProcedureException(ProcedureResult result) {
        this.result = result;
    }

}
