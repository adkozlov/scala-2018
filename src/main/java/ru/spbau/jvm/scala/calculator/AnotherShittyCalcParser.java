// Generated from /home/jetbrains/au_docs_ijJ9eOA8/Kotlin_Scala/scala-2018/src/main/antlr/AnotherShittyCalc.g4 by ANTLR 4.7
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
public class AnotherShittyCalcParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, BoolLiteral=3, TRUE=4, FALSE=5, Literal=6, PLUS=7, MINUS=8, 
		MULT=9, DIV=10, MOD=11, EQUAL=12, NOT_EQUAL=13, GT=14, GE=15, LT=16, LE=17, 
		AND=18, OR=19, NEWLINE=20, SPACES=21;
	public static final int
		RULE_expression = 0, RULE_logicExpr = 1, RULE_intExpr = 2, RULE_logicOrExpr = 3, 
		RULE_logicAndExpr = 4, RULE_atomLogicExpr = 5, RULE_equalityExpr = 6, 
		RULE_additionExp = 7, RULE_multiplyExp = 8, RULE_atomExp = 9;
	public static final String[] ruleNames = {
		"expression", "logicExpr", "intExpr", "logicOrExpr", "logicAndExpr", "atomLogicExpr", 
		"equalityExpr", "additionExp", "multiplyExp", "atomExp"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", null, "'true'", "'false'", null, "'+'", "'-'", "'*'", 
		"'/'", "'%'", "'=='", "'!='", "'>'", "'>='", "'<'", "'<='", "'&&'", "'||'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, "BoolLiteral", "TRUE", "FALSE", "Literal", "PLUS", "MINUS", 
		"MULT", "DIV", "MOD", "EQUAL", "NOT_EQUAL", "GT", "GE", "LT", "LE", "AND", 
		"OR", "NEWLINE", "SPACES"
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
	public String getGrammarFileName() { return "AnotherShittyCalc.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AnotherShittyCalcParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ExpressionContext extends ParserRuleContext {
		public LogicExprContext logicExpr() {
			return getRuleContext(LogicExprContext.class,0);
		}
		public IntExprContext intExpr() {
			return getRuleContext(IntExprContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnotherShittyCalcVisitor ) return ((AnotherShittyCalcVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_expression);
		try {
			setState(22);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(20);
				logicExpr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(21);
				intExpr();
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

	public static class LogicExprContext extends ParserRuleContext {
		public LogicOrExprContext logicOrExpr() {
			return getRuleContext(LogicOrExprContext.class,0);
		}
		public LogicExprContext logicExpr() {
			return getRuleContext(LogicExprContext.class,0);
		}
		public List<TerminalNode> SPACES() { return getTokens(AnotherShittyCalcParser.SPACES); }
		public TerminalNode SPACES(int i) {
			return getToken(AnotherShittyCalcParser.SPACES, i);
		}
		public LogicExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicExpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnotherShittyCalcVisitor ) return ((AnotherShittyCalcVisitor<? extends T>)visitor).visitLogicExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicExprContext logicExpr() throws RecognitionException {
		LogicExprContext _localctx = new LogicExprContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_logicExpr);
		int _la;
		try {
			setState(41);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(24);
				logicOrExpr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(25);
				match(T__0);
				setState(29);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SPACES) {
					{
					{
					setState(26);
					match(SPACES);
					}
					}
					setState(31);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(32);
				logicExpr();
				setState(36);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SPACES) {
					{
					{
					setState(33);
					match(SPACES);
					}
					}
					setState(38);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(39);
				match(T__1);
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

	public static class IntExprContext extends ParserRuleContext {
		public AdditionExpContext additionExp() {
			return getRuleContext(AdditionExpContext.class,0);
		}
		public IntExprContext intExpr() {
			return getRuleContext(IntExprContext.class,0);
		}
		public List<TerminalNode> SPACES() { return getTokens(AnotherShittyCalcParser.SPACES); }
		public TerminalNode SPACES(int i) {
			return getToken(AnotherShittyCalcParser.SPACES, i);
		}
		public IntExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intExpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnotherShittyCalcVisitor ) return ((AnotherShittyCalcVisitor<? extends T>)visitor).visitIntExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntExprContext intExpr() throws RecognitionException {
		IntExprContext _localctx = new IntExprContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_intExpr);
		int _la;
		try {
			setState(60);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(43);
				additionExp();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(44);
				match(T__0);
				setState(48);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SPACES) {
					{
					{
					setState(45);
					match(SPACES);
					}
					}
					setState(50);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(51);
				intExpr();
				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SPACES) {
					{
					{
					setState(52);
					match(SPACES);
					}
					}
					setState(57);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(58);
				match(T__1);
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

	public static class LogicOrExprContext extends ParserRuleContext {
		public LogicAndExprContext var;
		public LogicAndExprContext logicAndExpr;
		public List<LogicAndExprContext> vars = new ArrayList<LogicAndExprContext>();
		public List<LogicAndExprContext> logicAndExpr() {
			return getRuleContexts(LogicAndExprContext.class);
		}
		public LogicAndExprContext logicAndExpr(int i) {
			return getRuleContext(LogicAndExprContext.class,i);
		}
		public List<TerminalNode> SPACES() { return getTokens(AnotherShittyCalcParser.SPACES); }
		public TerminalNode SPACES(int i) {
			return getToken(AnotherShittyCalcParser.SPACES, i);
		}
		public LogicOrExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicOrExpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnotherShittyCalcVisitor ) return ((AnotherShittyCalcVisitor<? extends T>)visitor).visitLogicOrExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicOrExprContext logicOrExpr() throws RecognitionException {
		LogicOrExprContext _localctx = new LogicOrExprContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_logicOrExpr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			((LogicOrExprContext)_localctx).var = logicAndExpr();
			setState(79);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(66);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==SPACES) {
						{
						{
						setState(63);
						match(SPACES);
						}
						}
						setState(68);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(69);
					match(OR);
					setState(73);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==SPACES) {
						{
						{
						setState(70);
						match(SPACES);
						}
						}
						setState(75);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(76);
					((LogicOrExprContext)_localctx).logicAndExpr = logicAndExpr();
					((LogicOrExprContext)_localctx).vars.add(((LogicOrExprContext)_localctx).logicAndExpr);
					}
					} 
				}
				setState(81);
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
			exitRule();
		}
		return _localctx;
	}

	public static class LogicAndExprContext extends ParserRuleContext {
		public AtomLogicExprContext var;
		public AtomLogicExprContext atomLogicExpr;
		public List<AtomLogicExprContext> vars = new ArrayList<AtomLogicExprContext>();
		public List<AtomLogicExprContext> atomLogicExpr() {
			return getRuleContexts(AtomLogicExprContext.class);
		}
		public AtomLogicExprContext atomLogicExpr(int i) {
			return getRuleContext(AtomLogicExprContext.class,i);
		}
		public List<TerminalNode> SPACES() { return getTokens(AnotherShittyCalcParser.SPACES); }
		public TerminalNode SPACES(int i) {
			return getToken(AnotherShittyCalcParser.SPACES, i);
		}
		public LogicAndExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicAndExpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnotherShittyCalcVisitor ) return ((AnotherShittyCalcVisitor<? extends T>)visitor).visitLogicAndExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicAndExprContext logicAndExpr() throws RecognitionException {
		LogicAndExprContext _localctx = new LogicAndExprContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_logicAndExpr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			((LogicAndExprContext)_localctx).var = atomLogicExpr();
			setState(99);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(86);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==SPACES) {
						{
						{
						setState(83);
						match(SPACES);
						}
						}
						setState(88);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(89);
					match(AND);
					setState(93);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==SPACES) {
						{
						{
						setState(90);
						match(SPACES);
						}
						}
						setState(95);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(96);
					((LogicAndExprContext)_localctx).atomLogicExpr = atomLogicExpr();
					((LogicAndExprContext)_localctx).vars.add(((LogicAndExprContext)_localctx).atomLogicExpr);
					}
					} 
				}
				setState(101);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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

	public static class AtomLogicExprContext extends ParserRuleContext {
		public EqualityExprContext value;
		public Token constValue;
		public LogicOrExprContext exp;
		public EqualityExprContext equalityExpr() {
			return getRuleContext(EqualityExprContext.class,0);
		}
		public TerminalNode BoolLiteral() { return getToken(AnotherShittyCalcParser.BoolLiteral, 0); }
		public LogicOrExprContext logicOrExpr() {
			return getRuleContext(LogicOrExprContext.class,0);
		}
		public List<TerminalNode> SPACES() { return getTokens(AnotherShittyCalcParser.SPACES); }
		public TerminalNode SPACES(int i) {
			return getToken(AnotherShittyCalcParser.SPACES, i);
		}
		public AtomLogicExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomLogicExpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnotherShittyCalcVisitor ) return ((AnotherShittyCalcVisitor<? extends T>)visitor).visitAtomLogicExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomLogicExprContext atomLogicExpr() throws RecognitionException {
		AtomLogicExprContext _localctx = new AtomLogicExprContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_atomLogicExpr);
		int _la;
		try {
			setState(120);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(102);
				((AtomLogicExprContext)_localctx).value = equalityExpr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(103);
				((AtomLogicExprContext)_localctx).constValue = match(BoolLiteral);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(104);
				match(T__0);
				setState(108);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SPACES) {
					{
					{
					setState(105);
					match(SPACES);
					}
					}
					setState(110);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(111);
				((AtomLogicExprContext)_localctx).exp = logicOrExpr();
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SPACES) {
					{
					{
					setState(112);
					match(SPACES);
					}
					}
					setState(117);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(118);
				match(T__1);
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

	public static class EqualityExprContext extends ParserRuleContext {
		public IntExprContext var1;
		public Token op;
		public IntExprContext var2;
		public List<IntExprContext> intExpr() {
			return getRuleContexts(IntExprContext.class);
		}
		public IntExprContext intExpr(int i) {
			return getRuleContext(IntExprContext.class,i);
		}
		public TerminalNode EQUAL() { return getToken(AnotherShittyCalcParser.EQUAL, 0); }
		public TerminalNode NOT_EQUAL() { return getToken(AnotherShittyCalcParser.NOT_EQUAL, 0); }
		public TerminalNode LT() { return getToken(AnotherShittyCalcParser.LT, 0); }
		public TerminalNode LE() { return getToken(AnotherShittyCalcParser.LE, 0); }
		public TerminalNode GT() { return getToken(AnotherShittyCalcParser.GT, 0); }
		public TerminalNode GE() { return getToken(AnotherShittyCalcParser.GE, 0); }
		public List<TerminalNode> SPACES() { return getTokens(AnotherShittyCalcParser.SPACES); }
		public TerminalNode SPACES(int i) {
			return getToken(AnotherShittyCalcParser.SPACES, i);
		}
		public EqualityExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityExpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnotherShittyCalcVisitor ) return ((AnotherShittyCalcVisitor<? extends T>)visitor).visitEqualityExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqualityExprContext equalityExpr() throws RecognitionException {
		EqualityExprContext _localctx = new EqualityExprContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_equalityExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			((EqualityExprContext)_localctx).var1 = intExpr();
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SPACES) {
				{
				{
				setState(123);
				match(SPACES);
				}
				}
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(129);
			((EqualityExprContext)_localctx).op = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQUAL) | (1L << NOT_EQUAL) | (1L << GT) | (1L << GE) | (1L << LT) | (1L << LE))) != 0)) ) {
				((EqualityExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SPACES) {
				{
				{
				setState(130);
				match(SPACES);
				}
				}
				setState(135);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(136);
			((EqualityExprContext)_localctx).var2 = intExpr();
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

	public static class AdditionExpContext extends ParserRuleContext {
		public MultiplyExpContext var;
		public Token PLUS;
		public List<Token> ops = new ArrayList<Token>();
		public Token MINUS;
		public Token _tset207;
		public MultiplyExpContext multiplyExp;
		public List<MultiplyExpContext> vars = new ArrayList<MultiplyExpContext>();
		public List<MultiplyExpContext> multiplyExp() {
			return getRuleContexts(MultiplyExpContext.class);
		}
		public MultiplyExpContext multiplyExp(int i) {
			return getRuleContext(MultiplyExpContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(AnotherShittyCalcParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(AnotherShittyCalcParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(AnotherShittyCalcParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(AnotherShittyCalcParser.MINUS, i);
		}
		public List<TerminalNode> SPACES() { return getTokens(AnotherShittyCalcParser.SPACES); }
		public TerminalNode SPACES(int i) {
			return getToken(AnotherShittyCalcParser.SPACES, i);
		}
		public AdditionExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additionExp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnotherShittyCalcVisitor ) return ((AnotherShittyCalcVisitor<? extends T>)visitor).visitAdditionExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AdditionExpContext additionExp() throws RecognitionException {
		AdditionExpContext _localctx = new AdditionExpContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_additionExp);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			((AdditionExpContext)_localctx).var = multiplyExp();
			setState(155);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(142);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==SPACES) {
						{
						{
						setState(139);
						match(SPACES);
						}
						}
						setState(144);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(145);
					((AdditionExpContext)_localctx)._tset207 = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
						((AdditionExpContext)_localctx)._tset207 = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					((AdditionExpContext)_localctx).ops.add(((AdditionExpContext)_localctx)._tset207);
					setState(149);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==SPACES) {
						{
						{
						setState(146);
						match(SPACES);
						}
						}
						setState(151);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(152);
					((AdditionExpContext)_localctx).multiplyExp = multiplyExp();
					((AdditionExpContext)_localctx).vars.add(((AdditionExpContext)_localctx).multiplyExp);
					}
					} 
				}
				setState(157);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
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

	public static class MultiplyExpContext extends ParserRuleContext {
		public AtomExpContext var;
		public Token MULT;
		public List<Token> ops = new ArrayList<Token>();
		public Token DIV;
		public Token MOD;
		public Token _tset240;
		public AtomExpContext atomExp;
		public List<AtomExpContext> vars = new ArrayList<AtomExpContext>();
		public List<AtomExpContext> atomExp() {
			return getRuleContexts(AtomExpContext.class);
		}
		public AtomExpContext atomExp(int i) {
			return getRuleContext(AtomExpContext.class,i);
		}
		public List<TerminalNode> MULT() { return getTokens(AnotherShittyCalcParser.MULT); }
		public TerminalNode MULT(int i) {
			return getToken(AnotherShittyCalcParser.MULT, i);
		}
		public List<TerminalNode> DIV() { return getTokens(AnotherShittyCalcParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(AnotherShittyCalcParser.DIV, i);
		}
		public List<TerminalNode> MOD() { return getTokens(AnotherShittyCalcParser.MOD); }
		public TerminalNode MOD(int i) {
			return getToken(AnotherShittyCalcParser.MOD, i);
		}
		public List<TerminalNode> SPACES() { return getTokens(AnotherShittyCalcParser.SPACES); }
		public TerminalNode SPACES(int i) {
			return getToken(AnotherShittyCalcParser.SPACES, i);
		}
		public MultiplyExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplyExp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnotherShittyCalcVisitor ) return ((AnotherShittyCalcVisitor<? extends T>)visitor).visitMultiplyExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplyExpContext multiplyExp() throws RecognitionException {
		MultiplyExpContext _localctx = new MultiplyExpContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_multiplyExp);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			((MultiplyExpContext)_localctx).var = atomExp();
			setState(175);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(162);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==SPACES) {
						{
						{
						setState(159);
						match(SPACES);
						}
						}
						setState(164);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(165);
					((MultiplyExpContext)_localctx)._tset240 = _input.LT(1);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULT) | (1L << DIV) | (1L << MOD))) != 0)) ) {
						((MultiplyExpContext)_localctx)._tset240 = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					((MultiplyExpContext)_localctx).ops.add(((MultiplyExpContext)_localctx)._tset240);
					setState(169);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==SPACES) {
						{
						{
						setState(166);
						match(SPACES);
						}
						}
						setState(171);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(172);
					((MultiplyExpContext)_localctx).atomExp = atomExp();
					((MultiplyExpContext)_localctx).vars.add(((MultiplyExpContext)_localctx).atomExp);
					}
					} 
				}
				setState(177);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
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

	public static class AtomExpContext extends ParserRuleContext {
		public Token n;
		public IntExprContext exp;
		public TerminalNode Literal() { return getToken(AnotherShittyCalcParser.Literal, 0); }
		public IntExprContext intExpr() {
			return getRuleContext(IntExprContext.class,0);
		}
		public List<TerminalNode> SPACES() { return getTokens(AnotherShittyCalcParser.SPACES); }
		public TerminalNode SPACES(int i) {
			return getToken(AnotherShittyCalcParser.SPACES, i);
		}
		public AtomExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomExp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AnotherShittyCalcVisitor ) return ((AnotherShittyCalcVisitor<? extends T>)visitor).visitAtomExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomExpContext atomExp() throws RecognitionException {
		AtomExpContext _localctx = new AtomExpContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_atomExp);
		int _la;
		try {
			setState(195);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Literal:
				enterOuterAlt(_localctx, 1);
				{
				setState(178);
				((AtomExpContext)_localctx).n = match(Literal);
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(179);
				match(T__0);
				setState(183);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SPACES) {
					{
					{
					setState(180);
					match(SPACES);
					}
					}
					setState(185);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(186);
				((AtomExpContext)_localctx).exp = intExpr();
				setState(190);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SPACES) {
					{
					{
					setState(187);
					match(SPACES);
					}
					}
					setState(192);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(193);
				match(T__1);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\27\u00c8\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\3\2\3\2\5\2\31\n\2\3\3\3\3\3\3\7\3\36\n\3\f\3\16\3!\13\3\3\3\3\3"+
		"\7\3%\n\3\f\3\16\3(\13\3\3\3\3\3\5\3,\n\3\3\4\3\4\3\4\7\4\61\n\4\f\4\16"+
		"\4\64\13\4\3\4\3\4\7\48\n\4\f\4\16\4;\13\4\3\4\3\4\5\4?\n\4\3\5\3\5\7"+
		"\5C\n\5\f\5\16\5F\13\5\3\5\3\5\7\5J\n\5\f\5\16\5M\13\5\3\5\7\5P\n\5\f"+
		"\5\16\5S\13\5\3\6\3\6\7\6W\n\6\f\6\16\6Z\13\6\3\6\3\6\7\6^\n\6\f\6\16"+
		"\6a\13\6\3\6\7\6d\n\6\f\6\16\6g\13\6\3\7\3\7\3\7\3\7\7\7m\n\7\f\7\16\7"+
		"p\13\7\3\7\3\7\7\7t\n\7\f\7\16\7w\13\7\3\7\3\7\5\7{\n\7\3\b\3\b\7\b\177"+
		"\n\b\f\b\16\b\u0082\13\b\3\b\3\b\7\b\u0086\n\b\f\b\16\b\u0089\13\b\3\b"+
		"\3\b\3\t\3\t\7\t\u008f\n\t\f\t\16\t\u0092\13\t\3\t\3\t\7\t\u0096\n\t\f"+
		"\t\16\t\u0099\13\t\3\t\7\t\u009c\n\t\f\t\16\t\u009f\13\t\3\n\3\n\7\n\u00a3"+
		"\n\n\f\n\16\n\u00a6\13\n\3\n\3\n\7\n\u00aa\n\n\f\n\16\n\u00ad\13\n\3\n"+
		"\7\n\u00b0\n\n\f\n\16\n\u00b3\13\n\3\13\3\13\3\13\7\13\u00b8\n\13\f\13"+
		"\16\13\u00bb\13\13\3\13\3\13\7\13\u00bf\n\13\f\13\16\13\u00c2\13\13\3"+
		"\13\3\13\5\13\u00c6\n\13\3\13\2\2\f\2\4\6\b\n\f\16\20\22\24\2\5\3\2\16"+
		"\23\3\2\t\n\3\2\13\r\2\u00d9\2\30\3\2\2\2\4+\3\2\2\2\6>\3\2\2\2\b@\3\2"+
		"\2\2\nT\3\2\2\2\fz\3\2\2\2\16|\3\2\2\2\20\u008c\3\2\2\2\22\u00a0\3\2\2"+
		"\2\24\u00c5\3\2\2\2\26\31\5\4\3\2\27\31\5\6\4\2\30\26\3\2\2\2\30\27\3"+
		"\2\2\2\31\3\3\2\2\2\32,\5\b\5\2\33\37\7\3\2\2\34\36\7\27\2\2\35\34\3\2"+
		"\2\2\36!\3\2\2\2\37\35\3\2\2\2\37 \3\2\2\2 \"\3\2\2\2!\37\3\2\2\2\"&\5"+
		"\4\3\2#%\7\27\2\2$#\3\2\2\2%(\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\')\3\2\2\2"+
		"(&\3\2\2\2)*\7\4\2\2*,\3\2\2\2+\32\3\2\2\2+\33\3\2\2\2,\5\3\2\2\2-?\5"+
		"\20\t\2.\62\7\3\2\2/\61\7\27\2\2\60/\3\2\2\2\61\64\3\2\2\2\62\60\3\2\2"+
		"\2\62\63\3\2\2\2\63\65\3\2\2\2\64\62\3\2\2\2\659\5\6\4\2\668\7\27\2\2"+
		"\67\66\3\2\2\28;\3\2\2\29\67\3\2\2\29:\3\2\2\2:<\3\2\2\2;9\3\2\2\2<=\7"+
		"\4\2\2=?\3\2\2\2>-\3\2\2\2>.\3\2\2\2?\7\3\2\2\2@Q\5\n\6\2AC\7\27\2\2B"+
		"A\3\2\2\2CF\3\2\2\2DB\3\2\2\2DE\3\2\2\2EG\3\2\2\2FD\3\2\2\2GK\7\25\2\2"+
		"HJ\7\27\2\2IH\3\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2\2LN\3\2\2\2MK\3\2\2"+
		"\2NP\5\n\6\2OD\3\2\2\2PS\3\2\2\2QO\3\2\2\2QR\3\2\2\2R\t\3\2\2\2SQ\3\2"+
		"\2\2Te\5\f\7\2UW\7\27\2\2VU\3\2\2\2WZ\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y[\3"+
		"\2\2\2ZX\3\2\2\2[_\7\24\2\2\\^\7\27\2\2]\\\3\2\2\2^a\3\2\2\2_]\3\2\2\2"+
		"_`\3\2\2\2`b\3\2\2\2a_\3\2\2\2bd\5\f\7\2cX\3\2\2\2dg\3\2\2\2ec\3\2\2\2"+
		"ef\3\2\2\2f\13\3\2\2\2ge\3\2\2\2h{\5\16\b\2i{\7\5\2\2jn\7\3\2\2km\7\27"+
		"\2\2lk\3\2\2\2mp\3\2\2\2nl\3\2\2\2no\3\2\2\2oq\3\2\2\2pn\3\2\2\2qu\5\b"+
		"\5\2rt\7\27\2\2sr\3\2\2\2tw\3\2\2\2us\3\2\2\2uv\3\2\2\2vx\3\2\2\2wu\3"+
		"\2\2\2xy\7\4\2\2y{\3\2\2\2zh\3\2\2\2zi\3\2\2\2zj\3\2\2\2{\r\3\2\2\2|\u0080"+
		"\5\6\4\2}\177\7\27\2\2~}\3\2\2\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0080"+
		"\u0081\3\2\2\2\u0081\u0083\3\2\2\2\u0082\u0080\3\2\2\2\u0083\u0087\t\2"+
		"\2\2\u0084\u0086\7\27\2\2\u0085\u0084\3\2\2\2\u0086\u0089\3\2\2\2\u0087"+
		"\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u008a\3\2\2\2\u0089\u0087\3\2"+
		"\2\2\u008a\u008b\5\6\4\2\u008b\17\3\2\2\2\u008c\u009d\5\22\n\2\u008d\u008f"+
		"\7\27\2\2\u008e\u008d\3\2\2\2\u008f\u0092\3\2\2\2\u0090\u008e\3\2\2\2"+
		"\u0090\u0091\3\2\2\2\u0091\u0093\3\2\2\2\u0092\u0090\3\2\2\2\u0093\u0097"+
		"\t\3\2\2\u0094\u0096\7\27\2\2\u0095\u0094\3\2\2\2\u0096\u0099\3\2\2\2"+
		"\u0097\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u009a\3\2\2\2\u0099\u0097"+
		"\3\2\2\2\u009a\u009c\5\22\n\2\u009b\u0090\3\2\2\2\u009c\u009f\3\2\2\2"+
		"\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\21\3\2\2\2\u009f\u009d"+
		"\3\2\2\2\u00a0\u00b1\5\24\13\2\u00a1\u00a3\7\27\2\2\u00a2\u00a1\3\2\2"+
		"\2\u00a3\u00a6\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a7"+
		"\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a7\u00ab\t\4\2\2\u00a8\u00aa\7\27\2\2"+
		"\u00a9\u00a8\3\2\2\2\u00aa\u00ad\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac"+
		"\3\2\2\2\u00ac\u00ae\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ae\u00b0\5\24\13\2"+
		"\u00af\u00a4\3\2\2\2\u00b0\u00b3\3\2\2\2\u00b1\u00af\3\2\2\2\u00b1\u00b2"+
		"\3\2\2\2\u00b2\23\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b4\u00c6\7\b\2\2\u00b5"+
		"\u00b9\7\3\2\2\u00b6\u00b8\7\27\2\2\u00b7\u00b6\3\2\2\2\u00b8\u00bb\3"+
		"\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bc\3\2\2\2\u00bb"+
		"\u00b9\3\2\2\2\u00bc\u00c0\5\6\4\2\u00bd\u00bf\7\27\2\2\u00be\u00bd\3"+
		"\2\2\2\u00bf\u00c2\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1"+
		"\u00c3\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c3\u00c4\7\4\2\2\u00c4\u00c6\3\2"+
		"\2\2\u00c5\u00b4\3\2\2\2\u00c5\u00b5\3\2\2\2\u00c6\25\3\2\2\2\35\30\37"+
		"&+\629>DKQX_enuz\u0080\u0087\u0090\u0097\u009d\u00a4\u00ab\u00b1\u00b9"+
		"\u00c0\u00c5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}