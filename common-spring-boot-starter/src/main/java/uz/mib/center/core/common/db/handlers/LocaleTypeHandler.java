package uz.mib.center.core.common.db.handlers;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

public class LocaleTypeHandler extends BaseTypeHandler<Locale> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Locale parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.getLanguage());
    }

    @Override
    public Locale getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return getLocale(rs.getString(columnName));
    }

    @Override
    public Locale getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return getLocale(rs.getString(columnIndex));
    }

    @Override
    public Locale getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return getLocale(cs.getString(columnIndex));
    }

    private Locale getLocale(String lang) {
        if (StringUtils.isBlank(lang)) {
            return null;
        }
        return new Locale(lang);
    }
}
