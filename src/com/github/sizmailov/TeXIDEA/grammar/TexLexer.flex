package com.github.sizmailov.TeXIDEA.grammar;

import java.util.ArrayDeque;
import java.util.Deque;

import com.intellij.psi.tree.IElementType;

import com.intellij.lexer.FlexLexer;
import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.github.sizmailov.TeXIDEA.psi.TeXTypes.*;

%%

%{
  private Deque<Integer> stack = new ArrayDeque<>();

  public void yypushState(int newState) {
    stack.push(yystate());
    yybegin(newState);
  }

  public void yypopState() {
    yybegin(stack.pop());
  }

%}

%public
%class TeXLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

//WHITE_SPACE=\s+
//
//COMMAND_IDENTIFIER=([a-zA-Z@][a-zA-Z@]+|[^a-zA-Z@\r\n])
//ENVIRONMENT_IDENTIFIER=[^{}]+
//NORMAL_TEXT_WORD=[^\s\\{}%\[\]$\(\)]+
//COMMENT_CONTENT=[^\r\n]*[\r\n]
EOL=\R
WHITE_SPACE=\s+

DISPLAY_MATH_BEGIN_PARENTHESES=\\\[
DISPLAY_MATH_END_PARENTHESES=\\\]
COMMAND=(\\([a-zA-Z@]+|\\|.))
WORD=[^\s\\{}%\[\]$\(\)]+
NEW_LINE=[\r\n]*
SPACE=[ \t\n\x0B\f\r]+
COMMENT_CONTEXT=%[^\r\n]*
ENVIRONMENT_IDENTIFIER=([^\${}])
BRAKETS=([\[\]()])

%states WITHIN_ENVIRONMENT WITHIN_TEXT_GROUP WITHIN_MATH_GROUP WITHIN_COMMENT WITHIN_MATH_CONTEXT WITHIN_INLINE_MATH_DOLLAR WITHIN_INLINE_MATH_PARENTHESES WITHIN_DISPLAY_MATH_DOLLAR WITHIN_DISPLAY_MATH_PARENTHESES OPEN_ENVIRONMENT_1 OPEN_ENVIRONMENT_2 READ_OPENED_ENVID CLOSE_ENVIRONMENT_1 CLOSE_ENVIRONMENT_2 READ_CLOSED_ENVID

%%


<YYINITIAL, WITHIN_ENVIRONMENT, WITHIN_TEXT_GROUP> {
    "$$"                                            { yypushState(WITHIN_DISPLAY_MATH_DOLLAR); return DISPLAY_MATH_DOLLAR; }
    {DISPLAY_MATH_BEGIN_PARENTHESES}                { yypushState(WITHIN_DISPLAY_MATH_PARENTHESES); return DISPLAY_MATH_BEGIN_PARENTHESES; }
    "$"                                             { yypushState(WITHIN_INLINE_MATH_DOLLAR); return INLINE_MATH_DOLLAR; }
    "\\("                                           { yypushState(WITHIN_INLINE_MATH_PARENTHESES); return INLINE_MATH_BEGIN_PARENTHESES; }

}

<WITHIN_DISPLAY_MATH_PARENTHESES> {
    {DISPLAY_MATH_BEGIN_PARENTHESES}               { yypopState(); return DISPLAY_MATH_END_PARENTHESES; }
}

<WITHIN_DISPLAY_MATH_DOLLAR> {
    "$$"                                            { yypopState(); return DISPLAY_MATH_DOLLAR; }
}

<WITHIN_INLINE_MATH_PARENTHESES> {
    "\\)"                                          { yypopState(); return INLINE_MATH_END_PARENTHESES; }
}


<WITHIN_INLINE_MATH_DOLLAR> {
    "$"                                            { yypopState(); return INLINE_MATH_DOLLAR; }
}


<WITHIN_ENVIRONMENT>{
 "\\end"       { yybegin(CLOSE_ENVIRONMENT_1); return ENVIRONMENT_CONTEXT; }
}

<YYINITIAL, WITHIN_ENVIRONMENT, WITHIN_TEXT_GROUP, WITHIN_MATH_GROUP, WITHIN_MATH_CONTEXT, OPEN_ENVIRONMENT_1,WITHIN_DISPLAY_MATH_DOLLAR, WITHIN_INLINE_MATH_DOLLAR,WITHIN_DISPLAY_MATH_PARENTHESES, WITHIN_INLINE_MATH_PARENTHESES> {
 "\\begin"                  { yybegin(OPEN_ENVIRONMENT_1); return ENVIRONMENT_BEGIN; }
 {BRAKETS}                                                    { return BRACKETS; }
 {WHITE_SPACE}                                                { return WHITE_SPACE; }
 {COMMENT_CONTEXT}                                            { return COMMENT_CONTEXT; }
 {COMMAND}                                                    { return COMMAND;}
 {WORD}                                                       { return WORD; }
}

<OPEN_ENVIRONMENT_1>{
    "{"  { yybegin(READ_OPENED_ENVID); return BRACE_LEFT; }
}

<READ_OPENED_ENVID>{
    {ENVIRONMENT_IDENTIFIER}  { yybegin(OPEN_ENVIRONMENT_2); return ENVIRONMENT_IDENTIFIER; }
}

<OPEN_ENVIRONMENT_2>{
    "}"  { yypushState(WITHIN_ENVIRONMENT); return BRACE_RIGHT; }
}

<CLOSE_ENVIRONMENT_1>{
    "{"  { yybegin(READ_CLOSED_ENVID); return BRACE_LEFT; }
}

<READ_CLOSED_ENVID>{
    {ENVIRONMENT_IDENTIFIER}  { yybegin(CLOSE_ENVIRONMENT_2); return ENVIRONMENT_IDENTIFIER; }
}

<CLOSE_ENVIRONMENT_2>{
    "}" { yypushState(WITHIN_ENVIRONMENT); return BRACE_RIGHT; }
}



<YYINITIAL, WITHIN_ENVIRONMENT, WITHIN_TEXT_GROUP>{
 "{"                                                          { yypushState(WITHIN_TEXT_GROUP); return GROUP_BEGIN; }
}

<WITHIN_MATH_CONTEXT, WITHIN_MATH_GROUP>{
 "{"                                                          { yypushState(WITHIN_MATH_GROUP); return GROUP_BEGIN; }
}


<WITHIN_MATH_GROUP>{
 "}"                                                           { yypopState(); return MATH_GROUP; }
}

<WITHIN_TEXT_GROUP>{
 "}"                                                           { yypopState(); return TEXT_GROUP; }
}



[^] { return BAD_CHARACTER; }
