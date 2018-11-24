package com.github.sizmailov.TeXIDEA;


import com.github.sizmailov.TeXIDEA.grammar.TeXLexer;
import com.intellij.lexer.FlexAdapter;

import java.io.Reader;

public class TeXLexerAdapter extends FlexAdapter {
    public TeXLexerAdapter() {
        super(new TeXLexer((Reader) null));
    }
}
