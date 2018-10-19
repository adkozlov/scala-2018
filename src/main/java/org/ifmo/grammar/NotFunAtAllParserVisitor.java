// Generated from /home/aleks/Documents/edu/scala-2018/src/main/antlr/NotFunAtAllParser.g4 by ANTLR 4.7
package org.ifmo.grammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link NotFunAtAllParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface NotFunAtAllParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link NotFunAtAllParser#bool_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool_literal(NotFunAtAllParser.Bool_literalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicalCompareExpr}
	 * labeled alternative in {@link NotFunAtAllParser#logical_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalCompareExpr(NotFunAtAllParser.LogicalCompareExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicalBinaryExpr}
	 * labeled alternative in {@link NotFunAtAllParser#logical_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalBinaryExpr(NotFunAtAllParser.LogicalBinaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicalParensExpr}
	 * labeled alternative in {@link NotFunAtAllParser#logical_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalParensExpr(NotFunAtAllParser.LogicalParensExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicalAtomExpr}
	 * labeled alternative in {@link NotFunAtAllParser#logical_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalAtomExpr(NotFunAtAllParser.LogicalAtomExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NotFunAtAllParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(NotFunAtAllParser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link NotFunAtAllParser#logical_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogical_op(NotFunAtAllParser.Logical_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link NotFunAtAllParser#compare_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompare_op(NotFunAtAllParser.Compare_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link NotFunAtAllParser#plumin}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlumin(NotFunAtAllParser.PluminContext ctx);
	/**
	 * Visit a parse tree produced by {@link NotFunAtAllParser#divast}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivast(NotFunAtAllParser.DivastContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArithmeticParensExpr}
	 * labeled alternative in {@link NotFunAtAllParser#arithm_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticParensExpr(NotFunAtAllParser.ArithmeticParensExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArithmeticDABinaryExpr}
	 * labeled alternative in {@link NotFunAtAllParser#arithm_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticDABinaryExpr(NotFunAtAllParser.ArithmeticDABinaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArithmeticPMBinaryExpr}
	 * labeled alternative in {@link NotFunAtAllParser#arithm_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticPMBinaryExpr(NotFunAtAllParser.ArithmeticPMBinaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArithmeticAtomExpr}
	 * labeled alternative in {@link NotFunAtAllParser#arithm_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticAtomExpr(NotFunAtAllParser.ArithmeticAtomExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link NotFunAtAllParser#binary_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinary_expr(NotFunAtAllParser.Binary_exprContext ctx);
}