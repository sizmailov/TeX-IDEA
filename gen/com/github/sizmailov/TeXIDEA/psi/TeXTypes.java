// This is a generated file. Not intended for manual editing.
package com.github.sizmailov.TeXIDEA.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.sizmailov.TeXIDEA.psi.impl.*;

public interface TeXTypes {

  IElementType CONTEXT = new TeXElementType("CONTEXT");
  IElementType DISPLAY_MATH_CONTEXT = new TeXElementType("DISPLAY_MATH_CONTEXT");
  IElementType ENVIRONMENT_BEGIN = new TeXElementType("ENVIRONMENT_BEGIN");
  IElementType ENVIRONMENT_CONTENT = new TeXElementType("ENVIRONMENT_CONTENT");
  IElementType ENVIRONMENT_CONTEXT = new TeXElementType("ENVIRONMENT_CONTEXT");
  IElementType ENVIRONMENT_END = new TeXElementType("ENVIRONMENT_END");
  IElementType INLINE_MATH_CONTEXT = new TeXElementType("INLINE_MATH_CONTEXT");
  IElementType MATH_CONTENT = new TeXElementType("MATH_CONTENT");
  IElementType MATH_CONTEXT = new TeXElementType("MATH_CONTEXT");
  IElementType MATH_ELEMENT = new TeXElementType("MATH_ELEMENT");
  IElementType MATH_GROUP = new TeXElementType("MATH_GROUP");
  IElementType TEXT_CONTENT = new TeXElementType("TEXT_CONTENT");
  IElementType TEXT_CONTEXT = new TeXElementType("TEXT_CONTEXT");
  IElementType TEXT_ELEMENT = new TeXElementType("TEXT_ELEMENT");
  IElementType TEXT_GROUP = new TeXElementType("TEXT_GROUP");

  IElementType BRACE_LEFT = new TeXTokenType("{");
  IElementType BRACE_RIGHT = new TeXTokenType("}");
  IElementType BRACKETS = new TeXTokenType("brackets");
  IElementType BRACKET_LEFT = new TeXTokenType("[");
  IElementType BRACKET_RIGHT = new TeXTokenType("]");
  IElementType BRAKETS = new TeXTokenType("brakets");
  IElementType COMMAND = new TeXTokenType("command");
  IElementType COMMENT_BEGIN = new TeXTokenType("%");
  IElementType COMMENT_CONTEXT = new TeXTokenType("comment_context");
  IElementType DISPLAY_MATH_BEGIN_PARENTHESES = new TeXTokenType("\\[");
  IElementType DISPLAY_MATH_DOLLAR = new TeXTokenType("$$");
  IElementType DISPLAY_MATH_END_PARENTHESES = new TeXTokenType("\\]");
  IElementType ENVIRONMENT_BEGIN_TOKEN = new TeXTokenType("\\begin");
  IElementType ENVIRONMENT_END_TOKEN = new TeXTokenType("\\end");
  IElementType ENVIRONMENT_IDENTIFIER = new TeXTokenType("environment_identifier");
  IElementType ESCAPE = new TeXTokenType("\\\\");
  IElementType INLINE_MATH_BEGIN_PARENTHESES = new TeXTokenType("\\(");
  IElementType INLINE_MATH_DOLLAR = new TeXTokenType("$");
  IElementType INLINE_MATH_END_PARENTHESES = new TeXTokenType("\\)");
  IElementType PARENTHESES_LEFT = new TeXTokenType("(");
  IElementType PARENTHESES_RIGHT = new TeXTokenType(")");
  IElementType WORD = new TeXTokenType("word");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == CONTEXT) {
        return new TeXContextImpl(node);
      }
      else if (type == DISPLAY_MATH_CONTEXT) {
        return new TeXDisplayMathContextImpl(node);
      }
      else if (type == ENVIRONMENT_BEGIN) {
        return new TeXEnvironmentBeginImpl(node);
      }
      else if (type == ENVIRONMENT_CONTENT) {
        return new TeXEnvironmentContentImpl(node);
      }
      else if (type == ENVIRONMENT_CONTEXT) {
        return new TeXEnvironmentContextImpl(node);
      }
      else if (type == ENVIRONMENT_END) {
        return new TeXEnvironmentEndImpl(node);
      }
      else if (type == INLINE_MATH_CONTEXT) {
        return new TeXInlineMathContextImpl(node);
      }
      else if (type == MATH_CONTENT) {
        return new TeXMathContentImpl(node);
      }
      else if (type == MATH_CONTEXT) {
        return new TeXMathContextImpl(node);
      }
      else if (type == MATH_ELEMENT) {
        return new TeXMathElementImpl(node);
      }
      else if (type == MATH_GROUP) {
        return new TeXMathGroupImpl(node);
      }
      else if (type == TEXT_CONTENT) {
        return new TeXTextContentImpl(node);
      }
      else if (type == TEXT_CONTEXT) {
        return new TeXTextContextImpl(node);
      }
      else if (type == TEXT_ELEMENT) {
        return new TeXTextElementImpl(node);
      }
      else if (type == TEXT_GROUP) {
        return new TeXTextGroupImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
