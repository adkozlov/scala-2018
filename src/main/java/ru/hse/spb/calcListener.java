package ru.hse.spb;// Generated from /Users/psolikov/Scala/scala-2018/src/main/antlr/calc.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link calcParser}.
 */
public interface calcListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code ToSetVar}
	 * labeled alternative in {@link calcParser#input}.
	 * @param ctx the parse tree
	 */
	void enterToSetVar(calcParser.ToSetVarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToSetVar}
	 * labeled alternative in {@link calcParser#input}.
	 * @param ctx the parse tree
	 */
	void exitToSetVar(calcParser.ToSetVarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Calculate}
	 * labeled alternative in {@link calcParser#input}.
	 * @param ctx the parse tree
	 */
	void enterCalculate(calcParser.CalculateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Calculate}
	 * labeled alternative in {@link calcParser#input}.
	 * @param ctx the parse tree
	 */
	void exitCalculate(calcParser.CalculateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SetVariable}
	 * labeled alternative in {@link calcParser#setVar}.
	 * @param ctx the parse tree
	 */
	void enterSetVariable(calcParser.SetVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SetVariable}
	 * labeled alternative in {@link calcParser#setVar}.
	 * @param ctx the parse tree
	 */
	void exitSetVariable(calcParser.SetVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ToMultOrDiv}
	 * labeled alternative in {@link calcParser#plusOrMinus}.
	 * @param ctx the parse tree
	 */
	void enterToMultOrDiv(calcParser.ToMultOrDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToMultOrDiv}
	 * labeled alternative in {@link calcParser#plusOrMinus}.
	 * @param ctx the parse tree
	 */
	void exitToMultOrDiv(calcParser.ToMultOrDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Plus}
	 * labeled alternative in {@link calcParser#plusOrMinus}.
	 * @param ctx the parse tree
	 */
	void enterPlus(calcParser.PlusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Plus}
	 * labeled alternative in {@link calcParser#plusOrMinus}.
	 * @param ctx the parse tree
	 */
	void exitPlus(calcParser.PlusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Minus}
	 * labeled alternative in {@link calcParser#plusOrMinus}.
	 * @param ctx the parse tree
	 */
	void enterMinus(calcParser.MinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Minus}
	 * labeled alternative in {@link calcParser#plusOrMinus}.
	 * @param ctx the parse tree
	 */
	void exitMinus(calcParser.MinusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Multiplication}
	 * labeled alternative in {@link calcParser#multOrDiv}.
	 * @param ctx the parse tree
	 */
	void enterMultiplication(calcParser.MultiplicationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Multiplication}
	 * labeled alternative in {@link calcParser#multOrDiv}.
	 * @param ctx the parse tree
	 */
	void exitMultiplication(calcParser.MultiplicationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Division}
	 * labeled alternative in {@link calcParser#multOrDiv}.
	 * @param ctx the parse tree
	 */
	void enterDivision(calcParser.DivisionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Division}
	 * labeled alternative in {@link calcParser#multOrDiv}.
	 * @param ctx the parse tree
	 */
	void exitDivision(calcParser.DivisionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ToPow}
	 * labeled alternative in {@link calcParser#multOrDiv}.
	 * @param ctx the parse tree
	 */
	void enterToPow(calcParser.ToPowContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToPow}
	 * labeled alternative in {@link calcParser#multOrDiv}.
	 * @param ctx the parse tree
	 */
	void exitToPow(calcParser.ToPowContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SimplePow}
	 * labeled alternative in {@link calcParser#pow}.
	 * @param ctx the parse tree
	 */
	void enterSimplePow(calcParser.SimplePowContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SimplePow}
	 * labeled alternative in {@link calcParser#pow}.
	 * @param ctx the parse tree
	 */
	void exitSimplePow(calcParser.SimplePowContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ComplexPow}
	 * labeled alternative in {@link calcParser#pow}.
	 * @param ctx the parse tree
	 */
	void enterComplexPow(calcParser.ComplexPowContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ComplexPow}
	 * labeled alternative in {@link calcParser#pow}.
	 * @param ctx the parse tree
	 */
	void exitComplexPow(calcParser.ComplexPowContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ChangeSign}
	 * labeled alternative in {@link calcParser#unaryMinus}.
	 * @param ctx the parse tree
	 */
	void enterChangeSign(calcParser.ChangeSignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ChangeSign}
	 * labeled alternative in {@link calcParser#unaryMinus}.
	 * @param ctx the parse tree
	 */
	void exitChangeSign(calcParser.ChangeSignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ToAtom}
	 * labeled alternative in {@link calcParser#unaryMinus}.
	 * @param ctx the parse tree
	 */
	void enterToAtom(calcParser.ToAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToAtom}
	 * labeled alternative in {@link calcParser#unaryMinus}.
	 * @param ctx the parse tree
	 */
	void exitToAtom(calcParser.ToAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConstantPI}
	 * labeled alternative in {@link calcParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterConstantPI(calcParser.ConstantPIContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConstantPI}
	 * labeled alternative in {@link calcParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitConstantPI(calcParser.ConstantPIContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConstantE}
	 * labeled alternative in {@link calcParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterConstantE(calcParser.ConstantEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConstantE}
	 * labeled alternative in {@link calcParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitConstantE(calcParser.ConstantEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Double}
	 * labeled alternative in {@link calcParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterDouble(calcParser.DoubleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Double}
	 * labeled alternative in {@link calcParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitDouble(calcParser.DoubleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Int}
	 * labeled alternative in {@link calcParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterInt(calcParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Int}
	 * labeled alternative in {@link calcParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitInt(calcParser.IntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Braces}
	 * labeled alternative in {@link calcParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterBraces(calcParser.BracesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Braces}
	 * labeled alternative in {@link calcParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitBraces(calcParser.BracesContext ctx);
}