// This is a generated file. Not intended for manual editing.
package com.github.sizmailov.TeXIDEA.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface TeXEnvironmentContext extends PsiElement {

  @NotNull
  TeXEnvironmentBegin getEnvironmentBegin();

  @NotNull
  List<TeXEnvironmentContent> getEnvironmentContentList();

  @NotNull
  TeXEnvironmentEnd getEnvironmentEnd();

}