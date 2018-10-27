// Generated from Calc.g4 by ANTLR 4.7.1

package ru.hse.mit;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CalcParser}.
 */
public interface CalcListener extends ParseTreeListener {
    /**
     * Enter a parse tree produced by {@link CalcParser#data}.
     *
     * @param ctx the parse tree
     */
    void enterData(CalcParser.DataContext ctx);

    /**
     * Exit a parse tree produced by {@link CalcParser#data}.
     *
     * @param ctx the parse tree
     */
    void exitData(CalcParser.DataContext ctx);

    /**
     * Enter a parse tree produced by {@link CalcParser#expression}.
     *
     * @param ctx the parse tree
     */
    void enterExpression(CalcParser.ExpressionContext ctx);

    /**
     * Exit a parse tree produced by {@link CalcParser#expression}.
     *
     * @param ctx the parse tree
     */
    void exitExpression(CalcParser.ExpressionContext ctx);

    /**
     * Enter a parse tree produced by {@link CalcParser#binaryExpression}.
     *
     * @param ctx the parse tree
     */
    void enterBinaryExpression(CalcParser.BinaryExpressionContext ctx);

    /**
     * Exit a parse tree produced by {@link CalcParser#binaryExpression}.
     *
     * @param ctx the parse tree
     */
    void exitBinaryExpression(CalcParser.BinaryExpressionContext ctx);

    /**
     * Enter a parse tree produced by {@link CalcParser#logicalExp}.
     *
     * @param ctx the parse tree
     */
    void enterLogicalExp(CalcParser.LogicalExpContext ctx);

    /**
     * Exit a parse tree produced by {@link CalcParser#logicalExp}.
     *
     * @param ctx the parse tree
     */
    void exitLogicalExp(CalcParser.LogicalExpContext ctx);

    /**
     * Enter a parse tree produced by {@link CalcParser#comparisonExp}.
     *
     * @param ctx the parse tree
     */
    void enterComparisonExp(CalcParser.ComparisonExpContext ctx);

    /**
     * Exit a parse tree produced by {@link CalcParser#comparisonExp}.
     *
     * @param ctx the parse tree
     */
    void exitComparisonExp(CalcParser.ComparisonExpContext ctx);

    /**
     * Enter a parse tree produced by {@link CalcParser#additionExp}.
     *
     * @param ctx the parse tree
     */
    void enterAdditionExp(CalcParser.AdditionExpContext ctx);

    /**
     * Exit a parse tree produced by {@link CalcParser#additionExp}.
     *
     * @param ctx the parse tree
     */
    void exitAdditionExp(CalcParser.AdditionExpContext ctx);

    /**
     * Enter a parse tree produced by {@link CalcParser#multiplyExp}.
     *
     * @param ctx the parse tree
     */
    void enterMultiplyExp(CalcParser.MultiplyExpContext ctx);

    /**
     * Exit a parse tree produced by {@link CalcParser#multiplyExp}.
     *
     * @param ctx the parse tree
     */
    void exitMultiplyExp(CalcParser.MultiplyExpContext ctx);

    /**
     * Enter a parse tree produced by {@link CalcParser#atomExp}.
     *
     * @param ctx the parse tree
     */
    void enterAtomExp(CalcParser.AtomExpContext ctx);

    /**
     * Exit a parse tree produced by {@link CalcParser#atomExp}.
     *
     * @param ctx the parse tree
     */
    void exitAtomExp(CalcParser.AtomExpContext ctx);

    /**
     * Enter a parse tree produced by {@link CalcParser#bool}.
     *
     * @param ctx the parse tree
     */
    void enterBool(CalcParser.BoolContext ctx);

    /**
     * Exit a parse tree produced by {@link CalcParser#bool}.
     *
     * @param ctx the parse tree
     */
    void exitBool(CalcParser.BoolContext ctx);
}