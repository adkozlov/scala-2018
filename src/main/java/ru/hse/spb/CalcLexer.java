// Generated from /home/zoldater/Documents/au/scala-2018/src/main/antlr4/CalcLexer.g4 by ANTLR 4.7
package ru.hse.spb;
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
		LITERAL=1, LPAREN=2, RPAREN=3, WS=4, ADD=5, SUB=6, MULT=7, DIV=8, MOD=9, 
		GT=10, LT=11, LE=12, GE=13, EQUAL=14, NOTEQUAL=15, AND=16, OR=17;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"LITERAL", "LPAREN", "RPAREN", "WS", "ADD", "SUB", "MULT", "DIV", "MOD", 
		"GT", "LT", "LE", "GE", "EQUAL", "NOTEQUAL", "AND", "OR", "Digits"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, "'('", "')'", null, "'+'", "'-'", "'*'", "'/'", "'%'", "'>'", 
		"'<'", "'<='", "'>='", "'=='", "'!='", "'&&'", "'||'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "LITERAL", "LPAREN", "RPAREN", "WS", "ADD", "SUB", "MULT", "DIV", 
		"MOD", "GT", "LT", "LE", "GE", "EQUAL", "NOTEQUAL", "AND", "OR"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\23f\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\5\2*\n\2\3\2\3\2\5\2.\n\2\5\2\60\n\2\3\3\3\3\3\4\3"+
		"\4\3\5\6\5\67\n\5\r\5\16\58\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3"+
		"\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20"+
		"\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\7\23_\n\23\f\23\16"+
		"\23b\13\23\3\23\5\23e\n\23\2\2\24\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\2\3\2\6\3\2\63;\4\2\13"+
		"\f\"\"\3\2\62;\4\2\62;aa\2j\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2"+
		"\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37"+
		"\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\3/\3\2\2\2\5\61\3\2\2\2\7\63\3\2\2\2\t"+
		"\66\3\2\2\2\13<\3\2\2\2\r>\3\2\2\2\17@\3\2\2\2\21B\3\2\2\2\23D\3\2\2\2"+
		"\25F\3\2\2\2\27H\3\2\2\2\31J\3\2\2\2\33M\3\2\2\2\35P\3\2\2\2\37S\3\2\2"+
		"\2!V\3\2\2\2#Y\3\2\2\2%\\\3\2\2\2\'\60\7\62\2\2(*\7/\2\2)(\3\2\2\2)*\3"+
		"\2\2\2*+\3\2\2\2+-\t\2\2\2,.\5%\23\2-,\3\2\2\2-.\3\2\2\2.\60\3\2\2\2/"+
		"\'\3\2\2\2/)\3\2\2\2\60\4\3\2\2\2\61\62\7*\2\2\62\6\3\2\2\2\63\64\7+\2"+
		"\2\64\b\3\2\2\2\65\67\t\3\2\2\66\65\3\2\2\2\678\3\2\2\28\66\3\2\2\289"+
		"\3\2\2\29:\3\2\2\2:;\b\5\2\2;\n\3\2\2\2<=\7-\2\2=\f\3\2\2\2>?\7/\2\2?"+
		"\16\3\2\2\2@A\7,\2\2A\20\3\2\2\2BC\7\61\2\2C\22\3\2\2\2DE\7\'\2\2E\24"+
		"\3\2\2\2FG\7@\2\2G\26\3\2\2\2HI\7>\2\2I\30\3\2\2\2JK\7>\2\2KL\7?\2\2L"+
		"\32\3\2\2\2MN\7@\2\2NO\7?\2\2O\34\3\2\2\2PQ\7?\2\2QR\7?\2\2R\36\3\2\2"+
		"\2ST\7#\2\2TU\7?\2\2U \3\2\2\2VW\7(\2\2WX\7(\2\2X\"\3\2\2\2YZ\7~\2\2Z"+
		"[\7~\2\2[$\3\2\2\2\\d\t\4\2\2]_\t\5\2\2^]\3\2\2\2_b\3\2\2\2`^\3\2\2\2"+
		"`a\3\2\2\2ac\3\2\2\2b`\3\2\2\2ce\t\4\2\2d`\3\2\2\2de\3\2\2\2e&\3\2\2\2"+
		"\t\2)-/8`d\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}