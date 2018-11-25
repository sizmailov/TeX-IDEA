// This is a generated file. Not intended for manual editing.
package com.github.sizmailov.TeXIDEA.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface TeXNewcommand extends PsiElement {

  @NotNull
  TeXNewcommandBody getNewcommandBody();

  @Nullable
  TeXNewcommandNargs getNewcommandNargs();

  @Nullable
  TeXNewcommandOptArgDefault getNewcommandOptArgDefault();

  @NotNull
  PsiElement getGenericCommand();

  @NotNull
  PsiElement getNewcommandToken();

}
