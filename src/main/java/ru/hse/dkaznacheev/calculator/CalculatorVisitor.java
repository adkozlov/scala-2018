package ru.hse.dkaznacheev.calculator;

// Generated from /home/dk/scala-2018/src/main/antlr/Calculator.g4 by ANTLR 4.7
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
	 * Visit a parse tree produced by {@link CalculatorParser#calculator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCalculator(CalculatorParser.CalculatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(CalculatorParser.ExpressionContext ctx);
}