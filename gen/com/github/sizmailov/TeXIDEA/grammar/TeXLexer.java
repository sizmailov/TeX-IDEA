/* The following code was generated by JFlex 1.7.0 tweaked for IntelliJ platform */

package com.github.sizmailov.TeXIDEA.grammar;

import java.util.ArrayDeque;
import java.util.Deque;

import com.intellij.psi.tree.IElementType;

import com.intellij.lexer.FlexLexer;
import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.github.sizmailov.TeXIDEA.psi.TeXTypes.*;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0
 * from the specification file <tt>TexLexer.flex</tt>
 */
public class TeXLexer implements FlexLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int WITHIN_ENVIRONMENT = 2;
  public static final int WITHIN_TEXT_GROUP = 4;
  public static final int WITHIN_MATH_GROUP = 6;
  public static final int WITHIN_COMMENT = 8;
  public static final int WITHIN_INLINE_MATH_DOLLAR = 10;
  public static final int WITHIN_INLINE_MATH_PARENTHESES = 12;
  public static final int WITHIN_DISPLAY_MATH_DOLLAR = 14;
  public static final int WITHIN_DISPLAY_MATH_PARENTHESES = 16;
  public static final int EXPECT_ENV_BEGIN_OPEN_BRACE = 18;
  public static final int EXPECT_ENV_BEGIN_CLOSE_BRACE = 20;
  public static final int EXPECT_ENV_BEGIN_ID = 22;
  public static final int EXPECT_ENV_END_OPEN_BRACE = 24;
  public static final int EXPECT_ENV_END_CLOSE_BRACE = 26;
  public static final int EXPECT_ENV_END_ID = 28;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2,  2,  3,  3,  4,  4,  5,  5,  6,  6,  7,  7, 
     8,  8,  9,  9, 10, 10, 11, 11, 12, 12, 13, 13, 14, 14
  };

  /** 
   * Translates characters to character classes
   * Chosen bits are [7, 7, 7]
   * Total runtime size is 1928 bytes
   */
  public static int ZZ_CMAP(int ch) {
    return ZZ_CMAP_A[(ZZ_CMAP_Y[ZZ_CMAP_Z[ch>>14]|((ch>>7)&0x7f)]<<7)|(ch&0x7f)];
  }

  /* The ZZ_CMAP_Z table has 68 entries */
  static final char ZZ_CMAP_Z[] = zzUnpackCMap(
    "\1\0\103\200");

  /* The ZZ_CMAP_Y table has 256 entries */
  static final char ZZ_CMAP_Y[] = zzUnpackCMap(
    "\1\0\1\1\53\2\1\3\22\2\1\4\37\2\1\3\237\2");

  /* The ZZ_CMAP_A table has 640 entries */
  static final char ZZ_CMAP_A[] = zzUnpackCMap(
    "\11\0\1\3\1\2\2\1\1\2\22\0\1\3\3\0\1\11\1\7\2\0\1\13\1\6\26\0\33\5\1\12\1"+
    "\4\1\14\3\0\1\5\1\21\1\5\1\17\1\15\1\5\1\22\1\5\1\23\4\5\1\16\14\5\1\20\1"+
    "\0\1\10\7\0\1\1\32\0\1\3\337\0\1\3\177\0\13\3\35\0\2\1\5\0\1\3\57\0\1\3\40"+
    "\0");

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\17\0\1\1\1\2\1\3\1\4\1\5\1\3\1\6"+
    "\1\7\1\3\1\10\1\3\1\11\1\12\1\13\3\3"+
    "\1\14\1\15\1\16\1\17\1\20\1\21\2\22\1\23"+
    "\1\24\1\22\1\25\1\22\1\26\1\27\1\30\3\22"+
    "\1\31\1\22\1\32";

  private static int [] zzUnpackAction() {
    int [] result = new int[54];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\24\0\50\0\74\0\120\0\144\0\170\0\214"+
    "\0\240\0\264\0\310\0\334\0\360\0\u0104\0\u0118\0\u012c"+
    "\0\u0140\0\u0154\0\u0168\0\u017c\0\u0168\0\u0190\0\u0168\0\u01a4"+
    "\0\u0168\0\u01b8\0\u0168\0\u0168\0\u0168\0\u01cc\0\u01e0\0\u01f4"+
    "\0\u0168\0\u0168\0\u0208\0\u0168\0\u0168\0\u021c\0\u0168\0\u0230"+
    "\0\u0168\0\u0168\0\u0244\0\u0168\0\u0258\0\u0168\0\u0168\0\u0168"+
    "\0\u026c\0\u0280\0\u0294\0\u0230\0\u02a8\0\u0230";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[54];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\20\3\21\1\22\1\20\1\23\1\24\1\25\1\26"+
    "\3\23\3\20\1\27\4\20\3\21\1\30\1\20\1\23"+
    "\1\24\1\25\1\26\3\23\3\20\1\27\4\20\3\21"+
    "\1\22\1\20\1\23\1\24\1\31\1\26\3\23\3\20"+
    "\1\27\4\20\3\21\1\32\1\20\1\23\1\24\1\33"+
    "\1\25\3\23\3\20\1\34\3\20\24\25\1\20\3\21"+
    "\1\32\1\20\1\23\1\24\1\25\1\35\3\23\3\20"+
    "\1\34\4\20\3\21\1\36\1\20\1\23\1\24\2\25"+
    "\3\23\3\20\1\34\4\20\3\21\1\32\1\20\1\23"+
    "\1\24\1\25\1\37\3\23\3\20\1\34\4\20\3\21"+
    "\1\40\1\20\1\23\1\24\2\25\3\23\3\20\1\34"+
    "\4\20\3\21\1\32\1\20\1\23\1\24\2\25\3\23"+
    "\3\20\1\41\3\20\10\25\1\42\13\25\10\43\2\25"+
    "\6\43\1\25\3\43\20\25\1\44\13\25\1\45\13\25"+
    "\10\46\2\25\6\46\1\25\3\46\1\20\4\0\1\20"+
    "\7\0\3\20\1\0\3\20\1\0\3\21\20\0\1\47"+
    "\2\0\2\47\1\50\4\47\1\51\1\52\1\47\3\50"+
    "\1\47\1\53\2\50\24\0\2\24\1\0\21\24\11\0"+
    "\1\54\12\0\1\47\2\0\2\47\1\50\4\47\1\51"+
    "\1\52\1\47\1\55\2\50\1\47\1\53\2\50\1\47"+
    "\2\0\2\47\1\50\7\47\3\50\1\47\1\53\2\50"+
    "\1\47\2\0\2\47\1\50\1\56\6\47\3\50\1\47"+
    "\1\53\2\50\11\0\1\57\12\0\1\47\2\0\2\47"+
    "\1\50\6\47\1\60\3\50\1\47\1\53\2\50\10\43"+
    "\2\0\6\43\1\0\3\43\10\46\2\0\6\46\1\0"+
    "\3\46\5\0\1\50\7\0\3\50\1\0\3\50\5\0"+
    "\1\50\7\0\1\61\2\50\1\0\3\50\5\0\1\50"+
    "\7\0\1\50\1\62\1\50\1\0\3\50\5\0\1\50"+
    "\7\0\3\50\1\0\1\50\1\63\1\50\5\0\1\50"+
    "\7\0\2\50\1\64\1\0\3\50\5\0\1\50\7\0"+
    "\3\50\1\0\2\50\1\65\5\0\1\50\7\0\1\50"+
    "\1\66\1\50\1\0\3\50";

  private static int [] zzUnpackTrans() {
    int [] result = new int[700];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String[] ZZ_ERROR_MSG = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\17\0\3\1\1\11\1\1\1\11\1\1\1\11\1\1"+
    "\1\11\1\1\3\11\3\1\2\11\1\1\2\11\1\1"+
    "\1\11\1\1\2\11\1\1\1\11\1\1\3\11\6\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[54];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
  private Deque<Integer> stack = new ArrayDeque<>();

  public void yypushState(int newState) {
    System.out.println("Save state " + yystate());
    stack.push(yystate());
    System.out.println("Set new state " + newState);
    yybegin(newState);
  }

  public void yypopState() {
    yybegin(stack.pop());
    System.out.println("Restore state " + yystate());
  }
  public void log(String stateName){
      System.out.println(new String(new char[stack.size()]).replace("\0", " ") + "->" + stateName);
  }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public TeXLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    int size = 0;
    for (int i = 0, length = packed.length(); i < length; i += 2) {
      size += packed.charAt(i);
    }
    char[] map = new char[size];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < packed.length()) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart() {
    return zzStartRead;
  }

  public final int getTokenEnd() {
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end, int initialState) {
    zzBuffer = buffer;
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position <tt>pos</tt> from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + ZZ_CMAP(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { log("<word>");  return WORD;
            } 
            // fall through
          case 27: break;
          case 2: 
            { log("<space>"); return WHITE_SPACE;
            } 
            // fall through
          case 28: break;
          case 3: 
            { return BAD_CHARACTER;
            } 
            // fall through
          case 29: break;
          case 4: 
            { log("[]()"); return BRACKETS;
            } 
            // fall through
          case 30: break;
          case 5: 
            { log("<comment>"); return COMMENT_CONTEXT;
            } 
            // fall through
          case 31: break;
          case 6: 
            { log("$ in "); yypushState(WITHIN_INLINE_MATH_DOLLAR); return INLINE_MATH_DOLLAR;
            } 
            // fall through
          case 32: break;
          case 7: 
            { log("text group in {"); yypushState(WITHIN_TEXT_GROUP); return BRACE_LEFT;
            } 
            // fall through
          case 33: break;
          case 8: 
            { log("text group out }"); yypopState(); return BRACE_RIGHT;
            } 
            // fall through
          case 34: break;
          case 9: 
            { log("math group out }"); yypopState(); return BRACE_RIGHT;
            } 
            // fall through
          case 35: break;
          case 10: 
            { log("math group in {"); yypushState(WITHIN_MATH_GROUP); return BRACE_LEFT;
            } 
            // fall through
          case 36: break;
          case 11: 
            { log("$ out");yypopState(); return INLINE_MATH_DOLLAR;
            } 
            // fall through
          case 37: break;
          case 12: 
            { log("env in {");  yybegin(EXPECT_ENV_BEGIN_ID); return BRACE_LEFT;
            } 
            // fall through
          case 38: break;
          case 13: 
            { log("env in }"); yybegin(WITHIN_ENVIRONMENT); return BRACE_RIGHT;
            } 
            // fall through
          case 39: break;
          case 14: 
            { log("env in <id>"); yybegin(EXPECT_ENV_BEGIN_CLOSE_BRACE); return ENVIRONMENT_IDENTIFIER;
            } 
            // fall through
          case 40: break;
          case 15: 
            { log("env out {"); yybegin(EXPECT_ENV_END_ID); return BRACE_LEFT;
            } 
            // fall through
          case 41: break;
          case 16: 
            { log("env out }"); yypopState(); return BRACE_RIGHT;
            } 
            // fall through
          case 42: break;
          case 17: 
            { log("env out <id>"); yybegin(EXPECT_ENV_END_CLOSE_BRACE); return ENVIRONMENT_IDENTIFIER;
            } 
            // fall through
          case 43: break;
          case 18: 
            { log("<command>");  return COMMAND;
            } 
            // fall through
          case 44: break;
          case 19: 
            { log("\\[ in "); yypushState(WITHIN_DISPLAY_MATH_PARENTHESES); return DISPLAY_MATH_BEGIN_PARENTHESES;
            } 
            // fall through
          case 45: break;
          case 20: 
            { log("\\( in ");yypushState(WITHIN_INLINE_MATH_PARENTHESES); return INLINE_MATH_BEGIN_PARENTHESES;
            } 
            // fall through
          case 46: break;
          case 21: 
            { log("$$ in "); yypushState(WITHIN_DISPLAY_MATH_DOLLAR); return DISPLAY_MATH_DOLLAR;
            } 
            // fall through
          case 47: break;
          case 22: 
            { log("\\) out"); yypopState(); return INLINE_MATH_END_PARENTHESES;
            } 
            // fall through
          case 48: break;
          case 23: 
            { log("$$ out");yypopState(); return DISPLAY_MATH_DOLLAR;
            } 
            // fall through
          case 49: break;
          case 24: 
            { log("\\] out");yypopState(); return DISPLAY_MATH_END_PARENTHESES;
            } 
            // fall through
          case 50: break;
          case 25: 
            { log("env out"); yybegin(EXPECT_ENV_END_OPEN_BRACE); return ENVIRONMENT_END_TOKEN;
            } 
            // fall through
          case 51: break;
          case 26: 
            { log("env in"); yypushState(EXPECT_ENV_BEGIN_OPEN_BRACE); return ENVIRONMENT_BEGIN_TOKEN;
            } 
            // fall through
          case 52: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}