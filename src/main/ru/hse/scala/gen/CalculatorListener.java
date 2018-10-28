// Generated from C:/Users/olga/SPbAU/2018-2019/scala-2018/src/main/antlr\Calculator.g4 by ANTLR 4.7
package ru.hse.scala.gen;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CalculatorParser}.
 */
public interface CalculatorListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(CalculatorParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(CalculatorParser.StatementContext ctx);
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
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#orExp}.
	 * @param ctx the parse tree
	 */
	void enterOrExp(CalculatorParser.OrExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#orExp}.
	 * @param ctx the parse tree
	 */
	void exitOrExp(CalculatorParser.OrExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#andExp}.
	 * @param ctx the parse tree
	 */
	void enterAndExp(CalculatorParser.AndExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#andExp}.
	 * @param ctx the parse tree
	 */
	void exitAndExp(CalculatorParser.AndExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#comparExp}.
	 * @param ctx the parse tree
	 */
	void enterComparExp(CalculatorParser.ComparExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#comparExp}.
	 * @param ctx the parse tree
	 */
	void exitComparExp(CalculatorParser.ComparExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#additionExp}.
	 * @param ctx the parse tree
	 */
	void enterAdditionExp(CalculatorParser.AdditionExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#additionExp}.
	 * @param ctx the parse tree
	 */
	void exitAdditionExp(CalculatorParser.AdditionExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#multiplyExp}.
	 * @param ctx the parse tree
	 */
	void enterMultiplyExp(CalculatorParser.MultiplyExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#multiplyExp}.
	 * @param ctx the parse tree
	 */
	void exitMultiplyExp(CalculatorParser.MultiplyExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#atomExp}.
	 * @param ctx the parse tree
	 */
	void enterAtomExp(CalculatorParser.AtomExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#atomExp}.
	 * @param ctx the parse tree
	 */
	void exitAtomExp(CalculatorParser.AtomExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#surroundedExpression}.
	 * @param ctx the parse tree
	 */
	void enterSurroundedExpression(CalculatorParser.SurroundedExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#surroundedExpression}.
	 * @param ctx the parse tree
	 */
	void exitSurroundedExpression(CalculatorParser.SurroundedExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#doubleExp}.
	 * @param ctx the parse tree
	 */
	void enterDoubleExp(CalculatorParser.DoubleExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#doubleExp}.
	 * @param ctx the parse tree
	 */
	void exitDoubleExp(CalculatorParser.DoubleExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#integerExp}.
	 * @param ctx the parse tree
	 */
	void enterIntegerExp(CalculatorParser.IntegerExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#integerExp}.
	 * @param ctx the parse tree
	 */
	void exitIntegerExp(CalculatorParser.IntegerExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#booleanExp}.
	 * @param ctx the parse tree
	 */
	void enterBooleanExp(CalculatorParser.BooleanExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#booleanExp}.
	 * @param ctx the parse tree
	 */
	void exitBooleanExp(CalculatorParser.BooleanExpContext ctx);
}