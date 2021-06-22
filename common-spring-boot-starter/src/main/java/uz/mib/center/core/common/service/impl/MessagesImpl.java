package uz.mib.center.core.common.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.lang.Nullable;
import uz.mib.center.core.common.service.IMessages;

import java.util.Locale;

@Slf4j
@RequiredArgsConstructor
public class MessagesImpl implements IMessages {

    private final MessageSource messageSource;

    @Override
    public String getString(String key) {
        return getString(key, null);
    }

    @Override
    public String getString(String key, @Nullable String defaultMessage) {
        return getString(key, null, defaultMessage);
    }

    @Override
    public String getString(String key, @Nullable Object[] args, @Nullable String defaultMessage) {
        Locale locale = LocaleContextHolder.getLocale();
        try {
            return messageSource.getMessage(key, args, defaultMessage, locale);
        } catch (NoSuchMessageException ex) {
            log.error(ex.getMessage(), ex);
            return defaultMessage;
        }
    }
}
