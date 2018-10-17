// Generated from /home/jetbrains/au_docs_ijJ9eOA8/Kotlin_Scala/scala-2018/src/main/antlr/Calc.g4 by ANTLR 4.7
package ru.spbau.jvm.scala.calculator;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CalcParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CalcVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CalcParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(CalcParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalcParser#logicExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicExpr(CalcParser.LogicExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalcParser#intExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntExpr(CalcParser.IntExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalcParser#logicOrExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicOrExpr(CalcParser.LogicOrExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalcParser#logicAndExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicAndExpr(CalcParser.LogicAndExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalcParser#atomLogicExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomLogicExpr(CalcParser.AtomLogicExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalcParser#equalityExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpr(CalcParser.EqualityExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalcParser#additionExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditionExp(CalcParser.AdditionExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalcParser#multiplyExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplyExp(CalcParser.MultiplyExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalcParser#atomExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExp(CalcParser.AtomExpContext ctx);
}