// Generated from Calc.g4 by ANTLR 4.7.1

package ru.hse.mit;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CalcParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CalcVisitor<T> extends ParseTreeVisitor<T> {
    /**
     * Visit a parse tree produced by {@link CalcParser#data}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitData(CalcParser.DataContext ctx);

    /**
     * Visit a parse tree produced by {@link CalcParser#expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExpression(CalcParser.ExpressionContext ctx);

    /**
     * Visit a parse tree produced by {@link CalcParser#binaryExpression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBinaryExpression(CalcParser.BinaryExpressionContext ctx);

    /**
     * Visit a parse tree produced by {@link CalcParser#logicalExp}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitLogicalExp(CalcParser.LogicalExpContext ctx);

    /**
     * Visit a parse tree produced by {@link CalcParser#comparisonExp}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitComparisonExp(CalcParser.ComparisonExpContext ctx);

    /**
     * Visit a parse tree produced by {@link CalcParser#additionExp}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAdditionExp(CalcParser.AdditionExpContext ctx);

    /**
     * Visit a parse tree produced by {@link CalcParser#multiplyExp}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitMultiplyExp(CalcParser.MultiplyExpContext ctx);

    /**
     * Visit a parse tree produced by {@link CalcParser#atomExp}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAtomExp(CalcParser.AtomExpContext ctx);

    /**
     * Visit a parse tree produced by {@link CalcParser#bool}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBool(CalcParser.BoolContext ctx);
}