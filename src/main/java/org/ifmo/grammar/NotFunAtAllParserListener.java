// Generated from /home/aleks/Documents/edu/scala-2018/src/main/antlr/NotFunAtAllParser.g4 by ANTLR 4.7
package org.ifmo.grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link NotFunAtAllParser}.
 */
public interface NotFunAtAllParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link NotFunAtAllParser#bool_literal}.
	 * @param ctx the parse tree
	 */
	void enterBool_literal(NotFunAtAllParser.Bool_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link NotFunAtAllParser#bool_literal}.
	 * @param ctx the parse tree
	 */
	void exitBool_literal(NotFunAtAllParser.Bool_literalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalCompareExpr}
	 * labeled alternative in {@link NotFunAtAllParser#logical_expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalCompareExpr(NotFunAtAllParser.LogicalCompareExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalCompareExpr}
	 * labeled alternative in {@link NotFunAtAllParser#logical_expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalCompareExpr(NotFunAtAllParser.LogicalCompareExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalBinaryExpr}
	 * labeled alternative in {@link NotFunAtAllParser#logical_expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalBinaryExpr(NotFunAtAllParser.LogicalBinaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalBinaryExpr}
	 * labeled alternative in {@link NotFunAtAllParser#logical_expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalBinaryExpr(NotFunAtAllParser.LogicalBinaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalParensExpr}
	 * labeled alternative in {@link NotFunAtAllParser#logical_expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalParensExpr(NotFunAtAllParser.LogicalParensExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalParensExpr}
	 * labeled alternative in {@link NotFunAtAllParser#logical_expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalParensExpr(NotFunAtAllParser.LogicalParensExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalAtomExpr}
	 * labeled alternative in {@link NotFunAtAllParser#logical_expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalAtomExpr(NotFunAtAllParser.LogicalAtomExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalAtomExpr}
	 * labeled alternative in {@link NotFunAtAllParser#logical_expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalAtomExpr(NotFunAtAllParser.LogicalAtomExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NotFunAtAllParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(NotFunAtAllParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link NotFunAtAllParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(NotFunAtAllParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link NotFunAtAllParser#logical_op}.
	 * @param ctx the parse tree
	 */
	void enterLogical_op(NotFunAtAllParser.Logical_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link NotFunAtAllParser#logical_op}.
	 * @param ctx the parse tree
	 */
	void exitLogical_op(NotFunAtAllParser.Logical_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link NotFunAtAllParser#compare_op}.
	 * @param ctx the parse tree
	 */
	void enterCompare_op(NotFunAtAllParser.Compare_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link NotFunAtAllParser#compare_op}.
	 * @param ctx the parse tree
	 */
	void exitCompare_op(NotFunAtAllParser.Compare_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link NotFunAtAllParser#plumin}.
	 * @param ctx the parse tree
	 */
	void enterPlumin(NotFunAtAllParser.PluminContext ctx);
	/**
	 * Exit a parse tree produced by {@link NotFunAtAllParser#plumin}.
	 * @param ctx the parse tree
	 */
	void exitPlumin(NotFunAtAllParser.PluminContext ctx);
	/**
	 * Enter a parse tree produced by {@link NotFunAtAllParser#divast}.
	 * @param ctx the parse tree
	 */
	void enterDivast(NotFunAtAllParser.DivastContext ctx);
	/**
	 * Exit a parse tree produced by {@link NotFunAtAllParser#divast}.
	 * @param ctx the parse tree
	 */
	void exitDivast(NotFunAtAllParser.DivastContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArithmeticParensExpr}
	 * labeled alternative in {@link NotFunAtAllParser#arithm_expr}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticParensExpr(NotFunAtAllParser.ArithmeticParensExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArithmeticParensExpr}
	 * labeled alternative in {@link NotFunAtAllParser#arithm_expr}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticParensExpr(NotFunAtAllParser.ArithmeticParensExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArithmeticDABinaryExpr}
	 * labeled alternative in {@link NotFunAtAllParser#arithm_expr}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticDABinaryExpr(NotFunAtAllParser.ArithmeticDABinaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArithmeticDABinaryExpr}
	 * labeled alternative in {@link NotFunAtAllParser#arithm_expr}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticDABinaryExpr(NotFunAtAllParser.ArithmeticDABinaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArithmeticPMBinaryExpr}
	 * labeled alternative in {@link NotFunAtAllParser#arithm_expr}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticPMBinaryExpr(NotFunAtAllParser.ArithmeticPMBinaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArithmeticPMBinaryExpr}
	 * labeled alternative in {@link NotFunAtAllParser#arithm_expr}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticPMBinaryExpr(NotFunAtAllParser.ArithmeticPMBinaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArithmeticAtomExpr}
	 * labeled alternative in {@link NotFunAtAllParser#arithm_expr}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticAtomExpr(NotFunAtAllParser.ArithmeticAtomExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArithmeticAtomExpr}
	 * labeled alternative in {@link NotFunAtAllParser#arithm_expr}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticAtomExpr(NotFunAtAllParser.ArithmeticAtomExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link NotFunAtAllParser#binary_expr}.
	 * @param ctx the parse tree
	 */
	void enterBinary_expr(NotFunAtAllParser.Binary_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link NotFunAtAllParser#binary_expr}.
	 * @param ctx the parse tree
	 */
	void exitBinary_expr(NotFunAtAllParser.Binary_exprContext ctx);
}