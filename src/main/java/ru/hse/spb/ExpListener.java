package ru.hse.spb;// Generated from /Users/User/Documents/Study/SpbAU3/Scala/scala-2018/src/main/antlr4/Exp.g4 by ANTLR 4.7
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
	/**
	 * Enter a parse tree produced by {@link ExpParser#andExp}.
	 * @param ctx the parse tree
	 */
	void enterAndExp(ExpParser.AndExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#andExp}.
	 * @param ctx the parse tree
	 */
	void exitAndExp(ExpParser.AndExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpParser#equalsExp}.
	 * @param ctx the parse tree
	 */
	void enterEqualsExp(ExpParser.EqualsExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#equalsExp}.
	 * @param ctx the parse tree
	 */
	void exitEqualsExp(ExpParser.EqualsExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpParser#compareExp}.
	 * @param ctx the parse tree
	 */
	void enterCompareExp(ExpParser.CompareExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#compareExp}.
	 * @param ctx the parse tree
	 */
	void exitCompareExp(ExpParser.CompareExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpParser#plusExp}.
	 * @param ctx the parse tree
	 */
	void enterPlusExp(ExpParser.PlusExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#plusExp}.
	 * @param ctx the parse tree
	 */
	void exitPlusExp(ExpParser.PlusExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpParser#multExp}.
	 * @param ctx the parse tree
	 */
	void enterMultExp(ExpParser.MultExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#multExp}.
	 * @param ctx the parse tree
	 */
	void exitMultExp(ExpParser.MultExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(ExpParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(ExpParser.LiteralContext ctx);
}