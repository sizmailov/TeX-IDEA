package com.github.sizmailov.TeXIDEA.grammar;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.github.sizmailov.TeXIDEA.psi.TexTypes.*;

%%

%{
  public _TexLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _TexLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+

INLINE_MATH_END=(\$|\\\))
COMMAND_IDENTIFIER=([a-zA-Z@]{2,}|[^a-zA-Z@\r\n])
ENVIRONMENT_IDENTIFIER=[^{}]+
NORMAL_TEXT_WORD=[^\s\\{}%\[\]$\(\)]+
COMMENT_CONTENT=[^\r\n]*

%%
<YYINITIAL> {
  {WHITE_SPACE}                 { return WHITE_SPACE; }

  "\\begin"                     { return ENV_BEGIN; }
  "\\end"                       { return ENV_END; }

  {INLINE_MATH_END}             { return INLINE_MATH_END; }
  {COMMAND_IDENTIFIER}          { return COMMAND_IDENTIFIER; }
  {ENVIRONMENT_IDENTIFIER}      { return ENVIRONMENT_IDENTIFIER; }
  {NORMAL_TEXT_WORD}            { return NORMAL_TEXT_WORD; }
  {COMMENT_CONTENT}             { return COMMENT_CONTENT; }

}

[^] { return BAD_CHARACTER; }
