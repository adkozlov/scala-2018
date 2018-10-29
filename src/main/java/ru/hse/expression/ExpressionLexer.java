// Generated from /home/annikura/HSE/JVM/scala-2018/src/main/antlr/Expression.g4 by ANTLR 4.7
package ru.hse.expression;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExpressionLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, OPERATOR1=3, OPERATOR2=4, OPERATOR3=5, OPERATOR4=6, OPERATOR5=7, 
		OPERATOR6=8, MUL=9, DIV=10, MOD=11, PLUS=12, MINUS=13, LESS_THAN=14, GREATER_THAN=15, 
		LE=16, GE=17, EQ=18, NEQ=19, AND=20, OR=21, NUMBER=22, BOOLEAN=23, WS=24;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "OPERATOR1", "OPERATOR2", "OPERATOR3", "OPERATOR4", "OPERATOR5", 
		"OPERATOR6", "MUL", "DIV", "MOD", "PLUS", "MINUS", "LESS_THAN", "GREATER_THAN", 
		"LE", "GE", "EQ", "NEQ", "AND", "OR", "NUMBER", "BOOLEAN", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", null, null, null, null, null, null, "'*'", "'/'", 
		"'%'", "'+'", "'-'", "'<'", "'>'", "'<='", "'>='", "'=='", "'!='", "'&&'", 
		"'||'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, "OPERATOR1", "OPERATOR2", "OPERATOR3", "OPERATOR4", 
		"OPERATOR5", "OPERATOR6", "MUL", "DIV", "MOD", "PLUS", "MINUS", "LESS_THAN", 
		"GREATER_THAN", "LE", "GE", "EQ", "NEQ", "AND", "OR", "NUMBER", "BOOLEAN", 
		"WS"
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


	public ExpressionLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Expression.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\32\u0085\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\3\2\3\2\3\3\3\3\3\4\3\4\3\4\5\4;\n\4\3\5\3\5\5\5?\n\5\3\6\3\6\3"+
		"\6\3\6\5\6E\n\6\3\7\3\7\5\7I\n\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f"+
		"\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3"+
		"\22\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27\6"+
		"\27p\n\27\r\27\16\27q\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30"+
		"}\n\30\3\31\6\31\u0080\n\31\r\31\16\31\u0081\3\31\3\31\2\2\32\3\3\5\4"+
		"\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27-\30/\31\61\32\3\2\3\5\2\13\f\17\17\"\"\2\u008e\2"+
		"\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2"+
		"\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2"+
		"\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2"+
		"\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2"+
		"\2\61\3\2\2\2\3\63\3\2\2\2\5\65\3\2\2\2\7:\3\2\2\2\t>\3\2\2\2\13D\3\2"+
		"\2\2\rH\3\2\2\2\17J\3\2\2\2\21L\3\2\2\2\23N\3\2\2\2\25P\3\2\2\2\27R\3"+
		"\2\2\2\31T\3\2\2\2\33V\3\2\2\2\35X\3\2\2\2\37Z\3\2\2\2!\\\3\2\2\2#_\3"+
		"\2\2\2%b\3\2\2\2\'e\3\2\2\2)h\3\2\2\2+k\3\2\2\2-o\3\2\2\2/|\3\2\2\2\61"+
		"\177\3\2\2\2\63\64\7*\2\2\64\4\3\2\2\2\65\66\7+\2\2\66\6\3\2\2\2\67;\5"+
		"\23\n\28;\5\25\13\29;\5\27\f\2:\67\3\2\2\2:8\3\2\2\2:9\3\2\2\2;\b\3\2"+
		"\2\2<?\5\31\r\2=?\5\33\16\2><\3\2\2\2>=\3\2\2\2?\n\3\2\2\2@E\5\35\17\2"+
		"AE\5\37\20\2BE\5!\21\2CE\5#\22\2D@\3\2\2\2DA\3\2\2\2DB\3\2\2\2DC\3\2\2"+
		"\2E\f\3\2\2\2FI\5%\23\2GI\5\'\24\2HF\3\2\2\2HG\3\2\2\2I\16\3\2\2\2JK\5"+
		")\25\2K\20\3\2\2\2LM\5+\26\2M\22\3\2\2\2NO\7,\2\2O\24\3\2\2\2PQ\7\61\2"+
		"\2Q\26\3\2\2\2RS\7\'\2\2S\30\3\2\2\2TU\7-\2\2U\32\3\2\2\2VW\7/\2\2W\34"+
		"\3\2\2\2XY\7>\2\2Y\36\3\2\2\2Z[\7@\2\2[ \3\2\2\2\\]\7>\2\2]^\7?\2\2^\""+
		"\3\2\2\2_`\7@\2\2`a\7?\2\2a$\3\2\2\2bc\7?\2\2cd\7?\2\2d&\3\2\2\2ef\7#"+
		"\2\2fg\7?\2\2g(\3\2\2\2hi\7(\2\2ij\7(\2\2j*\3\2\2\2kl\7~\2\2lm\7~\2\2"+
		"m,\3\2\2\2np\4\62;\2on\3\2\2\2pq\3\2\2\2qo\3\2\2\2qr\3\2\2\2r.\3\2\2\2"+
		"st\7v\2\2tu\7t\2\2uv\7w\2\2v}\7g\2\2wx\7h\2\2xy\7c\2\2yz\7n\2\2z{\7u\2"+
		"\2{}\7g\2\2|s\3\2\2\2|w\3\2\2\2}\60\3\2\2\2~\u0080\t\2\2\2\177~\3\2\2"+
		"\2\u0080\u0081\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0083"+
		"\3\2\2\2\u0083\u0084\b\31\2\2\u0084\62\3\2\2\2\n\2:>DHq|\u0081\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}