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
    if (t == COMMENT_CONTEXT) {
      r = comment_context(b, 0);
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
    else if (t == GENERIC_CONTENT) {
      r = generic_content(b, 0);
    }
    else if (t == GENERIC_CONTEXT) {
      r = generic_context(b, 0);
    }
    else if (t == GROUP) {
      r = group(b, 0);
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
    else if (t == NEWCOMMAND_BODY) {
      r = newcommand_body(b, 0);
    }
    else if (t == NEWCOMMAND_CONTEXT) {
      r = newcommand_context(b, 0);
    }
    else if (t == NEWCOMMAND_NAME) {
      r = newcommand_name(b, 0);
    }
    else if (t == NEWCOMMAND_NARGS) {
      r = newcommand_nargs(b, 0);
    }
    else if (t == NEWCOMMAND_OPTARG) {
      r = newcommand_optarg(b, 0);
    }
    else if (t == TEXT_CONTENT) {
      r = text_content(b, 0);
    }
    else if (t == TEXT_CONTEXT) {
      r = text_context(b, 0);
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
  // "(" | ")" | "[" | "]"
  static boolean brackets(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "brackets")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PARENTHESES_LEFT);
    if (!r) r = consumeToken(b, PARENTHESES_RIGHT);
    if (!r) r = consumeToken(b, BRACKET_LEFT);
    if (!r) r = consumeToken(b, BRACKET_RIGHT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // COMMENT_CONTEXT_TOKEN
  public static boolean comment_context(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comment_context")) return false;
    if (!nextTokenIs(b, COMMENT_CONTEXT_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMENT_CONTEXT_TOKEN);
    exit_section_(b, m, COMMENT_CONTEXT, r);
    return r;
  }

  /* ********************************************************** */
  // comment_context | environment_context | math_context | text_context | generic_context | newcommand_context
  static boolean context(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "context")) return false;
    boolean r;
    r = comment_context(b, l + 1);
    if (!r) r = environment_context(b, l + 1);
    if (!r) r = math_context(b, l + 1);
    if (!r) r = text_context(b, l + 1);
    if (!r) r = generic_context(b, l + 1);
    if (!r) r = newcommand_context(b, l + 1);
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
  // "\begin" "{" ENVIRONMENT_IDENTIFIER "}"
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
  // context*
  public static boolean environment_content(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "environment_content")) return false;
    Marker m = enter_section_(b, l, _NONE_, ENVIRONMENT_CONTENT, "<environment content>");
    while (true) {
      int c = current_position_(b);
      if (!context(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "environment_content", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // environment_begin environment_content environment_end
  public static boolean environment_context(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "environment_context")) return false;
    if (!nextTokenIs(b, ENVIRONMENT_BEGIN_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = environment_begin(b, l + 1);
    r = r && environment_content(b, l + 1);
    r = r && environment_end(b, l + 1);
    exit_section_(b, m, ENVIRONMENT_CONTEXT, r);
    return r;
  }

  /* ********************************************************** */
  // "\end" "{" ENVIRONMENT_IDENTIFIER "}"
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
  // generic_element+
  public static boolean generic_content(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generic_content")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, GENERIC_CONTENT, "<generic content>");
    r = generic_element(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!generic_element(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "generic_content", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // generic_content
  public static boolean generic_context(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generic_context")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, GENERIC_CONTEXT, "<generic context>");
    r = generic_content(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // group | WORD | COMMAND | brackets | DOLLARS
  static boolean generic_element(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "generic_element")) return false;
    boolean r;
    r = group(b, l + 1);
    if (!r) r = consumeToken(b, WORD);
    if (!r) r = consumeToken(b, COMMAND);
    if (!r) r = brackets(b, l + 1);
    if (!r) r = consumeToken(b, DOLLARS);
    return r;
  }

  /* ********************************************************** */
  // "{" context* "}"
  public static boolean group(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "group")) return false;
    if (!nextTokenIs(b, BRACE_LEFT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BRACE_LEFT);
    r = r && group_1(b, l + 1);
    r = r && consumeToken(b, BRACE_RIGHT);
    exit_section_(b, m, GROUP, r);
    return r;
  }

  // context*
  private static boolean group_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "group_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!context(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "group_1", c)) break;
    }
    return true;
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
  // group | COMMAND | WORD | brackets | environment_context
  static boolean math_element(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "math_element")) return false;
    boolean r;
    r = group(b, l + 1);
    if (!r) r = consumeToken(b, COMMAND);
    if (!r) r = consumeToken(b, WORD);
    if (!r) r = brackets(b, l + 1);
    if (!r) r = environment_context(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // generic_context?
  public static boolean newcommand_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "newcommand_body")) return false;
    Marker m = enter_section_(b, l, _NONE_, NEWCOMMAND_BODY, "<newcommand body>");
    generic_context(b, l + 1);
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // NEWCOMMAND_TOKEN newcommand_name ( "[" newcommand_nargs "]" ("[" newcommand_optarg "]")? )? "{" newcommand_body "}"
  public static boolean newcommand_context(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "newcommand_context")) return false;
    if (!nextTokenIs(b, NEWCOMMAND_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NEWCOMMAND_TOKEN);
    r = r && newcommand_name(b, l + 1);
    r = r && newcommand_context_2(b, l + 1);
    r = r && consumeToken(b, BRACE_LEFT);
    r = r && newcommand_body(b, l + 1);
    r = r && consumeToken(b, BRACE_RIGHT);
    exit_section_(b, m, NEWCOMMAND_CONTEXT, r);
    return r;
  }

  // ( "[" newcommand_nargs "]" ("[" newcommand_optarg "]")? )?
  private static boolean newcommand_context_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "newcommand_context_2")) return false;
    newcommand_context_2_0(b, l + 1);
    return true;
  }

  // "[" newcommand_nargs "]" ("[" newcommand_optarg "]")?
  private static boolean newcommand_context_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "newcommand_context_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BRACKET_LEFT);
    r = r && newcommand_nargs(b, l + 1);
    r = r && consumeToken(b, BRACKET_RIGHT);
    r = r && newcommand_context_2_0_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ("[" newcommand_optarg "]")?
  private static boolean newcommand_context_2_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "newcommand_context_2_0_3")) return false;
    newcommand_context_2_0_3_0(b, l + 1);
    return true;
  }

  // "[" newcommand_optarg "]"
  private static boolean newcommand_context_2_0_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "newcommand_context_2_0_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BRACKET_LEFT);
    r = r && newcommand_optarg(b, l + 1);
    r = r && consumeToken(b, BRACKET_RIGHT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "{" COMMAND "}" | COMMAND
  public static boolean newcommand_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "newcommand_name")) return false;
    if (!nextTokenIs(b, "<newcommand name>", BRACE_LEFT, COMMAND)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NEWCOMMAND_NAME, "<newcommand name>");
    r = parseTokens(b, 0, BRACE_LEFT, COMMAND, BRACE_RIGHT);
    if (!r) r = consumeToken(b, COMMAND);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // WORD
  public static boolean newcommand_nargs(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "newcommand_nargs")) return false;
    if (!nextTokenIs(b, WORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WORD);
    exit_section_(b, m, NEWCOMMAND_NARGS, r);
    return r;
  }

  /* ********************************************************** */
  // (group | WORD | COMMAND | "(" | ")" | "["  | DOLLARS)*
  public static boolean newcommand_optarg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "newcommand_optarg")) return false;
    Marker m = enter_section_(b, l, _NONE_, NEWCOMMAND_OPTARG, "<newcommand optarg>");
    while (true) {
      int c = current_position_(b);
      if (!newcommand_optarg_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "newcommand_optarg", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // group | WORD | COMMAND | "(" | ")" | "["  | DOLLARS
  private static boolean newcommand_optarg_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "newcommand_optarg_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = group(b, l + 1);
    if (!r) r = consumeToken(b, WORD);
    if (!r) r = consumeToken(b, COMMAND);
    if (!r) r = consumeToken(b, PARENTHESES_LEFT);
    if (!r) r = consumeToken(b, PARENTHESES_RIGHT);
    if (!r) r = consumeToken(b, BRACKET_LEFT);
    if (!r) r = consumeToken(b, DOLLARS);
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
  // text_content
  public static boolean text_context(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "text_context")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TEXT_CONTEXT, "<text context>");
    r = text_content(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // group | WORD | COMMAND | brackets
  static boolean text_element(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "text_element")) return false;
    boolean r;
    r = group(b, l + 1);
    if (!r) r = consumeToken(b, WORD);
    if (!r) r = consumeToken(b, COMMAND);
    if (!r) r = brackets(b, l + 1);
    return r;
  }

}
