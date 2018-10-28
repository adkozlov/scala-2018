package ru.hse.spb;// Generated from /Users/User/Documents/Study/SpbAU3/Scala/scala-2018/src/main/antlr4/Exp.g4 by ANTLR 4.7
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
	 * Visit a parse tree produced by {@link ExpParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(ExpParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#andExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExp(ExpParser.AndExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#equalsExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualsExp(ExpParser.EqualsExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#compareExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompareExp(ExpParser.CompareExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#plusExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusExp(ExpParser.PlusExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#multExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultExp(ExpParser.MultExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(ExpParser.LiteralContext ctx);
}