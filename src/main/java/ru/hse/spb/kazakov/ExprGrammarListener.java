// Generated from /home/dmitry/HW/scala-2018/src/main/antlr4/ExprGrammar.g4 by ANTLR 4.7
package ru.hse.spb.kazakov;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExprGrammarParser}.
 */
public interface ExprGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExprGrammarParser#parse}.
	 * @param ctx the parse tree
	 */
	void enterParse(ExprGrammarParser.ParseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprGrammarParser#parse}.
	 * @param ctx the parse tree
	 */
	void exitParse(ExprGrammarParser.ParseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(ExprGrammarParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(ExprGrammarParser.ExpressionContext ctx);
}