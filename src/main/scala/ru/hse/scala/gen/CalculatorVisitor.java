// Generated from C:/Users/olga/SPbAU/2018-2019/scala-2018/src/main/antlr\Calculator.g4 by ANTLR 4.7
package ru.hse.scala.gen;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CalculatorParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CalculatorVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CalculatorParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(CalculatorParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(CalculatorParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorParser#orExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExp(CalculatorParser.OrExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorParser#andExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExp(CalculatorParser.AndExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorParser#comparExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparExp(CalculatorParser.ComparExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorParser#additionExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditionExp(CalculatorParser.AdditionExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorParser#multiplyExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplyExp(CalculatorParser.MultiplyExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorParser#atomExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExp(CalculatorParser.AtomExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorParser#surroundedExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSurroundedExpression(CalculatorParser.SurroundedExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorParser#doubleExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleExp(CalculatorParser.DoubleExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorParser#integerExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerExp(CalculatorParser.IntegerExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorParser#booleanExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanExp(CalculatorParser.BooleanExpContext ctx);
}