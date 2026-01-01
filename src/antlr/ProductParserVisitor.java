// Generated from C:/Users/ASUS/IdeaProjects/FlaskTemplateCompiler/src/antlr/ProductParser.g4 by ANTLR 4.13.2
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ProductParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ProductParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ProductParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(ProductParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProductParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(ProductParser.FileContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProductParser#importStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportStmt(ProductParser.ImportStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProductParser#importItems}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportItems(ProductParser.ImportItemsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProductParser#importItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportItem(ProductParser.ImportItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProductParser#importJsItems}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportJsItems(ProductParser.ImportJsItemsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProductParser#appInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAppInit(ProductParser.AppInitContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProductParser#dataBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataBlock(ProductParser.DataBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProductParser#addBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddBlock(ProductParser.AddBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProductParser#dictAssign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDictAssign(ProductParser.DictAssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProductParser#productFields}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProductFields(ProductParser.ProductFieldsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProductParser#field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField(ProductParser.FieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProductParser#singleTag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleTag(ProductParser.SingleTagContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProductParser#closeSingleTag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCloseSingleTag(ProductParser.CloseSingleTagContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProductParser#id_id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId_id(ProductParser.Id_idContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProductParser#bodyCSS}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBodyCSS(ProductParser.BodyCSSContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProductParser#jinjatemplete}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjatemplete(ProductParser.JinjatempleteContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProductParser#elseElif}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseElif(ProductParser.ElseElifContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProductParser#if_statment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_statment(ProductParser.If_statmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProductParser#htmlTag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlTag(ProductParser.HtmlTagContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProductParser#fortemplete}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFortemplete(ProductParser.FortempleteContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProductParser#valueHtmlL}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueHtmlL(ProductParser.ValueHtmlLContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProductParser#htmlTemplate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlTemplate(ProductParser.HtmlTemplateContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProductParser#routeDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRouteDef(ProductParser.RouteDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProductParser#paramList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamList(ProductParser.ParamListContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProductParser#routeBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRouteBody(ProductParser.RouteBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProductParser#returnStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(ProductParser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProductParser#formHandler}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormHandler(ProductParser.FormHandlerContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProductParser#requestMethodIsPost}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRequestMethodIsPost(ProductParser.RequestMethodIsPostContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProductParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(ProductParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProductParser#target}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTarget(ProductParser.TargetContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProductParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(ProductParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProductParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(ProductParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProductParser#suffix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuffix(ProductParser.SuffixContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProductParser#dictLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDictLiteral(ProductParser.DictLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProductParser#listLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListLiteral(ProductParser.ListLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProductParser#exprList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprList(ProductParser.ExprListContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProductParser#listComprehension}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListComprehension(ProductParser.ListComprehensionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProductParser#compFor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompFor(ProductParser.CompForContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProductParser#compCond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompCond(ProductParser.CompCondContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProductParser#leftOperand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeftOperand(ProductParser.LeftOperandContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProductParser#rightOperand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRightOperand(ProductParser.RightOperandContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProductParser#comparator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparator(ProductParser.ComparatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProductParser#runStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRunStmt(ProductParser.RunStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProductParser#mainCheck}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainCheck(ProductParser.MainCheckContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProductParser#runArgs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRunArgs(ProductParser.RunArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProductParser#arg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArg(ProductParser.ArgContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProductParser#jsInstruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsInstruction(ProductParser.JsInstructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProductParser#function_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_declaration(ProductParser.Function_declarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProductParser#function_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_body(ProductParser.Function_bodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProductParser#instruction_js}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruction_js(ProductParser.Instruction_jsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProductParser#return_js}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_js(ProductParser.Return_jsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProductParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_call(ProductParser.Function_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProductParser#variabe}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariabe(ProductParser.VariabeContext ctx);
}