// Generated from C:/Users/machine/Documents/github/scala-2018/src/main/antlr\Calculator.g4 by ANTLR 4.7
package ru.hse.scala.nedikov.calculator;
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
	 * Visit a parse tree produced by {@link CalculatorParser#eval}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEval(CalculatorParser.EvalContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorParser#doubleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleExpression(CalculatorParser.DoubleExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorParser#booleanExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanExpression(CalculatorParser.BooleanExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorParser#atomDouble}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomDouble(CalculatorParser.AtomDoubleContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorParser#atomBoolean}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomBoolean(CalculatorParser.AtomBooleanContext ctx);
}