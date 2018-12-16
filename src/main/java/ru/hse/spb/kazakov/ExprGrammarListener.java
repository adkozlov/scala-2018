// Generated from /home/dmitry/HW/scala-2018/src/main/antlr4/ExprGrammar.g4 by ANTLR 4.7
package ru.hse.spb.kazakov;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExprGrammarParser}.
 */
public interface ExprGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code arithmetic}
	 * labeled alternative in {@link ExprGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterArithmetic(ExprGrammarParser.ArithmeticContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arithmetic}
	 * labeled alternative in {@link ExprGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitArithmetic(ExprGrammarParser.ArithmeticContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolean}
	 * labeled alternative in {@link ExprGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBoolean(ExprGrammarParser.BooleanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolean}
	 * labeled alternative in {@link ExprGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBoolean(ExprGrammarParser.BooleanContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprGrammarParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticExpression(ExprGrammarParser.ArithmeticExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprGrammarParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticExpression(ExprGrammarParser.ArithmeticExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprGrammarParser#booleanExpression}.
	 * @param ctx the parse tree
	 */
	void enterBooleanExpression(ExprGrammarParser.BooleanExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprGrammarParser#booleanExpression}.
	 * @param ctx the parse tree
	 */
	void exitBooleanExpression(ExprGrammarParser.BooleanExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprGrammarParser#booleanAtom}.
	 * @param ctx the parse tree
	 */
	void enterBooleanAtom(ExprGrammarParser.BooleanAtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprGrammarParser#booleanAtom}.
	 * @param ctx the parse tree
	 */
	void exitBooleanAtom(ExprGrammarParser.BooleanAtomContext ctx);
}