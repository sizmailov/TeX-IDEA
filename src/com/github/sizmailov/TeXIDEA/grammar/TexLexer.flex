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
  public void log(String stateName){
      System.out.println(new String(new char[stack.size()]).replace("\0", " ") + "->" + stateName);
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
ENVIRONMENT_IDENTIFIER=([^\${}]+)
BRAKETS=([\[\]()])

%states WITHIN_ENVIRONMENT WITHIN_TEXT_GROUP WITHIN_MATH_GROUP WITHIN_COMMENT WITHIN_MATH_CONTEXT WITHIN_INLINE_MATH_DOLLAR WITHIN_INLINE_MATH_PARENTHESES WITHIN_DISPLAY_MATH_DOLLAR WITHIN_DISPLAY_MATH_PARENTHESES OPEN_ENVIRONMENT_1 OPEN_ENVIRONMENT_2 READ_OPENED_ENVID CLOSE_ENVIRONMENT_1 CLOSE_ENVIRONMENT_2 READ_CLOSED_ENVID

%%


<YYINITIAL, WITHIN_ENVIRONMENT, WITHIN_TEXT_GROUP> {
    "$$"                                            { log("$$ in "); yypushState(WITHIN_DISPLAY_MATH_DOLLAR); return DISPLAY_MATH_DOLLAR; }
    {DISPLAY_MATH_BEGIN_PARENTHESES}                { log("\\[ in "); yypushState(WITHIN_DISPLAY_MATH_PARENTHESES); return DISPLAY_MATH_BEGIN_PARENTHESES; }
    "$"                                             { log("$ in "); yypushState(WITHIN_INLINE_MATH_DOLLAR); return INLINE_MATH_DOLLAR; }
    "\\("                                           { log("\\( in ");yypushState(WITHIN_INLINE_MATH_PARENTHESES); return INLINE_MATH_BEGIN_PARENTHESES; }

}

<WITHIN_DISPLAY_MATH_PARENTHESES> {
    {DISPLAY_MATH_BEGIN_PARENTHESES}               { log("\\] out");yypopState(); return DISPLAY_MATH_END_PARENTHESES; }
}

<WITHIN_DISPLAY_MATH_DOLLAR> {
    "$$"                                            { log("$$ out");yypopState(); return DISPLAY_MATH_DOLLAR; }
}

<WITHIN_INLINE_MATH_PARENTHESES> {
    "\\)"                                          { log("\\) out"); yypopState(); return INLINE_MATH_END_PARENTHESES; }
}


<WITHIN_INLINE_MATH_DOLLAR> {
    "$"                                            { log("$ out");yypopState(); return INLINE_MATH_DOLLAR; }
}


<WITHIN_ENVIRONMENT>{
 "\\end"       { log("env out"); yybegin(CLOSE_ENVIRONMENT_1); return ENVIRONMENT_END; }
}


<OPEN_ENVIRONMENT_1>{
    "{"  { log("env in {");  yybegin(READ_OPENED_ENVID); return BRACE_LEFT; }
}

<READ_OPENED_ENVID>{
    {ENVIRONMENT_IDENTIFIER}  { log("env in <id>"); yybegin(OPEN_ENVIRONMENT_2); return ENVIRONMENT_IDENTIFIER; }
}

<OPEN_ENVIRONMENT_2>{
    "}"  { log("env in }"); yypushState(WITHIN_ENVIRONMENT); return BRACE_RIGHT; }
}

<CLOSE_ENVIRONMENT_1>{
    "{"  { log("env out {"); yybegin(READ_CLOSED_ENVID); return BRACE_LEFT; }
}

<READ_CLOSED_ENVID>{
    {ENVIRONMENT_IDENTIFIER}  { log("env out <id>"); yybegin(CLOSE_ENVIRONMENT_2); return ENVIRONMENT_IDENTIFIER; }
}

<CLOSE_ENVIRONMENT_2>{
    "}" { log("env out }"); yypopState(); return BRACE_RIGHT; }
}



<YYINITIAL, WITHIN_ENVIRONMENT, WITHIN_TEXT_GROUP>{
 "{"                                                          { log("text group in {"); yypushState(WITHIN_TEXT_GROUP); return BRACE_LEFT; }
}

<WITHIN_MATH_CONTEXT, WITHIN_MATH_GROUP>{
 "{"                                                          { log("math group in {"); yypushState(WITHIN_MATH_GROUP); return BRACE_LEFT; }
}


<WITHIN_MATH_GROUP>{
 "}"                                                           { log("math group out }"); yypopState(); return BRACE_RIGHT; }
}

<WITHIN_TEXT_GROUP>{
 "}"                                                           { log("text group out }"); yypopState(); return BRACE_RIGHT; }
}



<YYINITIAL, WITHIN_ENVIRONMENT, WITHIN_TEXT_GROUP, WITHIN_MATH_GROUP, WITHIN_MATH_CONTEXT, OPEN_ENVIRONMENT_1,WITHIN_DISPLAY_MATH_DOLLAR, WITHIN_INLINE_MATH_DOLLAR,WITHIN_DISPLAY_MATH_PARENTHESES, WITHIN_INLINE_MATH_PARENTHESES> {
 "\\begin"                  { log("env in"); yybegin(OPEN_ENVIRONMENT_1); return ENVIRONMENT_BEGIN; }
 {BRAKETS}                                                    {log("[]()"); return BRACKETS; }
 {WHITE_SPACE}                                                {log("<space>"); return WHITE_SPACE; }
 {COMMENT_CONTEXT}                                            {log("<comment>"); return COMMENT_CONTEXT; }
 {COMMAND}                                                    {log("<command>");  return COMMAND;}
 {WORD}                                                       {log("<word>");  return WORD; }
}



[^] { return BAD_CHARACTER; }
