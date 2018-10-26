// Generated from /Users/vladislavkalinin/IdeaProjects/scala-2018/src/main/antlr4/Calculator.g4 by ANTLR 4.7
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CalculatorParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CalculatorVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CalculatorParser#calculator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCalculator(CalculatorParser.CalculatorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicalCompareExpr}
	 * labeled alternative in {@link CalculatorParser#logic_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalCompareExpr(CalculatorParser.LogicalCompareExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicalBinaryExpr}
	 * labeled alternative in {@link CalculatorParser#logic_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalBinaryExpr(CalculatorParser.LogicalBinaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicalParensExpr}
	 * labeled alternative in {@link CalculatorParser#logic_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalParensExpr(CalculatorParser.LogicalParensExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicalAtomExpr}
	 * labeled alternative in {@link CalculatorParser#logic_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalAtomExpr(CalculatorParser.LogicalAtomExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArithmeticParensExpr}
	 * labeled alternative in {@link CalculatorParser#arithm_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticParensExpr(CalculatorParser.ArithmeticParensExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArithmeticExponentExpr}
	 * labeled alternative in {@link CalculatorParser#arithm_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticExponentExpr(CalculatorParser.ArithmeticExponentExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArithmeticPrior2BinaryExpr}
	 * labeled alternative in {@link CalculatorParser#arithm_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticPrior2BinaryExpr(CalculatorParser.ArithmeticPrior2BinaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArithmeticAtomExpr}
	 * labeled alternative in {@link CalculatorParser#arithm_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticAtomExpr(CalculatorParser.ArithmeticAtomExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArithmeticPrior1BinaryExpr}
	 * labeled alternative in {@link CalculatorParser#arithm_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticPrior1BinaryExpr(CalculatorParser.ArithmeticPrior1BinaryExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorParser#arithm_prior1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithm_prior1(CalculatorParser.Arithm_prior1Context ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorParser#arithm_prior2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithm_prior2(CalculatorParser.Arithm_prior2Context ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorParser#exponent_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExponent_op(CalculatorParser.Exponent_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorParser#compare_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompare_op(CalculatorParser.Compare_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorParser#logic_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogic_op(CalculatorParser.Logic_opContext ctx);
}