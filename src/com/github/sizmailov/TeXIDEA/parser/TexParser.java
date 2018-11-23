// This is a generated file. Not intended for manual editing.
package com.github.sizmailov.TeXIDEA.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.github.sizmailov.TeXIDEA.psi.TexTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class TexParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t == COMMAND) {
      r = command(b, 0);
    }
    else if (t == COMMENT_CONTEXT) {
      r = comment_context(b, 0);
    }
    else if (t == CONTENT) {
      r = content(b, 0);
    }
    else if (t == CONTEXT_WITHIN_MATH) {
      r = context_within_math(b, 0);
    }
    else if (t == ENVIRONMENT) {
      r = environment(b, 0);
    }
    else if (t == GROUP) {
      r = group(b, 0);
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
    else if (t == TEXT_CONTENT) {
      r = text_content(b, 0);
    }
    else if (t == TEXT_CONTEXT) {
      r = text_context(b, 0);
    }
    else if (t == TEXT_ELEMENT) {
      r = text_element(b, 0);
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
  // "\\" COMMAND_IDENTIFIER
  public static boolean command(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMMAND, "<command>");
    r = consumeToken(b, "\\");
    r = r && consumeToken(b, COMMAND_IDENTIFIER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "%" COMMENT_CONTENT
  public static boolean comment_context(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comment_context")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMMENT_CONTEXT, "<comment context>");
    r = consumeToken(b, "%");
    r = r && consumeToken(b, COMMENT_CONTENT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // math_context | text_context | comment_context
  public static boolean content(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "content")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONTENT, "<content>");
    r = math_context(b, l + 1);
    if (!r) r = text_context(b, l + 1);
    if (!r) r = comment_context(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "\\mbox" "{" content "}"
  public static boolean context_within_math(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "context_within_math")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONTEXT_WITHIN_MATH, "<context within math>");
    r = consumeToken(b, "\\mbox");
    r = r && consumeToken(b, "{");
    r = r && content(b, l + 1);
    r = r && consumeToken(b, "}");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ENV_BEGIN "{" ENVIRONMENT_IDENTIFIER "}" text_element* ENV_END "{" ENVIRONMENT_IDENTIFIER "}"
  public static boolean environment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "environment")) return false;
    if (!nextTokenIs(b, ENV_BEGIN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ENV_BEGIN);
    r = r && consumeToken(b, "{");
    r = r && consumeToken(b, ENVIRONMENT_IDENTIFIER);
    r = r && consumeToken(b, "}");
    r = r && environment_4(b, l + 1);
    r = r && consumeToken(b, ENV_END);
    r = r && consumeToken(b, "{");
    r = r && consumeToken(b, ENVIRONMENT_IDENTIFIER);
    r = r && consumeToken(b, "}");
    exit_section_(b, m, ENVIRONMENT, r);
    return r;
  }

  // text_element*
  private static boolean environment_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "environment_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!text_element(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "environment_4", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // "{" text_element "}"
  public static boolean group(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "group")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, GROUP, "<group>");
    r = consumeToken(b, "{");
    r = r && text_element(b, l + 1);
    r = r && consumeToken(b, "}");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // content*
  static boolean latexFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "latexFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!content(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "latexFile", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // math_element+
  public static boolean math_content(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "math_content")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MATH_CONTENT, "<math content>");
    r = math_element(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!math_element(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "math_content", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "\\[" math_content* "\\]"
  //     "\\(" math_content* "\\)"
  //     "$$" math_content* "$$"
  //     "$" math_content* "$"
  public static boolean math_context(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "math_context")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MATH_CONTEXT, "<math context>");
    r = consumeToken(b, "\\[");
    r = r && math_context_1(b, l + 1);
    r = r && consumeToken(b, "\\]");
    r = r && consumeToken(b, "\\(");
    r = r && math_context_4(b, l + 1);
    r = r && consumeToken(b, "\\)");
    r = r && consumeToken(b, "$$");
    r = r && math_context_7(b, l + 1);
    r = r && consumeToken(b, "$$");
    r = r && consumeToken(b, "$");
    r = r && math_context_10(b, l + 1);
    r = r && consumeToken(b, "$");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // math_content*
  private static boolean math_context_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "math_context_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!math_content(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "math_context_1", c)) break;
    }
    return true;
  }

  // math_content*
  private static boolean math_context_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "math_context_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!math_content(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "math_context_4", c)) break;
    }
    return true;
  }

  // math_content*
  private static boolean math_context_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "math_context_7")) return false;
    while (true) {
      int c = current_position_(b);
      if (!math_content(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "math_context_7", c)) break;
    }
    return true;
  }

  // math_content*
  private static boolean math_context_10(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "math_context_10")) return false;
    while (true) {
      int c = current_position_(b);
      if (!math_content(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "math_context_10", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // context_within_math |
  //         NORMAL_TEXT_WORD |
  //         command |
  //         "{" math_element "}" |
  //         "[" math_element "]" |
  //         "(" math_element ")"
  public static boolean math_element(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "math_element")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MATH_ELEMENT, "<math element>");
    r = context_within_math(b, l + 1);
    if (!r) r = consumeToken(b, NORMAL_TEXT_WORD);
    if (!r) r = command(b, l + 1);
    if (!r) r = math_element_3(b, l + 1);
    if (!r) r = math_element_4(b, l + 1);
    if (!r) r = math_element_5(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // "{" math_element "}"
  private static boolean math_element_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "math_element_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "{");
    r = r && math_element(b, l + 1);
    r = r && consumeToken(b, "}");
    exit_section_(b, m, null, r);
    return r;
  }

  // "[" math_element "]"
  private static boolean math_element_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "math_element_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "[");
    r = r && math_element(b, l + 1);
    r = r && consumeToken(b, "]");
    exit_section_(b, m, null, r);
    return r;
  }

  // "(" math_element ")"
  private static boolean math_element_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "math_element_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "(");
    r = r && math_element(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
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
  // group | NORMAL_TEXT_WORD | command | environment
  public static boolean text_element(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "text_element")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TEXT_ELEMENT, "<text element>");
    r = group(b, l + 1);
    if (!r) r = consumeToken(b, NORMAL_TEXT_WORD);
    if (!r) r = command(b, l + 1);
    if (!r) r = environment(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

}
