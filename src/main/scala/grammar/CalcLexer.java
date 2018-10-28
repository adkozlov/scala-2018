// Generated from /home/katya/AU/DT/DT2018-master/calculator/src/main/scala/grammar/CalcLexer.g4 by ANTLR 4.7
package grammar;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CalcLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, NUMBER=2, TRUE=3, FALSE=4, ADD=5, SUB=6, MUL=7, DIV=8, MOD=9, POW=10, 
		EQ=11, NEQ=12, LT=13, LE=14, GT=15, GE=16, OR=17, AND=18, NOT=19, LPAR=20, 
		RPAR=21;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"WS", "NUMBER", "TRUE", "FALSE", "ADD", "SUB", "MUL", "DIV", "MOD", "POW", 
		"EQ", "NEQ", "LT", "LE", "GT", "GE", "OR", "AND", "NOT", "LPAR", "RPAR"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, "'true'", "'false'", "'+'", "'-'", "'*'", "'/'", "'%'", 
		"'^'", "'=='", "'!='", "'<'", "'<='", "'>'", "'>='", "'||'", "'&&'", "'!'", 
		"'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "WS", "NUMBER", "TRUE", "FALSE", "ADD", "SUB", "MUL", "DIV", "MOD", 
		"POW", "EQ", "NEQ", "LT", "LE", "GT", "GE", "OR", "AND", "NOT", "LPAR", 
		"RPAR"
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


	public CalcLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CalcLexer.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\27t\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\6\2/\n\2\r\2\16\2\60\3\2"+
		"\3\2\3\3\6\3\66\n\3\r\3\16\3\67\3\3\3\3\6\3<\n\3\r\3\16\3=\5\3@\n\3\3"+
		"\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t"+
		"\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\17"+
		"\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\25"+
		"\3\25\3\26\3\26\2\2\27\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27"+
		"\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27\3\2\3\4\2\13\f\"\""+
		"\2w\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3"+
		"\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2"+
		"\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3"+
		"\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\3.\3\2\2\2\5\65\3"+
		"\2\2\2\7A\3\2\2\2\tF\3\2\2\2\13L\3\2\2\2\rN\3\2\2\2\17P\3\2\2\2\21R\3"+
		"\2\2\2\23T\3\2\2\2\25V\3\2\2\2\27X\3\2\2\2\31[\3\2\2\2\33^\3\2\2\2\35"+
		"`\3\2\2\2\37c\3\2\2\2!e\3\2\2\2#h\3\2\2\2%k\3\2\2\2\'n\3\2\2\2)p\3\2\2"+
		"\2+r\3\2\2\2-/\t\2\2\2.-\3\2\2\2/\60\3\2\2\2\60.\3\2\2\2\60\61\3\2\2\2"+
		"\61\62\3\2\2\2\62\63\b\2\2\2\63\4\3\2\2\2\64\66\4\62;\2\65\64\3\2\2\2"+
		"\66\67\3\2\2\2\67\65\3\2\2\2\678\3\2\2\28?\3\2\2\29;\7\60\2\2:<\4\62;"+
		"\2;:\3\2\2\2<=\3\2\2\2=;\3\2\2\2=>\3\2\2\2>@\3\2\2\2?9\3\2\2\2?@\3\2\2"+
		"\2@\6\3\2\2\2AB\7v\2\2BC\7t\2\2CD\7w\2\2DE\7g\2\2E\b\3\2\2\2FG\7h\2\2"+
		"GH\7c\2\2HI\7n\2\2IJ\7u\2\2JK\7g\2\2K\n\3\2\2\2LM\7-\2\2M\f\3\2\2\2NO"+
		"\7/\2\2O\16\3\2\2\2PQ\7,\2\2Q\20\3\2\2\2RS\7\61\2\2S\22\3\2\2\2TU\7\'"+
		"\2\2U\24\3\2\2\2VW\7`\2\2W\26\3\2\2\2XY\7?\2\2YZ\7?\2\2Z\30\3\2\2\2[\\"+
		"\7#\2\2\\]\7?\2\2]\32\3\2\2\2^_\7>\2\2_\34\3\2\2\2`a\7>\2\2ab\7?\2\2b"+
		"\36\3\2\2\2cd\7@\2\2d \3\2\2\2ef\7@\2\2fg\7?\2\2g\"\3\2\2\2hi\7~\2\2i"+
		"j\7~\2\2j$\3\2\2\2kl\7(\2\2lm\7(\2\2m&\3\2\2\2no\7#\2\2o(\3\2\2\2pq\7"+
		"*\2\2q*\3\2\2\2rs\7+\2\2s,\3\2\2\2\7\2\60\67=?\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}