package ru.spb.hse.tukh.hw01;// Generated from /home/igor/AU/3rd course/scala-2018/src/main/antlr4/Exp.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExpParser}.
 */
public interface ExpListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExpParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(ExpParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(ExpParser.ExpressionContext ctx);
}