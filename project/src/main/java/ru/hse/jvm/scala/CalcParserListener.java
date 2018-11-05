package ru.hse.jvm.scala;// Generated from /home/mikhail/myutman/Documents/SPbAU/scala-2018/project/src/main/antlr4/CalcParser.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CalcParser}.
 */
public interface CalcParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CalcParser#eval}.
	 * @param ctx the parse tree
	 */
	void enterEval(CalcParser.EvalContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#eval}.
	 * @param ctx the parse tree
	 */
	void exitEval(CalcParser.EvalContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalcParser#additionExp}.
	 * @param ctx the parse tree
	 */
	void enterAdditionExp(CalcParser.AdditionExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#additionExp}.
	 * @param ctx the parse tree
	 */
	void exitAdditionExp(CalcParser.AdditionExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalcParser#multiplyExp}.
	 * @param ctx the parse tree
	 */
	void enterMultiplyExp(CalcParser.MultiplyExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#multiplyExp}.
	 * @param ctx the parse tree
	 */
	void exitMultiplyExp(CalcParser.MultiplyExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalcParser#atomExp}.
	 * @param ctx the parse tree
	 */
	void enterAtomExp(CalcParser.AtomExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#atomExp}.
	 * @param ctx the parse tree
	 */
	void exitAtomExp(CalcParser.AtomExpContext ctx);
}