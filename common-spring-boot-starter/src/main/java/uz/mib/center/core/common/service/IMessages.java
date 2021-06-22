package uz.mib.center.core.common.service;

import org.springframework.lang.Nullable;

public interface IMessages {

    @Nullable
    String getString(String key);

    @Nullable
    String getString(String key, @Nullable String defaultMessage);

    /**
     * Try to resolve the message. Return default message if no message was found.
     *
     * @param key            the message code to look up, e.g. 'calculator.noRateSet'.
     *                       MessageSource users are encouraged to base message names on qualified class
     *                       or package names, avoiding potential conflicts and ensuring maximum clarity.
     * @param args           an array of arguments that will be filled in for params within
     *                       the message (params look like "{0}", "{1,date}", "{2,time}" within a message),
     *                       or {@code null} if none
     * @param defaultMessage a default message to return if the lookup fails
     * @return the resolved message if the lookup was successful, otherwise
     * the default message passed as a parameter (which may be {@code null})
     * @see java.text.MessageFormat
     */
    @Nullable
    String getString(String key, @Nullable Object[] args, @Nullable String defaultMessage);
}
