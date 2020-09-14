import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_Mayberry_componentview_gsp extends org.grails.gsp.GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/component/view.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',5,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',5,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',15,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
expressionOut.print(component.name)
printHtmlPart(6)
expressionOut.print(component.name)
printHtmlPart(7)
expressionOut.print(component.url)
printHtmlPart(8)
expressionOut.print(component.port)
printHtmlPart(9)
expressionOut.print(component.idSquad)
printHtmlPart(10)
expressionOut.print(component.discoverName)
printHtmlPart(11)
expressionOut.print(component.gitlab)
printHtmlPart(12)
invokeTag('img','g',27,['dir':("images"),'file':("/stack/repo.png"),'width':("50"),'height':("50")],-1)
printHtmlPart(13)
expressionOut.print(component.id)
printHtmlPart(14)
expressionOut.print(component.id)
printHtmlPart(15)
expressionOut.print(component.id)
printHtmlPart(16)
createTagBody(2, {->
printHtmlPart(4)
createTagBody(3, {->
printHtmlPart(17)
expressionOut.print(nodes)
printHtmlPart(18)
expressionOut.print(edges)
printHtmlPart(19)
expressionOut.print(nodes)
printHtmlPart(20)
expressionOut.print(edges)
printHtmlPart(21)
})
invokeTag('applyCodec','g',78,['encodeAs':("none")],3)
printHtmlPart(4)
})
invokeTag('javascript','g',79,[:],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',80,[:],1)
printHtmlPart(22)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1600092129862L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
