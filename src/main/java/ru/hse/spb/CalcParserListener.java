// Generated from /home/zoldater/Documents/au/scala-2018/src/main/antlr4/CalcParser.g4 by ANTLR 4.7
package ru.hse.spb;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CalcParser}.
 */
public interface CalcParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code operationUnitExpr}
	 * labeled alternative in {@link CalcParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterOperationUnitExpr(CalcParser.OperationUnitExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code operationUnitExpr}
	 * labeled alternative in {@link CalcParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitOperationUnitExpr(CalcParser.OperationUnitExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code paranthesisExpr}
	 * labeled alternative in {@link CalcParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParanthesisExpr(CalcParser.ParanthesisExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code paranthesisExpr}
	 * labeled alternative in {@link CalcParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParanthesisExpr(CalcParser.ParanthesisExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code comparisonExpr}
	 * labeled alternative in {@link CalcParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterComparisonExpr(CalcParser.ComparisonExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comparisonExpr}
	 * labeled alternative in {@link CalcParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitComparisonExpr(CalcParser.ComparisonExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code additiveExpr}
	 * labeled alternative in {@link CalcParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpr(CalcParser.AdditiveExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code additiveExpr}
	 * labeled alternative in {@link CalcParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpr(CalcParser.AdditiveExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link CalcParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpr(CalcParser.BoolExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link CalcParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpr(CalcParser.BoolExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multExpr}
	 * labeled alternative in {@link CalcParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMultExpr(CalcParser.MultExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multExpr}
	 * labeled alternative in {@link CalcParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMultExpr(CalcParser.MultExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unitLiteral}
	 * labeled alternative in {@link CalcParser#operationUnit}.
	 * @param ctx the parse tree
	 */
	void enterUnitLiteral(CalcParser.UnitLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unitLiteral}
	 * labeled alternative in {@link CalcParser#operationUnit}.
	 * @param ctx the parse tree
	 */
	void exitUnitLiteral(CalcParser.UnitLiteralContext ctx);
}