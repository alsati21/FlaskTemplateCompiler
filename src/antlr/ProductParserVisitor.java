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
	 * Visit a parse tree produced by {@link ProductParser#appInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAppInit(ProductParser.AppInitContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProductParser#addBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddBlock(ProductParser.AddBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProductParser#detailsBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDetailsBlock(ProductParser.DetailsBlockContext ctx);
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
	 * Visit a parse tree produced by {@link ProductParser#routeBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRouteBody(ProductParser.RouteBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProductParser#formHandler}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormHandler(ProductParser.FormHandlerContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProductParser#formFields}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormFields(ProductParser.FormFieldsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProductParser#formField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormField(ProductParser.FormFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProductParser#runStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRunStmt(ProductParser.RunStmtContext ctx);
}