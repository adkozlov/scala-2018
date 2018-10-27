// Generated from Calc.g4 by ANTLR 4.7.1

package ru.hse.mit;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CalcLexer extends Lexer {
    public static final int
            True = 1, False = 2, LeftParen = 3, RightParen = 4, IsEqual = 5, NotEquals = 6, Less = 7,
            LessEqual = 8, Greater = 9, GreaterEqual = 10, Plus = 11, Minus = 12, Mult = 13, Div = 14,
            Mod = 15, Or = 16, And = 17, Number = 18, WS = 19;
    public static final String[] ruleNames = {
            "True", "False", "LeftParen", "RightParen", "IsEqual", "NotEquals", "Less",
            "LessEqual", "Greater", "GreaterEqual", "Plus", "Minus", "Mult", "Div",
            "Mod", "Or", "And", "Number", "WS"
    };
    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;
    public static final String _serializedATN =
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\25i\b\1\4\2\t\2\4" +
                    "\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t" +
                    "\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22" +
                    "\4\23\t\23\4\24\t\24\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3" +
                    "\4\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\13\3" +
                    "\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21" +
                    "\3\22\3\22\3\22\3\23\3\23\5\23[\n\23\3\23\3\23\7\23_\n\23\f\23\16\23b" +
                    "\13\23\5\23d\n\23\3\24\3\24\3\24\3\24\2\2\25\3\3\5\4\7\5\t\6\13\7\r\b" +
                    "\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25\3" +
                    "\2\3\5\2\13\f\17\17\"\"\2k\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2" +
                    "\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2" +
                    "\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3" +
                    "\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\3)\3\2\2\2\5.\3\2" +
                    "\2\2\7\64\3\2\2\2\t\66\3\2\2\2\138\3\2\2\2\r;\3\2\2\2\17>\3\2\2\2\21@" +
                    "\3\2\2\2\23C\3\2\2\2\25E\3\2\2\2\27H\3\2\2\2\31J\3\2\2\2\33L\3\2\2\2\35" +
                    "N\3\2\2\2\37P\3\2\2\2!R\3\2\2\2#U\3\2\2\2%c\3\2\2\2\'e\3\2\2\2)*\7v\2" +
                    "\2*+\7t\2\2+,\7w\2\2,-\7g\2\2-\4\3\2\2\2./\7h\2\2/\60\7c\2\2\60\61\7n" +
                    "\2\2\61\62\7u\2\2\62\63\7g\2\2\63\6\3\2\2\2\64\65\7*\2\2\65\b\3\2\2\2" +
                    "\66\67\7+\2\2\67\n\3\2\2\289\7?\2\29:\7?\2\2:\f\3\2\2\2;<\7#\2\2<=\7?" +
                    "\2\2=\16\3\2\2\2>?\7>\2\2?\20\3\2\2\2@A\7>\2\2AB\7?\2\2B\22\3\2\2\2CD" +
                    "\7@\2\2D\24\3\2\2\2EF\7@\2\2FG\7?\2\2G\26\3\2\2\2HI\7-\2\2I\30\3\2\2\2" +
                    "JK\7/\2\2K\32\3\2\2\2LM\7,\2\2M\34\3\2\2\2NO\7\61\2\2O\36\3\2\2\2PQ\7" +
                    "\'\2\2Q \3\2\2\2RS\7~\2\2ST\7~\2\2T\"\3\2\2\2UV\7(\2\2VW\7(\2\2W$\3\2" +
                    "\2\2Xd\7\62\2\2Y[\5\31\r\2ZY\3\2\2\2Z[\3\2\2\2[\\\3\2\2\2\\`\4\63;\2]" +
                    "_\4\62;\2^]\3\2\2\2_b\3\2\2\2`^\3\2\2\2`a\3\2\2\2ad\3\2\2\2b`\3\2\2\2" +
                    "cX\3\2\2\2cZ\3\2\2\2d&\3\2\2\2ef\t\2\2\2fg\3\2\2\2gh\b\24\2\2h(\3\2\2" +
                    "\2\6\2Z`c\3\b\2\2";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());
    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    private static final String[] _LITERAL_NAMES = {
            null, "'true'", "'false'", "'('", "')'", "'=='", "'!='", "'<'", "'<='",
            "'>'", "'>='", "'+'", "'-'", "'*'", "'/'", "'%'", "'||'", "'&&'"
    };
    private static final String[] _SYMBOLIC_NAMES = {
            null, "True", "False", "LeftParen", "RightParen", "IsEqual", "NotEquals",
            "Less", "LessEqual", "Greater", "GreaterEqual", "Plus", "Minus", "Mult",
            "Div", "Mod", "Or", "And", "Number", "WS"
    };
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);
    public static String[] channelNames = {
            "DEFAULT_TOKEN_CHANNEL", "HIDDEN"
    };
    public static String[] modeNames = {
            "DEFAULT_MODE"
    };

    static {
        RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION);
    }

    static {
        tokenNames = new String[_SYMBOLIC_NAMES.length];
        for (int i = 0; i < tokenNames.length; i++) {
            tokenNames[i] = VOCABULARY.getLiteralName(i);
            if (tokenNames[i] == null) {
                tokenNames[i] = VOCABULARY.getSymbolicName(i);
            }

            if (tokenNames[i] == null) {
                tokenNames[i] = "<INVALID>";
            }
        }
    }

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }

    public CalcLexer(CharStream input) {
        super(input);
        _interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override

    public Vocabulary getVocabulary() {
        return VOCABULARY;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public String getGrammarFileName() {
        return "Calc.g4";
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    @Override
    public String[] getChannelNames() {
        return channelNames;
    }

    @Override
    public String[] getModeNames() {
        return modeNames;
    }

    @Override
    @Deprecated
    public String[] getTokenNames() {
        return tokenNames;
    }
}