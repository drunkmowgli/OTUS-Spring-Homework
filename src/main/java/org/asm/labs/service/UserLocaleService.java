package org.asm.labs.service;

import java.util.Locale;

public interface UserLocaleService {

    /**
     * Returns Users's Locale.
     * @param userLocale - Users's input locale choice
     * @return Users's Locale.
     */

    Locale getUserLocale(String userLocale);

}
