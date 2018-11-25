// This is a generated file. Not intended for manual editing.
package com.github.sizmailov.TeXIDEA.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface TeXGroup extends PsiElement {

  @NotNull
  List<TeXCommentContext> getCommentContextList();

  @NotNull
  List<TeXEnvironmentContext> getEnvironmentContextList();

  @NotNull
  List<TeXGenericContext> getGenericContextList();

  @NotNull
  List<TeXMathContext> getMathContextList();

  @NotNull
  List<TeXNewcommandContext> getNewcommandContextList();

  @NotNull
  List<TeXTextContext> getTextContextList();

}
