// Generated from /home/aleks/Documents/edu/scala-2018/src/main/antlr/NotFunAtAllParser.g4 by ANTLR 4.7
package org.ifmo.grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class NotFunAtAllParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SKIP_=1, PLUS=2, MINUS=3, ASTERISK=4, DIVISION=5, MOD=6, EQUAL=7, NOTEQUAL=8, 
		GREATER=9, GREQUAL=10, LESS=11, LEQUAL=12, AND=13, OR=14, LPAREN=15, RPAREN=16, 
		INT_NUM=17, TRUE=18, FALSE=19;
	public static final int
		RULE_bool_literal = 0, RULE_logical_expr = 1, RULE_atom = 2, RULE_logical_op = 3, 
		RULE_compare_op = 4, RULE_plumin = 5, RULE_divast = 6, RULE_arithm_expr = 7, 
		RULE_binary_expr = 8;
	public static final String[] ruleNames = {
		"bool_literal", "logical_expr", "atom", "logical_op", "compare_op", "plumin", 
		"divast", "arithm_expr", "binary_expr"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, "'+'", "'-'", "'*'", "'/'", "'%'", "'=='", "'!='", "'>'", 
		"'>='", "'<'", "'<='", "'&&'", "'||'", "'('", "')'", null, "'true'", "'false'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "SKIP_", "PLUS", "MINUS", "ASTERISK", "DIVISION", "MOD", "EQUAL", 
		"NOTEQUAL", "GREATER", "GREQUAL", "LESS", "LEQUAL", "AND", "OR", "LPAREN", 
		"RPAREN", "INT_NUM", "TRUE", "FALSE"
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
	public String getGrammarFileName() { return "NotFunAtAllParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public NotFunAtAllParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class Bool_literalContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(NotFunAtAllParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(NotFunAtAllParser.FALSE, 0); }
		public Bool_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NotFunAtAllParserListener ) ((NotFunAtAllParserListener)listener).enterBool_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NotFunAtAllParserListener ) ((NotFunAtAllParserListener)listener).exitBool_literal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NotFunAtAllParserVisitor ) return ((NotFunAtAllParserVisitor<? extends T>)visitor).visitBool_literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bool_literalContext bool_literal() throws RecognitionException {
		Bool_literalContext _localctx = new Bool_literalContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_bool_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
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

	public static class Logical_exprContext extends ParserRuleContext {
		public Logical_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logical_expr; }
	 
		public Logical_exprContext() { }
		public void copyFrom(Logical_exprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LogicalCompareExprContext extends Logical_exprContext {
		public Arithm_exprContext left;
		public Compare_opContext op;
		public Arithm_exprContext right;
		public List<Arithm_exprContext> arithm_expr() {
			return getRuleContexts(Arithm_exprContext.class);
		}
		public Arithm_exprContext arithm_expr(int i) {
			return getRuleContext(Arithm_exprContext.class,i);
		}
		public Compare_opContext compare_op() {
			return getRuleContext(Compare_opContext.class,0);
		}
		public LogicalCompareExprContext(Logical_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NotFunAtAllParserListener ) ((NotFunAtAllParserListener)listener).enterLogicalCompareExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NotFunAtAllParserListener ) ((NotFunAtAllParserListener)listener).exitLogicalCompareExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NotFunAtAllParserVisitor ) return ((NotFunAtAllParserVisitor<? extends T>)visitor).visitLogicalCompareExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LogicalBinaryExprContext extends Logical_exprContext {
		public Logical_exprContext left;
		public Logical_opContext op;
		public Logical_exprContext right;
		public List<Logical_exprContext> logical_expr() {
			return getRuleContexts(Logical_exprContext.class);
		}
		public Logical_exprContext logical_expr(int i) {
			return getRuleContext(Logical_exprContext.class,i);
		}
		public Logical_opContext logical_op() {
			return getRuleContext(Logical_opContext.class,0);
		}
		public LogicalBinaryExprContext(Logical_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NotFunAtAllParserListener ) ((NotFunAtAllParserListener)listener).enterLogicalBinaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NotFunAtAllParserListener ) ((NotFunAtAllParserListener)listener).exitLogicalBinaryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NotFunAtAllParserVisitor ) return ((NotFunAtAllParserVisitor<? extends T>)visitor).visitLogicalBinaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LogicalParensExprContext extends Logical_exprContext {
		public TerminalNode LPAREN() { return getToken(NotFunAtAllParser.LPAREN, 0); }
		public Logical_exprContext logical_expr() {
			return getRuleContext(Logical_exprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(NotFunAtAllParser.RPAREN, 0); }
		public LogicalParensExprContext(Logical_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NotFunAtAllParserListener ) ((NotFunAtAllParserListener)listener).enterLogicalParensExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NotFunAtAllParserListener ) ((NotFunAtAllParserListener)listener).exitLogicalParensExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NotFunAtAllParserVisitor ) return ((NotFunAtAllParserVisitor<? extends T>)visitor).visitLogicalParensExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LogicalAtomExprContext extends Logical_exprContext {
		public Bool_literalContext bool_literal() {
			return getRuleContext(Bool_literalContext.class,0);
		}
		public LogicalAtomExprContext(Logical_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NotFunAtAllParserListener ) ((NotFunAtAllParserListener)listener).enterLogicalAtomExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NotFunAtAllParserListener ) ((NotFunAtAllParserListener)listener).exitLogicalAtomExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NotFunAtAllParserVisitor ) return ((NotFunAtAllParserVisitor<? extends T>)visitor).visitLogicalAtomExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Logical_exprContext logical_expr() throws RecognitionException {
		return logical_expr(0);
	}

	private Logical_exprContext logical_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Logical_exprContext _localctx = new Logical_exprContext(_ctx, _parentState);
		Logical_exprContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_logical_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				_localctx = new LogicalCompareExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(21);
				((LogicalCompareExprContext)_localctx).left = arithm_expr(0);
				setState(22);
				((LogicalCompareExprContext)_localctx).op = compare_op();
				setState(23);
				((LogicalCompareExprContext)_localctx).right = arithm_expr(0);
				}
				break;
			case 2:
				{
				_localctx = new LogicalParensExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(25);
				match(LPAREN);
				setState(26);
				logical_expr(0);
				setState(27);
				match(RPAREN);
				}
				break;
			case 3:
				{
				_localctx = new LogicalAtomExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(29);
				bool_literal();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(38);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LogicalBinaryExprContext(new Logical_exprContext(_parentctx, _parentState));
					((LogicalBinaryExprContext)_localctx).left = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_logical_expr);
					setState(32);
					if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
					setState(33);
					((LogicalBinaryExprContext)_localctx).op = logical_op();
					setState(34);
					((LogicalBinaryExprContext)_localctx).right = logical_expr(5);
					}
					} 
				}
				setState(40);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
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

	public static class AtomContext extends ParserRuleContext {
		public TerminalNode INT_NUM() { return getToken(NotFunAtAllParser.INT_NUM, 0); }
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NotFunAtAllParserListener ) ((NotFunAtAllParserListener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NotFunAtAllParserListener ) ((NotFunAtAllParserListener)listener).exitAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NotFunAtAllParserVisitor ) return ((NotFunAtAllParserVisitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_atom);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			match(INT_NUM);
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

	public static class Logical_opContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(NotFunAtAllParser.AND, 0); }
		public TerminalNode OR() { return getToken(NotFunAtAllParser.OR, 0); }
		public Logical_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logical_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NotFunAtAllParserListener ) ((NotFunAtAllParserListener)listener).enterLogical_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NotFunAtAllParserListener ) ((NotFunAtAllParserListener)listener).exitLogical_op(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NotFunAtAllParserVisitor ) return ((NotFunAtAllParserVisitor<? extends T>)visitor).visitLogical_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Logical_opContext logical_op() throws RecognitionException {
		Logical_opContext _localctx = new Logical_opContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_logical_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			_la = _input.LA(1);
			if ( !(_la==AND || _la==OR) ) {
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

	public static class Compare_opContext extends ParserRuleContext {
		public TerminalNode EQUAL() { return getToken(NotFunAtAllParser.EQUAL, 0); }
		public TerminalNode NOTEQUAL() { return getToken(NotFunAtAllParser.NOTEQUAL, 0); }
		public TerminalNode GREATER() { return getToken(NotFunAtAllParser.GREATER, 0); }
		public TerminalNode GREQUAL() { return getToken(NotFunAtAllParser.GREQUAL, 0); }
		public TerminalNode LESS() { return getToken(NotFunAtAllParser.LESS, 0); }
		public TerminalNode LEQUAL() { return getToken(NotFunAtAllParser.LEQUAL, 0); }
		public Compare_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compare_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NotFunAtAllParserListener ) ((NotFunAtAllParserListener)listener).enterCompare_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NotFunAtAllParserListener ) ((NotFunAtAllParserListener)listener).exitCompare_op(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NotFunAtAllParserVisitor ) return ((NotFunAtAllParserVisitor<? extends T>)visitor).visitCompare_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Compare_opContext compare_op() throws RecognitionException {
		Compare_opContext _localctx = new Compare_opContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_compare_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQUAL) | (1L << NOTEQUAL) | (1L << GREATER) | (1L << GREQUAL) | (1L << LESS) | (1L << LEQUAL))) != 0)) ) {
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

	public static class PluminContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(NotFunAtAllParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(NotFunAtAllParser.MINUS, 0); }
		public PluminContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plumin; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NotFunAtAllParserListener ) ((NotFunAtAllParserListener)listener).enterPlumin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NotFunAtAllParserListener ) ((NotFunAtAllParserListener)listener).exitPlumin(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NotFunAtAllParserVisitor ) return ((NotFunAtAllParserVisitor<? extends T>)visitor).visitPlumin(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PluminContext plumin() throws RecognitionException {
		PluminContext _localctx = new PluminContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_plumin);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			_la = _input.LA(1);
			if ( !(_la==PLUS || _la==MINUS) ) {
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

	public static class DivastContext extends ParserRuleContext {
		public TerminalNode DIVISION() { return getToken(NotFunAtAllParser.DIVISION, 0); }
		public TerminalNode ASTERISK() { return getToken(NotFunAtAllParser.ASTERISK, 0); }
		public DivastContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_divast; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NotFunAtAllParserListener ) ((NotFunAtAllParserListener)listener).enterDivast(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NotFunAtAllParserListener ) ((NotFunAtAllParserListener)listener).exitDivast(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NotFunAtAllParserVisitor ) return ((NotFunAtAllParserVisitor<? extends T>)visitor).visitDivast(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DivastContext divast() throws RecognitionException {
		DivastContext _localctx = new DivastContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_divast);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			_la = _input.LA(1);
			if ( !(_la==ASTERISK || _la==DIVISION) ) {
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
		public TerminalNode LPAREN() { return getToken(NotFunAtAllParser.LPAREN, 0); }
		public Arithm_exprContext arithm_expr() {
			return getRuleContext(Arithm_exprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(NotFunAtAllParser.RPAREN, 0); }
		public ArithmeticParensExprContext(Arithm_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NotFunAtAllParserListener ) ((NotFunAtAllParserListener)listener).enterArithmeticParensExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NotFunAtAllParserListener ) ((NotFunAtAllParserListener)listener).exitArithmeticParensExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NotFunAtAllParserVisitor ) return ((NotFunAtAllParserVisitor<? extends T>)visitor).visitArithmeticParensExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArithmeticDABinaryExprContext extends Arithm_exprContext {
		public Arithm_exprContext left;
		public DivastContext op;
		public Arithm_exprContext right;
		public List<Arithm_exprContext> arithm_expr() {
			return getRuleContexts(Arithm_exprContext.class);
		}
		public Arithm_exprContext arithm_expr(int i) {
			return getRuleContext(Arithm_exprContext.class,i);
		}
		public DivastContext divast() {
			return getRuleContext(DivastContext.class,0);
		}
		public ArithmeticDABinaryExprContext(Arithm_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NotFunAtAllParserListener ) ((NotFunAtAllParserListener)listener).enterArithmeticDABinaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NotFunAtAllParserListener ) ((NotFunAtAllParserListener)listener).exitArithmeticDABinaryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NotFunAtAllParserVisitor ) return ((NotFunAtAllParserVisitor<? extends T>)visitor).visitArithmeticDABinaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArithmeticPMBinaryExprContext extends Arithm_exprContext {
		public Arithm_exprContext left;
		public PluminContext op;
		public Arithm_exprContext right;
		public List<Arithm_exprContext> arithm_expr() {
			return getRuleContexts(Arithm_exprContext.class);
		}
		public Arithm_exprContext arithm_expr(int i) {
			return getRuleContext(Arithm_exprContext.class,i);
		}
		public PluminContext plumin() {
			return getRuleContext(PluminContext.class,0);
		}
		public ArithmeticPMBinaryExprContext(Arithm_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NotFunAtAllParserListener ) ((NotFunAtAllParserListener)listener).enterArithmeticPMBinaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NotFunAtAllParserListener ) ((NotFunAtAllParserListener)listener).exitArithmeticPMBinaryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NotFunAtAllParserVisitor ) return ((NotFunAtAllParserVisitor<? extends T>)visitor).visitArithmeticPMBinaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArithmeticAtomExprContext extends Arithm_exprContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public ArithmeticAtomExprContext(Arithm_exprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NotFunAtAllParserListener ) ((NotFunAtAllParserListener)listener).enterArithmeticAtomExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NotFunAtAllParserListener ) ((NotFunAtAllParserListener)listener).exitArithmeticAtomExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NotFunAtAllParserVisitor ) return ((NotFunAtAllParserVisitor<? extends T>)visitor).visitArithmeticAtomExpr(this);
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
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_arithm_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				{
				_localctx = new ArithmeticParensExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(52);
				match(LPAREN);
				setState(53);
				arithm_expr(0);
				setState(54);
				match(RPAREN);
				}
				break;
			case INT_NUM:
				{
				_localctx = new ArithmeticAtomExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(56);
				atom();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(69);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(67);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new ArithmeticDABinaryExprContext(new Arithm_exprContext(_parentctx, _parentState));
						((ArithmeticDABinaryExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_arithm_expr);
						setState(59);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(60);
						((ArithmeticDABinaryExprContext)_localctx).op = divast();
						setState(61);
						((ArithmeticDABinaryExprContext)_localctx).right = arithm_expr(5);
						}
						break;
					case 2:
						{
						_localctx = new ArithmeticPMBinaryExprContext(new Arithm_exprContext(_parentctx, _parentState));
						((ArithmeticPMBinaryExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_arithm_expr);
						setState(63);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(64);
						((ArithmeticPMBinaryExprContext)_localctx).op = plumin();
						setState(65);
						((ArithmeticPMBinaryExprContext)_localctx).right = arithm_expr(4);
						}
						break;
					}
					} 
				}
				setState(71);
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

	public static class Binary_exprContext extends ParserRuleContext {
		public Logical_exprContext logical_expr() {
			return getRuleContext(Logical_exprContext.class,0);
		}
		public Arithm_exprContext arithm_expr() {
			return getRuleContext(Arithm_exprContext.class,0);
		}
		public Binary_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NotFunAtAllParserListener ) ((NotFunAtAllParserListener)listener).enterBinary_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NotFunAtAllParserListener ) ((NotFunAtAllParserListener)listener).exitBinary_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NotFunAtAllParserVisitor ) return ((NotFunAtAllParserVisitor<? extends T>)visitor).visitBinary_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Binary_exprContext binary_expr() throws RecognitionException {
		Binary_exprContext _localctx = new Binary_exprContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_binary_expr);
		try {
			setState(74);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(72);
				logical_expr(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(73);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return logical_expr_sempred((Logical_exprContext)_localctx, predIndex);
		case 7:
			return arithm_expr_sempred((Arithm_exprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean logical_expr_sempred(Logical_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		}
		return true;
	}
	private boolean arithm_expr_sempred(Arithm_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 4);
		case 2:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\25O\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3!\n\3\3\3\3\3\3\3\3\3\7\3\'\n"+
		"\3\f\3\16\3*\13\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\5\t<\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\tF\n\t\f\t\16"+
		"\tI\13\t\3\n\3\n\5\nM\n\n\3\n\2\4\4\20\13\2\4\6\b\n\f\16\20\22\2\7\3\2"+
		"\24\25\3\2\17\20\3\2\t\16\3\2\4\5\3\2\6\7\2L\2\24\3\2\2\2\4 \3\2\2\2\6"+
		"+\3\2\2\2\b-\3\2\2\2\n/\3\2\2\2\f\61\3\2\2\2\16\63\3\2\2\2\20;\3\2\2\2"+
		"\22L\3\2\2\2\24\25\t\2\2\2\25\3\3\2\2\2\26\27\b\3\1\2\27\30\5\20\t\2\30"+
		"\31\5\n\6\2\31\32\5\20\t\2\32!\3\2\2\2\33\34\7\21\2\2\34\35\5\4\3\2\35"+
		"\36\7\22\2\2\36!\3\2\2\2\37!\5\2\2\2 \26\3\2\2\2 \33\3\2\2\2 \37\3\2\2"+
		"\2!(\3\2\2\2\"#\f\6\2\2#$\5\b\5\2$%\5\4\3\7%\'\3\2\2\2&\"\3\2\2\2\'*\3"+
		"\2\2\2(&\3\2\2\2()\3\2\2\2)\5\3\2\2\2*(\3\2\2\2+,\7\23\2\2,\7\3\2\2\2"+
		"-.\t\3\2\2.\t\3\2\2\2/\60\t\4\2\2\60\13\3\2\2\2\61\62\t\5\2\2\62\r\3\2"+
		"\2\2\63\64\t\6\2\2\64\17\3\2\2\2\65\66\b\t\1\2\66\67\7\21\2\2\678\5\20"+
		"\t\289\7\22\2\29<\3\2\2\2:<\5\6\4\2;\65\3\2\2\2;:\3\2\2\2<G\3\2\2\2=>"+
		"\f\6\2\2>?\5\16\b\2?@\5\20\t\7@F\3\2\2\2AB\f\5\2\2BC\5\f\7\2CD\5\20\t"+
		"\6DF\3\2\2\2E=\3\2\2\2EA\3\2\2\2FI\3\2\2\2GE\3\2\2\2GH\3\2\2\2H\21\3\2"+
		"\2\2IG\3\2\2\2JM\5\4\3\2KM\5\20\t\2LJ\3\2\2\2LK\3\2\2\2M\23\3\2\2\2\b"+
		" (;EGL";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}