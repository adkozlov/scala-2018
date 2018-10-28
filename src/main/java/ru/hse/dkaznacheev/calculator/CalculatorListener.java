package ru.hse.dkaznacheev.calculator;

// Generated from /home/dk/scala-2018/src/main/antlr/Calculator.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CalculatorParser}.
 */
public interface CalculatorListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#calculator}.
	 * @param ctx the parse tree
	 */
	void enterCalculator(CalculatorParser.CalculatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#calculator}.
	 * @param ctx the parse tree
	 */
	void exitCalculator(CalculatorParser.CalculatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(CalculatorParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(CalculatorParser.ExpressionContext ctx);
}