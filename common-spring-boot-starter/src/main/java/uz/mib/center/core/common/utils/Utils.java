package uz.mib.center.core.common.utils;

public class Utils {

    public static boolean isZero(Integer integer) {
        return integer != null && integer == 0;
    }

    public static boolean isOne(Integer integer) {
        return integer != null && integer == 1;
    }

    public static <T> T nvl(T obj, T defObj) {
        if (obj == null) return defObj;
        return obj;
    }

}
