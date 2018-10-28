package ru.spb.hse.tukh.hw01;// Generated from /home/igor/AU/3rd course/scala-2018/src/main/antlr4/Exp.g4 by ANTLR 4.7
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExpParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, PLUS=3, MINUS=4, MULT=5, DIVIDE=6, MODULO=7, GREATER=8, 
		LOWER=9, GEQ=10, LEQ=11, EQ=12, NEQ=13, OR=14, AND=15, BOOL_LITERAL=16, 
		LITERAL=17, WS=18;
	public static final int
		RULE_expression = 0;
	public static final String[] ruleNames = {
		"expression"
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

	@Override
	public String getGrammarFileName() { return "Exp.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ExpParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext left;
		public ExpressionContext innerExpression;
		public Token boolLiteral;
		public Token literal;
		public Token operation;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode BOOL_LITERAL() { return getToken(ExpParser.BOOL_LITERAL, 0); }
		public TerminalNode LITERAL() { return getToken(ExpParser.LITERAL, 0); }
		public TerminalNode MULT() { return getToken(ExpParser.MULT, 0); }
		public TerminalNode DIVIDE() { return getToken(ExpParser.DIVIDE, 0); }
		public TerminalNode MODULO() { return getToken(ExpParser.MODULO, 0); }
		public TerminalNode PLUS() { return getToken(ExpParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(ExpParser.MINUS, 0); }
		public TerminalNode GREATER() { return getToken(ExpParser.GREATER, 0); }
		public TerminalNode LOWER() { return getToken(ExpParser.LOWER, 0); }
		public TerminalNode GEQ() { return getToken(ExpParser.GEQ, 0); }
		public TerminalNode LEQ() { return getToken(ExpParser.LEQ, 0); }
		public TerminalNode EQ() { return getToken(ExpParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(ExpParser.NEQ, 0); }
		public TerminalNode AND() { return getToken(ExpParser.AND, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpListener ) ((ExpListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpListener ) ((ExpListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpVisitor ) return ((ExpVisitor<? extends T>)visitor).visitExpression(this);
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
			case T__0:
				{
				setState(3);
				match(T__0);
				setState(4);
				((ExpressionContext)_localctx).innerExpression = expression(0);
				setState(5);
				match(T__1);
				}
				break;
			case BOOL_LITERAL:
				{
				setState(7);
				((ExpressionContext)_localctx).boolLiteral = match(BOOL_LITERAL);
				}
				break;
			case LITERAL:
				{
				setState(8);
				((ExpressionContext)_localctx).literal = match(LITERAL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(48);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(46);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(11);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(14);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case MULT:
							{
							setState(12);
							((ExpressionContext)_localctx).operation = match(MULT);
							}
							break;
						case DIVIDE:
							{
							setState(13);
							((ExpressionContext)_localctx).operation = match(DIVIDE);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(16);
						((ExpressionContext)_localctx).right = expression(9);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(17);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						{
						setState(18);
						((ExpressionContext)_localctx).operation = match(MODULO);
						}
						setState(19);
						((ExpressionContext)_localctx).right = expression(8);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(20);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(23);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case PLUS:
							{
							setState(21);
							((ExpressionContext)_localctx).operation = match(PLUS);
							}
							break;
						case MINUS:
							{
							setState(22);
							((ExpressionContext)_localctx).operation = match(MINUS);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(25);
						((ExpressionContext)_localctx).right = expression(7);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(26);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(31);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case GREATER:
							{
							setState(27);
							((ExpressionContext)_localctx).operation = match(GREATER);
							}
							break;
						case LOWER:
							{
							setState(28);
							((ExpressionContext)_localctx).operation = match(LOWER);
							}
							break;
						case GEQ:
							{
							setState(29);
							((ExpressionContext)_localctx).operation = match(GEQ);
							}
							break;
						case LEQ:
							{
							setState(30);
							((ExpressionContext)_localctx).operation = match(LEQ);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(33);
						((ExpressionContext)_localctx).right = expression(6);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(34);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(37);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case EQ:
							{
							setState(35);
							((ExpressionContext)_localctx).operation = match(EQ);
							}
							break;
						case NEQ:
							{
							setState(36);
							((ExpressionContext)_localctx).operation = match(NEQ);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(39);
						((ExpressionContext)_localctx).right = expression(5);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(40);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(43);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case AND:
							{
							setState(41);
							((ExpressionContext)_localctx).operation = match(AND);
							}
							break;
						case EQ:
							{
							setState(42);
							((ExpressionContext)_localctx).operation = match(EQ);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(45);
						((ExpressionContext)_localctx).right = expression(4);
						}
						break;
					}
					} 
				}
				setState(50);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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
			return precpred(_ctx, 8);
		case 1:
			return precpred(_ctx, 7);
		case 2:
			return precpred(_ctx, 6);
		case 3:
			return precpred(_ctx, 5);
		case 4:
			return precpred(_ctx, 4);
		case 5:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\24\66\4\2\t\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\5\2\f\n\2\3\2\3\2\3\2\5\2\21\n\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\5\2\32\n\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\"\n\2\3\2\3\2"+
		"\3\2\3\2\5\2(\n\2\3\2\3\2\3\2\3\2\5\2.\n\2\3\2\7\2\61\n\2\f\2\16\2\64"+
		"\13\2\3\2\2\3\2\3\2\2\2\2C\2\13\3\2\2\2\4\5\b\2\1\2\5\6\7\3\2\2\6\7\5"+
		"\2\2\2\7\b\7\4\2\2\b\f\3\2\2\2\t\f\7\22\2\2\n\f\7\23\2\2\13\4\3\2\2\2"+
		"\13\t\3\2\2\2\13\n\3\2\2\2\f\62\3\2\2\2\r\20\f\n\2\2\16\21\7\7\2\2\17"+
		"\21\7\b\2\2\20\16\3\2\2\2\20\17\3\2\2\2\21\22\3\2\2\2\22\61\5\2\2\13\23"+
		"\24\f\t\2\2\24\25\7\t\2\2\25\61\5\2\2\n\26\31\f\b\2\2\27\32\7\5\2\2\30"+
		"\32\7\6\2\2\31\27\3\2\2\2\31\30\3\2\2\2\32\33\3\2\2\2\33\61\5\2\2\t\34"+
		"!\f\7\2\2\35\"\7\n\2\2\36\"\7\13\2\2\37\"\7\f\2\2 \"\7\r\2\2!\35\3\2\2"+
		"\2!\36\3\2\2\2!\37\3\2\2\2! \3\2\2\2\"#\3\2\2\2#\61\5\2\2\b$\'\f\6\2\2"+
		"%(\7\16\2\2&(\7\17\2\2\'%\3\2\2\2\'&\3\2\2\2()\3\2\2\2)\61\5\2\2\7*-\f"+
		"\5\2\2+.\7\21\2\2,.\7\16\2\2-+\3\2\2\2-,\3\2\2\2./\3\2\2\2/\61\5\2\2\6"+
		"\60\r\3\2\2\2\60\23\3\2\2\2\60\26\3\2\2\2\60\34\3\2\2\2\60$\3\2\2\2\60"+
		"*\3\2\2\2\61\64\3\2\2\2\62\60\3\2\2\2\62\63\3\2\2\2\63\3\3\2\2\2\64\62"+
		"\3\2\2\2\n\13\20\31!\'-\60\62";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}