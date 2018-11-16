// Generated from src/main/java/ru/hse/Exp.g4 by ANTLR 4.7.1
package ru.hse;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ExpParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ExpVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ExpParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(ExpParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#atomExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExpression(ExpParser.AtomExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#expressionWithBraces}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionWithBraces(ExpParser.ExpressionWithBracesContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#orExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpression(ExpParser.OrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#andExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpression(ExpParser.AndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#relationalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpression(ExpParser.RelationalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#additiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpression(ExpParser.AdditiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpression(ExpParser.MultiplicativeExpressionContext ctx);
}