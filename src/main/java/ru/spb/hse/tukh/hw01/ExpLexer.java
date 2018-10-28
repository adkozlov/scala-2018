package ru.spb.hse.tukh.hw01;// Generated from /home/igor/AU/3rd course/scala-2018/src/main/antlr4/Exp.g4 by ANTLR 4.7
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExpLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, PLUS=3, MINUS=4, MULT=5, DIVIDE=6, MODULO=7, GREATER=8, 
		LOWER=9, GEQ=10, LEQ=11, EQ=12, NEQ=13, OR=14, AND=15, BOOL_LITERAL=16, 
		LITERAL=17, WS=18;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "PLUS", "MINUS", "MULT", "DIVIDE", "MODULO", "GREATER", 
		"LOWER", "GEQ", "LEQ", "EQ", "NEQ", "OR", "AND", "BOOL_LITERAL", "LITERAL", 
		"WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'+'", "'-'", "'*'", "'/'", "'%'", "'>'", "'<'", "'>='", 
		"'<='", "'=='", "'!='", "'||'", "'&&'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, "PLUS", "MINUS", "MULT", "DIVIDE", "MODULO", "GREATER", 
		"LOWER", "GEQ", "LEQ", "EQ", "NEQ", "OR", "AND", "BOOL_LITERAL", "LITERAL", 
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


	public ExpLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Exp.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\24g\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t"+
		"\3\t\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17"+
		"\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\5\21U\n\21\3\22\5\22X\n\22\3\22\3\22\7\22\\\n\22\f\22\16\22_\13\22\3"+
		"\22\5\22b\n\22\3\23\3\23\3\23\3\23\2\2\24\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\3\2\3\5\2"+
		"\13\f\17\17\"\"\2j\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\3\'\3\2\2\2\5)\3\2\2\2\7+\3\2\2\2\t-\3"+
		"\2\2\2\13/\3\2\2\2\r\61\3\2\2\2\17\63\3\2\2\2\21\65\3\2\2\2\23\67\3\2"+
		"\2\2\259\3\2\2\2\27<\3\2\2\2\31?\3\2\2\2\33B\3\2\2\2\35E\3\2\2\2\37H\3"+
		"\2\2\2!T\3\2\2\2#a\3\2\2\2%c\3\2\2\2\'(\7*\2\2(\4\3\2\2\2)*\7+\2\2*\6"+
		"\3\2\2\2+,\7-\2\2,\b\3\2\2\2-.\7/\2\2.\n\3\2\2\2/\60\7,\2\2\60\f\3\2\2"+
		"\2\61\62\7\61\2\2\62\16\3\2\2\2\63\64\7\'\2\2\64\20\3\2\2\2\65\66\7@\2"+
		"\2\66\22\3\2\2\2\678\7>\2\28\24\3\2\2\29:\7@\2\2:;\7?\2\2;\26\3\2\2\2"+
		"<=\7>\2\2=>\7?\2\2>\30\3\2\2\2?@\7?\2\2@A\7?\2\2A\32\3\2\2\2BC\7#\2\2"+
		"CD\7?\2\2D\34\3\2\2\2EF\7~\2\2FG\7~\2\2G\36\3\2\2\2HI\7(\2\2IJ\7(\2\2"+
		"J \3\2\2\2KL\7v\2\2LM\7t\2\2MN\7w\2\2NU\7g\2\2OP\7h\2\2PQ\7c\2\2QR\7n"+
		"\2\2RS\7u\2\2SU\7g\2\2TK\3\2\2\2TO\3\2\2\2U\"\3\2\2\2VX\7/\2\2WV\3\2\2"+
		"\2WX\3\2\2\2XY\3\2\2\2Y]\4\63;\2Z\\\4\62;\2[Z\3\2\2\2\\_\3\2\2\2][\3\2"+
		"\2\2]^\3\2\2\2^b\3\2\2\2_]\3\2\2\2`b\7\62\2\2aW\3\2\2\2a`\3\2\2\2b$\3"+
		"\2\2\2cd\t\2\2\2de\3\2\2\2ef\b\23\2\2f&\3\2\2\2\7\2TW]a\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}