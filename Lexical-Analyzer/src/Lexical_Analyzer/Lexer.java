/* The following code was generated by JFlex 1.6.1 */

package Lexical_Analyzer;
import static Lexical_Analyzer.Token.*;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.6.1
 * from the specification file <tt>C:/Users/Diego P�rez Moir/Desktop/Lexical-Analyzer-master/Lexical-Analyzer-master/Lexical-Analyzer/src/Lexical_Analyzer/Lexer.flex</tt>
 */
class Lexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\66\1\36\1\37\1\37\1\37\22\0\1\66\1\56\1\47"+
    "\1\53\1\53\1\65\1\54\1\53\1\64\1\50\1\40\1\46\1\52"+
    "\1\46\1\44\1\35\1\41\11\32\1\53\1\52\1\56\1\57\1\56"+
    "\2\0\1\30\3\43\1\45\1\43\7\33\1\27\11\33\1\42\2\33"+
    "\1\62\1\51\1\63\1\53\1\34\1\53\1\17\1\10\1\16\1\4"+
    "\1\12\1\20\1\15\1\21\1\3\1\33\1\26\1\11\1\23\1\5"+
    "\1\2\1\24\1\33\1\14\1\13\1\6\1\7\1\1\1\25\1\22"+
    "\1\31\1\33\1\60\1\55\1\61\1\53\6\0\1\37\32\0\1\66"+
    "\23\0\1\53\12\0\1\53\u15c0\0\1\66\u097f\0\13\66\35\0\1\37"+
    "\1\37\5\0\1\66\57\0\1\66\u0fa0\0\1\66\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\ud00f\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\16\1\1\2\1\3\1\4\1\5\1\4\1\2"+
    "\1\6\3\3\4\4\2\1\1\7\20\1\1\10\1\0"+
    "\1\11\2\0\1\12\1\0\1\13\1\1\1\7\15\1"+
    "\1\7\1\0\1\14\1\0\1\15\1\12\2\1\1\16"+
    "\5\1\1\10\2\0\1\14\15\1";

  private static int [] zzUnpackAction() {
    int [] result = new int[102];
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
    "\0\0\0\67\0\156\0\245\0\334\0\u0113\0\u014a\0\u0181"+
    "\0\u01b8\0\u01ef\0\u0226\0\u025d\0\u0294\0\u02cb\0\u0302\0\u0339"+
    "\0\u0370\0\u03a7\0\u0370\0\u0370\0\u03de\0\u0370\0\u0415\0\u044c"+
    "\0\u0483\0\u04ba\0\u04f1\0\u0528\0\u055f\0\u0596\0\u05cd\0\156"+
    "\0\u0604\0\u063b\0\u0672\0\u06a9\0\u06e0\0\u0717\0\u074e\0\u0785"+
    "\0\u07bc\0\u07f3\0\u082a\0\u0861\0\u0898\0\u08cf\0\u0906\0\u093d"+
    "\0\u0974\0\u09ab\0\u09e2\0\u0a19\0\u0415\0\u0370\0\u0a50\0\u0370"+
    "\0\u0a87\0\u0abe\0\u0af5\0\u0b2c\0\u0b63\0\u0b9a\0\u0bd1\0\u0c08"+
    "\0\u0c3f\0\u0c76\0\u0cad\0\u0ce4\0\u0d1b\0\u0d52\0\u0d89\0\u0dc0"+
    "\0\u0df7\0\u09ab\0\u0e2e\0\u0a19\0\u0415\0\u0e65\0\u0e9c\0\156"+
    "\0\u0ed3\0\u0f0a\0\u0f41\0\u0f78\0\u0faf\0\u0fe6\0\u0fe6\0\u101d"+
    "\0\u0370\0\u1054\0\u108b\0\u10c2\0\u10f9\0\u1130\0\u1167\0\u119e"+
    "\0\u11d5\0\u120c\0\u1243\0\u127a\0\u12b1\0\u12e8";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[102];
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
    "\1\0\1\2\1\3\1\4\1\5\1\6\1\7\1\3"+
    "\1\10\1\3\1\11\1\12\1\13\1\3\1\14\1\3"+
    "\1\15\4\3\1\16\1\3\1\17\2\3\1\20\1\3"+
    "\1\21\1\22\2\23\1\24\1\25\2\3\1\26\1\3"+
    "\1\24\1\27\1\24\1\0\1\26\1\21\1\30\1\31"+
    "\2\32\1\33\1\24\1\34\1\24\1\35\1\24\1\23"+
    "\1\0\1\3\1\36\27\3\1\0\2\3\5\0\2\3"+
    "\1\0\1\3\22\0\31\3\1\0\2\3\5\0\2\3"+
    "\1\0\1\3\22\0\4\3\1\37\12\3\1\40\2\3"+
    "\1\41\6\3\1\0\2\3\5\0\2\3\1\0\1\3"+
    "\22\0\1\3\1\42\27\3\1\0\2\3\5\0\2\3"+
    "\1\0\1\3\22\0\6\3\1\43\22\3\1\0\2\3"+
    "\5\0\2\3\1\0\1\3\22\0\13\3\1\44\4\3"+
    "\1\45\10\3\1\0\2\3\5\0\2\3\1\0\1\3"+
    "\22\0\1\3\1\46\11\3\1\47\15\3\1\0\2\3"+
    "\5\0\2\3\1\0\1\3\22\0\10\3\1\50\10\3"+
    "\1\51\7\3\1\0\2\3\5\0\2\3\1\0\1\3"+
    "\22\0\5\3\1\52\23\3\1\0\2\3\5\0\2\3"+
    "\1\0\1\3\22\0\11\3\1\53\17\3\1\0\2\3"+
    "\5\0\2\3\1\0\1\3\22\0\10\3\1\54\20\3"+
    "\1\0\2\3\5\0\2\3\1\0\1\3\22\0\1\3"+
    "\1\55\14\3\1\56\12\3\1\0\2\3\5\0\2\3"+
    "\1\0\1\3\22\0\20\3\1\57\10\3\1\0\2\3"+
    "\5\0\2\3\1\0\1\3\22\0\11\3\1\60\17\3"+
    "\1\0\2\3\5\0\2\3\1\0\1\3\53\0\1\20"+
    "\6\0\1\20\2\0\1\61\146\0\1\62\2\0\1\63"+
    "\50\0\1\64\7\0\1\20\6\0\1\20\1\64\1\0"+
    "\1\61\22\0\36\65\1\0\10\65\1\66\1\0\1\67"+
    "\12\65\1\0\2\65\54\0\1\70\67\0\1\70\70\0"+
    "\1\70\70\0\1\70\70\0\1\70\53\0\1\70\17\0"+
    "\2\3\1\71\26\3\1\0\2\3\5\0\2\3\1\0"+
    "\1\3\22\0\5\3\1\72\23\3\1\0\2\3\5\0"+
    "\2\3\1\0\1\3\22\0\23\3\1\73\5\3\1\0"+
    "\2\3\5\0\2\3\1\0\1\3\22\0\6\3\1\74"+
    "\22\3\1\0\2\3\5\0\2\3\1\0\1\3\22\0"+
    "\10\3\1\75\20\3\1\0\2\3\5\0\2\3\1\0"+
    "\1\3\22\0\6\3\1\76\22\3\1\0\2\3\5\0"+
    "\2\3\1\0\1\3\22\0\2\3\1\77\26\3\1\0"+
    "\2\3\5\0\2\3\1\0\1\3\22\0\1\3\1\75"+
    "\27\3\1\0\2\3\5\0\2\3\1\0\1\3\22\0"+
    "\11\3\1\100\17\3\1\0\2\3\5\0\2\3\1\0"+
    "\1\3\22\0\12\3\1\101\16\3\1\0\2\3\5\0"+
    "\2\3\1\0\1\3\22\0\5\3\1\102\23\3\1\0"+
    "\2\3\5\0\2\3\1\0\1\3\22\0\13\3\1\103"+
    "\15\3\1\0\2\3\5\0\2\3\1\0\1\3\22\0"+
    "\5\3\1\104\23\3\1\0\2\3\5\0\2\3\1\0"+
    "\1\3\22\0\16\3\1\105\12\3\1\0\2\3\5\0"+
    "\2\3\1\0\1\3\22\0\13\3\1\40\15\3\1\0"+
    "\2\3\5\0\2\3\1\0\1\3\22\0\10\3\1\106"+
    "\20\3\1\0\2\3\5\0\2\3\1\0\1\3\22\0"+
    "\2\3\1\107\26\3\1\0\2\3\5\0\2\3\1\0"+
    "\1\3\22\0\24\3\1\110\4\3\1\0\2\3\5\0"+
    "\2\3\1\0\1\3\33\0\1\111\17\0\1\61\6\0"+
    "\1\61\3\0\1\111\21\0\36\112\2\0\27\112\40\63"+
    "\1\113\26\63\4\0\1\114\3\0\1\114\1\0\1\114"+
    "\3\0\3\114\7\0\1\114\1\0\1\114\6\0\1\114"+
    "\1\0\1\114\1\0\1\114\21\0\36\65\1\0\10\65"+
    "\1\115\1\0\1\67\12\65\1\0\2\65\1\0\3\3"+
    "\1\40\25\3\1\0\2\3\5\0\2\3\1\0\1\3"+
    "\22\0\11\3\1\116\17\3\1\0\2\3\5\0\2\3"+
    "\1\0\1\3\22\0\10\3\1\117\20\3\1\0\2\3"+
    "\5\0\2\3\1\0\1\3\22\0\7\3\1\107\21\3"+
    "\1\0\2\3\5\0\2\3\1\0\1\3\22\0\10\3"+
    "\1\40\20\3\1\0\2\3\5\0\2\3\1\0\1\3"+
    "\22\0\11\3\1\120\17\3\1\0\2\3\5\0\2\3"+
    "\1\0\1\3\22\0\12\3\1\40\16\3\1\0\2\3"+
    "\5\0\2\3\1\0\1\3\22\0\16\3\1\121\12\3"+
    "\1\0\2\3\5\0\2\3\1\0\1\3\22\0\11\3"+
    "\1\40\17\3\1\0\2\3\5\0\2\3\1\0\1\3"+
    "\22\0\11\3\1\122\17\3\1\0\2\3\5\0\2\3"+
    "\1\0\1\3\22\0\2\3\1\123\26\3\1\0\2\3"+
    "\5\0\2\3\1\0\1\3\22\0\6\3\1\124\22\3"+
    "\1\0\2\3\5\0\2\3\1\0\1\3\22\0\12\3"+
    "\1\77\16\3\1\0\2\3\5\0\2\3\1\0\1\3"+
    "\22\0\12\3\1\76\16\3\1\0\2\3\5\0\2\3"+
    "\1\0\1\3\22\0\10\3\1\101\20\3\1\0\2\3"+
    "\5\0\2\3\1\0\1\3\22\0\27\3\1\125\1\3"+
    "\1\0\2\3\5\0\2\3\1\0\1\3\53\0\1\126"+
    "\6\0\1\126\4\0\1\127\20\0\35\130\1\131\2\130"+
    "\1\113\26\130\1\0\13\3\1\132\15\3\1\0\2\3"+
    "\5\0\2\3\1\0\1\3\22\0\11\3\1\133\17\3"+
    "\1\0\2\3\5\0\2\3\1\0\1\3\22\0\25\3"+
    "\1\40\3\3\1\0\2\3\5\0\2\3\1\0\1\3"+
    "\22\0\4\3\1\134\24\3\1\0\2\3\5\0\2\3"+
    "\1\0\1\3\22\0\4\3\1\135\24\3\1\0\2\3"+
    "\5\0\2\3\1\0\1\3\22\0\13\3\1\136\15\3"+
    "\1\0\2\3\5\0\2\3\1\0\1\3\22\0\13\3"+
    "\1\137\15\3\1\0\2\3\5\0\2\3\1\0\1\3"+
    "\53\0\1\126\6\0\1\126\25\0\40\130\1\113\26\130"+
    "\1\0\17\3\1\140\11\3\1\0\2\3\5\0\2\3"+
    "\1\0\1\3\22\0\22\3\1\141\6\3\1\0\2\3"+
    "\5\0\2\3\1\0\1\3\22\0\3\3\1\77\25\3"+
    "\1\0\2\3\5\0\2\3\1\0\1\3\22\0\14\3"+
    "\1\40\14\3\1\0\2\3\5\0\2\3\1\0\1\3"+
    "\22\0\4\3\1\40\24\3\1\0\2\3\5\0\2\3"+
    "\1\0\1\3\22\0\13\3\1\142\15\3\1\0\2\3"+
    "\5\0\2\3\1\0\1\3\22\0\16\3\1\143\12\3"+
    "\1\0\2\3\5\0\2\3\1\0\1\3\22\0\11\3"+
    "\1\144\17\3\1\0\2\3\5\0\2\3\1\0\1\3"+
    "\22\0\16\3\1\145\12\3\1\0\2\3\5\0\2\3"+
    "\1\0\1\3\22\0\15\3\1\101\13\3\1\0\2\3"+
    "\5\0\2\3\1\0\1\3\22\0\4\3\1\146\24\3"+
    "\1\0\2\3\5\0\2\3\1\0\1\3\22\0\30\3"+
    "\1\40\1\0\2\3\5\0\2\3\1\0\1\3\22\0"+
    "\5\3\1\77\23\3\1\0\2\3\5\0\2\3\1\0"+
    "\1\3\21\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[4895];
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
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\17\1\1\11\1\1\2\11\1\1\1\11\33\1"+
    "\1\0\1\1\2\0\1\11\1\0\1\11\20\1\1\0"+
    "\1\1\1\0\13\1\2\0\1\11\15\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[102];
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
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /* user code: */
    public String token; 
    public int lineNumber; 
    public int colNumber; 


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  Lexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x110000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 228) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException("Reader returned 0 characters. See JFlex examples for workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      /* If numRead == requested, we might have requested to few chars to
         encode a full Unicode character. We assume that a Reader would
         otherwise never return half characters. */
      if (numRead == requested) {
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
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
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
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
    return zzBuffer[zzStartRead+pos];
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
  public Token yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
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
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
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
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
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
            { token = yytext(); lineNumber = yyline; colNumber = yycolumn; return IDENTIFIER;
            }
          case 15: break;
          case 2: 
            { token = yytext(); lineNumber = yyline; colNumber = yycolumn; return INTEGER;
            }
          case 16: break;
          case 3: 
            { token = yytext(); lineNumber = yyline; colNumber = yycolumn; return ERROR;
            }
          case 17: break;
          case 4: 
            { token = yytext(); lineNumber = yyline; colNumber = yycolumn; return ONECHAR;
            }
          case 18: break;
          case 5: 
            { 
            }
          case 19: break;
          case 6: 
            { token = yytext(); lineNumber = yyline; colNumber = yycolumn; return PUNCTUATIONSYMBOL;
            }
          case 20: break;
          case 7: 
            { token = yytext(); lineNumber = yyline;  colNumber = yycolumn; return KEYWORD;
            }
          case 21: break;
          case 8: 
            { token = yytext(); lineNumber = yyline; colNumber = yycolumn; return DOUBLE;
            }
          case 22: break;
          case 9: 
            { token = yytext(); lineNumber = yyline; colNumber = yycolumn; return COMMENTERROR;
            }
          case 23: break;
          case 10: 
            { token = yytext(); lineNumber = yyline; colNumber = yycolumn; return STRING;
            }
          case 24: break;
          case 11: 
            { token = yytext(); lineNumber = yyline; colNumber = yycolumn; return TWOCHAR;
            }
          case 25: break;
          case 12: 
            { token = yytext(); lineNumber = yyline; colNumber = yycolumn; return COMMENT;
            }
          case 26: break;
          case 13: 
            { token = yytext(); lineNumber = yyline; colNumber = yycolumn; return HEXADECIMAL;
            }
          case 27: break;
          case 14: 
            { token = yytext(); lineNumber = yyline; colNumber = yycolumn; return BOOL;
            }
          case 28: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
