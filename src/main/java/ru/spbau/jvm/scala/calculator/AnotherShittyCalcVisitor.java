// Generated from /home/jetbrains/au_docs_ijJ9eOA8/Kotlin_Scala/scala-2018/src/main/antlr/AnotherShittyCalc.g4 by ANTLR 4.7
package ru.spbau.jvm.scala.calculator;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link AnotherShittyCalcParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface AnotherShittyCalcVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link AnotherShittyCalcParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(AnotherShittyCalcParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnotherShittyCalcParser#logicExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicExpr(AnotherShittyCalcParser.LogicExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnotherShittyCalcParser#intExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntExpr(AnotherShittyCalcParser.IntExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnotherShittyCalcParser#logicOrExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicOrExpr(AnotherShittyCalcParser.LogicOrExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnotherShittyCalcParser#logicAndExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicAndExpr(AnotherShittyCalcParser.LogicAndExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnotherShittyCalcParser#atomLogicExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomLogicExpr(AnotherShittyCalcParser.AtomLogicExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnotherShittyCalcParser#equalityExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpr(AnotherShittyCalcParser.EqualityExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnotherShittyCalcParser#additionExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditionExp(AnotherShittyCalcParser.AdditionExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnotherShittyCalcParser#multiplyExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplyExp(AnotherShittyCalcParser.MultiplyExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link AnotherShittyCalcParser#atomExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExp(AnotherShittyCalcParser.AtomExpContext ctx);
}