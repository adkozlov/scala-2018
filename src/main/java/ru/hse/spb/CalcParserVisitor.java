// Generated from /home/zoldater/Documents/au/scala-2018/src/main/antlr4/CalcParser.g4 by ANTLR 4.7
package ru.hse.spb;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CalcParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CalcParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code operationUnitExpr}
	 * labeled alternative in {@link CalcParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperationUnitExpr(CalcParser.OperationUnitExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code paranthesisExpr}
	 * labeled alternative in {@link CalcParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParanthesisExpr(CalcParser.ParanthesisExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code comparisonExpr}
	 * labeled alternative in {@link CalcParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonExpr(CalcParser.ComparisonExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code additiveExpr}
	 * labeled alternative in {@link CalcParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpr(CalcParser.AdditiveExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link CalcParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolExpr(CalcParser.BoolExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multExpr}
	 * labeled alternative in {@link CalcParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultExpr(CalcParser.MultExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unitLiteral}
	 * labeled alternative in {@link CalcParser#operationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnitLiteral(CalcParser.UnitLiteralContext ctx);
}