package com.github.sizmailov.TeXIDEA.psi;

import com.intellij.psi.tree.IElementType;
import com.github.sizmailov.TeXIDEA.TeXLanguage;
import org.jetbrains.annotations.*;

public class TeXElementType extends IElementType {
    public TeXElementType(@NotNull @NonNls String debugName) {
        super(debugName, TeXLanguage.INSTANCE);
    }
}
