import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_Mayberry_componentupdate_gsp extends org.grails.gsp.GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/component/update.gsp" }
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
invokeTag('captureHead','sitemesh',6,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
expressionOut.print(component.name)
printHtmlPart(5)
expressionOut.print(component.name)
printHtmlPart(6)
expressionOut.print(component.url)
printHtmlPart(7)
expressionOut.print(component.port)
printHtmlPart(8)
expressionOut.print(component.url_development)
printHtmlPart(9)
expressionOut.print(component.port_development)
printHtmlPart(10)
expressionOut.print(component.discoverName)
printHtmlPart(11)
expressionOut.print(component.gitlab)
printHtmlPart(12)
expressionOut.print(component.id)
printHtmlPart(13)
expressionOut.print(component.id)
printHtmlPart(14)
invokeTag('select','g',52,['name':("idSquad"),'from':(squads),'optionKey':("id"),'optionValue':("name")],-1)
printHtmlPart(15)
})
invokeTag('captureBody','sitemesh',63,[:],1)
printHtmlPart(16)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1600092129860L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
