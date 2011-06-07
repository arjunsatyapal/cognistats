from __future__ import division
from jinja2.runtime import LoopContext, TemplateReference, Macro, Markup, TemplateRuntimeError, missing, concat, escape, markup_join, unicode_join, to_string, identity, TemplateNotFound
name = 'error_handlers/timeout.html'

def root(context):
    if 0: yield None
    yield u"<html>\n  <head>\n    <title>Timeout</title>\n    <style>\n    h1 {\n      color: #666666;\n      text-align: center;\n      font-family: 'trebuchet ms', trebuchet, georgia, arial, sans-serif;\n      font-size: 36px;\n      margin-top: 144px;\n    }\n    </style>\n  </head>\n  <body>\n    <h1>The server timed out while processing this request.</h1>\n  </body>\n</html>"

blocks = {}
debug_info = ''