// Generated from src/main/java/ru/hse/Exp.g4 by ANTLR 4.7.1
package ru.hse;
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
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, MultiplicativeOp=3, AdditiveOp=4, RelationalOp=5, AndOp=6, 
		OrOp=7, BoolLiteral=8, IntLiteral=9, WS=10;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "MultiplicativeOp", "AdditiveOp", "RelationalOp", "AndOp", 
		"OrOp", "BoolLiteral", "IntLiteral", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", null, null, null, "'&&'", "'||'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, "MultiplicativeOp", "AdditiveOp", "RelationalOp", "AndOp", 
		"OrOp", "BoolLiteral", "IntLiteral", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\fW\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\5\6)\n\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\5\t:\n\t\3\n\3\n\5\n>\n\n\3\n\3\n\7\nB\n\n\f\n\16\nE\13\n\5\nG\n\n"+
		"\3\13\3\13\3\13\3\13\7\13M\n\13\f\13\16\13P\13\13\3\13\3\13\5\13T\n\13"+
		"\3\13\3\13\3N\2\f\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\3\2\b"+
		"\5\2\'\',,\61\61\4\2--//\4\2>>@@\3\2\63;\3\2\62;\5\2\13\f\17\17\"\"\2"+
		"`\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\3\27\3\2\2\2"+
		"\5\31\3\2\2\2\7\33\3\2\2\2\t\35\3\2\2\2\13(\3\2\2\2\r*\3\2\2\2\17-\3\2"+
		"\2\2\219\3\2\2\2\23F\3\2\2\2\25S\3\2\2\2\27\30\7*\2\2\30\4\3\2\2\2\31"+
		"\32\7+\2\2\32\6\3\2\2\2\33\34\t\2\2\2\34\b\3\2\2\2\35\36\t\3\2\2\36\n"+
		"\3\2\2\2\37)\t\4\2\2 !\7@\2\2!)\7?\2\2\"#\7>\2\2#)\7?\2\2$%\7?\2\2%)\7"+
		"?\2\2&\'\7#\2\2\')\7?\2\2(\37\3\2\2\2( \3\2\2\2(\"\3\2\2\2($\3\2\2\2("+
		"&\3\2\2\2)\f\3\2\2\2*+\7(\2\2+,\7(\2\2,\16\3\2\2\2-.\7~\2\2./\7~\2\2/"+
		"\20\3\2\2\2\60\61\7v\2\2\61\62\7t\2\2\62\63\7w\2\2\63:\7g\2\2\64\65\7"+
		"h\2\2\65\66\7c\2\2\66\67\7n\2\2\678\7u\2\28:\7g\2\29\60\3\2\2\29\64\3"+
		"\2\2\2:\22\3\2\2\2;G\7\62\2\2<>\7/\2\2=<\3\2\2\2=>\3\2\2\2>?\3\2\2\2?"+
		"C\t\5\2\2@B\t\6\2\2A@\3\2\2\2BE\3\2\2\2CA\3\2\2\2CD\3\2\2\2DG\3\2\2\2"+
		"EC\3\2\2\2F;\3\2\2\2F=\3\2\2\2G\24\3\2\2\2HI\7\61\2\2IJ\7\61\2\2JN\3\2"+
		"\2\2KM\13\2\2\2LK\3\2\2\2MP\3\2\2\2NO\3\2\2\2NL\3\2\2\2OQ\3\2\2\2PN\3"+
		"\2\2\2QT\7\f\2\2RT\t\7\2\2SH\3\2\2\2SR\3\2\2\2TU\3\2\2\2UV\b\13\2\2V\26"+
		"\3\2\2\2\n\2(9=CFNS\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}