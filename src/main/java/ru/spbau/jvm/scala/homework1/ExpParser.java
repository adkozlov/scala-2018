// Generated from /Users/aleksandra.orlova/Documents/JVM HW/scala-2018/src/main/antlr/Exp.g4 by ANTLR 4.7
package ru.spbau.jvm.scala.homework1;

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
		T__0=1, T__1=2, T__2=3, MUL=4, DEL=5, SUM=6, MUN=7, EQ=8, NEQ=9, LE=10, 
		GR=11, LEQ=12, GEQ=13, OR=14, AND=15, Number=16, WS=17;
	public static final int
		RULE_calc = 0, RULE_expr = 1, RULE_negative_Number = 2;
	public static final String[] ruleNames = {
		"calc", "expr", "negative_Number"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'(-'", "'*'", "'/'", "'+'", "'-'", "'=='", "'!='", 
		"'<'", "'>'", "'<='", "'>='", "'||'", "'&&'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, "MUL", "DEL", "SUM", "MUN", "EQ", "NEQ", "LE", 
		"GR", "LEQ", "GEQ", "OR", "AND", "Number", "WS"
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
	public static class CalcContext extends ParserRuleContext {
		public ExprContext exp;
		public TerminalNode EOF() { return getToken(ExpParser.EOF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public CalcContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_calc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpListener ) ((ExpListener)listener).enterCalc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpListener ) ((ExpListener)listener).exitCalc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpVisitor ) return ((ExpVisitor<? extends T>)visitor).visitCalc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CalcContext calc() throws RecognitionException {
		CalcContext _localctx = new CalcContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_calc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(6);
			((CalcContext)_localctx).exp = expr(0);
			setState(7);
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

	public static class ExprContext extends ParserRuleContext {
		public ExprContext left;
		public Token num;
		public Negative_NumberContext neg_num;
		public ExprContext exp;
		public Token op;
		public ExprContext right;
		public TerminalNode Number() { return getToken(ExpParser.Number, 0); }
		public Negative_NumberContext negative_Number() {
			return getRuleContext(Negative_NumberContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MUL() { return getToken(ExpParser.MUL, 0); }
		public TerminalNode DEL() { return getToken(ExpParser.DEL, 0); }
		public TerminalNode SUM() { return getToken(ExpParser.SUM, 0); }
		public TerminalNode MUN() { return getToken(ExpParser.MUN, 0); }
		public TerminalNode EQ() { return getToken(ExpParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(ExpParser.NEQ, 0); }
		public TerminalNode LEQ() { return getToken(ExpParser.LEQ, 0); }
		public TerminalNode GEQ() { return getToken(ExpParser.GEQ, 0); }
		public TerminalNode GR() { return getToken(ExpParser.GR, 0); }
		public TerminalNode LE() { return getToken(ExpParser.LE, 0); }
		public TerminalNode OR() { return getToken(ExpParser.OR, 0); }
		public TerminalNode AND() { return getToken(ExpParser.AND, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpListener ) ((ExpListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpListener ) ((ExpListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpVisitor ) return ((ExpVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Number:
				{
				setState(10);
				((ExprContext)_localctx).num = match(Number);
				}
				break;
			case T__2:
				{
				setState(11);
				((ExprContext)_localctx).neg_num = negative_Number();
				}
				break;
			case T__0:
				{
				setState(12);
				match(T__0);
				setState(13);
				((ExprContext)_localctx).exp = expr(0);
				setState(14);
				match(T__1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(32);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(30);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(18);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(19);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DEL) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(20);
						((ExprContext)_localctx).right = expr(5);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(21);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(22);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==SUM || _la==MUN) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(23);
						((ExprContext)_localctx).right = expr(4);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(24);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(25);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << NEQ) | (1L << LE) | (1L << GR) | (1L << LEQ) | (1L << GEQ))) != 0)) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(26);
						((ExprContext)_localctx).right = expr(3);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(27);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(28);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==OR || _la==AND) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(29);
						((ExprContext)_localctx).right = expr(2);
						}
						break;
					}
					} 
				}
				setState(34);
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

	public static class Negative_NumberContext extends ParserRuleContext {
		public Token num;
		public TerminalNode Number() { return getToken(ExpParser.Number, 0); }
		public Negative_NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_negative_Number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpListener ) ((ExpListener)listener).enterNegative_Number(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpListener ) ((ExpListener)listener).exitNegative_Number(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpVisitor ) return ((ExpVisitor<? extends T>)visitor).visitNegative_Number(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Negative_NumberContext negative_Number() throws RecognitionException {
		Negative_NumberContext _localctx = new Negative_NumberContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_negative_Number);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			match(T__2);
			setState(36);
			((Negative_NumberContext)_localctx).num = match(Number);
			setState(37);
			match(T__1);
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
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		case 2:
			return precpred(_ctx, 2);
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\23*\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\23\n\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3!\n\3\f\3\16\3$\13\3\3\4\3"+
		"\4\3\4\3\4\3\4\2\3\4\5\2\4\6\2\6\3\2\6\7\3\2\b\t\3\2\n\17\3\2\20\21\2"+
		",\2\b\3\2\2\2\4\22\3\2\2\2\6%\3\2\2\2\b\t\5\4\3\2\t\n\7\2\2\3\n\3\3\2"+
		"\2\2\13\f\b\3\1\2\f\23\7\22\2\2\r\23\5\6\4\2\16\17\7\3\2\2\17\20\5\4\3"+
		"\2\20\21\7\4\2\2\21\23\3\2\2\2\22\13\3\2\2\2\22\r\3\2\2\2\22\16\3\2\2"+
		"\2\23\"\3\2\2\2\24\25\f\6\2\2\25\26\t\2\2\2\26!\5\4\3\7\27\30\f\5\2\2"+
		"\30\31\t\3\2\2\31!\5\4\3\6\32\33\f\4\2\2\33\34\t\4\2\2\34!\5\4\3\5\35"+
		"\36\f\3\2\2\36\37\t\5\2\2\37!\5\4\3\4 \24\3\2\2\2 \27\3\2\2\2 \32\3\2"+
		"\2\2 \35\3\2\2\2!$\3\2\2\2\" \3\2\2\2\"#\3\2\2\2#\5\3\2\2\2$\"\3\2\2\2"+
		"%&\7\5\2\2&\'\7\22\2\2\'(\7\4\2\2(\7\3\2\2\2\5\22 \"";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}