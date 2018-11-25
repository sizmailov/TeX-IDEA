// This is a generated file. Not intended for manual editing.
package com.github.sizmailov.TeXIDEA.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.sizmailov.TeXIDEA.psi.impl.*;

public interface TeXTypes {

  IElementType COMMENT_CONTEXT = new TeXElementType("COMMENT_CONTEXT");
  IElementType DISPLAY_MATH_CONTEXT = new TeXElementType("DISPLAY_MATH_CONTEXT");
  IElementType ENVIRONMENT_BEGIN = new TeXElementType("ENVIRONMENT_BEGIN");
  IElementType ENVIRONMENT_CONTENT = new TeXElementType("ENVIRONMENT_CONTENT");
  IElementType ENVIRONMENT_CONTEXT = new TeXElementType("ENVIRONMENT_CONTEXT");
  IElementType ENVIRONMENT_END = new TeXElementType("ENVIRONMENT_END");
  IElementType GENERIC_CONTENT = new TeXElementType("GENERIC_CONTENT");
  IElementType GENERIC_CONTEXT = new TeXElementType("GENERIC_CONTEXT");
  IElementType GROUP = new TeXElementType("GROUP");
  IElementType INLINE_MATH_CONTEXT = new TeXElementType("INLINE_MATH_CONTEXT");
  IElementType MATH_CONTENT = new TeXElementType("MATH_CONTENT");
  IElementType MATH_CONTEXT = new TeXElementType("MATH_CONTEXT");
  IElementType NEWCOMMAND_BODY = new TeXElementType("NEWCOMMAND_BODY");
  IElementType NEWCOMMAND_CONTEXT = new TeXElementType("NEWCOMMAND_CONTEXT");
  IElementType NEWCOMMAND_NAME = new TeXElementType("NEWCOMMAND_NAME");
  IElementType NEWCOMMAND_NARGS = new TeXElementType("NEWCOMMAND_NARGS");
  IElementType NEWCOMMAND_OPTARG = new TeXElementType("NEWCOMMAND_OPTARG");
  IElementType TEXT_CONTENT = new TeXElementType("TEXT_CONTENT");
  IElementType TEXT_CONTEXT = new TeXElementType("TEXT_CONTEXT");

  IElementType BRACE_LEFT = new TeXTokenType("{");
  IElementType BRACE_RIGHT = new TeXTokenType("}");
  IElementType BRACKET_LEFT = new TeXTokenType("[");
  IElementType BRACKET_RIGHT = new TeXTokenType("]");
  IElementType COMMAND = new TeXTokenType("COMMAND");
  IElementType COMMENT_CONTEXT_TOKEN = new TeXTokenType("COMMENT_CONTEXT_TOKEN");
  IElementType DISPLAY_MATH_BEGIN_PARENTHESES = new TeXTokenType("\\[");
  IElementType DISPLAY_MATH_DOLLAR = new TeXTokenType("$$");
  IElementType DISPLAY_MATH_END_PARENTHESES = new TeXTokenType("\\]");
  IElementType DOLLARS = new TeXTokenType("$+");
  IElementType ENVIRONMENT_BEGIN_TOKEN = new TeXTokenType("\\begin");
  IElementType ENVIRONMENT_END_TOKEN = new TeXTokenType("\\end");
  IElementType ENVIRONMENT_IDENTIFIER = new TeXTokenType("ENVIRONMENT_IDENTIFIER");
  IElementType INLINE_MATH_BEGIN_PARENTHESES = new TeXTokenType("\\(");
  IElementType INLINE_MATH_DOLLAR = new TeXTokenType("$");
  IElementType INLINE_MATH_END_PARENTHESES = new TeXTokenType("\\)");
  IElementType NEWCOMMAND_TOKEN = new TeXTokenType("NEWCOMMAND_TOKEN");
  IElementType PARENTHESES_LEFT = new TeXTokenType("(");
  IElementType PARENTHESES_RIGHT = new TeXTokenType(")");
  IElementType WORD = new TeXTokenType("WORD");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == COMMENT_CONTEXT) {
        return new TeXCommentContextImpl(node);
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
      else if (type == GENERIC_CONTENT) {
        return new TeXGenericContentImpl(node);
      }
      else if (type == GENERIC_CONTEXT) {
        return new TeXGenericContextImpl(node);
      }
      else if (type == GROUP) {
        return new TeXGroupImpl(node);
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
      else if (type == NEWCOMMAND_BODY) {
        return new TeXNewcommandBodyImpl(node);
      }
      else if (type == NEWCOMMAND_CONTEXT) {
        return new TeXNewcommandContextImpl(node);
      }
      else if (type == NEWCOMMAND_NAME) {
        return new TeXNewcommandNameImpl(node);
      }
      else if (type == NEWCOMMAND_NARGS) {
        return new TeXNewcommandNargsImpl(node);
      }
      else if (type == NEWCOMMAND_OPTARG) {
        return new TeXNewcommandOptargImpl(node);
      }
      else if (type == TEXT_CONTENT) {
        return new TeXTextContentImpl(node);
      }
      else if (type == TEXT_CONTEXT) {
        return new TeXTextContextImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
