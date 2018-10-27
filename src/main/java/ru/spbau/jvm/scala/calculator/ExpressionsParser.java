// Generated from /Users/alexvangogen/Fall/scala-course/hw/scala-2018/src/main/resources/ru.spbau.jvm.scala.calculator/Expressions.g4 by ANTLR 4.7
package ru.spbau.jvm.scala.calculator;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExpressionsParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, LPAREN=2, RPAREN=3, DOT=4, PLUS=5, MINUS=6, MULT=7, DIV=8, LT=9, 
		LEQ=10, GT=11, GEQ=12, EQ=13, NEQ=14, AND=15, OR=16, XOR=17, NOT=18, NUMBER=19, 
		BOOL=20, MismatchedSymbol=21;
	public static final int
		RULE_expression = 0, RULE_logicalExpression = 1, RULE_arithmeticExpression = 2;
	public static final String[] ruleNames = {
		"expression", "logicalExpression", "arithmeticExpression"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, "'('", "')'", "'.'", "'+'", "'-'", "'*'", "'/'", "'<'", "'<='", 
		"'>'", "'>='", "'=='", "'!='", "'&&'", "'||'", "'^'", "'!'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "WS", "LPAREN", "RPAREN", "DOT", "PLUS", "MINUS", "MULT", "DIV", 
		"LT", "LEQ", "GT", "GEQ", "EQ", "NEQ", "AND", "OR", "XOR", "NOT", "NUMBER", 
		"BOOL", "MismatchedSymbol"
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
	public String getGrammarFileName() { return "Expressions.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ExpressionsParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ExpressionContext extends ParserRuleContext {
		public LogicalExpressionContext logicalExpression() {
			return getRuleContext(LogicalExpressionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(ExpressionsParser.EOF, 0); }
		public ArithmeticExpressionContext arithmeticExpression() {
			return getRuleContext(ArithmeticExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionsVisitor ) return ((ExpressionsVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_expression);
		try {
			setState(12);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(6);
				logicalExpression(0);
				setState(7);
				match(EOF);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(9);
				arithmeticExpression(0);
				setState(10);
				match(EOF);
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

	public static class LogicalExpressionContext extends ParserRuleContext {
		public LogicalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalExpression; }
	 
		public LogicalExpressionContext() { }
		public void copyFrom(LogicalExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NotContext extends LogicalExpressionContext {
		public Token op;
		public LogicalExpressionContext operand;
		public TerminalNode NOT() { return getToken(ExpressionsParser.NOT, 0); }
		public LogicalExpressionContext logicalExpression() {
			return getRuleContext(LogicalExpressionContext.class,0);
		}
		public NotContext(LogicalExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionsVisitor ) return ((ExpressionsVisitor<? extends T>)visitor).visitNot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrContext extends LogicalExpressionContext {
		public LogicalExpressionContext left;
		public Token op;
		public LogicalExpressionContext right;
		public List<LogicalExpressionContext> logicalExpression() {
			return getRuleContexts(LogicalExpressionContext.class);
		}
		public LogicalExpressionContext logicalExpression(int i) {
			return getRuleContext(LogicalExpressionContext.class,i);
		}
		public TerminalNode OR() { return getToken(ExpressionsParser.OR, 0); }
		public OrContext(LogicalExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionsVisitor ) return ((ExpressionsVisitor<? extends T>)visitor).visitOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolContext extends LogicalExpressionContext {
		public TerminalNode BOOL() { return getToken(ExpressionsParser.BOOL, 0); }
		public BoolContext(LogicalExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionsVisitor ) return ((ExpressionsVisitor<? extends T>)visitor).visitBool(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndContext extends LogicalExpressionContext {
		public LogicalExpressionContext left;
		public Token op;
		public LogicalExpressionContext right;
		public List<LogicalExpressionContext> logicalExpression() {
			return getRuleContexts(LogicalExpressionContext.class);
		}
		public LogicalExpressionContext logicalExpression(int i) {
			return getRuleContext(LogicalExpressionContext.class,i);
		}
		public TerminalNode AND() { return getToken(ExpressionsParser.AND, 0); }
		public AndContext(LogicalExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionsVisitor ) return ((ExpressionsVisitor<? extends T>)visitor).visitAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NestedLogicalContext extends LogicalExpressionContext {
		public LogicalExpressionContext nested;
		public TerminalNode LPAREN() { return getToken(ExpressionsParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ExpressionsParser.RPAREN, 0); }
		public LogicalExpressionContext logicalExpression() {
			return getRuleContext(LogicalExpressionContext.class,0);
		}
		public NestedLogicalContext(LogicalExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionsVisitor ) return ((ExpressionsVisitor<? extends T>)visitor).visitNestedLogical(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XorContext extends LogicalExpressionContext {
		public LogicalExpressionContext left;
		public Token op;
		public LogicalExpressionContext right;
		public List<LogicalExpressionContext> logicalExpression() {
			return getRuleContexts(LogicalExpressionContext.class);
		}
		public LogicalExpressionContext logicalExpression(int i) {
			return getRuleContext(LogicalExpressionContext.class,i);
		}
		public TerminalNode XOR() { return getToken(ExpressionsParser.XOR, 0); }
		public XorContext(LogicalExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionsVisitor ) return ((ExpressionsVisitor<? extends T>)visitor).visitXor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqLogicalContext extends LogicalExpressionContext {
		public LogicalExpressionContext left;
		public Token op;
		public LogicalExpressionContext right;
		public List<LogicalExpressionContext> logicalExpression() {
			return getRuleContexts(LogicalExpressionContext.class);
		}
		public LogicalExpressionContext logicalExpression(int i) {
			return getRuleContext(LogicalExpressionContext.class,i);
		}
		public TerminalNode EQ() { return getToken(ExpressionsParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(ExpressionsParser.NEQ, 0); }
		public EqLogicalContext(LogicalExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionsVisitor ) return ((ExpressionsVisitor<? extends T>)visitor).visitEqLogical(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CompContext extends LogicalExpressionContext {
		public ArithmeticExpressionContext left;
		public Token op;
		public ArithmeticExpressionContext right;
		public List<ArithmeticExpressionContext> arithmeticExpression() {
			return getRuleContexts(ArithmeticExpressionContext.class);
		}
		public ArithmeticExpressionContext arithmeticExpression(int i) {
			return getRuleContext(ArithmeticExpressionContext.class,i);
		}
		public TerminalNode LT() { return getToken(ExpressionsParser.LT, 0); }
		public TerminalNode LEQ() { return getToken(ExpressionsParser.LEQ, 0); }
		public TerminalNode GT() { return getToken(ExpressionsParser.GT, 0); }
		public TerminalNode GEQ() { return getToken(ExpressionsParser.GEQ, 0); }
		public CompContext(LogicalExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionsVisitor ) return ((ExpressionsVisitor<? extends T>)visitor).visitComp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqArithmeticContext extends LogicalExpressionContext {
		public ArithmeticExpressionContext left;
		public Token op;
		public ArithmeticExpressionContext right;
		public List<ArithmeticExpressionContext> arithmeticExpression() {
			return getRuleContexts(ArithmeticExpressionContext.class);
		}
		public ArithmeticExpressionContext arithmeticExpression(int i) {
			return getRuleContext(ArithmeticExpressionContext.class,i);
		}
		public TerminalNode EQ() { return getToken(ExpressionsParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(ExpressionsParser.NEQ, 0); }
		public EqArithmeticContext(LogicalExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionsVisitor ) return ((ExpressionsVisitor<? extends T>)visitor).visitEqArithmetic(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalExpressionContext logicalExpression() throws RecognitionException {
		return logicalExpression(0);
	}

	private LogicalExpressionContext logicalExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LogicalExpressionContext _localctx = new LogicalExpressionContext(_ctx, _parentState);
		LogicalExpressionContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_logicalExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				_localctx = new NestedLogicalContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(15);
				match(LPAREN);
				setState(16);
				((NestedLogicalContext)_localctx).nested = logicalExpression(0);
				setState(17);
				match(RPAREN);
				}
				break;
			case 2:
				{
				_localctx = new CompContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(19);
				((CompContext)_localctx).left = arithmeticExpression(0);
				setState(20);
				((CompContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LT) | (1L << LEQ) | (1L << GT) | (1L << GEQ))) != 0)) ) {
					((CompContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(21);
				((CompContext)_localctx).right = arithmeticExpression(0);
				}
				break;
			case 3:
				{
				_localctx = new EqArithmeticContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(23);
				((EqArithmeticContext)_localctx).left = arithmeticExpression(0);
				setState(24);
				((EqArithmeticContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==EQ || _la==NEQ) ) {
					((EqArithmeticContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(25);
				((EqArithmeticContext)_localctx).right = arithmeticExpression(0);
				}
				break;
			case 4:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(27);
				((NotContext)_localctx).op = match(NOT);
				setState(28);
				((NotContext)_localctx).operand = logicalExpression(2);
				}
				break;
			case 5:
				{
				_localctx = new BoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(29);
				match(BOOL);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(46);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(44);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						_localctx = new AndContext(new LogicalExpressionContext(_parentctx, _parentState));
						((AndContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_logicalExpression);
						setState(32);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(33);
						((AndContext)_localctx).op = match(AND);
						setState(34);
						((AndContext)_localctx).right = logicalExpression(9);
						}
						break;
					case 2:
						{
						_localctx = new XorContext(new LogicalExpressionContext(_parentctx, _parentState));
						((XorContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_logicalExpression);
						setState(35);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(36);
						((XorContext)_localctx).op = match(XOR);
						setState(37);
						((XorContext)_localctx).right = logicalExpression(8);
						}
						break;
					case 3:
						{
						_localctx = new OrContext(new LogicalExpressionContext(_parentctx, _parentState));
						((OrContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_logicalExpression);
						setState(38);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(39);
						((OrContext)_localctx).op = match(OR);
						setState(40);
						((OrContext)_localctx).right = logicalExpression(7);
						}
						break;
					case 4:
						{
						_localctx = new EqLogicalContext(new LogicalExpressionContext(_parentctx, _parentState));
						((EqLogicalContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_logicalExpression);
						setState(41);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(42);
						((EqLogicalContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQ || _la==NEQ) ) {
							((EqLogicalContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(43);
						((EqLogicalContext)_localctx).right = logicalExpression(6);
						}
						break;
					}
					} 
				}
				setState(48);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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

	public static class ArithmeticExpressionContext extends ParserRuleContext {
		public ArithmeticExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmeticExpression; }
	 
		public ArithmeticExpressionContext() { }
		public void copyFrom(ArithmeticExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AddContext extends ArithmeticExpressionContext {
		public ArithmeticExpressionContext left;
		public Token op;
		public ArithmeticExpressionContext right;
		public List<ArithmeticExpressionContext> arithmeticExpression() {
			return getRuleContexts(ArithmeticExpressionContext.class);
		}
		public ArithmeticExpressionContext arithmeticExpression(int i) {
			return getRuleContext(ArithmeticExpressionContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(ExpressionsParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(ExpressionsParser.MINUS, 0); }
		public AddContext(ArithmeticExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionsVisitor ) return ((ExpressionsVisitor<? extends T>)visitor).visitAdd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumberContext extends ArithmeticExpressionContext {
		public TerminalNode NUMBER() { return getToken(ExpressionsParser.NUMBER, 0); }
		public NumberContext(ArithmeticExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionsVisitor ) return ((ExpressionsVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultContext extends ArithmeticExpressionContext {
		public ArithmeticExpressionContext left;
		public Token op;
		public ArithmeticExpressionContext right;
		public List<ArithmeticExpressionContext> arithmeticExpression() {
			return getRuleContexts(ArithmeticExpressionContext.class);
		}
		public ArithmeticExpressionContext arithmeticExpression(int i) {
			return getRuleContext(ArithmeticExpressionContext.class,i);
		}
		public TerminalNode MULT() { return getToken(ExpressionsParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(ExpressionsParser.DIV, 0); }
		public MultContext(ArithmeticExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionsVisitor ) return ((ExpressionsVisitor<? extends T>)visitor).visitMult(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NestedArithmeticContext extends ArithmeticExpressionContext {
		public ArithmeticExpressionContext nested;
		public TerminalNode LPAREN() { return getToken(ExpressionsParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ExpressionsParser.RPAREN, 0); }
		public ArithmeticExpressionContext arithmeticExpression() {
			return getRuleContext(ArithmeticExpressionContext.class,0);
		}
		public NestedArithmeticContext(ArithmeticExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionsVisitor ) return ((ExpressionsVisitor<? extends T>)visitor).visitNestedArithmetic(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryContext extends ArithmeticExpressionContext {
		public Token op;
		public ArithmeticExpressionContext operand;
		public ArithmeticExpressionContext arithmeticExpression() {
			return getRuleContext(ArithmeticExpressionContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(ExpressionsParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(ExpressionsParser.MINUS, 0); }
		public UnaryContext(ArithmeticExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionsVisitor ) return ((ExpressionsVisitor<? extends T>)visitor).visitUnary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithmeticExpressionContext arithmeticExpression() throws RecognitionException {
		return arithmeticExpression(0);
	}

	private ArithmeticExpressionContext arithmeticExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ArithmeticExpressionContext _localctx = new ArithmeticExpressionContext(_ctx, _parentState);
		ArithmeticExpressionContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_arithmeticExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				{
				_localctx = new NestedArithmeticContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(50);
				match(LPAREN);
				setState(51);
				((NestedArithmeticContext)_localctx).nested = arithmeticExpression(0);
				setState(52);
				match(RPAREN);
				}
				break;
			case PLUS:
			case MINUS:
				{
				_localctx = new UnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(54);
				((UnaryContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
					((UnaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(55);
				((UnaryContext)_localctx).operand = arithmeticExpression(4);
				}
				break;
			case NUMBER:
				{
				_localctx = new NumberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(56);
				match(NUMBER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(67);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(65);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new MultContext(new ArithmeticExpressionContext(_parentctx, _parentState));
						((MultContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_arithmeticExpression);
						setState(59);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(60);
						((MultContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MULT || _la==DIV) ) {
							((MultContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(61);
						((MultContext)_localctx).right = arithmeticExpression(4);
						}
						break;
					case 2:
						{
						_localctx = new AddContext(new ArithmeticExpressionContext(_parentctx, _parentState));
						((AddContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_arithmeticExpression);
						setState(62);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(63);
						((AddContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((AddContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(64);
						((AddContext)_localctx).right = arithmeticExpression(3);
						}
						break;
					}
					} 
				}
				setState(69);
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
			return logicalExpression_sempred((LogicalExpressionContext)_localctx, predIndex);
		case 2:
			return arithmeticExpression_sempred((ArithmeticExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean logicalExpression_sempred(LogicalExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 8);
		case 1:
			return precpred(_ctx, 7);
		case 2:
			return precpred(_ctx, 6);
		case 3:
			return precpred(_ctx, 5);
		}
		return true;
	}
	private boolean arithmeticExpression_sempred(ArithmeticExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 3);
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\27I\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\3\2\3\2\3\2\3\2\3\2\3\2\5\2\17\n\2\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3!\n\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3/\n\3\f\3\16\3\62\13\3\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\5\4<\n\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4D\n\4\f\4\16\4G\13"+
		"\4\3\4\2\4\4\6\5\2\4\6\2\6\3\2\13\16\3\2\17\20\3\2\7\b\3\2\t\n\2R\2\16"+
		"\3\2\2\2\4 \3\2\2\2\6;\3\2\2\2\b\t\5\4\3\2\t\n\7\2\2\3\n\17\3\2\2\2\13"+
		"\f\5\6\4\2\f\r\7\2\2\3\r\17\3\2\2\2\16\b\3\2\2\2\16\13\3\2\2\2\17\3\3"+
		"\2\2\2\20\21\b\3\1\2\21\22\7\4\2\2\22\23\5\4\3\2\23\24\7\5\2\2\24!\3\2"+
		"\2\2\25\26\5\6\4\2\26\27\t\2\2\2\27\30\5\6\4\2\30!\3\2\2\2\31\32\5\6\4"+
		"\2\32\33\t\3\2\2\33\34\5\6\4\2\34!\3\2\2\2\35\36\7\24\2\2\36!\5\4\3\4"+
		"\37!\7\26\2\2 \20\3\2\2\2 \25\3\2\2\2 \31\3\2\2\2 \35\3\2\2\2 \37\3\2"+
		"\2\2!\60\3\2\2\2\"#\f\n\2\2#$\7\21\2\2$/\5\4\3\13%&\f\t\2\2&\'\7\23\2"+
		"\2\'/\5\4\3\n()\f\b\2\2)*\7\22\2\2*/\5\4\3\t+,\f\7\2\2,-\t\3\2\2-/\5\4"+
		"\3\b.\"\3\2\2\2.%\3\2\2\2.(\3\2\2\2.+\3\2\2\2/\62\3\2\2\2\60.\3\2\2\2"+
		"\60\61\3\2\2\2\61\5\3\2\2\2\62\60\3\2\2\2\63\64\b\4\1\2\64\65\7\4\2\2"+
		"\65\66\5\6\4\2\66\67\7\5\2\2\67<\3\2\2\289\t\4\2\29<\5\6\4\6:<\7\25\2"+
		"\2;\63\3\2\2\2;8\3\2\2\2;:\3\2\2\2<E\3\2\2\2=>\f\5\2\2>?\t\5\2\2?D\5\6"+
		"\4\6@A\f\4\2\2AB\t\4\2\2BD\5\6\4\5C=\3\2\2\2C@\3\2\2\2DG\3\2\2\2EC\3\2"+
		"\2\2EF\3\2\2\2F\7\3\2\2\2GE\3\2\2\2\t\16 .\60;CE";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}