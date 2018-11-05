package ru.hse.jvm.scala;// Generated from /home/mikhail/myutman/Documents/SPbAU/scala-2018/project/src/main/antlr4/CalcParser.g4 by ANTLR 4.7
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
	 * Visit a parse tree produced by {@link CalcParser#eval}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEval(CalcParser.EvalContext ctx);
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