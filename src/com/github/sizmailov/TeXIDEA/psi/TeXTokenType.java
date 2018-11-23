package com.github.sizmailov.TeXIDEA.psi;


import com.intellij.psi.tree.IElementType;
import com.github.sizmailov.TeXIDEA.TeXLanguage;
import org.jetbrains.annotations.*;

public class TeXTokenType extends IElementType {
    public TeXTokenType(@NotNull @NonNls String debugName) {
        super(debugName, TeXLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "TeXTokenType." + super.toString();
    }
}