// Generated from /home/annikura/HSE/JVM/scala-2018/src/main/antlr/Expression.g4 by ANTLR 4.7
package ru.hse.expression;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExpressionParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, OPERATOR1=3, OPERATOR2=4, OPERATOR3=5, OPERATOR4=6, OPERATOR5=7, 
		OPERATOR6=8, MUL=9, DIV=10, MOD=11, PLUS=12, MINUS=13, LESS_THAN=14, GREATER_THAN=15, 
		LE=16, GE=17, EQ=18, NEQ=19, AND=20, OR=21, NUMBER=22, BOOLEAN=23, WS=24;
	public static final int
		RULE_expression = 0;
	public static final String[] ruleNames = {
		"expression"
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

	@Override
	public String getGrammarFileName() { return "Expression.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ExpressionParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext left;
		public Token num;
		public Token bool;
		public ExpressionContext innerExpression;
		public Token op;
		public ExpressionContext right;
		public TerminalNode NUMBER() { return getToken(ExpressionParser.NUMBER, 0); }
		public TerminalNode BOOLEAN() { return getToken(ExpressionParser.BOOLEAN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode OPERATOR1() { return getToken(ExpressionParser.OPERATOR1, 0); }
		public TerminalNode OPERATOR2() { return getToken(ExpressionParser.OPERATOR2, 0); }
		public TerminalNode OPERATOR3() { return getToken(ExpressionParser.OPERATOR3, 0); }
		public TerminalNode OPERATOR4() { return getToken(ExpressionParser.OPERATOR4, 0); }
		public TerminalNode OPERATOR5() { return getToken(ExpressionParser.OPERATOR5, 0); }
		public TerminalNode OPERATOR6() { return getToken(ExpressionParser.OPERATOR6, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 0;
		enterRecursionRule(_localctx, 0, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(9);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				{
				setState(3);
				((ExpressionContext)_localctx).num = match(NUMBER);
				}
				break;
			case BOOLEAN:
				{
				setState(4);
				((ExpressionContext)_localctx).bool = match(BOOLEAN);
				}
				break;
			case T__0:
				{
				setState(5);
				match(T__0);
				setState(6);
				((ExpressionContext)_localctx).innerExpression = expression(0);
				setState(7);
				match(T__1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(31);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(29);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(11);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(12);
						((ExpressionContext)_localctx).op = match(OPERATOR1);
						setState(13);
						((ExpressionContext)_localctx).right = expression(7);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(14);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(15);
						((ExpressionContext)_localctx).op = match(OPERATOR2);
						setState(16);
						((ExpressionContext)_localctx).right = expression(6);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(17);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(18);
						((ExpressionContext)_localctx).op = match(OPERATOR3);
						setState(19);
						((ExpressionContext)_localctx).right = expression(5);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(20);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(21);
						((ExpressionContext)_localctx).op = match(OPERATOR4);
						setState(22);
						((ExpressionContext)_localctx).right = expression(4);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(23);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(24);
						((ExpressionContext)_localctx).op = match(OPERATOR5);
						setState(25);
						((ExpressionContext)_localctx).right = expression(3);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(26);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(27);
						((ExpressionContext)_localctx).op = match(OPERATOR6);
						setState(28);
						((ExpressionContext)_localctx).right = expression(2);
						}
						break;
					}
					} 
				}
				setState(33);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 0:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		case 3:
			return precpred(_ctx, 3);
		case 4:
			return precpred(_ctx, 2);
		case 5:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\32%\4\2\t\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\5\2\f\n\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2 \n\2\f\2\16\2#\13\2\3\2\2\3\2\3"+
		"\2\2\2\2+\2\13\3\2\2\2\4\5\b\2\1\2\5\f\7\30\2\2\6\f\7\31\2\2\7\b\7\3\2"+
		"\2\b\t\5\2\2\2\t\n\7\4\2\2\n\f\3\2\2\2\13\4\3\2\2\2\13\6\3\2\2\2\13\7"+
		"\3\2\2\2\f!\3\2\2\2\r\16\f\b\2\2\16\17\7\5\2\2\17 \5\2\2\t\20\21\f\7\2"+
		"\2\21\22\7\6\2\2\22 \5\2\2\b\23\24\f\6\2\2\24\25\7\7\2\2\25 \5\2\2\7\26"+
		"\27\f\5\2\2\27\30\7\b\2\2\30 \5\2\2\6\31\32\f\4\2\2\32\33\7\t\2\2\33 "+
		"\5\2\2\5\34\35\f\3\2\2\35\36\7\n\2\2\36 \5\2\2\4\37\r\3\2\2\2\37\20\3"+
		"\2\2\2\37\23\3\2\2\2\37\26\3\2\2\2\37\31\3\2\2\2\37\34\3\2\2\2 #\3\2\2"+
		"\2!\37\3\2\2\2!\"\3\2\2\2\"\3\3\2\2\2#!\3\2\2\2\5\13\37!";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}