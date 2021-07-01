package uz.mib.center.core.common.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.val;
import uz.mib.center.core.common.error.exception.AppProcedureException;
import uz.mib.center.core.common.utils.ConvertUtils;
import uz.mib.center.core.common.utils.Utils;

import java.util.Map;

@Data
public class ProcedureResult {

    private Integer result;
    private String resMsg;

    @JsonIgnore
    private String sysMsg;

    public static ProcedureResult convert(Map<String, Object> m) {
        val result = new ProcedureResult();
        result.setResult(ConvertUtils.toInt(m.get("p_result")));
        result.setResMsg(ConvertUtils.toString(m.get("p_res_msg")));
        result.setSysMsg(ConvertUtils.toString(m.get("p_sys_msg")));
        return result;
    }

    public static ProcedureResult convertAndValidate(Map<String, Object> m) {
        return convert(m).validate();
    }

    public boolean isSuccess() {
        return Utils.isZero(result);
    }

    public boolean isNotSuccess() {
        return !Utils.isZero(result);
    }

    public ProcedureResult validate() {
        if (isNotSuccess()) {
            throw new AppProcedureException(this);
        }
        return this;
    }
}
