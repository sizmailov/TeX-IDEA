// This is a generated file. Not intended for manual editing.
package com.github.sizmailov.TeXIDEA.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface TeXContext extends PsiElement {

  @Nullable
  TeXEnvironmentContext getEnvironmentContext();

  @Nullable
  TeXGenericContext getGenericContext();

  @Nullable
  TeXMathContext getMathContext();

  @Nullable
  TeXTextContext getTextContext();

  @Nullable
  PsiElement getCommentContext();

}
