package com.github.sizmailov.TeXIDEA;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.*;

import javax.swing.*;

public class TeXFileType extends LanguageFileType {
    public static final TeXFileType INSTANCE = new TeXFileType();

    private TeXFileType() {
        super(TeXLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "TeX file";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "TeX language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "tex";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return TeXIcons.FILE;
    }
}