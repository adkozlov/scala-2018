// Generated from /Users/vladislavkalinin/IdeaProjects/scala-2018/src/main/antlr4/Calculator.g4 by ANTLR 4.7
package antlr;
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
		INT=1, BOOL=2, NOT=3, MINUS=4, PLUS=5, POW=6, MULT=7, DIV=8, MOD=9, EQC=10, 
		NEQ=11, LT=12, GT=13, LE=14, GE=15, AND=16, XOR=17, OR=18, RPAREN=19, 
		LPAREN=20, WS=21;
	public static final int
		RULE_calculator = 0, RULE_logic_expr = 1, RULE_arithm_expr = 2, RULE_arithm_prior1 = 3, 
		RULE_arithm_prior2 = 4, RULE_exponent_op = 5, RULE_compare_op = 6, RULE_logic_op = 7;
	public static final String[] ruleNames = {
		"calculator", "logic_expr", "arithm_expr", "arithm_prior1", "arithm_prior2", 
		"exponent_op", "compare_op", "logic_op"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, "'!'", "'-'", "'+'", "'^'", "'*'", "'/'", "'%'", "'=='", 
		"'!='", "'<'", "'>'", "'<='", "'>='", "'&&'", "'^^'", "'||'", "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "INT", "BOOL", "NOT", "MINUS", "PLUS", "POW", "MULT", "DIV", "MOD", 
		"EQC", "NEQ", "LT", "GT", "LE", "GE", "AND", "XOR", "OR", "RPAREN", "LPAREN", 
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
		public Logic_exprContext logic_expr() {
			return getRuleContext(Logic_exprContext.class,0);
		}
		public Arithm_exprContext arithm_expr() {
			return getRuleContext(Arithm_exprContext.class,0);
		}
		public CalculatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_calculator; }
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
			setState(18);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(16);
				logic_expr(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(17);
				arithm_expr(0);
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

	public static class Logic_exprContext extends ParserRuleContext {
		public Logic_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logic_expr; }
	 
		public Logic_exprContext() { }
		public void copyFrom(Logic_exprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LogicalCompareExprContext extends Logic_exprContext {
		public Arithm_exprContext lvalue;
		public Compare_opContext op;
		public Arithm_exprContext rvalue;
		public List<Arithm_exprContext> arithm_expr() {
			return getRuleContexts(Arithm_exprContext.class);
		}
		public Arithm_exprContext arithm_expr(int i) {
			return getRuleContext(Arithm_exprContext.class,i);
		}
		public Compare_opContext compare_op() {
			return getRuleContext(Compare_opContext.class,0);
		}
		public LogicalCompareExprContext(Logic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorVisitor ) return ((CalculatorVisitor<? extends T>)visitor).visitLogicalCompareExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LogicalBinaryExprContext extends Logic_exprContext {
		public Logic_exprContext lvalue;
		public Logic_opContext op;
		public Logic_exprContext rvalue;
		public List<Logic_exprContext> logic_expr() {
			return getRuleContexts(Logic_exprContext.class);
		}
		public Logic_exprContext logic_expr(int i) {
			return getRuleContext(Logic_exprContext.class,i);
		}
		public Logic_opContext logic_op() {
			return getRuleContext(Logic_opContext.class,0);
		}
		public LogicalBinaryExprContext(Logic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorVisitor ) return ((CalculatorVisitor<? extends T>)visitor).visitLogicalBinaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LogicalParensExprContext extends Logic_exprContext {
		public TerminalNode RPAREN() { return getToken(CalculatorParser.RPAREN, 0); }
		public Logic_exprContext logic_expr() {
			return getRuleContext(Logic_exprContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(CalculatorParser.LPAREN, 0); }
		public TerminalNode NOT() { return getToken(CalculatorParser.NOT, 0); }
		public LogicalParensExprContext(Logic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorVisitor ) return ((CalculatorVisitor<? extends T>)visitor).visitLogicalParensExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LogicalAtomExprContext extends Logic_exprContext {
		public TerminalNode BOOL() { return getToken(CalculatorParser.BOOL, 0); }
		public TerminalNode NOT() { return getToken(CalculatorParser.NOT, 0); }
		public LogicalAtomExprContext(Logic_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorVisitor ) return ((CalculatorVisitor<? extends T>)visitor).visitLogicalAtomExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Logic_exprContext logic_expr() throws RecognitionException {
		return logic_expr(0);
	}

	private Logic_exprContext logic_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Logic_exprContext _localctx = new Logic_exprContext(_ctx, _parentState);
		Logic_exprContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_logic_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				_localctx = new LogicalCompareExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(21);
				((LogicalCompareExprContext)_localctx).lvalue = arithm_expr(0);
				setState(22);
				((LogicalCompareExprContext)_localctx).op = compare_op();
				setState(23);
				((LogicalCompareExprContext)_localctx).rvalue = arithm_expr(0);
				}
				break;
			case 2:
				{
				_localctx = new LogicalParensExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(26);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(25);
					match(NOT);
					}
				}

				setState(28);
				match(RPAREN);
				setState(29);
				logic_expr(0);
				setState(30);
				match(LPAREN);
				}
				break;
			case 3:
				{
				_localctx = new LogicalAtomExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(33);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(32);
					match(NOT);
					}
				}

				setState(35);
				match(BOOL);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(44);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LogicalBinaryExprContext(new Logic_exprContext(_parentctx, _parentState));
					((LogicalBinaryExprContext)_localctx).lvalue = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_logic_expr);
					setState(38);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(39);
					((LogicalBinaryExprContext)_localctx).op = logic_op();
					setState(40);
					((LogicalBinaryExprContext)_localctx).rvalue = logic_expr(4);
					}
					} 
				}
				setState(46);
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

	public static class Arithm_exprContext extends ParserRuleContext {
		public Arithm_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithm_expr; }
	 
		public Arithm_exprContext() { }
		public void copyFrom(Arithm_exprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ArithmeticParensExprContext extends Arithm_exprContext {
		public TerminalNode RPAREN() { return getToken(CalculatorParser.RPAREN, 0); }
		public Arithm_exprContext arithm_expr() {
			return getRuleContext(Arithm_exprContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(CalculatorParser.LPAREN, 0); }
		public TerminalNode MINUS() { return getToken(CalculatorParser.MINUS, 0); }
		public ArithmeticParensExprContext(Arithm_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorVisitor ) return ((CalculatorVisitor<? extends T>)visitor).visitArithmeticParensExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArithmeticExponentExprContext extends Arithm_exprContext {
		public Arithm_exprContext value;
		public Exponent_opContext op;
		public Arithm_exprContext degree;
		public List<Arithm_exprContext> arithm_expr() {
			return getRuleContexts(Arithm_exprContext.class);
		}
		public Arithm_exprContext arithm_expr(int i) {
			return getRuleContext(Arithm_exprContext.class,i);
		}
		public Exponent_opContext exponent_op() {
			return getRuleContext(Exponent_opContext.class,0);
		}
		public ArithmeticExponentExprContext(Arithm_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorVisitor ) return ((CalculatorVisitor<? extends T>)visitor).visitArithmeticExponentExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArithmeticPrior2BinaryExprContext extends Arithm_exprContext {
		public Arithm_exprContext lvalue;
		public Arithm_prior2Context op;
		public Arithm_exprContext rvalue;
		public List<Arithm_exprContext> arithm_expr() {
			return getRuleContexts(Arithm_exprContext.class);
		}
		public Arithm_exprContext arithm_expr(int i) {
			return getRuleContext(Arithm_exprContext.class,i);
		}
		public Arithm_prior2Context arithm_prior2() {
			return getRuleContext(Arithm_prior2Context.class,0);
		}
		public ArithmeticPrior2BinaryExprContext(Arithm_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorVisitor ) return ((CalculatorVisitor<? extends T>)visitor).visitArithmeticPrior2BinaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArithmeticAtomExprContext extends Arithm_exprContext {
		public TerminalNode INT() { return getToken(CalculatorParser.INT, 0); }
		public TerminalNode MINUS() { return getToken(CalculatorParser.MINUS, 0); }
		public ArithmeticAtomExprContext(Arithm_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorVisitor ) return ((CalculatorVisitor<? extends T>)visitor).visitArithmeticAtomExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArithmeticPrior1BinaryExprContext extends Arithm_exprContext {
		public Arithm_exprContext lvalue;
		public Arithm_prior1Context op;
		public Arithm_exprContext rvalue;
		public List<Arithm_exprContext> arithm_expr() {
			return getRuleContexts(Arithm_exprContext.class);
		}
		public Arithm_exprContext arithm_expr(int i) {
			return getRuleContext(Arithm_exprContext.class,i);
		}
		public Arithm_prior1Context arithm_prior1() {
			return getRuleContext(Arithm_prior1Context.class,0);
		}
		public ArithmeticPrior1BinaryExprContext(Arithm_exprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorVisitor ) return ((CalculatorVisitor<? extends T>)visitor).visitArithmeticPrior1BinaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Arithm_exprContext arithm_expr() throws RecognitionException {
		return arithm_expr(0);
	}

	private Arithm_exprContext arithm_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Arithm_exprContext _localctx = new Arithm_exprContext(_ctx, _parentState);
		Arithm_exprContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_arithm_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				_localctx = new ArithmeticParensExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(48);
					match(MINUS);
					}
				}

				setState(51);
				match(RPAREN);
				setState(52);
				arithm_expr(0);
				setState(53);
				match(LPAREN);
				}
				break;
			case 2:
				{
				_localctx = new ArithmeticAtomExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(55);
					match(MINUS);
					}
				}

				setState(58);
				match(INT);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(75);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(73);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new ArithmeticExponentExprContext(new Arithm_exprContext(_parentctx, _parentState));
						((ArithmeticExponentExprContext)_localctx).value = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_arithm_expr);
						setState(61);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(62);
						((ArithmeticExponentExprContext)_localctx).op = exponent_op();
						setState(63);
						((ArithmeticExponentExprContext)_localctx).degree = arithm_expr(6);
						}
						break;
					case 2:
						{
						_localctx = new ArithmeticPrior1BinaryExprContext(new Arithm_exprContext(_parentctx, _parentState));
						((ArithmeticPrior1BinaryExprContext)_localctx).lvalue = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_arithm_expr);
						setState(65);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(66);
						((ArithmeticPrior1BinaryExprContext)_localctx).op = arithm_prior1();
						setState(67);
						((ArithmeticPrior1BinaryExprContext)_localctx).rvalue = arithm_expr(5);
						}
						break;
					case 3:
						{
						_localctx = new ArithmeticPrior2BinaryExprContext(new Arithm_exprContext(_parentctx, _parentState));
						((ArithmeticPrior2BinaryExprContext)_localctx).lvalue = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_arithm_expr);
						setState(69);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(70);
						((ArithmeticPrior2BinaryExprContext)_localctx).op = arithm_prior2();
						setState(71);
						((ArithmeticPrior2BinaryExprContext)_localctx).rvalue = arithm_expr(4);
						}
						break;
					}
					} 
				}
				setState(77);
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

	public static class Arithm_prior1Context extends ParserRuleContext {
		public TerminalNode MULT() { return getToken(CalculatorParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(CalculatorParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(CalculatorParser.MOD, 0); }
		public Arithm_prior1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithm_prior1; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorVisitor ) return ((CalculatorVisitor<? extends T>)visitor).visitArithm_prior1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Arithm_prior1Context arithm_prior1() throws RecognitionException {
		Arithm_prior1Context _localctx = new Arithm_prior1Context(_ctx, getState());
		enterRule(_localctx, 6, RULE_arithm_prior1);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULT) | (1L << DIV) | (1L << MOD))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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

	public static class Arithm_prior2Context extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(CalculatorParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(CalculatorParser.MINUS, 0); }
		public Arithm_prior2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithm_prior2; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorVisitor ) return ((CalculatorVisitor<? extends T>)visitor).visitArithm_prior2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Arithm_prior2Context arithm_prior2() throws RecognitionException {
		Arithm_prior2Context _localctx = new Arithm_prior2Context(_ctx, getState());
		enterRule(_localctx, 8, RULE_arithm_prior2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			_la = _input.LA(1);
			if ( !(_la==MINUS || _la==PLUS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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

	public static class Exponent_opContext extends ParserRuleContext {
		public TerminalNode POW() { return getToken(CalculatorParser.POW, 0); }
		public Exponent_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exponent_op; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorVisitor ) return ((CalculatorVisitor<? extends T>)visitor).visitExponent_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Exponent_opContext exponent_op() throws RecognitionException {
		Exponent_opContext _localctx = new Exponent_opContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_exponent_op);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(POW);
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

	public static class Compare_opContext extends ParserRuleContext {
		public TerminalNode EQC() { return getToken(CalculatorParser.EQC, 0); }
		public TerminalNode NEQ() { return getToken(CalculatorParser.NEQ, 0); }
		public TerminalNode LT() { return getToken(CalculatorParser.LT, 0); }
		public TerminalNode GT() { return getToken(CalculatorParser.GT, 0); }
		public TerminalNode LE() { return getToken(CalculatorParser.LE, 0); }
		public TerminalNode GE() { return getToken(CalculatorParser.GE, 0); }
		public Compare_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compare_op; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorVisitor ) return ((CalculatorVisitor<? extends T>)visitor).visitCompare_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Compare_opContext compare_op() throws RecognitionException {
		Compare_opContext _localctx = new Compare_opContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_compare_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQC) | (1L << NEQ) | (1L << LT) | (1L << GT) | (1L << LE) | (1L << GE))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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

	public static class Logic_opContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(CalculatorParser.AND, 0); }
		public TerminalNode OR() { return getToken(CalculatorParser.OR, 0); }
		public TerminalNode XOR() { return getToken(CalculatorParser.XOR, 0); }
		public Logic_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logic_op; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculatorVisitor ) return ((CalculatorVisitor<? extends T>)visitor).visitLogic_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Logic_opContext logic_op() throws RecognitionException {
		Logic_opContext _localctx = new Logic_opContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_logic_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << XOR) | (1L << OR))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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
			return logic_expr_sempred((Logic_exprContext)_localctx, predIndex);
		case 2:
			return arithm_expr_sempred((Arithm_exprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean logic_expr_sempred(Logic_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean arithm_expr_sempred(Arithm_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		case 3:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\27[\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\5\2\25\n\2"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\5\3\35\n\3\3\3\3\3\3\3\3\3\3\3\5\3$\n\3\3\3\5"+
		"\3\'\n\3\3\3\3\3\3\3\3\3\7\3-\n\3\f\3\16\3\60\13\3\3\4\3\4\5\4\64\n\4"+
		"\3\4\3\4\3\4\3\4\3\4\5\4;\n\4\3\4\5\4>\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\7\4L\n\4\f\4\16\4O\13\4\3\5\3\5\3\6\3\6\3\7\3\7\3"+
		"\b\3\b\3\t\3\t\3\t\2\4\4\6\n\2\4\6\b\n\f\16\20\2\6\3\2\t\13\3\2\6\7\3"+
		"\2\f\21\3\2\22\24\2^\2\24\3\2\2\2\4&\3\2\2\2\6=\3\2\2\2\bP\3\2\2\2\nR"+
		"\3\2\2\2\fT\3\2\2\2\16V\3\2\2\2\20X\3\2\2\2\22\25\5\4\3\2\23\25\5\6\4"+
		"\2\24\22\3\2\2\2\24\23\3\2\2\2\25\3\3\2\2\2\26\27\b\3\1\2\27\30\5\6\4"+
		"\2\30\31\5\16\b\2\31\32\5\6\4\2\32\'\3\2\2\2\33\35\7\5\2\2\34\33\3\2\2"+
		"\2\34\35\3\2\2\2\35\36\3\2\2\2\36\37\7\25\2\2\37 \5\4\3\2 !\7\26\2\2!"+
		"\'\3\2\2\2\"$\7\5\2\2#\"\3\2\2\2#$\3\2\2\2$%\3\2\2\2%\'\7\4\2\2&\26\3"+
		"\2\2\2&\34\3\2\2\2&#\3\2\2\2\'.\3\2\2\2()\f\5\2\2)*\5\20\t\2*+\5\4\3\6"+
		"+-\3\2\2\2,(\3\2\2\2-\60\3\2\2\2.,\3\2\2\2./\3\2\2\2/\5\3\2\2\2\60.\3"+
		"\2\2\2\61\63\b\4\1\2\62\64\7\6\2\2\63\62\3\2\2\2\63\64\3\2\2\2\64\65\3"+
		"\2\2\2\65\66\7\25\2\2\66\67\5\6\4\2\678\7\26\2\28>\3\2\2\29;\7\6\2\2:"+
		"9\3\2\2\2:;\3\2\2\2;<\3\2\2\2<>\7\3\2\2=\61\3\2\2\2=:\3\2\2\2>M\3\2\2"+
		"\2?@\f\7\2\2@A\5\f\7\2AB\5\6\4\bBL\3\2\2\2CD\f\6\2\2DE\5\b\5\2EF\5\6\4"+
		"\7FL\3\2\2\2GH\f\5\2\2HI\5\n\6\2IJ\5\6\4\6JL\3\2\2\2K?\3\2\2\2KC\3\2\2"+
		"\2KG\3\2\2\2LO\3\2\2\2MK\3\2\2\2MN\3\2\2\2N\7\3\2\2\2OM\3\2\2\2PQ\t\2"+
		"\2\2Q\t\3\2\2\2RS\t\3\2\2S\13\3\2\2\2TU\7\b\2\2U\r\3\2\2\2VW\t\4\2\2W"+
		"\17\3\2\2\2XY\t\5\2\2Y\21\3\2\2\2\f\24\34#&.\63:=KM";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}