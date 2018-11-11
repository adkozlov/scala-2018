// Generated from C:/Users/machine/Documents/github/scala-2018/src/main/antlr\Calculator.g4 by ANTLR 4.7
package ru.hse.scala.nedikov.calculator;
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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, NUMBER=15, BOOLEAN=16, 
		WS=17;
	public static final int
		RULE_eval = 0, RULE_doubleExpression = 1, RULE_booleanExpression = 2, 
		RULE_booleanCompare = 3, RULE_atomDouble = 4, RULE_number = 5, RULE_bracedDoubleExpression = 6, 
		RULE_atomBoolean = 7, RULE_bool = 8, RULE_bracedBooleanExpression = 9;
	public static final String[] ruleNames = {
		"eval", "doubleExpression", "booleanExpression", "booleanCompare", "atomDouble", 
		"number", "bracedDoubleExpression", "atomBoolean", "bool", "bracedBooleanExpression"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'*'", "'/'", "'+'", "'-'", "'=='", "'!='", "'&&'", "'||'", "'>='", 
		"'<='", "'>'", "'<'", "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, "NUMBER", "BOOLEAN", "WS"
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
	public static class EvalContext extends ParserRuleContext {
		public DoubleExpressionContext doubleExpression() {
			return getRuleContext(DoubleExpressionContext.class,0);
		}
		public BooleanExpressionContext booleanExpression() {
			return getRuleContext(BooleanExpressionContext.class,0);
		}
		public EvalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eval; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorListener ) ((CalculatorListener)listener).enterEval(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorListener ) ((CalculatorListener)listener).exitEval(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorVisitor ) return ((CalculatorVisitor<? extends T>)visitor).visitEval(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EvalContext eval() throws RecognitionException {
		EvalContext _localctx = new EvalContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_eval);
		try {
			setState(22);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(20);
				doubleExpression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(21);
				booleanExpression(0);
				}
				break;
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

	public static class DoubleExpressionContext extends ParserRuleContext {
		public DoubleExpressionContext left;
		public Token op;
		public DoubleExpressionContext right;
		public AtomDoubleContext atomDouble() {
			return getRuleContext(AtomDoubleContext.class,0);
		}
		public List<DoubleExpressionContext> doubleExpression() {
			return getRuleContexts(DoubleExpressionContext.class);
		}
		public DoubleExpressionContext doubleExpression(int i) {
			return getRuleContext(DoubleExpressionContext.class,i);
		}
		public DoubleExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doubleExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorListener ) ((CalculatorListener)listener).enterDoubleExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorListener ) ((CalculatorListener)listener).exitDoubleExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorVisitor ) return ((CalculatorVisitor<? extends T>)visitor).visitDoubleExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoubleExpressionContext doubleExpression() throws RecognitionException {
		return doubleExpression(0);
	}

	private DoubleExpressionContext doubleExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		DoubleExpressionContext _localctx = new DoubleExpressionContext(_ctx, _parentState);
		DoubleExpressionContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_doubleExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(25);
			atomDouble();
			}
			_ctx.stop = _input.LT(-1);
			setState(41);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(39);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new DoubleExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_doubleExpression);
						setState(27);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(30);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case T__0:
							{
							setState(28);
							((DoubleExpressionContext)_localctx).op = match(T__0);
							}
							break;
						case T__1:
							{
							setState(29);
							((DoubleExpressionContext)_localctx).op = match(T__1);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(32);
						((DoubleExpressionContext)_localctx).right = doubleExpression(3);
						}
						break;
					case 2:
						{
						_localctx = new DoubleExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_doubleExpression);
						setState(33);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(36);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case T__2:
							{
							setState(34);
							((DoubleExpressionContext)_localctx).op = match(T__2);
							}
							break;
						case T__3:
							{
							setState(35);
							((DoubleExpressionContext)_localctx).op = match(T__3);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(38);
						((DoubleExpressionContext)_localctx).right = doubleExpression(2);
						}
						break;
					}
					} 
				}
				setState(43);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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

	public static class BooleanExpressionContext extends ParserRuleContext {
		public BooleanExpressionContext left;
		public Token op;
		public BooleanExpressionContext right;
		public AtomBooleanContext atomBoolean() {
			return getRuleContext(AtomBooleanContext.class,0);
		}
		public BooleanCompareContext booleanCompare() {
			return getRuleContext(BooleanCompareContext.class,0);
		}
		public List<BooleanExpressionContext> booleanExpression() {
			return getRuleContexts(BooleanExpressionContext.class);
		}
		public BooleanExpressionContext booleanExpression(int i) {
			return getRuleContext(BooleanExpressionContext.class,i);
		}
		public BooleanExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorListener ) ((CalculatorListener)listener).enterBooleanExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorListener ) ((CalculatorListener)listener).exitBooleanExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorVisitor ) return ((CalculatorVisitor<? extends T>)visitor).visitBooleanExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanExpressionContext booleanExpression() throws RecognitionException {
		return booleanExpression(0);
	}

	private BooleanExpressionContext booleanExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BooleanExpressionContext _localctx = new BooleanExpressionContext(_ctx, _parentState);
		BooleanExpressionContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_booleanExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(45);
				atomBoolean();
				}
				break;
			case 2:
				{
				setState(46);
				booleanCompare();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(63);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(61);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new BooleanExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_booleanExpression);
						setState(49);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(52);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case T__4:
							{
							setState(50);
							((BooleanExpressionContext)_localctx).op = match(T__4);
							}
							break;
						case T__5:
							{
							setState(51);
							((BooleanExpressionContext)_localctx).op = match(T__5);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(54);
						((BooleanExpressionContext)_localctx).right = booleanExpression(3);
						}
						break;
					case 2:
						{
						_localctx = new BooleanExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_booleanExpression);
						setState(55);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(58);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case T__6:
							{
							setState(56);
							((BooleanExpressionContext)_localctx).op = match(T__6);
							}
							break;
						case T__7:
							{
							setState(57);
							((BooleanExpressionContext)_localctx).op = match(T__7);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(60);
						((BooleanExpressionContext)_localctx).right = booleanExpression(2);
						}
						break;
					}
					} 
				}
				setState(65);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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

	public static class BooleanCompareContext extends ParserRuleContext {
		public DoubleExpressionContext left;
		public Token op;
		public DoubleExpressionContext right;
		public List<DoubleExpressionContext> doubleExpression() {
			return getRuleContexts(DoubleExpressionContext.class);
		}
		public DoubleExpressionContext doubleExpression(int i) {
			return getRuleContext(DoubleExpressionContext.class,i);
		}
		public BooleanCompareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanCompare; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorListener ) ((CalculatorListener)listener).enterBooleanCompare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorListener ) ((CalculatorListener)listener).exitBooleanCompare(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorVisitor ) return ((CalculatorVisitor<? extends T>)visitor).visitBooleanCompare(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanCompareContext booleanCompare() throws RecognitionException {
		BooleanCompareContext _localctx = new BooleanCompareContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_booleanCompare);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			((BooleanCompareContext)_localctx).left = doubleExpression(0);
			setState(73);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
				{
				setState(67);
				((BooleanCompareContext)_localctx).op = match(T__8);
				}
				break;
			case T__9:
				{
				setState(68);
				((BooleanCompareContext)_localctx).op = match(T__9);
				}
				break;
			case T__4:
				{
				setState(69);
				((BooleanCompareContext)_localctx).op = match(T__4);
				}
				break;
			case T__5:
				{
				setState(70);
				((BooleanCompareContext)_localctx).op = match(T__5);
				}
				break;
			case T__10:
				{
				setState(71);
				((BooleanCompareContext)_localctx).op = match(T__10);
				}
				break;
			case T__11:
				{
				setState(72);
				((BooleanCompareContext)_localctx).op = match(T__11);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(75);
			((BooleanCompareContext)_localctx).right = doubleExpression(0);
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

	public static class AtomDoubleContext extends ParserRuleContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public BracedDoubleExpressionContext bracedDoubleExpression() {
			return getRuleContext(BracedDoubleExpressionContext.class,0);
		}
		public AtomDoubleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomDouble; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorListener ) ((CalculatorListener)listener).enterAtomDouble(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorListener ) ((CalculatorListener)listener).exitAtomDouble(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorVisitor ) return ((CalculatorVisitor<? extends T>)visitor).visitAtomDouble(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomDoubleContext atomDouble() throws RecognitionException {
		AtomDoubleContext _localctx = new AtomDoubleContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_atomDouble);
		try {
			setState(79);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				number();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 2);
				{
				setState(78);
				bracedDoubleExpression();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class NumberContext extends ParserRuleContext {
		public Token n;
		public TerminalNode NUMBER() { return getToken(CalculatorParser.NUMBER, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorListener ) ((CalculatorListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorListener ) ((CalculatorListener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorVisitor ) return ((CalculatorVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_number);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			((NumberContext)_localctx).n = match(NUMBER);
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

	public static class BracedDoubleExpressionContext extends ParserRuleContext {
		public DoubleExpressionContext exp;
		public DoubleExpressionContext doubleExpression() {
			return getRuleContext(DoubleExpressionContext.class,0);
		}
		public BracedDoubleExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bracedDoubleExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorListener ) ((CalculatorListener)listener).enterBracedDoubleExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorListener ) ((CalculatorListener)listener).exitBracedDoubleExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorVisitor ) return ((CalculatorVisitor<? extends T>)visitor).visitBracedDoubleExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BracedDoubleExpressionContext bracedDoubleExpression() throws RecognitionException {
		BracedDoubleExpressionContext _localctx = new BracedDoubleExpressionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_bracedDoubleExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(T__12);
			setState(84);
			((BracedDoubleExpressionContext)_localctx).exp = doubleExpression(0);
			setState(85);
			match(T__13);
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

	public static class AtomBooleanContext extends ParserRuleContext {
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public BracedBooleanExpressionContext bracedBooleanExpression() {
			return getRuleContext(BracedBooleanExpressionContext.class,0);
		}
		public AtomBooleanContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomBoolean; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorListener ) ((CalculatorListener)listener).enterAtomBoolean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorListener ) ((CalculatorListener)listener).exitAtomBoolean(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorVisitor ) return ((CalculatorVisitor<? extends T>)visitor).visitAtomBoolean(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomBooleanContext atomBoolean() throws RecognitionException {
		AtomBooleanContext _localctx = new AtomBooleanContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_atomBoolean);
		try {
			setState(89);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOLEAN:
				enterOuterAlt(_localctx, 1);
				{
				setState(87);
				bool();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 2);
				{
				setState(88);
				bracedBooleanExpression();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class BoolContext extends ParserRuleContext {
		public Token b;
		public TerminalNode BOOLEAN() { return getToken(CalculatorParser.BOOLEAN, 0); }
		public BoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorListener ) ((CalculatorListener)listener).enterBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorListener ) ((CalculatorListener)listener).exitBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorVisitor ) return ((CalculatorVisitor<? extends T>)visitor).visitBool(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolContext bool() throws RecognitionException {
		BoolContext _localctx = new BoolContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_bool);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			((BoolContext)_localctx).b = match(BOOLEAN);
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

	public static class BracedBooleanExpressionContext extends ParserRuleContext {
		public BooleanExpressionContext exp;
		public BooleanExpressionContext booleanExpression() {
			return getRuleContext(BooleanExpressionContext.class,0);
		}
		public BracedBooleanExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bracedBooleanExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorListener ) ((CalculatorListener)listener).enterBracedBooleanExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculatorListener ) ((CalculatorListener)listener).exitBracedBooleanExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorVisitor ) return ((CalculatorVisitor<? extends T>)visitor).visitBracedBooleanExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BracedBooleanExpressionContext bracedBooleanExpression() throws RecognitionException {
		BracedBooleanExpressionContext _localctx = new BracedBooleanExpressionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_bracedBooleanExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(T__12);
			setState(94);
			((BracedBooleanExpressionContext)_localctx).exp = booleanExpression(0);
			setState(95);
			match(T__13);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return doubleExpression_sempred((DoubleExpressionContext)_localctx, predIndex);
		case 2:
			return booleanExpression_sempred((BooleanExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean doubleExpression_sempred(DoubleExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean booleanExpression_sempred(BooleanExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 2);
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\23d\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\3"+
		"\2\3\2\5\2\31\n\2\3\3\3\3\3\3\3\3\3\3\3\3\5\3!\n\3\3\3\3\3\3\3\3\3\5\3"+
		"\'\n\3\3\3\7\3*\n\3\f\3\16\3-\13\3\3\4\3\4\3\4\5\4\62\n\4\3\4\3\4\3\4"+
		"\5\4\67\n\4\3\4\3\4\3\4\3\4\5\4=\n\4\3\4\7\4@\n\4\f\4\16\4C\13\4\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\5\5L\n\5\3\5\3\5\3\6\3\6\5\6R\n\6\3\7\3\7\3\b\3"+
		"\b\3\b\3\b\3\t\3\t\5\t\\\n\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\2\4\4\6"+
		"\f\2\4\6\b\n\f\16\20\22\24\2\2\2j\2\30\3\2\2\2\4\32\3\2\2\2\6\61\3\2\2"+
		"\2\bD\3\2\2\2\nQ\3\2\2\2\fS\3\2\2\2\16U\3\2\2\2\20[\3\2\2\2\22]\3\2\2"+
		"\2\24_\3\2\2\2\26\31\5\4\3\2\27\31\5\6\4\2\30\26\3\2\2\2\30\27\3\2\2\2"+
		"\31\3\3\2\2\2\32\33\b\3\1\2\33\34\5\n\6\2\34+\3\2\2\2\35 \f\4\2\2\36!"+
		"\7\3\2\2\37!\7\4\2\2 \36\3\2\2\2 \37\3\2\2\2!\"\3\2\2\2\"*\5\4\3\5#&\f"+
		"\3\2\2$\'\7\5\2\2%\'\7\6\2\2&$\3\2\2\2&%\3\2\2\2\'(\3\2\2\2(*\5\4\3\4"+
		")\35\3\2\2\2)#\3\2\2\2*-\3\2\2\2+)\3\2\2\2+,\3\2\2\2,\5\3\2\2\2-+\3\2"+
		"\2\2./\b\4\1\2/\62\5\20\t\2\60\62\5\b\5\2\61.\3\2\2\2\61\60\3\2\2\2\62"+
		"A\3\2\2\2\63\66\f\4\2\2\64\67\7\7\2\2\65\67\7\b\2\2\66\64\3\2\2\2\66\65"+
		"\3\2\2\2\678\3\2\2\28@\5\6\4\59<\f\3\2\2:=\7\t\2\2;=\7\n\2\2<:\3\2\2\2"+
		"<;\3\2\2\2=>\3\2\2\2>@\5\6\4\4?\63\3\2\2\2?9\3\2\2\2@C\3\2\2\2A?\3\2\2"+
		"\2AB\3\2\2\2B\7\3\2\2\2CA\3\2\2\2DK\5\4\3\2EL\7\13\2\2FL\7\f\2\2GL\7\7"+
		"\2\2HL\7\b\2\2IL\7\r\2\2JL\7\16\2\2KE\3\2\2\2KF\3\2\2\2KG\3\2\2\2KH\3"+
		"\2\2\2KI\3\2\2\2KJ\3\2\2\2LM\3\2\2\2MN\5\4\3\2N\t\3\2\2\2OR\5\f\7\2PR"+
		"\5\16\b\2QO\3\2\2\2QP\3\2\2\2R\13\3\2\2\2ST\7\21\2\2T\r\3\2\2\2UV\7\17"+
		"\2\2VW\5\4\3\2WX\7\20\2\2X\17\3\2\2\2Y\\\5\22\n\2Z\\\5\24\13\2[Y\3\2\2"+
		"\2[Z\3\2\2\2\\\21\3\2\2\2]^\7\22\2\2^\23\3\2\2\2_`\7\17\2\2`a\5\6\4\2"+
		"ab\7\20\2\2b\25\3\2\2\2\17\30 &)+\61\66<?AKQ[";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}