// Generated from /home/dmitry/HW/scala-2018/src/main/antlr4/ExprGrammar.g4 by ANTLR 4.7
package ru.hse.spb.kazakov;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ExprGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ExprGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code arithmetic}
	 * labeled alternative in {@link ExprGrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmetic(ExprGrammarParser.ArithmeticContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolean}
	 * labeled alternative in {@link ExprGrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean(ExprGrammarParser.BooleanContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprGrammarParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticExpression(ExprGrammarParser.ArithmeticExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprGrammarParser#booleanExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanExpression(ExprGrammarParser.BooleanExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprGrammarParser#booleanAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanAtom(ExprGrammarParser.BooleanAtomContext ctx);
}