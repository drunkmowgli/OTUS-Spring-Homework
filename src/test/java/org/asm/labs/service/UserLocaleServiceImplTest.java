package org.asm.labs.service;

import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserLocaleServiceImplTest {

    @Test
    void getUserLocale() {
        UserLocaleService userLocaleService = new UserLocaleServiceImpl();
        assertEquals(userLocaleService.getUserLocale("en"), Locale.ENGLISH);
        assertEquals(userLocaleService.getUserLocale("EN"), Locale.ENGLISH);
        assertEquals(userLocaleService.getUserLocale("ru"), Locale.getDefault());
        assertEquals(userLocaleService.getUserLocale("default"), Locale.getDefault());
    }
}