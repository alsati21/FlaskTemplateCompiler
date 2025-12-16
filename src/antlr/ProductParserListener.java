// Generated from C:/Users/ASUS/IdeaProjects/FlaskTemplateCompiler/src/antlr/ProductParser.g4 by ANTLR 4.13.2
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ProductParser}.
 */
public interface ProductParserListener extends ParseTreeListener {
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
	 * Enter a parse tree produced by {@link ProductParser#detailsBlock}.
	 * @param ctx the parse tree
	 */
	void enterDetailsBlock(ProductParser.DetailsBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProductParser#detailsBlock}.
	 * @param ctx the parse tree
	 */
	void exitDetailsBlock(ProductParser.DetailsBlockContext ctx);
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
	 * Enter a parse tree produced by {@link ProductParser#formFields}.
	 * @param ctx the parse tree
	 */
	void enterFormFields(ProductParser.FormFieldsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProductParser#formFields}.
	 * @param ctx the parse tree
	 */
	void exitFormFields(ProductParser.FormFieldsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProductParser#formField}.
	 * @param ctx the parse tree
	 */
	void enterFormField(ProductParser.FormFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProductParser#formField}.
	 * @param ctx the parse tree
	 */
	void exitFormField(ProductParser.FormFieldContext ctx);
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
}