// This is a generated file. Not intended for manual editing.
package com.github.sizmailov.TeXIDEA.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface TeXMathElement extends PsiElement {

  @Nullable
  TeXEnvironmentContext getEnvironmentContext();

  @Nullable
  TeXMathGroup getMathGroup();

  @Nullable
  PsiElement getCommand();

  @Nullable
  PsiElement getWord();

}
