package uz.mib.center.core.security.provider;

import com.nimbusds.jose.util.JSONObjectUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@Component
public class SecurityAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest req, HttpServletResponse res, AccessDeniedException exception) throws IOException {

        res.setContentType("application/json;charset=UTF-8");
        res.setStatus(403);
        res.getWriter().write(JSONObjectUtils.toJSONString(new HashMap<String, Object>() {{
            put("timestamp", System.currentTimeMillis());
            put("status", 403);
            put("message", "Access denied");
        }}));
    }
}
