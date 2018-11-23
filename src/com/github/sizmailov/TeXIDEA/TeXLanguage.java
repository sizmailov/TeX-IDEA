package com.github.sizmailov.TeXIDEA;

import com.intellij.lang.Language;

public class TeXLanguage extends Language {
    public static final TeXLanguage INSTANCE = new TeXLanguage();

    private TeXLanguage() {
        super("TeX");
    }
}
