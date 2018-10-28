// Generated from /Users/aleksandra.orlova/Documents/JVM HW/scala-2018/src/main/antlr/Exp.g4 by ANTLR 4.7
package ru.spbau.jvm.scala.homework1;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ExpParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ExpVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ExpParser#calc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCalc(ExpParser.CalcContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(ExpParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#negative_Number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegative_Number(ExpParser.Negative_NumberContext ctx);
}