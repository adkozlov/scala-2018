// Generated from /Users/aleksandra.orlova/Documents/JVM HW/scala-2018/src/main/antlr/Exp.g4 by ANTLR 4.7
package ru.spbau.jvm.scala.homework1;

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
		T__0=1, T__1=2, T__2=3, MUL=4, DEL=5, SUM=6, MUN=7, EQ=8, NEQ=9, LE=10, 
		GR=11, LEQ=12, GEQ=13, OR=14, AND=15, Number=16, WS=17;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "MUL", "DEL", "SUM", "MUN", "EQ", "NEQ", "LE", 
		"GR", "LEQ", "GEQ", "OR", "AND", "Number", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'(-'", "'*'", "'/'", "'+'", "'-'", "'=='", "'!='", 
		"'<'", "'>'", "'<='", "'>='", "'||'", "'&&'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, "MUL", "DEL", "SUM", "MUN", "EQ", "NEQ", "LE", 
		"GR", "LEQ", "GEQ", "OR", "AND", "Number", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\23X\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3"+
		"\t\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17"+
		"\3\17\3\20\3\20\3\20\3\21\3\21\7\21M\n\21\f\21\16\21P\13\21\3\21\5\21"+
		"S\n\21\3\22\3\22\3\22\3\22\2\2\23\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23\3\2\3\5\2\13\f\17\17\"\""+
		"\2Y\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3"+
		"\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2"+
		"\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3"+
		"\2\2\2\3%\3\2\2\2\5\'\3\2\2\2\7)\3\2\2\2\t,\3\2\2\2\13.\3\2\2\2\r\60\3"+
		"\2\2\2\17\62\3\2\2\2\21\64\3\2\2\2\23\67\3\2\2\2\25:\3\2\2\2\27<\3\2\2"+
		"\2\31>\3\2\2\2\33A\3\2\2\2\35D\3\2\2\2\37G\3\2\2\2!R\3\2\2\2#T\3\2\2\2"+
		"%&\7*\2\2&\4\3\2\2\2\'(\7+\2\2(\6\3\2\2\2)*\7*\2\2*+\7/\2\2+\b\3\2\2\2"+
		",-\7,\2\2-\n\3\2\2\2./\7\61\2\2/\f\3\2\2\2\60\61\7-\2\2\61\16\3\2\2\2"+
		"\62\63\7/\2\2\63\20\3\2\2\2\64\65\7?\2\2\65\66\7?\2\2\66\22\3\2\2\2\67"+
		"8\7#\2\289\7?\2\29\24\3\2\2\2:;\7>\2\2;\26\3\2\2\2<=\7@\2\2=\30\3\2\2"+
		"\2>?\7>\2\2?@\7?\2\2@\32\3\2\2\2AB\7@\2\2BC\7?\2\2C\34\3\2\2\2DE\7~\2"+
		"\2EF\7~\2\2F\36\3\2\2\2GH\7(\2\2HI\7(\2\2I \3\2\2\2JN\4\63;\2KM\4\62;"+
		"\2LK\3\2\2\2MP\3\2\2\2NL\3\2\2\2NO\3\2\2\2OS\3\2\2\2PN\3\2\2\2QS\7\62"+
		"\2\2RJ\3\2\2\2RQ\3\2\2\2S\"\3\2\2\2TU\t\2\2\2UV\3\2\2\2VW\b\22\2\2W$\3"+
		"\2\2\2\5\2NR\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}