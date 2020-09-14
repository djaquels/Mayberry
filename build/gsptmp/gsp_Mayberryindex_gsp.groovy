import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_Mayberryindex_gsp extends org.grails.gsp.GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/index.gsp" }
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
invokeTag('img','g',11,['dir':("images"),'file':("/stack/spring.png"),'width':("50"),'height':("50")],-1)
printHtmlPart(5)
invokeTag('img','g',16,['dir':("images"),'file':("/stack/flask.png"),'width':("50"),'height':("50")],-1)
printHtmlPart(6)
invokeTag('img','g',21,['dir':("images"),'file':("/stack/laravel.png"),'width':("50"),'height':("50")],-1)
printHtmlPart(7)
invokeTag('img','g',25,['dir':("images"),'file':("/stack/java.png"),'width':("50"),'height':("50")],-1)
printHtmlPart(8)
invokeTag('img','g',29,['dir':("images"),'file':("/stack/gear.jpg"),'width':("50"),'height':("50")],-1)
printHtmlPart(9)
})
invokeTag('captureBody','sitemesh',34,[:],1)
printHtmlPart(10)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1595947260289L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
