// Generated from C:/Users/machine/Documents/github/scala-2018/src/main/antlr\Calculator.g4 by ANTLR 4.7
package ru.hse.scala.nedikov.calculator;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CalculatorLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, NUMBER=15, BOOLEAN=16, 
		WS=17;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "NUMBER", "BOOLEAN", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'*'", "'/'", "'+'", "'-'", "'=='", "'!='", "'&&'", "'||'", "'>='", 
		"'<='", "'>'", "'<'", "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, "NUMBER", "BOOLEAN", "WS"
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


	public CalculatorLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Calculator.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\23m\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3"+
		"\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3"+
		"\17\3\20\6\20I\n\20\r\20\16\20J\3\20\3\20\7\20O\n\20\f\20\16\20R\13\20"+
		"\5\20T\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\5\21h\n\21\3\22\3\22\3\22\3\22\2\2\23\3"+
		"\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37"+
		"\21!\22#\23\3\2\4\3\2\62;\4\2\13\13\"\"\2r\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2"+
		"\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2"+
		"\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\3%\3\2\2\2\5\'\3\2\2\2"+
		"\7)\3\2\2\2\t+\3\2\2\2\13-\3\2\2\2\r\60\3\2\2\2\17\63\3\2\2\2\21\66\3"+
		"\2\2\2\239\3\2\2\2\25<\3\2\2\2\27?\3\2\2\2\31A\3\2\2\2\33C\3\2\2\2\35"+
		"E\3\2\2\2\37H\3\2\2\2!g\3\2\2\2#i\3\2\2\2%&\7,\2\2&\4\3\2\2\2\'(\7\61"+
		"\2\2(\6\3\2\2\2)*\7-\2\2*\b\3\2\2\2+,\7/\2\2,\n\3\2\2\2-.\7?\2\2./\7?"+
		"\2\2/\f\3\2\2\2\60\61\7#\2\2\61\62\7?\2\2\62\16\3\2\2\2\63\64\7(\2\2\64"+
		"\65\7(\2\2\65\20\3\2\2\2\66\67\7~\2\2\678\7~\2\28\22\3\2\2\29:\7@\2\2"+
		":;\7?\2\2;\24\3\2\2\2<=\7>\2\2=>\7?\2\2>\26\3\2\2\2?@\7@\2\2@\30\3\2\2"+
		"\2AB\7>\2\2B\32\3\2\2\2CD\7*\2\2D\34\3\2\2\2EF\7+\2\2F\36\3\2\2\2GI\t"+
		"\2\2\2HG\3\2\2\2IJ\3\2\2\2JH\3\2\2\2JK\3\2\2\2KS\3\2\2\2LP\7\60\2\2MO"+
		"\t\2\2\2NM\3\2\2\2OR\3\2\2\2PN\3\2\2\2PQ\3\2\2\2QT\3\2\2\2RP\3\2\2\2S"+
		"L\3\2\2\2ST\3\2\2\2T \3\2\2\2UV\7v\2\2VW\7t\2\2WX\7w\2\2Xh\7g\2\2YZ\7"+
		"h\2\2Z[\7c\2\2[\\\7n\2\2\\]\7u\2\2]h\7g\2\2^_\7V\2\2_`\7T\2\2`a\7W\2\2"+
		"ah\7G\2\2bc\7H\2\2cd\7C\2\2de\7N\2\2ef\7U\2\2fh\7G\2\2gU\3\2\2\2gY\3\2"+
		"\2\2g^\3\2\2\2gb\3\2\2\2h\"\3\2\2\2ij\t\3\2\2jk\3\2\2\2kl\b\22\2\2l$\3"+
		"\2\2\2\7\2JPSg\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}