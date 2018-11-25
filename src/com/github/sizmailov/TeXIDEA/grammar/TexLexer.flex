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
//    System.out.println("Save state " + yystate());
    stack.push(yystate());
//    System.out.println("Set new state " + newState);
    yybegin(newState);
  }

  public void yypopState() {
    yybegin(stack.pop());
//    System.out.println("Restore state " + yystate());
  }
  public void log(String stateName){
//      System.out.println(new String(new char[stack.size()]).replace("\0", " ") + "->" + stateName);
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

DOLLARS=\$+
COMMAND=(\\([a-zA-Z@]+|.|\n|\r))
WORD=[^\s\\{}%\[\]$\(\)]+
NEW_LINE=[\r\n]*
SPACE=[ \t\n\x0B\f\r]+
NEWCOMMAND_TOKEN=\\(re)?newcommand\*?
COMMENT_CONTEXT=%[^\r\n]*
ENVIRONMENT_IDENTIFIER=([^\${}]+)
BRAKETS=([\[\]()])

//%states WITHIN_ENVIRONMENT WITHIN_TEXT_GROUP WITHIN_MATH_GROUP

%states WITHIN_GROUP
%states WITHIN_GENERIC_CONTEXT
//newcommand
%states EXPECT_NEWCOMMAND_NAME EXPECT_NEWCOMMAND_NARGS EXPECT_NEWCOMMAND_OPTARG EXPECT_NEWCOMMAND_BODY
%states WITHIN_NEWCOMMAND_OPTARG WITHIN_NEWCOMMAND_BODY
// math
%states WITHIN_INLINE_MATH_DOLLAR WITHIN_INLINE_MATH_PARENTHESES
%states WITHIN_DISPLAY_MATH_DOLLAR WITHIN_DISPLAY_MATH_PARENTHESES
// env
%states WITHIN_ENV
%states EXPECT_ENV_BEGIN_OPEN_BRACE EXPECT_ENV_BEGIN_ID  EXPECT_ENV_BEGIN_CLOSE_BRACE
%states EXPECT_ENV_END_OPEN_BRACE EXPECT_ENV_END_ID EXPECT_ENV_END_CLOSE_BRACE

%%


<YYINITIAL, WITHIN_ENV, WITHIN_GROUP> {
    "$$"                                            { log("$$ in "); yypushState(WITHIN_DISPLAY_MATH_DOLLAR); return DISPLAY_MATH_DOLLAR; }
    "\\["                                           { log("\\[ in "); yypushState(WITHIN_DISPLAY_MATH_PARENTHESES); return DISPLAY_MATH_BEGIN_PARENTHESES; }
    "$"                                             { log("$ in "); yypushState(WITHIN_INLINE_MATH_DOLLAR); return INLINE_MATH_DOLLAR; }
    "\\("                                           { log("\\( in ");yypushState(WITHIN_INLINE_MATH_PARENTHESES); return INLINE_MATH_BEGIN_PARENTHESES; }
}

<WITHIN_DISPLAY_MATH_PARENTHESES> {
    "\\]"                                           { log("\\] out");yypopState(); return DISPLAY_MATH_END_PARENTHESES; }
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

<WITHIN_ENV>{
 "\\end"       { log("env out"); yybegin(EXPECT_ENV_END_OPEN_BRACE); return ENVIRONMENT_END_TOKEN; }
}




<EXPECT_ENV_BEGIN_OPEN_BRACE>{
    "{"  { log("env in {");  yybegin(EXPECT_ENV_BEGIN_ID); return BRACE_LEFT; }
}

<EXPECT_ENV_BEGIN_ID>{
    {ENVIRONMENT_IDENTIFIER}  { log("env in <id>"); yybegin(EXPECT_ENV_BEGIN_CLOSE_BRACE); return ENVIRONMENT_IDENTIFIER; }
}

<EXPECT_ENV_BEGIN_CLOSE_BRACE>{
    "}"  { log("env in }"); yybegin(WITHIN_ENV); return BRACE_RIGHT; }
}


<EXPECT_NEWCOMMAND_NAME>{
    {WHITE_SPACE}             {log("<space>"); return WHITE_SPACE;}
    "{"        { log("new cmd name {"); return BRACE_LEFT; }
    {COMMAND}  { log("new cmd name <name>"); return COMMAND; }
    "}"        { log("new cmd name }"); yybegin(EXPECT_NEWCOMMAND_NARGS); return BRACE_RIGHT; }

    "["     { log("new cmd name [");  yybegin(EXPECT_NEWCOMMAND_NARGS); return BRACKET_LEFT; }
}

<EXPECT_NEWCOMMAND_NARGS>{
     {WHITE_SPACE}             {log("<space>"); return WHITE_SPACE;}
    "["     { log("new cmd nargs [");  return BRACKET_LEFT; }
    {WORD}  { log("new cmd nargs <id>"); return WORD; }
    "]"     { log("new cmd nargs ]"); yybegin(EXPECT_NEWCOMMAND_OPTARG); return BRACKET_RIGHT; }
    "{"     { log("new cmd nargs ]"); yybegin(WITHIN_NEWCOMMAND_BODY); return BRACE_LEFT; }
}

<EXPECT_NEWCOMMAND_OPTARG>{

     {WHITE_SPACE}             {log("<space>"); return WHITE_SPACE;}
    "["  { log("new command optarg [");  yybegin(WITHIN_NEWCOMMAND_OPTARG); return BRACKET_LEFT; }
    "{"  { log("new command optarg {"); yybegin(WITHIN_NEWCOMMAND_BODY); return BRACE_LEFT; }
}

<EXPECT_NEWCOMMAND_BODY>{

     {WHITE_SPACE}             {log("<space>"); return WHITE_SPACE;}
    "{"  { log("new command body {"); yybegin(WITHIN_NEWCOMMAND_BODY); return BRACE_LEFT; }
}



<EXPECT_ENV_END_OPEN_BRACE>{
    "{"  { log("env out {"); yybegin(EXPECT_ENV_END_ID); return BRACE_LEFT; }
}

<EXPECT_ENV_END_ID>{
    {ENVIRONMENT_IDENTIFIER}  { log("env out <id>"); yybegin(EXPECT_ENV_END_CLOSE_BRACE); return ENVIRONMENT_IDENTIFIER; }
}

<EXPECT_ENV_END_CLOSE_BRACE>{
    "}" { log("env out }"); yypopState(); return BRACE_RIGHT; }
}



<WITHIN_NEWCOMMAND_OPTARG>
{
 "]"                 {log("]"); yybegin(EXPECT_NEWCOMMAND_BODY); return BRACKET_RIGHT;}
}

<WITHIN_NEWCOMMAND_BODY>
{
 "}"                 {log("}"); yypopState(); return BRACE_RIGHT;}
}

<YYINITIAL,
WITHIN_GROUP, WITHIN_ENV,
WITHIN_DISPLAY_MATH_DOLLAR, WITHIN_DISPLAY_MATH_PARENTHESES,
WITHIN_INLINE_MATH_DOLLAR, WITHIN_DISPLAY_MATH_PARENTHESES>
{
 "\\begin"                 { log("env in"); yypushState(EXPECT_ENV_BEGIN_OPEN_BRACE); return ENVIRONMENT_BEGIN_TOKEN; }
 {NEWCOMMAND_TOKEN}        { log("new cmd in"); yypushState(EXPECT_NEWCOMMAND_NAME); return NEWCOMMAND_TOKEN; }
}

<YYINITIAL, WITHIN_GENERIC_CONTEXT,WITHIN_NEWCOMMAND_OPTARG, WITHIN_NEWCOMMAND_BODY,
WITHIN_GROUP, WITHIN_ENV,
WITHIN_DISPLAY_MATH_DOLLAR, WITHIN_DISPLAY_MATH_PARENTHESES,
WITHIN_INLINE_MATH_DOLLAR, WITHIN_DISPLAY_MATH_PARENTHESES>
{
 {WHITE_SPACE}             {log("<space>"); return WHITE_SPACE;}
 {WORD}                    {log("<word>"); return WORD;}
 {COMMENT_CONTEXT}         {log("<comment>"); return COMMENT_CONTEXT;}
 "{"                       {log("text group in {"); yypushState(WITHIN_GROUP); return BRACE_LEFT; }
 {COMMAND}                 {log("<command>");  return COMMAND;}
 "["                 {log("[");  return BRACKET_LEFT;}
 "]"                 {log("]");  return BRACKET_RIGHT;}
 "("                 {log("(");  return PARENTHESES_LEFT;}
 ")"                 {log(")");  return PARENTHESES_RIGHT;}
}

<YYINITIAL, WITHIN_GROUP, WITHIN_ENV, WITHIN_GENERIC_CONTEXT>
{
 {DOLLARS}                 {log("<dollars>"); return DOLLARS;}
}

<WITHIN_GROUP>{
 "}"                       { log("text group out }"); yypopState(); return BRACE_RIGHT; }
}


[^] { return BAD_CHARACTER; }
