// Generated from /home/aleks/Documents/edu/scala-2018/src/main/antlr/NotFunAtAllLexer.g4 by ANTLR 4.7
package org.ifmo.grammar;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class NotFunAtAllLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SKIP_=1, PLUS=2, MINUS=3, ASTERISK=4, DIVISION=5, MOD=6, EQUAL=7, NOTEQUAL=8, 
		GREATER=9, GREQUAL=10, LESS=11, LEQUAL=12, AND=13, OR=14, LPAREN=15, RPAREN=16, 
		INT_NUM=17, TRUE=18, FALSE=19;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"WS", "NL", "SKIP_", "CR", "LF", "PLUS", "MINUS", "ASTERISK", "DIVISION", 
		"MOD", "EQUAL", "NOTEQUAL", "GREATER", "GREQUAL", "LESS", "LEQUAL", "AND", 
		"OR", "LPAREN", "RPAREN", "INT_NUM", "TRUE", "FALSE"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, "'+'", "'-'", "'*'", "'/'", "'%'", "'=='", "'!='", "'>'", 
		"'>='", "'<'", "'<='", "'&&'", "'||'", "'('", "')'", null, "'true'", "'false'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "SKIP_", "PLUS", "MINUS", "ASTERISK", "DIVISION", "MOD", "EQUAL", 
		"NOTEQUAL", "GREATER", "GREQUAL", "LESS", "LEQUAL", "AND", "OR", "LPAREN", 
		"RPAREN", "INT_NUM", "TRUE", "FALSE"
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


	public NotFunAtAllLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "NotFunAtAllLexer.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\25\177\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2\6\2\63"+
		"\n\2\r\2\16\2\64\3\3\5\38\n\3\3\3\3\3\5\3<\n\3\3\4\3\4\3\4\5\4A\n\4\3"+
		"\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3"+
		"\f\3\f\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3"+
		"\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\26\5\26n\n\26\3\26"+
		"\6\26q\n\26\r\26\16\26r\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3"+
		"\30\3\30\2\2\31\3\2\5\2\7\3\t\2\13\2\r\4\17\5\21\6\23\7\25\b\27\t\31\n"+
		"\33\13\35\f\37\r!\16#\17%\20\'\21)\22+\23-\24/\25\3\2\3\4\2\13\13\"\""+
		"\2\u0081\2\7\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2"+
		"\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2"+
		"\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2"+
		"+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\3\62\3\2\2\2\5;\3\2\2\2\7@\3\2\2\2\tD"+
		"\3\2\2\2\13F\3\2\2\2\rH\3\2\2\2\17J\3\2\2\2\21L\3\2\2\2\23N\3\2\2\2\25"+
		"P\3\2\2\2\27R\3\2\2\2\31U\3\2\2\2\33X\3\2\2\2\35Z\3\2\2\2\37]\3\2\2\2"+
		"!_\3\2\2\2#b\3\2\2\2%e\3\2\2\2\'h\3\2\2\2)j\3\2\2\2+m\3\2\2\2-t\3\2\2"+
		"\2/y\3\2\2\2\61\63\t\2\2\2\62\61\3\2\2\2\63\64\3\2\2\2\64\62\3\2\2\2\64"+
		"\65\3\2\2\2\65\4\3\2\2\2\668\7\17\2\2\67\66\3\2\2\2\678\3\2\2\289\3\2"+
		"\2\29<\7\f\2\2:<\7\17\2\2;\67\3\2\2\2;:\3\2\2\2<\6\3\2\2\2=A\5\3\2\2>"+
		"A\5\5\3\2?A\7\2\2\3@=\3\2\2\2@>\3\2\2\2@?\3\2\2\2AB\3\2\2\2BC\b\4\2\2"+
		"C\b\3\2\2\2DE\7\17\2\2E\n\3\2\2\2FG\7\f\2\2G\f\3\2\2\2HI\7-\2\2I\16\3"+
		"\2\2\2JK\7/\2\2K\20\3\2\2\2LM\7,\2\2M\22\3\2\2\2NO\7\61\2\2O\24\3\2\2"+
		"\2PQ\7\'\2\2Q\26\3\2\2\2RS\7?\2\2ST\7?\2\2T\30\3\2\2\2UV\7#\2\2VW\7?\2"+
		"\2W\32\3\2\2\2XY\7@\2\2Y\34\3\2\2\2Z[\7@\2\2[\\\7?\2\2\\\36\3\2\2\2]^"+
		"\7>\2\2^ \3\2\2\2_`\7>\2\2`a\7?\2\2a\"\3\2\2\2bc\7(\2\2cd\7(\2\2d$\3\2"+
		"\2\2ef\7~\2\2fg\7~\2\2g&\3\2\2\2hi\7*\2\2i(\3\2\2\2jk\7+\2\2k*\3\2\2\2"+
		"ln\7/\2\2ml\3\2\2\2mn\3\2\2\2np\3\2\2\2oq\4\62;\2po\3\2\2\2qr\3\2\2\2"+
		"rp\3\2\2\2rs\3\2\2\2s,\3\2\2\2tu\7v\2\2uv\7t\2\2vw\7w\2\2wx\7g\2\2x.\3"+
		"\2\2\2yz\7h\2\2z{\7c\2\2{|\7n\2\2|}\7u\2\2}~\7g\2\2~\60\3\2\2\2\t\2\64"+
		"\67;@mr\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}