// This is a generated file. Not intended for manual editing.
package com.github.sizmailov.TeXIDEA.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface TeXNewcommandContext extends PsiElement {

  @NotNull
  TeXNewcommandBody getNewcommandBody();

  @NotNull
  TeXNewcommandName getNewcommandName();

  @Nullable
  TeXNewcommandNargs getNewcommandNargs();

  @Nullable
  TeXNewcommandOptarg getNewcommandOptarg();

  @NotNull
  PsiElement getNewcommandToken();

}
