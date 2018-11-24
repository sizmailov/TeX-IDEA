// This is a generated file. Not intended for manual editing.
package com.github.sizmailov.TeXIDEA.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.sizmailov.TeXIDEA.psi.TeXTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.github.sizmailov.TeXIDEA.psi.*;

public class TeXMathContentImpl extends ASTWrapperPsiElement implements TeXMathContent {

  public TeXMathContentImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull TeXVisitor visitor) {
    visitor.visitMathContent(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof TeXVisitor) accept((TeXVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<TeXMathElement> getMathElementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, TeXMathElement.class);
  }

}
