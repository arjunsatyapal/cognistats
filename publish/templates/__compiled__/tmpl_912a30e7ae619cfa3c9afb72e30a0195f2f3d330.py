from __future__ import division
from jinja2.runtime import LoopContext, TemplateReference, Macro, Markup, TemplateRuntimeError, missing, concat, escape, markup_join, unicode_join, to_string, identity, TemplateNotFound
name = 'h5bp.html'

def root(context):
    if 0: yield None
    yield u'<!doctype html>\n\n<!--[if lt IE 7]><html class="no-js ie6 oldie" lang=en><![endif]-->\n<!--[if IE 7]><html class="no-js ie7 oldie" lang=en><![endif]-->\n<!--[if IE 8]><html class="no-js ie8 oldie" lang=en><![endif]-->\n<!--[if gt IE 8]><!--> <html class=no-js lang=en> <!--<![endif]-->\n<head>\n  <meta charset=utf-8>\n\n  \n  <meta http-equiv=X-UA-Compatible content="IE=edge,chrome=1">\n\n    <title>'
    for event in context.blocks['title'][0](context):
        yield event
    yield u'</title>\n    '
    for event in context.blocks['meta'][0](context):
        yield event
    yield u'\n\n  \n  <meta name=viewport content="width=device-width, initial-scale=1.0">\n\n  \n\n  '
    for event in context.blocks['css'][0](context):
        yield event
    yield u'\n\n  \n\n  \n  <script src="/js/libs/modernizr-1.7.min.js"></script>\n  <script src="/js/libs/respond.min.js"></script>\n\n    <!--[if IE]><meta http-equiv=imagetoolbar content=no /><![endif]-->\n</head>\n\n<body>\n\n  <div id=container>\n    <header>\n        '
    for event in context.blocks['header'][0](context):
        yield event
    yield u'\n    </header>\n    <div id=main role=main>\n        '
    for event in context.blocks['content'][0](context):
        yield event
    yield u'\n    </div>\n\n    <footer>\n        '
    for event in context.blocks['footer'][0](context):
        yield event
    yield u'\n    </footer>\n  </div> \n\n\n  \n\n  \n  <script src="//ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js"></script>\n  <script>window.jQuery||document.write(\'<script src="/js/libs/jquery-1.6.1.min.js">\\x3C/script>\');</script>\n\n\n  '
    for event in context.blocks['scripts'][0](context):
        yield event
    yield u'\n\n\t\n  \n  <script>var _gaq=[["_setAccount","UA-XXXXX-X"],["_trackPageview"],["_trackPageLoadTime"]];(function(e,a){var c=e.createElement(a),b=e.getElementsByTagName(a)[0];c.async=1;c.src=("https:"==location.protocol?"//ssl":"//www")+".google-analytics.com/ga.js";b.parentNode.insertBefore(c,b)}(document,"script"));</script>\n\n</body>\n</html>'

def block_footer(context):
    if 0: yield None
    yield u'\n        '

def block_title(context):
    if 0: yield None

def block_content(context):
    if 0: yield None
    yield u'\n        '

def block_header(context):
    if 0: yield None
    yield u'\n        '

def block_meta(context):
    if 0: yield None
    yield u'\n  <meta name=description content="">\n  <meta name=author content="">\n    '

def block_scripts(context):
    if 0: yield None
    yield u"\n  <script src='/js/855194a64c8954a7a72b33695cdcbc2cbe15fff1.js'></script>\n  "

def block_css(context):
    if 0: yield None
    yield u'\n  \n  <link rel=stylesheet href="/css/c8e1e91bdfe52fae3412f36a2d7eaa9915bd005d.css">\n  '

blocks = {'footer': block_footer, 'title': block_title, 'content': block_content, 'header': block_header, 'meta': block_meta, 'scripts': block_scripts, 'css': block_css}
debug_info = '13=8&14=11&24=14&42=17&46=20&51=23&64=26&51=30&13=34&46=37&42=41&14=45&64=49&24=53'