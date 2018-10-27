// Generated from Calc.g4 by ANTLR 4.7.1

package ru.hse.mit;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CalcParser extends Parser {
    public static final int
            True = 1, False = 2, LeftParen = 3, RightParen = 4, IsEqual = 5, NotEquals = 6, Less = 7,
            LessEqual = 8, Greater = 9, GreaterEqual = 10, Plus = 11, Minus = 12, Mult = 13, Div = 14,
            Mod = 15, Or = 16, And = 17, Number = 18, WS = 19;
    public static final int
            RULE_data = 0, RULE_expression = 1, RULE_binaryExpression = 2, RULE_logicalExp = 3,
            RULE_comparisonExp = 4, RULE_additionExp = 5, RULE_multiplyExp = 6, RULE_atomExp = 7,
            RULE_bool = 8;
    public static final String[] ruleNames = {
            "data", "expression", "binaryExpression", "logicalExp", "comparisonExp",
            "additionExp", "multiplyExp", "atomExp", "bool"
    };
    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;
    public static final String _serializedATN =
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\25I\4\2\t\2\4\3\t" +
                    "\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2\3\2" +
                    "\3\3\3\3\3\3\3\3\3\3\3\3\5\3\36\n\3\3\4\3\4\3\5\3\5\3\5\7\5%\n\5\f\5\16" +
                    "\5(\13\5\3\6\3\6\3\6\5\6-\n\6\3\7\3\7\3\7\7\7\62\n\7\f\7\16\7\65\13\7" +
                    "\3\b\3\b\3\b\7\b:\n\b\f\b\16\b=\13\b\3\t\3\t\3\t\3\t\3\t\3\t\5\tE\n\t" +
                    "\3\n\3\n\3\n\2\2\13\2\4\6\b\n\f\16\20\22\2\7\3\2\22\23\3\2\7\f\3\2\r\16" +
                    "\3\2\17\21\3\2\3\4\2F\2\24\3\2\2\2\4\35\3\2\2\2\6\37\3\2\2\2\b!\3\2\2" +
                    "\2\n)\3\2\2\2\f.\3\2\2\2\16\66\3\2\2\2\20D\3\2\2\2\22F\3\2\2\2\24\25\5" +
                    "\4\3\2\25\26\7\2\2\3\26\3\3\2\2\2\27\36\5\6\4\2\30\31\7\24\2\2\31\32\7" +
                    "\5\2\2\32\33\5\4\3\2\33\34\7\6\2\2\34\36\3\2\2\2\35\27\3\2\2\2\35\30\3" +
                    "\2\2\2\36\5\3\2\2\2\37 \5\b\5\2 \7\3\2\2\2!&\5\n\6\2\"#\t\2\2\2#%\5\n" +
                    "\6\2$\"\3\2\2\2%(\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\'\t\3\2\2\2(&\3\2\2\2)" +
                    ",\5\f\7\2*+\t\3\2\2+-\5\f\7\2,*\3\2\2\2,-\3\2\2\2-\13\3\2\2\2.\63\5\16" +
                    "\b\2/\60\t\4\2\2\60\62\5\16\b\2\61/\3\2\2\2\62\65\3\2\2\2\63\61\3\2\2" +
                    "\2\63\64\3\2\2\2\64\r\3\2\2\2\65\63\3\2\2\2\66;\5\20\t\2\678\t\5\2\28" +
                    ":\5\20\t\29\67\3\2\2\2:=\3\2\2\2;9\3\2\2\2;<\3\2\2\2<\17\3\2\2\2=;\3\2" +
                    "\2\2>E\7\24\2\2?E\5\22\n\2@A\7\5\2\2AB\5\4\3\2BC\7\6\2\2CE\3\2\2\2D>\3" +
                    "\2\2\2D?\3\2\2\2D@\3\2\2\2E\21\3\2\2\2FG\t\6\2\2G\23\3\2\2\2\b\35&,\63" +
                    ";D";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());
    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    private static final String[] _LITERAL_NAMES = {
            null, "'true'", "'false'", "'('", "')'", "'=='", "'!='", "'<'", "'<='",
            "'>'", "'>='", "'+'", "'-'", "'*'", "'/'", "'%'", "'||'", "'&&'"
    };
    private static final String[] _SYMBOLIC_NAMES = {
            null, "True", "False", "LeftParen", "RightParen", "IsEqual", "NotEquals",
            "Less", "LessEqual", "Greater", "GreaterEqual", "Plus", "Minus", "Mult",
            "Div", "Mod", "Or", "And", "Number", "WS"
    };
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

    static {
        RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION);
    }

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

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }

    public CalcParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    @Override
    @Deprecated
    public String[] getTokenNames() {
        return tokenNames;
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override

    public Vocabulary getVocabulary() {
        return VOCABULARY;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public String getGrammarFileName() {
        return "Calc.g4";
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public final DataContext data() throws RecognitionException {
        DataContext _localctx = new DataContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_data);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(18);
                expression();
                setState(19);
                match(EOF);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ExpressionContext expression() throws RecognitionException {
        ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_expression);
        try {
            setState(27);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 0, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(21);
                    binaryExpression();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(22);
                    match(Number);
                    setState(23);
                    match(LeftParen);
                    setState(24);
                    expression();
                    setState(25);
                    match(RightParen);
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final BinaryExpressionContext binaryExpression() throws RecognitionException {
        BinaryExpressionContext _localctx = new BinaryExpressionContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_binaryExpression);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(29);
                logicalExp();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final LogicalExpContext logicalExp() throws RecognitionException {
        LogicalExpContext _localctx = new LogicalExpContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_logicalExp);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(31);
                comparisonExp();
                setState(36);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == Or || _la == And) {
                    {
                        {
                            setState(32);
                            _la = _input.LA(1);
                            if (!(_la == Or || _la == And)) {
                                _errHandler.recoverInline(this);
                            } else {
                                if (_input.LA(1) == Token.EOF) {
                                    matchedEOF = true;
                                }
                                _errHandler.reportMatch(this);
                                consume();
                            }
                            setState(33);
                            comparisonExp();
                        }
                    }
                    setState(38);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ComparisonExpContext comparisonExp() throws RecognitionException {
        ComparisonExpContext _localctx = new ComparisonExpContext(_ctx, getState());
        enterRule(_localctx, 8, RULE_comparisonExp);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(39);
                additionExp();
                setState(42);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IsEqual) | (1L << NotEquals) | (1L << Less) | (1L << LessEqual) | (1L << Greater) | (1L << GreaterEqual))) != 0)) {
                    {
                        setState(40);
                        _la = _input.LA(1);
                        if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IsEqual) | (1L << NotEquals) | (1L << Less) | (1L << LessEqual) | (1L << Greater) | (1L << GreaterEqual))) != 0))) {
                            _errHandler.recoverInline(this);
                        } else {
                            if (_input.LA(1) == Token.EOF) {
                                matchedEOF = true;
                            }
                            _errHandler.reportMatch(this);
                            consume();
                        }
                        setState(41);
                        additionExp();
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final AdditionExpContext additionExp() throws RecognitionException {
        AdditionExpContext _localctx = new AdditionExpContext(_ctx, getState());
        enterRule(_localctx, 10, RULE_additionExp);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(44);
                multiplyExp();
                setState(49);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == Plus || _la == Minus) {
                    {
                        {
                            setState(45);
                            _la = _input.LA(1);
                            if (!(_la == Plus || _la == Minus)) {
                                _errHandler.recoverInline(this);
                            } else {
                                if (_input.LA(1) == Token.EOF) {
                                    matchedEOF = true;
                                }
                                _errHandler.reportMatch(this);
                                consume();
                            }
                            setState(46);
                            multiplyExp();
                        }
                    }
                    setState(51);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final MultiplyExpContext multiplyExp() throws RecognitionException {
        MultiplyExpContext _localctx = new MultiplyExpContext(_ctx, getState());
        enterRule(_localctx, 12, RULE_multiplyExp);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(52);
                atomExp();
                setState(57);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Mult) | (1L << Div) | (1L << Mod))) != 0)) {
                    {
                        {
                            setState(53);
                            _la = _input.LA(1);
                            if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Mult) | (1L << Div) | (1L << Mod))) != 0))) {
                                _errHandler.recoverInline(this);
                            } else {
                                if (_input.LA(1) == Token.EOF) {
                                    matchedEOF = true;
                                }
                                _errHandler.reportMatch(this);
                                consume();
                            }
                            setState(54);
                            atomExp();
                        }
                    }
                    setState(59);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final AtomExpContext atomExp() throws RecognitionException {
        AtomExpContext _localctx = new AtomExpContext(_ctx, getState());
        enterRule(_localctx, 14, RULE_atomExp);
        try {
            setState(66);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case Number:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(60);
                    match(Number);
                }
                break;
                case True:
                case False:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(61);
                    bool();
                }
                break;
                case LeftParen:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(62);
                    match(LeftParen);
                    setState(63);
                    expression();
                    setState(64);
                    match(RightParen);
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final BoolContext bool() throws RecognitionException {
        BoolContext _localctx = new BoolContext(_ctx, getState());
        enterRule(_localctx, 16, RULE_bool);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(68);
                _la = _input.LA(1);
                if (!(_la == True || _la == False)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) {
                        matchedEOF = true;
                    }
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class DataContext extends ParserRuleContext {
        public DataContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public TerminalNode EOF() {
            return getToken(CalcParser.EOF, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_data;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof CalcListener) {
                ((CalcListener) listener).enterData(this);
            }
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof CalcListener) {
                ((CalcListener) listener).exitData(this);
            }
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CalcVisitor) {
                return ((CalcVisitor<? extends T>) visitor).visitData(this);
            } else {
                return visitor.visitChildren(this);
            }
        }
    }

    public static class ExpressionContext extends ParserRuleContext {
        public ExpressionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public BinaryExpressionContext binaryExpression() {
            return getRuleContext(BinaryExpressionContext.class, 0);
        }

        public TerminalNode Number() {
            return getToken(CalcParser.Number, 0);
        }

        public TerminalNode LeftParen() {
            return getToken(CalcParser.LeftParen, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public TerminalNode RightParen() {
            return getToken(CalcParser.RightParen, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_expression;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof CalcListener) {
                ((CalcListener) listener).enterExpression(this);
            }
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof CalcListener) {
                ((CalcListener) listener).exitExpression(this);
            }
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CalcVisitor) {
                return ((CalcVisitor<? extends T>) visitor).visitExpression(this);
            } else {
                return visitor.visitChildren(this);
            }
        }
    }

    public static class BinaryExpressionContext extends ParserRuleContext {
        public BinaryExpressionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public LogicalExpContext logicalExp() {
            return getRuleContext(LogicalExpContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_binaryExpression;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof CalcListener) {
                ((CalcListener) listener).enterBinaryExpression(this);
            }
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof CalcListener) {
                ((CalcListener) listener).exitBinaryExpression(this);
            }
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CalcVisitor) {
                return ((CalcVisitor<? extends T>) visitor).visitBinaryExpression(this);
            } else {
                return visitor.visitChildren(this);
            }
        }
    }

    public static class LogicalExpContext extends ParserRuleContext {
        public LogicalExpContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<ComparisonExpContext> comparisonExp() {
            return getRuleContexts(ComparisonExpContext.class);
        }

        public ComparisonExpContext comparisonExp(int i) {
            return getRuleContext(ComparisonExpContext.class, i);
        }

        public List<TerminalNode> Or() {
            return getTokens(CalcParser.Or);
        }

        public TerminalNode Or(int i) {
            return getToken(CalcParser.Or, i);
        }

        public List<TerminalNode> And() {
            return getTokens(CalcParser.And);
        }

        public TerminalNode And(int i) {
            return getToken(CalcParser.And, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_logicalExp;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof CalcListener) {
                ((CalcListener) listener).enterLogicalExp(this);
            }
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof CalcListener) {
                ((CalcListener) listener).exitLogicalExp(this);
            }
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CalcVisitor) {
                return ((CalcVisitor<? extends T>) visitor).visitLogicalExp(this);
            } else {
                return visitor.visitChildren(this);
            }
        }
    }

    public static class ComparisonExpContext extends ParserRuleContext {
        public ComparisonExpContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<AdditionExpContext> additionExp() {
            return getRuleContexts(AdditionExpContext.class);
        }

        public AdditionExpContext additionExp(int i) {
            return getRuleContext(AdditionExpContext.class, i);
        }

        public TerminalNode NotEquals() {
            return getToken(CalcParser.NotEquals, 0);
        }

        public TerminalNode IsEqual() {
            return getToken(CalcParser.IsEqual, 0);
        }

        public TerminalNode LessEqual() {
            return getToken(CalcParser.LessEqual, 0);
        }

        public TerminalNode GreaterEqual() {
            return getToken(CalcParser.GreaterEqual, 0);
        }

        public TerminalNode Less() {
            return getToken(CalcParser.Less, 0);
        }

        public TerminalNode Greater() {
            return getToken(CalcParser.Greater, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_comparisonExp;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof CalcListener) {
                ((CalcListener) listener).enterComparisonExp(this);
            }
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof CalcListener) {
                ((CalcListener) listener).exitComparisonExp(this);
            }
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CalcVisitor) {
                return ((CalcVisitor<? extends T>) visitor).visitComparisonExp(this);
            } else {
                return visitor.visitChildren(this);
            }
        }
    }

    public static class AdditionExpContext extends ParserRuleContext {
        public AdditionExpContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<MultiplyExpContext> multiplyExp() {
            return getRuleContexts(MultiplyExpContext.class);
        }

        public MultiplyExpContext multiplyExp(int i) {
            return getRuleContext(MultiplyExpContext.class, i);
        }

        public List<TerminalNode> Plus() {
            return getTokens(CalcParser.Plus);
        }

        public TerminalNode Plus(int i) {
            return getToken(CalcParser.Plus, i);
        }

        public List<TerminalNode> Minus() {
            return getTokens(CalcParser.Minus);
        }

        public TerminalNode Minus(int i) {
            return getToken(CalcParser.Minus, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_additionExp;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof CalcListener) {
                ((CalcListener) listener).enterAdditionExp(this);
            }
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof CalcListener) {
                ((CalcListener) listener).exitAdditionExp(this);
            }
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CalcVisitor) {
                return ((CalcVisitor<? extends T>) visitor).visitAdditionExp(this);
            } else {
                return visitor.visitChildren(this);
            }
        }
    }

    public static class MultiplyExpContext extends ParserRuleContext {
        public MultiplyExpContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<AtomExpContext> atomExp() {
            return getRuleContexts(AtomExpContext.class);
        }

        public AtomExpContext atomExp(int i) {
            return getRuleContext(AtomExpContext.class, i);
        }

        public List<TerminalNode> Mult() {
            return getTokens(CalcParser.Mult);
        }

        public TerminalNode Mult(int i) {
            return getToken(CalcParser.Mult, i);
        }

        public List<TerminalNode> Div() {
            return getTokens(CalcParser.Div);
        }

        public TerminalNode Div(int i) {
            return getToken(CalcParser.Div, i);
        }

        public List<TerminalNode> Mod() {
            return getTokens(CalcParser.Mod);
        }

        public TerminalNode Mod(int i) {
            return getToken(CalcParser.Mod, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_multiplyExp;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof CalcListener) {
                ((CalcListener) listener).enterMultiplyExp(this);
            }
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof CalcListener) {
                ((CalcListener) listener).exitMultiplyExp(this);
            }
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CalcVisitor) {
                return ((CalcVisitor<? extends T>) visitor).visitMultiplyExp(this);
            } else {
                return visitor.visitChildren(this);
            }
        }
    }

    public static class AtomExpContext extends ParserRuleContext {
        public AtomExpContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode Number() {
            return getToken(CalcParser.Number, 0);
        }

        public BoolContext bool() {
            return getRuleContext(BoolContext.class, 0);
        }

        public TerminalNode LeftParen() {
            return getToken(CalcParser.LeftParen, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public TerminalNode RightParen() {
            return getToken(CalcParser.RightParen, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_atomExp;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof CalcListener) {
                ((CalcListener) listener).enterAtomExp(this);
            }
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof CalcListener) {
                ((CalcListener) listener).exitAtomExp(this);
            }
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CalcVisitor) {
                return ((CalcVisitor<? extends T>) visitor).visitAtomExp(this);
            } else {
                return visitor.visitChildren(this);
            }
        }
    }

    public static class BoolContext extends ParserRuleContext {
        public BoolContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode True() {
            return getToken(CalcParser.True, 0);
        }

        public TerminalNode False() {
            return getToken(CalcParser.False, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_bool;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof CalcListener) {
                ((CalcListener) listener).enterBool(this);
            }
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof CalcListener) {
                ((CalcListener) listener).exitBool(this);
            }
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CalcVisitor) {
                return ((CalcVisitor<? extends T>) visitor).visitBool(this);
            } else {
                return visitor.visitChildren(this);
            }
        }
    }
}