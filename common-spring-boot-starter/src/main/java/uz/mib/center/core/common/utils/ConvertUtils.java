package uz.mib.center.core.common.utils;

import org.springframework.util.NumberUtils;

import java.math.BigDecimal;
import java.util.Objects;

public class ConvertUtils {

    /**
     * Convert to String
     */
    public static String toString(Object obj) {
        return toString(obj, null);
    }

    public static String toString(Object obj, String defValue) {
        if (obj == null) return defValue;
        return Objects.toString(obj);
    }

    /**
     * Convert to Integer
     */
    public static Integer toInt(Object obj) {
        return toInt(obj, null);
    }

    public static Integer toInt(Object obj, Integer defValue) {
        if (obj == null) return defValue;
        if (obj instanceof BigDecimal) {
            return ((BigDecimal) obj).intValue();
        } else if (obj instanceof Double) {
            return ((Double) obj).intValue();
        } else if (obj instanceof Float) {
            return ((Float) obj).intValue();
        } else if (obj instanceof Long) {
            return ((Long) obj).intValue();
        } else if (obj instanceof Integer) {
            return (Integer) obj;
        } else {
            try {
                return NumberUtils.parseNumber(toString(obj), Integer.class);
            } catch (Exception ex) {
                return defValue;
            }
        }
    }

    /**
     * Convert to Long
     */
    public static Long toLong(Object obj) {
        return toLong(obj, null);
    }

    public static Long toLong(Object obj, Long defValue) {
        if (obj == null) return defValue;
        if (obj instanceof BigDecimal) {
            return ((BigDecimal) obj).longValue();
        } else if (obj instanceof Double) {
            return ((Double) obj).longValue();
        } else if (obj instanceof Float) {
            return ((Float) obj).longValue();
        } else if (obj instanceof Long) {
            return (Long) obj;
        } else if (obj instanceof Integer) {
            return ((Integer) obj).longValue();
        } else {
            try {
                return NumberUtils.parseNumber(toString(obj), Long.class);
            } catch (Exception ex) {
                return defValue;
            }
        }
    }

    /**
     * Convert to Double
     */
    public static Double toDouble(Object obj) {
        return toDouble(obj, null);
    }

    public static Double toDouble(Object obj, Double defValue) {
        if (obj == null) return defValue;
        if (obj instanceof BigDecimal) {
            return ((BigDecimal) obj).doubleValue();
        } else if (obj instanceof Double) {
            return ((Double) obj);
        } else if (obj instanceof Float) {
            return ((Float) obj).doubleValue();
        } else if (obj instanceof Long) {
            return ((Long) obj).doubleValue();
        } else if (obj instanceof Integer) {
            return ((Integer) obj).doubleValue();
        } else {
            try {
                return NumberUtils.parseNumber(toString(obj), Double.class);
            } catch (Exception ex) {
                return defValue;
            }
        }
    }

}
