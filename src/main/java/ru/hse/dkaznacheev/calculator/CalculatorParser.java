package ru.hse.dkaznacheev.calculator;

// Generated from /home/dk/scala-2018/src/main/antlr/Calculator.g4 by ANTLR 4.7
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CalculatorParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, Number=3, MUL=4, DIV=5, MOD=6, ADD=7, SUB=8, LT=9, LE=10, 
		GT=11, GE=12, EQ=13, NE=14, AND=15, OR=16, WHITESPACE=17;
	public static final int
		RULE_calculator = 0, RULE_expression = 1;
	public static final String[] ruleNames = {
		"calculator", "expression"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", null, "'*'", "'/'", "'%'", "'+'", "'-'", "'<'", "'<='", 
		"'>'", "'>='", "'=='", "'!='", "'&&'", "'||'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, "Number", "MUL", "DIV", "MOD", "ADD", "SUB", "LT", "LE", 
		"GT", "GE", "EQ", "NE", "AND", "OR", "WHITESPACE"
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
	public String getGrammarFileName() { return "Calculator.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CalculatorParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class CalculatorContext extends ParserRuleContext {
		public ExpressionContext ex;
		public TerminalNode EOF() { return getToken(CalculatorParser.EOF, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CalculatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_calculator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorListener ) ((CalculatorListener)listener).enterCalculator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorListener ) ((CalculatorListener)listener).exitCalculator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorVisitor ) return ((CalculatorVisitor<? extends T>)visitor).visitCalculator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CalculatorContext calculator() throws RecognitionException {
		CalculatorContext _localctx = new CalculatorContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_calculator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4);
			((CalculatorContext)_localctx).ex = expression(0);
			setState(5);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext left;
		public Token unOp;
		public ExpressionContext ex;
		public Token num;
		public Token op;
		public ExpressionContext right;
		public TerminalNode SUB() { return getToken(CalculatorParser.SUB, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Number() { return getToken(CalculatorParser.Number, 0); }
		public TerminalNode MUL() { return getToken(CalculatorParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(CalculatorParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(CalculatorParser.MOD, 0); }
		public TerminalNode ADD() { return getToken(CalculatorParser.ADD, 0); }
		public TerminalNode LT() { return getToken(CalculatorParser.LT, 0); }
		public TerminalNode LE() { return getToken(CalculatorParser.LE, 0); }
		public TerminalNode GT() { return getToken(CalculatorParser.GT, 0); }
		public TerminalNode GE() { return getToken(CalculatorParser.GE, 0); }
		public TerminalNode EQ() { return getToken(CalculatorParser.EQ, 0); }
		public TerminalNode NE() { return getToken(CalculatorParser.NE, 0); }
		public TerminalNode AND() { return getToken(CalculatorParser.AND, 0); }
		public TerminalNode OR() { return getToken(CalculatorParser.OR, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorListener ) ((CalculatorListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorListener ) ((CalculatorListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorVisitor ) return ((CalculatorVisitor<? extends T>)visitor).visitExpression(this);
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
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(15);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SUB:
				{
				setState(8);
				((ExpressionContext)_localctx).unOp = match(SUB);
				setState(9);
				((ExpressionContext)_localctx).ex = expression(9);
				}
				break;
			case T__0:
				{
				setState(10);
				match(T__0);
				setState(11);
				((ExpressionContext)_localctx).ex = expression(0);
				setState(12);
				match(T__1);
				}
				break;
			case Number:
				{
				setState(14);
				((ExpressionContext)_localctx).num = match(Number);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(52);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(50);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(17);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(21);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case MUL:
							{
							setState(18);
							((ExpressionContext)_localctx).op = match(MUL);
							}
							break;
						case DIV:
							{
							setState(19);
							((ExpressionContext)_localctx).op = match(DIV);
							}
							break;
						case MOD:
							{
							setState(20);
							((ExpressionContext)_localctx).op = match(MOD);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(23);
						((ExpressionContext)_localctx).right = expression(9);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(24);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(27);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case ADD:
							{
							setState(25);
							((ExpressionContext)_localctx).op = match(ADD);
							}
							break;
						case SUB:
							{
							setState(26);
							((ExpressionContext)_localctx).op = match(SUB);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(29);
						((ExpressionContext)_localctx).right = expression(8);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(30);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(35);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case LT:
							{
							setState(31);
							((ExpressionContext)_localctx).op = match(LT);
							}
							break;
						case LE:
							{
							setState(32);
							((ExpressionContext)_localctx).op = match(LE);
							}
							break;
						case GT:
							{
							setState(33);
							((ExpressionContext)_localctx).op = match(GT);
							}
							break;
						case GE:
							{
							setState(34);
							((ExpressionContext)_localctx).op = match(GE);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(37);
						((ExpressionContext)_localctx).right = expression(7);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(38);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(41);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case EQ:
							{
							setState(39);
							((ExpressionContext)_localctx).op = match(EQ);
							}
							break;
						case NE:
							{
							setState(40);
							((ExpressionContext)_localctx).op = match(NE);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(43);
						((ExpressionContext)_localctx).right = expression(6);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(44);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(45);
						((ExpressionContext)_localctx).op = match(AND);
						setState(46);
						((ExpressionContext)_localctx).right = expression(5);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(47);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(48);
						((ExpressionContext)_localctx).op = match(OR);
						setState(49);
						((ExpressionContext)_localctx).right = expression(4);
						}
						break;
					}
					} 
				}
				setState(54);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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
		case 1:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\23:\4\2\t\2\4\3\t"+
		"\3\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\22\n\3\3\3\3\3\3\3"+
		"\3\3\5\3\30\n\3\3\3\3\3\3\3\3\3\5\3\36\n\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3"+
		"&\n\3\3\3\3\3\3\3\3\3\5\3,\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3\65\n\3"+
		"\f\3\16\38\13\3\3\3\2\3\4\4\2\4\2\2\2F\2\6\3\2\2\2\4\21\3\2\2\2\6\7\5"+
		"\4\3\2\7\b\7\2\2\3\b\3\3\2\2\2\t\n\b\3\1\2\n\13\7\n\2\2\13\22\5\4\3\13"+
		"\f\r\7\3\2\2\r\16\5\4\3\2\16\17\7\4\2\2\17\22\3\2\2\2\20\22\7\5\2\2\21"+
		"\t\3\2\2\2\21\f\3\2\2\2\21\20\3\2\2\2\22\66\3\2\2\2\23\27\f\n\2\2\24\30"+
		"\7\6\2\2\25\30\7\7\2\2\26\30\7\b\2\2\27\24\3\2\2\2\27\25\3\2\2\2\27\26"+
		"\3\2\2\2\30\31\3\2\2\2\31\65\5\4\3\13\32\35\f\t\2\2\33\36\7\t\2\2\34\36"+
		"\7\n\2\2\35\33\3\2\2\2\35\34\3\2\2\2\36\37\3\2\2\2\37\65\5\4\3\n %\f\b"+
		"\2\2!&\7\13\2\2\"&\7\f\2\2#&\7\r\2\2$&\7\16\2\2%!\3\2\2\2%\"\3\2\2\2%"+
		"#\3\2\2\2%$\3\2\2\2&\'\3\2\2\2\'\65\5\4\3\t(+\f\7\2\2),\7\17\2\2*,\7\20"+
		"\2\2+)\3\2\2\2+*\3\2\2\2,-\3\2\2\2-\65\5\4\3\b./\f\6\2\2/\60\7\21\2\2"+
		"\60\65\5\4\3\7\61\62\f\5\2\2\62\63\7\22\2\2\63\65\5\4\3\6\64\23\3\2\2"+
		"\2\64\32\3\2\2\2\64 \3\2\2\2\64(\3\2\2\2\64.\3\2\2\2\64\61\3\2\2\2\65"+
		"8\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2\67\5\3\2\2\28\66\3\2\2\2\t\21\27"+
		"\35%+\64\66";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}