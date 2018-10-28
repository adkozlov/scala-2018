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
		RULE_atomDouble = 3, RULE_atomBoolean = 4;
	public static final String[] ruleNames = {
		"eval", "doubleExpression", "booleanExpression", "atomDouble", "atomBoolean"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'*'", "'/'", "'+'", "'-'", "'>='", "'<='", "'=='", "'!='", "'>'", 
		"'<'", "'&&'", "'||'", "'('", "')'"
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
		public String value;
		public DoubleExpressionContext dexp;
		public BooleanExpressionContext bexp;
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
			setState(16);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(10);
				((EvalContext)_localctx).dexp = doubleExpression(0);
				((EvalContext)_localctx).value =  Double.toString(((EvalContext)_localctx).dexp.value);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(13);
				((EvalContext)_localctx).bexp = booleanExpression(0);
				((EvalContext)_localctx).value =  ((EvalContext)_localctx).bexp.value ? "true" : "false";
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
		public double value;
		public DoubleExpressionContext left;
		public AtomDoubleContext atom;
		public AtomDoubleContext righta;
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
			setState(19);
			((DoubleExpressionContext)_localctx).atom = atomDouble();
			((DoubleExpressionContext)_localctx).value =  ((DoubleExpressionContext)_localctx).atom.value;
			}
			_ctx.stop = _input.LT(-1);
			setState(44);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new DoubleExpressionContext(_parentctx, _parentState);
					_localctx.left = _prevctx;
					_localctx.left = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_doubleExpression);
					setState(22);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					((DoubleExpressionContext)_localctx).value =  ((DoubleExpressionContext)_localctx).left.value;
					setState(40);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__0:
						{
						setState(24);
						match(T__0);
						setState(25);
						((DoubleExpressionContext)_localctx).righta = atomDouble();
						_localctx.value *= ((DoubleExpressionContext)_localctx).righta.value;
						}
						break;
					case T__1:
						{
						setState(28);
						match(T__1);
						setState(29);
						((DoubleExpressionContext)_localctx).righta = atomDouble();
						_localctx.value /= ((DoubleExpressionContext)_localctx).righta.value;
						}
						break;
					case T__2:
						{
						setState(32);
						match(T__2);
						setState(33);
						((DoubleExpressionContext)_localctx).right = doubleExpression(0);
						_localctx.value += ((DoubleExpressionContext)_localctx).right.value;
						}
						break;
					case T__3:
						{
						setState(36);
						match(T__3);
						setState(37);
						((DoubleExpressionContext)_localctx).right = doubleExpression(0);
						_localctx.value -= ((DoubleExpressionContext)_localctx).right.value;
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					} 
				}
				setState(46);
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

	public static class BooleanExpressionContext extends ParserRuleContext {
		public boolean value;
		public BooleanExpressionContext left;
		public AtomBooleanContext atom;
		public DoubleExpressionContext leftd;
		public DoubleExpressionContext rightd;
		public BooleanExpressionContext right;
		public AtomBooleanContext atomBoolean() {
			return getRuleContext(AtomBooleanContext.class,0);
		}
		public List<DoubleExpressionContext> doubleExpression() {
			return getRuleContexts(DoubleExpressionContext.class);
		}
		public DoubleExpressionContext doubleExpression(int i) {
			return getRuleContext(DoubleExpressionContext.class,i);
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
			setState(78);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(48);
				((BooleanExpressionContext)_localctx).atom = atomBoolean();
				((BooleanExpressionContext)_localctx).value =  ((BooleanExpressionContext)_localctx).atom.value;
				}
				break;
			case 2:
				{
				setState(51);
				((BooleanExpressionContext)_localctx).leftd = doubleExpression(0);
				setState(76);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__4:
					{
					setState(52);
					match(T__4);
					setState(53);
					((BooleanExpressionContext)_localctx).rightd = doubleExpression(0);
					((BooleanExpressionContext)_localctx).value =  ((BooleanExpressionContext)_localctx).leftd.value >= ((BooleanExpressionContext)_localctx).rightd.value;
					}
					break;
				case T__5:
					{
					setState(56);
					match(T__5);
					setState(57);
					((BooleanExpressionContext)_localctx).rightd = doubleExpression(0);
					((BooleanExpressionContext)_localctx).value =  ((BooleanExpressionContext)_localctx).leftd.value <= ((BooleanExpressionContext)_localctx).rightd.value;
					}
					break;
				case T__6:
					{
					setState(60);
					match(T__6);
					setState(61);
					((BooleanExpressionContext)_localctx).rightd = doubleExpression(0);
					((BooleanExpressionContext)_localctx).value =  ((BooleanExpressionContext)_localctx).leftd.value == ((BooleanExpressionContext)_localctx).rightd.value;
					}
					break;
				case T__7:
					{
					setState(64);
					match(T__7);
					setState(65);
					((BooleanExpressionContext)_localctx).rightd = doubleExpression(0);
					((BooleanExpressionContext)_localctx).value =  ((BooleanExpressionContext)_localctx).leftd.value != ((BooleanExpressionContext)_localctx).rightd.value;
					}
					break;
				case T__8:
					{
					setState(68);
					match(T__8);
					setState(69);
					((BooleanExpressionContext)_localctx).rightd = doubleExpression(0);
					((BooleanExpressionContext)_localctx).value =  ((BooleanExpressionContext)_localctx).leftd.value > ((BooleanExpressionContext)_localctx).rightd.value;
					}
					break;
				case T__9:
					{
					setState(72);
					match(T__9);
					setState(73);
					((BooleanExpressionContext)_localctx).rightd = doubleExpression(0);
					((BooleanExpressionContext)_localctx).value =  ((BooleanExpressionContext)_localctx).leftd.value < ((BooleanExpressionContext)_localctx).rightd.value;
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(103);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(101);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new BooleanExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_booleanExpression);
						setState(80);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(81);
						match(T__10);
						setState(82);
						((BooleanExpressionContext)_localctx).right = booleanExpression(3);
						((BooleanExpressionContext)_localctx).value =  ((BooleanExpressionContext)_localctx).left.value && ((BooleanExpressionContext)_localctx).right.value;
						}
						break;
					case 2:
						{
						_localctx = new BooleanExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_booleanExpression);
						setState(85);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(86);
						match(T__11);
						setState(87);
						((BooleanExpressionContext)_localctx).right = booleanExpression(2);
						((BooleanExpressionContext)_localctx).value =  ((BooleanExpressionContext)_localctx).left.value || ((BooleanExpressionContext)_localctx).right.value;
						}
						break;
					case 3:
						{
						_localctx = new BooleanExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_booleanExpression);
						setState(90);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(99);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case T__6:
							{
							setState(91);
							match(T__6);
							setState(92);
							((BooleanExpressionContext)_localctx).right = booleanExpression(0);
							((BooleanExpressionContext)_localctx).value =  ((BooleanExpressionContext)_localctx).left.value == ((BooleanExpressionContext)_localctx).right.value;
							}
							break;
						case T__7:
							{
							setState(95);
							match(T__7);
							setState(96);
							((BooleanExpressionContext)_localctx).right = booleanExpression(0);
							((BooleanExpressionContext)_localctx).value =  ((BooleanExpressionContext)_localctx).left.value != ((BooleanExpressionContext)_localctx).right.value;
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						break;
					}
					} 
				}
				setState(105);
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

	public static class AtomDoubleContext extends ParserRuleContext {
		public double value;
		public Token n;
		public DoubleExpressionContext exp;
		public TerminalNode NUMBER() { return getToken(CalculatorParser.NUMBER, 0); }
		public DoubleExpressionContext doubleExpression() {
			return getRuleContext(DoubleExpressionContext.class,0);
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
		enterRule(_localctx, 6, RULE_atomDouble);
		try {
			setState(113);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(106);
				((AtomDoubleContext)_localctx).n = match(NUMBER);
				((AtomDoubleContext)_localctx).value =  Double.parseDouble((((AtomDoubleContext)_localctx).n!=null?((AtomDoubleContext)_localctx).n.getText():null));
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 2);
				{
				setState(108);
				match(T__12);
				setState(109);
				((AtomDoubleContext)_localctx).exp = doubleExpression(0);
				setState(110);
				match(T__13);
				((AtomDoubleContext)_localctx).value =  ((AtomDoubleContext)_localctx).exp.value;
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

	public static class AtomBooleanContext extends ParserRuleContext {
		public boolean value;
		public Token b;
		public BooleanExpressionContext exp;
		public TerminalNode BOOLEAN() { return getToken(CalculatorParser.BOOLEAN, 0); }
		public BooleanExpressionContext booleanExpression() {
			return getRuleContext(BooleanExpressionContext.class,0);
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
		enterRule(_localctx, 8, RULE_atomBoolean);
		try {
			setState(122);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOLEAN:
				enterOuterAlt(_localctx, 1);
				{
				setState(115);
				((AtomBooleanContext)_localctx).b = match(BOOLEAN);
				((AtomBooleanContext)_localctx).value =  Boolean.parseBoolean((((AtomBooleanContext)_localctx).b!=null?((AtomBooleanContext)_localctx).b.getText():null));
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 2);
				{
				setState(117);
				match(T__12);
				setState(118);
				((AtomBooleanContext)_localctx).exp = booleanExpression(0);
				setState(119);
				match(T__13);
				((AtomBooleanContext)_localctx).value =  ((AtomBooleanContext)_localctx).exp.value;
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
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean booleanExpression_sempred(BooleanExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		case 2:
			return precpred(_ctx, 1);
		case 3:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\23\177\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\3\2\3\2\3\2\5\2\23\n\2\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\5\3+\n\3\7\3-\n\3\f\3\16\3\60\13\3\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4O\n\4\5\4Q\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4f\n\4\7\4h\n\4\f"+
		"\4\16\4k\13\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5t\n\5\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\5\6}\n\6\3\6\2\4\4\6\7\2\4\6\b\n\2\2\2\u008a\2\22\3\2\2\2\4\24"+
		"\3\2\2\2\6P\3\2\2\2\bs\3\2\2\2\n|\3\2\2\2\f\r\5\4\3\2\r\16\b\2\1\2\16"+
		"\23\3\2\2\2\17\20\5\6\4\2\20\21\b\2\1\2\21\23\3\2\2\2\22\f\3\2\2\2\22"+
		"\17\3\2\2\2\23\3\3\2\2\2\24\25\b\3\1\2\25\26\5\b\5\2\26\27\b\3\1\2\27"+
		".\3\2\2\2\30\31\f\3\2\2\31*\b\3\1\2\32\33\7\3\2\2\33\34\5\b\5\2\34\35"+
		"\b\3\1\2\35+\3\2\2\2\36\37\7\4\2\2\37 \5\b\5\2 !\b\3\1\2!+\3\2\2\2\"#"+
		"\7\5\2\2#$\5\4\3\2$%\b\3\1\2%+\3\2\2\2&\'\7\6\2\2\'(\5\4\3\2()\b\3\1\2"+
		")+\3\2\2\2*\32\3\2\2\2*\36\3\2\2\2*\"\3\2\2\2*&\3\2\2\2+-\3\2\2\2,\30"+
		"\3\2\2\2-\60\3\2\2\2.,\3\2\2\2./\3\2\2\2/\5\3\2\2\2\60.\3\2\2\2\61\62"+
		"\b\4\1\2\62\63\5\n\6\2\63\64\b\4\1\2\64Q\3\2\2\2\65N\5\4\3\2\66\67\7\7"+
		"\2\2\678\5\4\3\289\b\4\1\29O\3\2\2\2:;\7\b\2\2;<\5\4\3\2<=\b\4\1\2=O\3"+
		"\2\2\2>?\7\t\2\2?@\5\4\3\2@A\b\4\1\2AO\3\2\2\2BC\7\n\2\2CD\5\4\3\2DE\b"+
		"\4\1\2EO\3\2\2\2FG\7\13\2\2GH\5\4\3\2HI\b\4\1\2IO\3\2\2\2JK\7\f\2\2KL"+
		"\5\4\3\2LM\b\4\1\2MO\3\2\2\2N\66\3\2\2\2N:\3\2\2\2N>\3\2\2\2NB\3\2\2\2"+
		"NF\3\2\2\2NJ\3\2\2\2OQ\3\2\2\2P\61\3\2\2\2P\65\3\2\2\2Qi\3\2\2\2RS\f\4"+
		"\2\2ST\7\r\2\2TU\5\6\4\5UV\b\4\1\2Vh\3\2\2\2WX\f\3\2\2XY\7\16\2\2YZ\5"+
		"\6\4\4Z[\b\4\1\2[h\3\2\2\2\\e\f\5\2\2]^\7\t\2\2^_\5\6\4\2_`\b\4\1\2`f"+
		"\3\2\2\2ab\7\n\2\2bc\5\6\4\2cd\b\4\1\2df\3\2\2\2e]\3\2\2\2ea\3\2\2\2f"+
		"h\3\2\2\2gR\3\2\2\2gW\3\2\2\2g\\\3\2\2\2hk\3\2\2\2ig\3\2\2\2ij\3\2\2\2"+
		"j\7\3\2\2\2ki\3\2\2\2lm\7\21\2\2mt\b\5\1\2no\7\17\2\2op\5\4\3\2pq\7\20"+
		"\2\2qr\b\5\1\2rt\3\2\2\2sl\3\2\2\2sn\3\2\2\2t\t\3\2\2\2uv\7\22\2\2v}\b"+
		"\6\1\2wx\7\17\2\2xy\5\6\4\2yz\7\20\2\2z{\b\6\1\2{}\3\2\2\2|u\3\2\2\2|"+
		"w\3\2\2\2}\13\3\2\2\2\f\22*.NPegis|";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}