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
		WS=1, LPAREN=2, RPAREN=3, DOT=4, PLUS=5, MINUS=6, MULT=7, DIV=8, AND=9, 
		OR=10, XOR=11, EQUIV=12, NOT=13, NUMBER=14, BOOL=15, MismatchedSymbol=16;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"WS", "LPAREN", "RPAREN", "DOT", "PLUS", "MINUS", "MULT", "DIV", "AND", 
		"OR", "XOR", "EQUIV", "NOT", "NUMBER", "BOOL", "Positive", "ZeroDigit", 
		"DigitWithoutZero", "Digit", "Digits", "FloatingPart", "ScientificPart", 
		"Sign", "MismatchedSymbol"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, "'('", "')'", "'.'", "'+'", "'-'", "'*'", "'/'", "'&&'", "'||'", 
		"'^'", "'=='", "'!'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "WS", "LPAREN", "RPAREN", "DOT", "PLUS", "MINUS", "MULT", "DIV", 
		"AND", "OR", "XOR", "EQUIV", "NOT", "NUMBER", "BOOL", "MismatchedSymbol"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\22\u008e\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b"+
		"\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\17"+
		"\3\17\5\17U\n\17\3\17\5\17X\n\17\3\17\3\17\5\17\\\n\17\5\17^\n\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20i\n\20\3\21\3\21\3\21\7\21"+
		"n\n\21\f\21\16\21q\13\21\5\21s\n\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25"+
		"\7\25|\n\25\f\25\16\25\177\13\25\3\26\3\26\5\26\u0083\n\26\3\27\3\27\5"+
		"\27\u0087\n\27\3\27\3\27\3\30\3\30\3\31\3\31\2\2\32\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\2#\2%\2\'\2"+
		")\2+\2-\2/\2\61\22\3\2\b\5\2\13\f\17\17\"\"\3\2\62\62\3\2\63;\3\2\62;"+
		"\4\2GGgg\4\2--//\2\u008f\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2\61\3\2\2\2\3\63\3\2\2\2\5\67\3\2\2\2\79\3\2\2\2\t;\3\2\2\2\13="+
		"\3\2\2\2\r?\3\2\2\2\17A\3\2\2\2\21C\3\2\2\2\23E\3\2\2\2\25H\3\2\2\2\27"+
		"K\3\2\2\2\31M\3\2\2\2\33P\3\2\2\2\35]\3\2\2\2\37h\3\2\2\2!r\3\2\2\2#t"+
		"\3\2\2\2%v\3\2\2\2\'x\3\2\2\2)}\3\2\2\2+\u0080\3\2\2\2-\u0084\3\2\2\2"+
		"/\u008a\3\2\2\2\61\u008c\3\2\2\2\63\64\t\2\2\2\64\65\3\2\2\2\65\66\b\2"+
		"\2\2\66\4\3\2\2\2\678\7*\2\28\6\3\2\2\29:\7+\2\2:\b\3\2\2\2;<\7\60\2\2"+
		"<\n\3\2\2\2=>\7-\2\2>\f\3\2\2\2?@\7/\2\2@\16\3\2\2\2AB\7,\2\2B\20\3\2"+
		"\2\2CD\7\61\2\2D\22\3\2\2\2EF\7(\2\2FG\7(\2\2G\24\3\2\2\2HI\7~\2\2IJ\7"+
		"~\2\2J\26\3\2\2\2KL\7`\2\2L\30\3\2\2\2MN\7?\2\2NO\7?\2\2O\32\3\2\2\2P"+
		"Q\7#\2\2Q\34\3\2\2\2RT\5!\21\2SU\5+\26\2TS\3\2\2\2TU\3\2\2\2UW\3\2\2\2"+
		"VX\5-\27\2WV\3\2\2\2WX\3\2\2\2X^\3\2\2\2Y[\5+\26\2Z\\\5-\27\2[Z\3\2\2"+
		"\2[\\\3\2\2\2\\^\3\2\2\2]R\3\2\2\2]Y\3\2\2\2^\36\3\2\2\2_`\7v\2\2`a\7"+
		"t\2\2ab\7w\2\2bi\7g\2\2cd\7h\2\2de\7c\2\2ef\7n\2\2fg\7u\2\2gi\7g\2\2h"+
		"_\3\2\2\2hc\3\2\2\2i \3\2\2\2js\5#\22\2ko\5%\23\2ln\5\'\24\2ml\3\2\2\2"+
		"nq\3\2\2\2om\3\2\2\2op\3\2\2\2ps\3\2\2\2qo\3\2\2\2rj\3\2\2\2rk\3\2\2\2"+
		"s\"\3\2\2\2tu\t\3\2\2u$\3\2\2\2vw\t\4\2\2w&\3\2\2\2xy\t\5\2\2y(\3\2\2"+
		"\2z|\5\'\24\2{z\3\2\2\2|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2~*\3\2\2\2\177"+
		"}\3\2\2\2\u0080\u0082\5\t\5\2\u0081\u0083\5)\25\2\u0082\u0081\3\2\2\2"+
		"\u0082\u0083\3\2\2\2\u0083,\3\2\2\2\u0084\u0086\t\6\2\2\u0085\u0087\5"+
		"/\30\2\u0086\u0085\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0088\3\2\2\2\u0088"+
		"\u0089\5!\21\2\u0089.\3\2\2\2\u008a\u008b\t\7\2\2\u008b\60\3\2\2\2\u008c"+
		"\u008d\13\2\2\2\u008d\62\3\2\2\2\r\2TW[]hor}\u0082\u0086\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}