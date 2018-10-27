// Generated from /Users/alexvangogen/Fall/scala-course/hw/scala-2018/src/main/resources/ru.spbau.jvm.scala.calculator/Expressions.g4 by ANTLR 4.7
package ru.spbau.jvm.scala.calculator;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExpressionsLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, LPAREN=2, RPAREN=3, DOT=4, PLUS=5, MINUS=6, MULT=7, DIV=8, LT=9, 
		LEQ=10, GT=11, GEQ=12, EQ=13, NEQ=14, AND=15, OR=16, XOR=17, NOT=18, NUMBER=19, 
		BOOL=20, MismatchedSymbol=21;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"WS", "LPAREN", "RPAREN", "DOT", "PLUS", "MINUS", "MULT", "DIV", "LT", 
		"LEQ", "GT", "GEQ", "EQ", "NEQ", "AND", "OR", "XOR", "NOT", "NUMBER", 
		"BOOL", "Positive", "ZeroDigit", "DigitWithoutZero", "Digit", "Digits", 
		"FloatingPart", "ScientificPart", "Sign", "MismatchedSymbol"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, "'('", "')'", "'.'", "'+'", "'-'", "'*'", "'/'", "'<'", "'<='", 
		"'>'", "'>='", "'=='", "'!='", "'&&'", "'||'", "'^'", "'!'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "WS", "LPAREN", "RPAREN", "DOT", "PLUS", "MINUS", "MULT", "DIV", 
		"LT", "LEQ", "GT", "GEQ", "EQ", "NEQ", "AND", "OR", "XOR", "NOT", "NUMBER", 
		"BOOL", "MismatchedSymbol"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
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

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public ExpressionsLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Expressions.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\27\u00a5\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\3\2\3"+
		"\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13"+
		"\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20"+
		"\3\20\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\5\24l\n\24\3\24\5\24"+
		"o\n\24\3\24\3\24\5\24s\n\24\5\24u\n\24\3\25\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\5\25\u0080\n\25\3\26\3\26\3\26\7\26\u0085\n\26\f\26\16\26"+
		"\u0088\13\26\5\26\u008a\n\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\7\32\u0093"+
		"\n\32\f\32\16\32\u0096\13\32\3\33\3\33\5\33\u009a\n\33\3\34\3\34\5\34"+
		"\u009e\n\34\3\34\3\34\3\35\3\35\3\36\3\36\2\2\37\3\3\5\4\7\5\t\6\13\7"+
		"\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26+\2-\2/\2\61\2\63\2\65\2\67\29\2;\27\3\2\b\5\2\13\f\17\17\"\"\3\2"+
		"\62\62\3\2\63;\3\2\62;\4\2GGgg\4\2--//\2\u00a6\2\3\3\2\2\2\2\5\3\2\2\2"+
		"\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3"+
		"\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2"+
		"\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2"+
		"\2\2\2)\3\2\2\2\2;\3\2\2\2\3=\3\2\2\2\5A\3\2\2\2\7C\3\2\2\2\tE\3\2\2\2"+
		"\13G\3\2\2\2\rI\3\2\2\2\17K\3\2\2\2\21M\3\2\2\2\23O\3\2\2\2\25Q\3\2\2"+
		"\2\27T\3\2\2\2\31V\3\2\2\2\33Y\3\2\2\2\35\\\3\2\2\2\37_\3\2\2\2!b\3\2"+
		"\2\2#e\3\2\2\2%g\3\2\2\2\'t\3\2\2\2)\177\3\2\2\2+\u0089\3\2\2\2-\u008b"+
		"\3\2\2\2/\u008d\3\2\2\2\61\u008f\3\2\2\2\63\u0094\3\2\2\2\65\u0097\3\2"+
		"\2\2\67\u009b\3\2\2\29\u00a1\3\2\2\2;\u00a3\3\2\2\2=>\t\2\2\2>?\3\2\2"+
		"\2?@\b\2\2\2@\4\3\2\2\2AB\7*\2\2B\6\3\2\2\2CD\7+\2\2D\b\3\2\2\2EF\7\60"+
		"\2\2F\n\3\2\2\2GH\7-\2\2H\f\3\2\2\2IJ\7/\2\2J\16\3\2\2\2KL\7,\2\2L\20"+
		"\3\2\2\2MN\7\61\2\2N\22\3\2\2\2OP\7>\2\2P\24\3\2\2\2QR\7>\2\2RS\7?\2\2"+
		"S\26\3\2\2\2TU\7@\2\2U\30\3\2\2\2VW\7@\2\2WX\7?\2\2X\32\3\2\2\2YZ\7?\2"+
		"\2Z[\7?\2\2[\34\3\2\2\2\\]\7#\2\2]^\7?\2\2^\36\3\2\2\2_`\7(\2\2`a\7(\2"+
		"\2a \3\2\2\2bc\7~\2\2cd\7~\2\2d\"\3\2\2\2ef\7`\2\2f$\3\2\2\2gh\7#\2\2"+
		"h&\3\2\2\2ik\5+\26\2jl\5\65\33\2kj\3\2\2\2kl\3\2\2\2ln\3\2\2\2mo\5\67"+
		"\34\2nm\3\2\2\2no\3\2\2\2ou\3\2\2\2pr\5\65\33\2qs\5\67\34\2rq\3\2\2\2"+
		"rs\3\2\2\2su\3\2\2\2ti\3\2\2\2tp\3\2\2\2u(\3\2\2\2vw\7v\2\2wx\7t\2\2x"+
		"y\7w\2\2y\u0080\7g\2\2z{\7h\2\2{|\7c\2\2|}\7n\2\2}~\7u\2\2~\u0080\7g\2"+
		"\2\177v\3\2\2\2\177z\3\2\2\2\u0080*\3\2\2\2\u0081\u008a\5-\27\2\u0082"+
		"\u0086\5/\30\2\u0083\u0085\5\61\31\2\u0084\u0083\3\2\2\2\u0085\u0088\3"+
		"\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u008a\3\2\2\2\u0088"+
		"\u0086\3\2\2\2\u0089\u0081\3\2\2\2\u0089\u0082\3\2\2\2\u008a,\3\2\2\2"+
		"\u008b\u008c\t\3\2\2\u008c.\3\2\2\2\u008d\u008e\t\4\2\2\u008e\60\3\2\2"+
		"\2\u008f\u0090\t\5\2\2\u0090\62\3\2\2\2\u0091\u0093\5\61\31\2\u0092\u0091"+
		"\3\2\2\2\u0093\u0096\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095"+
		"\64\3\2\2\2\u0096\u0094\3\2\2\2\u0097\u0099\5\t\5\2\u0098\u009a\5\63\32"+
		"\2\u0099\u0098\3\2\2\2\u0099\u009a\3\2\2\2\u009a\66\3\2\2\2\u009b\u009d"+
		"\t\6\2\2\u009c\u009e\59\35\2\u009d\u009c\3\2\2\2\u009d\u009e\3\2\2\2\u009e"+
		"\u009f\3\2\2\2\u009f\u00a0\5+\26\2\u00a08\3\2\2\2\u00a1\u00a2\t\7\2\2"+
		"\u00a2:\3\2\2\2\u00a3\u00a4\13\2\2\2\u00a4<\3\2\2\2\r\2knrt\177\u0086"+
		"\u0089\u0094\u0099\u009d\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}