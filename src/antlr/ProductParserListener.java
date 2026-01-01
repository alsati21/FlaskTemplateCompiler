// Generated from C:/Users/ASUS/IdeaProjects/FlaskTemplateCompiler/src/antlr/ProductParser.g4 by ANTLR 4.13.2
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ProductParser}.
 */
public interface ProductParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ProductParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(ProductParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProductParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(ProductParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProductParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(ProductParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProductParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(ProductParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProductParser#importStmt}.
	 * @param ctx the parse tree
	 */
	void enterImportStmt(ProductParser.ImportStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProductParser#importStmt}.
	 * @param ctx the parse tree
	 */
	void exitImportStmt(ProductParser.ImportStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProductParser#importItems}.
	 * @param ctx the parse tree
	 */
	void enterImportItems(ProductParser.ImportItemsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProductParser#importItems}.
	 * @param ctx the parse tree
	 */
	void exitImportItems(ProductParser.ImportItemsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProductParser#importItem}.
	 * @param ctx the parse tree
	 */
	void enterImportItem(ProductParser.ImportItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProductParser#importItem}.
	 * @param ctx the parse tree
	 */
	void exitImportItem(ProductParser.ImportItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProductParser#importJsItems}.
	 * @param ctx the parse tree
	 */
	void enterImportJsItems(ProductParser.ImportJsItemsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProductParser#importJsItems}.
	 * @param ctx the parse tree
	 */
	void exitImportJsItems(ProductParser.ImportJsItemsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProductParser#appInit}.
	 * @param ctx the parse tree
	 */
	void enterAppInit(ProductParser.AppInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProductParser#appInit}.
	 * @param ctx the parse tree
	 */
	void exitAppInit(ProductParser.AppInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProductParser#dataBlock}.
	 * @param ctx the parse tree
	 */
	void enterDataBlock(ProductParser.DataBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProductParser#dataBlock}.
	 * @param ctx the parse tree
	 */
	void exitDataBlock(ProductParser.DataBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProductParser#addBlock}.
	 * @param ctx the parse tree
	 */
	void enterAddBlock(ProductParser.AddBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProductParser#addBlock}.
	 * @param ctx the parse tree
	 */
	void exitAddBlock(ProductParser.AddBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProductParser#dictAssign}.
	 * @param ctx the parse tree
	 */
	void enterDictAssign(ProductParser.DictAssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProductParser#dictAssign}.
	 * @param ctx the parse tree
	 */
	void exitDictAssign(ProductParser.DictAssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProductParser#productFields}.
	 * @param ctx the parse tree
	 */
	void enterProductFields(ProductParser.ProductFieldsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProductParser#productFields}.
	 * @param ctx the parse tree
	 */
	void exitProductFields(ProductParser.ProductFieldsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProductParser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(ProductParser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProductParser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(ProductParser.FieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProductParser#singleTag}.
	 * @param ctx the parse tree
	 */
	void enterSingleTag(ProductParser.SingleTagContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProductParser#singleTag}.
	 * @param ctx the parse tree
	 */
	void exitSingleTag(ProductParser.SingleTagContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProductParser#closeSingleTag}.
	 * @param ctx the parse tree
	 */
	void enterCloseSingleTag(ProductParser.CloseSingleTagContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProductParser#closeSingleTag}.
	 * @param ctx the parse tree
	 */
	void exitCloseSingleTag(ProductParser.CloseSingleTagContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProductParser#id_id}.
	 * @param ctx the parse tree
	 */
	void enterId_id(ProductParser.Id_idContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProductParser#id_id}.
	 * @param ctx the parse tree
	 */
	void exitId_id(ProductParser.Id_idContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProductParser#bodyCSS}.
	 * @param ctx the parse tree
	 */
	void enterBodyCSS(ProductParser.BodyCSSContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProductParser#bodyCSS}.
	 * @param ctx the parse tree
	 */
	void exitBodyCSS(ProductParser.BodyCSSContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProductParser#jinjatemplete}.
	 * @param ctx the parse tree
	 */
	void enterJinjatemplete(ProductParser.JinjatempleteContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProductParser#jinjatemplete}.
	 * @param ctx the parse tree
	 */
	void exitJinjatemplete(ProductParser.JinjatempleteContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProductParser#elseElif}.
	 * @param ctx the parse tree
	 */
	void enterElseElif(ProductParser.ElseElifContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProductParser#elseElif}.
	 * @param ctx the parse tree
	 */
	void exitElseElif(ProductParser.ElseElifContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProductParser#if_statment}.
	 * @param ctx the parse tree
	 */
	void enterIf_statment(ProductParser.If_statmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProductParser#if_statment}.
	 * @param ctx the parse tree
	 */
	void exitIf_statment(ProductParser.If_statmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProductParser#htmlTag}.
	 * @param ctx the parse tree
	 */
	void enterHtmlTag(ProductParser.HtmlTagContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProductParser#htmlTag}.
	 * @param ctx the parse tree
	 */
	void exitHtmlTag(ProductParser.HtmlTagContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProductParser#fortemplete}.
	 * @param ctx the parse tree
	 */
	void enterFortemplete(ProductParser.FortempleteContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProductParser#fortemplete}.
	 * @param ctx the parse tree
	 */
	void exitFortemplete(ProductParser.FortempleteContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProductParser#valueHtmlL}.
	 * @param ctx the parse tree
	 */
	void enterValueHtmlL(ProductParser.ValueHtmlLContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProductParser#valueHtmlL}.
	 * @param ctx the parse tree
	 */
	void exitValueHtmlL(ProductParser.ValueHtmlLContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProductParser#htmlTemplate}.
	 * @param ctx the parse tree
	 */
	void enterHtmlTemplate(ProductParser.HtmlTemplateContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProductParser#htmlTemplate}.
	 * @param ctx the parse tree
	 */
	void exitHtmlTemplate(ProductParser.HtmlTemplateContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProductParser#routeDef}.
	 * @param ctx the parse tree
	 */
	void enterRouteDef(ProductParser.RouteDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProductParser#routeDef}.
	 * @param ctx the parse tree
	 */
	void exitRouteDef(ProductParser.RouteDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProductParser#paramList}.
	 * @param ctx the parse tree
	 */
	void enterParamList(ProductParser.ParamListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProductParser#paramList}.
	 * @param ctx the parse tree
	 */
	void exitParamList(ProductParser.ParamListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProductParser#routeBody}.
	 * @param ctx the parse tree
	 */
	void enterRouteBody(ProductParser.RouteBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProductParser#routeBody}.
	 * @param ctx the parse tree
	 */
	void exitRouteBody(ProductParser.RouteBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProductParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(ProductParser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProductParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(ProductParser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProductParser#formHandler}.
	 * @param ctx the parse tree
	 */
	void enterFormHandler(ProductParser.FormHandlerContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProductParser#formHandler}.
	 * @param ctx the parse tree
	 */
	void exitFormHandler(ProductParser.FormHandlerContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProductParser#requestMethodIsPost}.
	 * @param ctx the parse tree
	 */
	void enterRequestMethodIsPost(ProductParser.RequestMethodIsPostContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProductParser#requestMethodIsPost}.
	 * @param ctx the parse tree
	 */
	void exitRequestMethodIsPost(ProductParser.RequestMethodIsPostContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProductParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(ProductParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProductParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(ProductParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProductParser#target}.
	 * @param ctx the parse tree
	 */
	void enterTarget(ProductParser.TargetContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProductParser#target}.
	 * @param ctx the parse tree
	 */
	void exitTarget(ProductParser.TargetContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProductParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(ProductParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProductParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(ProductParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProductParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(ProductParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProductParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(ProductParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProductParser#suffix}.
	 * @param ctx the parse tree
	 */
	void enterSuffix(ProductParser.SuffixContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProductParser#suffix}.
	 * @param ctx the parse tree
	 */
	void exitSuffix(ProductParser.SuffixContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProductParser#dictLiteral}.
	 * @param ctx the parse tree
	 */
	void enterDictLiteral(ProductParser.DictLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProductParser#dictLiteral}.
	 * @param ctx the parse tree
	 */
	void exitDictLiteral(ProductParser.DictLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProductParser#listLiteral}.
	 * @param ctx the parse tree
	 */
	void enterListLiteral(ProductParser.ListLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProductParser#listLiteral}.
	 * @param ctx the parse tree
	 */
	void exitListLiteral(ProductParser.ListLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProductParser#exprList}.
	 * @param ctx the parse tree
	 */
	void enterExprList(ProductParser.ExprListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProductParser#exprList}.
	 * @param ctx the parse tree
	 */
	void exitExprList(ProductParser.ExprListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProductParser#listComprehension}.
	 * @param ctx the parse tree
	 */
	void enterListComprehension(ProductParser.ListComprehensionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProductParser#listComprehension}.
	 * @param ctx the parse tree
	 */
	void exitListComprehension(ProductParser.ListComprehensionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProductParser#compFor}.
	 * @param ctx the parse tree
	 */
	void enterCompFor(ProductParser.CompForContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProductParser#compFor}.
	 * @param ctx the parse tree
	 */
	void exitCompFor(ProductParser.CompForContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProductParser#compCond}.
	 * @param ctx the parse tree
	 */
	void enterCompCond(ProductParser.CompCondContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProductParser#compCond}.
	 * @param ctx the parse tree
	 */
	void exitCompCond(ProductParser.CompCondContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProductParser#leftOperand}.
	 * @param ctx the parse tree
	 */
	void enterLeftOperand(ProductParser.LeftOperandContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProductParser#leftOperand}.
	 * @param ctx the parse tree
	 */
	void exitLeftOperand(ProductParser.LeftOperandContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProductParser#rightOperand}.
	 * @param ctx the parse tree
	 */
	void enterRightOperand(ProductParser.RightOperandContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProductParser#rightOperand}.
	 * @param ctx the parse tree
	 */
	void exitRightOperand(ProductParser.RightOperandContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProductParser#comparator}.
	 * @param ctx the parse tree
	 */
	void enterComparator(ProductParser.ComparatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProductParser#comparator}.
	 * @param ctx the parse tree
	 */
	void exitComparator(ProductParser.ComparatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProductParser#runStmt}.
	 * @param ctx the parse tree
	 */
	void enterRunStmt(ProductParser.RunStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProductParser#runStmt}.
	 * @param ctx the parse tree
	 */
	void exitRunStmt(ProductParser.RunStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProductParser#mainCheck}.
	 * @param ctx the parse tree
	 */
	void enterMainCheck(ProductParser.MainCheckContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProductParser#mainCheck}.
	 * @param ctx the parse tree
	 */
	void exitMainCheck(ProductParser.MainCheckContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProductParser#runArgs}.
	 * @param ctx the parse tree
	 */
	void enterRunArgs(ProductParser.RunArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProductParser#runArgs}.
	 * @param ctx the parse tree
	 */
	void exitRunArgs(ProductParser.RunArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProductParser#arg}.
	 * @param ctx the parse tree
	 */
	void enterArg(ProductParser.ArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProductParser#arg}.
	 * @param ctx the parse tree
	 */
	void exitArg(ProductParser.ArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProductParser#jsInstruction}.
	 * @param ctx the parse tree
	 */
	void enterJsInstruction(ProductParser.JsInstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProductParser#jsInstruction}.
	 * @param ctx the parse tree
	 */
	void exitJsInstruction(ProductParser.JsInstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProductParser#function_declaration}.
	 * @param ctx the parse tree
	 */
	void enterFunction_declaration(ProductParser.Function_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProductParser#function_declaration}.
	 * @param ctx the parse tree
	 */
	void exitFunction_declaration(ProductParser.Function_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProductParser#function_body}.
	 * @param ctx the parse tree
	 */
	void enterFunction_body(ProductParser.Function_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProductParser#function_body}.
	 * @param ctx the parse tree
	 */
	void exitFunction_body(ProductParser.Function_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProductParser#instruction_js}.
	 * @param ctx the parse tree
	 */
	void enterInstruction_js(ProductParser.Instruction_jsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProductParser#instruction_js}.
	 * @param ctx the parse tree
	 */
	void exitInstruction_js(ProductParser.Instruction_jsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProductParser#return_js}.
	 * @param ctx the parse tree
	 */
	void enterReturn_js(ProductParser.Return_jsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProductParser#return_js}.
	 * @param ctx the parse tree
	 */
	void exitReturn_js(ProductParser.Return_jsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProductParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterFunction_call(ProductParser.Function_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProductParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitFunction_call(ProductParser.Function_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProductParser#variabe}.
	 * @param ctx the parse tree
	 */
	void enterVariabe(ProductParser.VariabeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProductParser#variabe}.
	 * @param ctx the parse tree
	 */
	void exitVariabe(ProductParser.VariabeContext ctx);
}