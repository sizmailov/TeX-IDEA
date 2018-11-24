// This is a generated file. Not intended for manual editing.
package com.github.sizmailov.TeXIDEA.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.github.sizmailov.TeXIDEA.psi.TeXTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class TeXParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t == CONTEXT) {
      r = context(b, 0);
    }
    else if (t == DISPLAY_MATH_CONTEXT) {
      r = display_math_context(b, 0);
    }
    else if (t == ENVIRONMENT_BEGIN) {
      r = environment_begin(b, 0);
    }
    else if (t == ENVIRONMENT_CONTENT) {
      r = environment_content(b, 0);
    }
    else if (t == ENVIRONMENT_CONTEXT) {
      r = environment_context(b, 0);
    }
    else if (t == ENVIRONMENT_END) {
      r = environment_end(b, 0);
    }
    else if (t == INLINE_MATH_CONTEXT) {
      r = inline_math_context(b, 0);
    }
    else if (t == MATH_CONTENT) {
      r = math_content(b, 0);
    }
    else if (t == MATH_CONTEXT) {
      r = math_context(b, 0);
    }
    else if (t == MATH_ELEMENT) {
      r = math_element(b, 0);
    }
    else if (t == MATH_GROUP) {
      r = math_group(b, 0);
    }
    else if (t == TEXT_CONTENT) {
      r = text_content(b, 0);
    }
    else if (t == TEXT_CONTEXT) {
      r = text_context(b, 0);
    }
    else if (t == TEXT_ELEMENT) {
      r = text_element(b, 0);
    }
    else if (t == TEXT_GROUP) {
      r = text_group(b, 0);
    }
    else {
      r = parse_root_(t, b, 0);
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return latexFile(b, l + 1);
  }

  /* ********************************************************** */
  // text_context | comment_context
  public static boolean context(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "context")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONTEXT, "<context>");
    r = text_context(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT_CONTEXT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "$$" math_content "$$" | 
  //                          "\[" math_content "\]"
  public static boolean display_math_context(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "display_math_context")) return false;
    if (!nextTokenIs(b, "<display math context>", DISPLAY_MATH_BEGIN_PARENTHESES, DISPLAY_MATH_DOLLAR)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DISPLAY_MATH_CONTEXT, "<display math context>");
    r = display_math_context_0(b, l + 1);
    if (!r) r = display_math_context_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // "$$" math_content "$$"
  private static boolean display_math_context_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "display_math_context_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DISPLAY_MATH_DOLLAR);
    r = r && math_content(b, l + 1);
    r = r && consumeToken(b, DISPLAY_MATH_DOLLAR);
    exit_section_(b, m, null, r);
    return r;
  }

  // "\[" math_content "\]"
  private static boolean display_math_context_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "display_math_context_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DISPLAY_MATH_BEGIN_PARENTHESES);
    r = r && math_content(b, l + 1);
    r = r && consumeToken(b, DISPLAY_MATH_END_PARENTHESES);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "\begin" "{" environment_identifier "}"
  public static boolean environment_begin(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "environment_begin")) return false;
    if (!nextTokenIs(b, ENVIRONMENT_BEGIN_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ENVIRONMENT_BEGIN_TOKEN, BRACE_LEFT, ENVIRONMENT_IDENTIFIER, BRACE_RIGHT);
    exit_section_(b, m, ENVIRONMENT_BEGIN, r);
    return r;
  }

  /* ********************************************************** */
  // context
  public static boolean environment_content(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "environment_content")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ENVIRONMENT_CONTENT, "<environment content>");
    r = context(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // environment_begin environment_content* environment_end
  public static boolean environment_context(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "environment_context")) return false;
    if (!nextTokenIs(b, ENVIRONMENT_BEGIN_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = environment_begin(b, l + 1);
    r = r && environment_context_1(b, l + 1);
    r = r && environment_end(b, l + 1);
    exit_section_(b, m, ENVIRONMENT_CONTEXT, r);
    return r;
  }

  // environment_content*
  private static boolean environment_context_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "environment_context_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!environment_content(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "environment_context_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // "\end" "{" environment_identifier "}"
  public static boolean environment_end(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "environment_end")) return false;
    if (!nextTokenIs(b, ENVIRONMENT_END_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ENVIRONMENT_END_TOKEN, BRACE_LEFT, ENVIRONMENT_IDENTIFIER, BRACE_RIGHT);
    exit_section_(b, m, ENVIRONMENT_END, r);
    return r;
  }

  /* ********************************************************** */
  // "$" math_content "$" |
  //                          "\(" math_content "\)"
  public static boolean inline_math_context(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inline_math_context")) return false;
    if (!nextTokenIs(b, "<inline math context>", INLINE_MATH_BEGIN_PARENTHESES, INLINE_MATH_DOLLAR)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INLINE_MATH_CONTEXT, "<inline math context>");
    r = inline_math_context_0(b, l + 1);
    if (!r) r = inline_math_context_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // "$" math_content "$"
  private static boolean inline_math_context_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inline_math_context_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INLINE_MATH_DOLLAR);
    r = r && math_content(b, l + 1);
    r = r && consumeToken(b, INLINE_MATH_DOLLAR);
    exit_section_(b, m, null, r);
    return r;
  }

  // "\(" math_content "\)"
  private static boolean inline_math_context_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inline_math_context_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INLINE_MATH_BEGIN_PARENTHESES);
    r = r && math_content(b, l + 1);
    r = r && consumeToken(b, INLINE_MATH_END_PARENTHESES);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // context*
  static boolean latexFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "latexFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!context(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "latexFile", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // math_element*
  public static boolean math_content(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "math_content")) return false;
    Marker m = enter_section_(b, l, _NONE_, MATH_CONTENT, "<math content>");
    while (true) {
      int c = current_position_(b);
      if (!math_element(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "math_content", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // inline_math_context | display_math_context
  public static boolean math_context(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "math_context")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MATH_CONTEXT, "<math context>");
    r = inline_math_context(b, l + 1);
    if (!r) r = display_math_context(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // math_group | command | word | environment_context | brackets
  public static boolean math_element(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "math_element")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MATH_ELEMENT, "<math element>");
    r = math_group(b, l + 1);
    if (!r) r = consumeToken(b, COMMAND);
    if (!r) r = consumeToken(b, WORD);
    if (!r) r = environment_context(b, l + 1);
    if (!r) r = consumeToken(b, BRACKETS);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "{" math_element* "}"
  public static boolean math_group(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "math_group")) return false;
    if (!nextTokenIs(b, BRACE_LEFT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BRACE_LEFT);
    r = r && math_group_1(b, l + 1);
    r = r && consumeToken(b, BRACE_RIGHT);
    exit_section_(b, m, MATH_GROUP, r);
    return r;
  }

  // math_element*
  private static boolean math_group_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "math_group_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!math_element(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "math_group_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // text_element+
  public static boolean text_content(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "text_content")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TEXT_CONTENT, "<text content>");
    r = text_element(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!text_element(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "text_content", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // text_content+
  public static boolean text_context(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "text_context")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TEXT_CONTEXT, "<text context>");
    r = text_content(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!text_content(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "text_context", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // text_group | word | command | environment_context | math_context | brackets
  public static boolean text_element(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "text_element")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TEXT_ELEMENT, "<text element>");
    r = text_group(b, l + 1);
    if (!r) r = consumeToken(b, WORD);
    if (!r) r = consumeToken(b, COMMAND);
    if (!r) r = environment_context(b, l + 1);
    if (!r) r = math_context(b, l + 1);
    if (!r) r = consumeToken(b, BRACKETS);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "{" text_element* "}"
  public static boolean text_group(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "text_group")) return false;
    if (!nextTokenIs(b, BRACE_LEFT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BRACE_LEFT);
    r = r && text_group_1(b, l + 1);
    r = r && consumeToken(b, BRACE_RIGHT);
    exit_section_(b, m, TEXT_GROUP, r);
    return r;
  }

  // text_element*
  private static boolean text_group_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "text_group_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!text_element(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "text_group_1", c)) break;
    }
    return true;
  }

}
