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
		GREATER=9, GREQUAL=10, LESS=11, LEQUAL=12, AND=13, OR=14, ASSIGN=15, LPAREN=16, 
		RPAREN=17, INT_NUM=18, TRUE=19, FALSE=20;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"WS", "NL", "SKIP_", "CR", "LF", "PLUS", "MINUS", "ASTERISK", "DIVISION", 
		"MOD", "EQUAL", "NOTEQUAL", "GREATER", "GREQUAL", "LESS", "LEQUAL", "AND", 
		"OR", "ASSIGN", "LPAREN", "RPAREN", "INT_NUM", "TRUE", "FALSE"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, "'+'", "'-'", "'*'", "'/'", "'%'", "'=='", "'!='", "'>'", 
		"'>='", "'<'", "'<='", "'&&'", "'||'", "'='", "'('", "')'", null, "'true'", 
		"'false'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "SKIP_", "PLUS", "MINUS", "ASTERISK", "DIVISION", "MOD", "EQUAL", 
		"NOTEQUAL", "GREATER", "GREQUAL", "LESS", "LEQUAL", "AND", "OR", "ASSIGN", 
		"LPAREN", "RPAREN", "INT_NUM", "TRUE", "FALSE"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\26\u0083\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\3\2\6\2\65\n\2\r\2\16\2\66\3\3\5\3:\n\3\3\3\3\3\5\3>\n\3\3\4\3\4"+
		"\3\4\5\4C\n\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n"+
		"\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\20\3\20"+
		"\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\26"+
		"\3\26\3\27\5\27r\n\27\3\27\6\27u\n\27\r\27\16\27v\3\30\3\30\3\30\3\30"+
		"\3\30\3\31\3\31\3\31\3\31\3\31\3\31\2\2\32\3\2\5\2\7\3\t\2\13\2\r\4\17"+
		"\5\21\6\23\7\25\b\27\t\31\n\33\13\35\f\37\r!\16#\17%\20\'\21)\22+\23-"+
		"\24/\25\61\26\3\2\3\4\2\13\13\"\"\2\u0085\2\7\3\2\2\2\2\r\3\2\2\2\2\17"+
		"\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2"+
		"\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3"+
		"\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3"+
		"\2\2\2\3\64\3\2\2\2\5=\3\2\2\2\7B\3\2\2\2\tF\3\2\2\2\13H\3\2\2\2\rJ\3"+
		"\2\2\2\17L\3\2\2\2\21N\3\2\2\2\23P\3\2\2\2\25R\3\2\2\2\27T\3\2\2\2\31"+
		"W\3\2\2\2\33Z\3\2\2\2\35\\\3\2\2\2\37_\3\2\2\2!a\3\2\2\2#d\3\2\2\2%g\3"+
		"\2\2\2\'j\3\2\2\2)l\3\2\2\2+n\3\2\2\2-q\3\2\2\2/x\3\2\2\2\61}\3\2\2\2"+
		"\63\65\t\2\2\2\64\63\3\2\2\2\65\66\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2"+
		"\67\4\3\2\2\28:\7\17\2\298\3\2\2\29:\3\2\2\2:;\3\2\2\2;>\7\f\2\2<>\7\17"+
		"\2\2=9\3\2\2\2=<\3\2\2\2>\6\3\2\2\2?C\5\3\2\2@C\5\5\3\2AC\7\2\2\3B?\3"+
		"\2\2\2B@\3\2\2\2BA\3\2\2\2CD\3\2\2\2DE\b\4\2\2E\b\3\2\2\2FG\7\17\2\2G"+
		"\n\3\2\2\2HI\7\f\2\2I\f\3\2\2\2JK\7-\2\2K\16\3\2\2\2LM\7/\2\2M\20\3\2"+
		"\2\2NO\7,\2\2O\22\3\2\2\2PQ\7\61\2\2Q\24\3\2\2\2RS\7\'\2\2S\26\3\2\2\2"+
		"TU\7?\2\2UV\7?\2\2V\30\3\2\2\2WX\7#\2\2XY\7?\2\2Y\32\3\2\2\2Z[\7@\2\2"+
		"[\34\3\2\2\2\\]\7@\2\2]^\7?\2\2^\36\3\2\2\2_`\7>\2\2` \3\2\2\2ab\7>\2"+
		"\2bc\7?\2\2c\"\3\2\2\2de\7(\2\2ef\7(\2\2f$\3\2\2\2gh\7~\2\2hi\7~\2\2i"+
		"&\3\2\2\2jk\7?\2\2k(\3\2\2\2lm\7*\2\2m*\3\2\2\2no\7+\2\2o,\3\2\2\2pr\7"+
		"/\2\2qp\3\2\2\2qr\3\2\2\2rt\3\2\2\2su\4\62;\2ts\3\2\2\2uv\3\2\2\2vt\3"+
		"\2\2\2vw\3\2\2\2w.\3\2\2\2xy\7v\2\2yz\7t\2\2z{\7w\2\2{|\7g\2\2|\60\3\2"+
		"\2\2}~\7h\2\2~\177\7c\2\2\177\u0080\7n\2\2\u0080\u0081\7u\2\2\u0081\u0082"+
		"\7g\2\2\u0082\62\3\2\2\2\t\2\669=Bqv\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}