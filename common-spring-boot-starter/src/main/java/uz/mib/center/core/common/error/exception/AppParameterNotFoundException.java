package uz.mib.center.core.common.error.exception;

import lombok.Getter;

import java.util.Arrays;

@Getter
public class AppParameterNotFoundException extends RuntimeException {
    public static final String CODE = "common.error.parameter-not-found-exception";

    private final String[] parameters;

    public AppParameterNotFoundException(String... parameters) {
        this.parameters = parameters;
    }

    public String[] allInOne(){
        return new String[]{Arrays.toString(parameters)};
    }

}
