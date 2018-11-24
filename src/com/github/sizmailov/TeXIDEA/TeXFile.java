package com.github.sizmailov.TeXIDEA;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
public class TeXFile extends PsiFileBase {
    public TeXFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, TeXLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return TeXFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "TeX File";
    }

    @Override
    public Icon getIcon(int flags) {
        return super.getIcon(flags);
    }
}
