// Generated from /Users/aleksandra.orlova/Documents/JVM HW/scala-2018/src/main/antlr/Exp.g4 by ANTLR 4.7
package ru.spbau.jvm.scala.homework1;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExpParser}.
 */
public interface ExpListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExpParser#calc}.
	 * @param ctx the parse tree
	 */
	void enterCalc(ExpParser.CalcContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#calc}.
	 * @param ctx the parse tree
	 */
	void exitCalc(ExpParser.CalcContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(ExpParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(ExpParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpParser#negative_Number}.
	 * @param ctx the parse tree
	 */
	void enterNegative_Number(ExpParser.Negative_NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#negative_Number}.
	 * @param ctx the parse tree
	 */
	void exitNegative_Number(ExpParser.Negative_NumberContext ctx);
}