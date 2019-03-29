package org.asm.labs.service;

import java.util.Locale;

public class UserLocaleServiceImpl implements UserLocaleService {

    public Locale getUserLocale(String userLocale) {

        Locale locale = null;
        switch (userLocale.toLowerCase()) {
            case "en":
                locale = Locale.ENGLISH;
                break;
            case "ru":
                locale = new Locale("ru", "RU");
                break;
            default:
                locale = Locale.getDefault();
        }
        return locale;

    }
}
