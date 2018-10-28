// Generated from C:/Users/machine/Documents/github/scala-2018/src/main/antlr\Calculator.g4 by ANTLR 4.7
package ru.hse.scala.nedikov.calculator;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CalculatorParser}.
 */
public interface CalculatorListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#eval}.
	 * @param ctx the parse tree
	 */
	void enterEval(CalculatorParser.EvalContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#eval}.
	 * @param ctx the parse tree
	 */
	void exitEval(CalculatorParser.EvalContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#doubleExpression}.
	 * @param ctx the parse tree
	 */
	void enterDoubleExpression(CalculatorParser.DoubleExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#doubleExpression}.
	 * @param ctx the parse tree
	 */
	void exitDoubleExpression(CalculatorParser.DoubleExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#booleanExpression}.
	 * @param ctx the parse tree
	 */
	void enterBooleanExpression(CalculatorParser.BooleanExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#booleanExpression}.
	 * @param ctx the parse tree
	 */
	void exitBooleanExpression(CalculatorParser.BooleanExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#atomDouble}.
	 * @param ctx the parse tree
	 */
	void enterAtomDouble(CalculatorParser.AtomDoubleContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#atomDouble}.
	 * @param ctx the parse tree
	 */
	void exitAtomDouble(CalculatorParser.AtomDoubleContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#atomBoolean}.
	 * @param ctx the parse tree
	 */
	void enterAtomBoolean(CalculatorParser.AtomBooleanContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#atomBoolean}.
	 * @param ctx the parse tree
	 */
	void exitAtomBoolean(CalculatorParser.AtomBooleanContext ctx);
}