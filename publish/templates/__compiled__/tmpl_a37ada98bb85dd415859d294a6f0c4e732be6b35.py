from __future__ import division
from jinja2.runtime import LoopContext, TemplateReference, Macro, Markup, TemplateRuntimeError, missing, concat, escape, markup_join, unicode_join, to_string, identity, TemplateNotFound
name = 'hello_world.html'

def root(context):
    parent_template = None
    if 0: yield None
    parent_template = environment.get_template('h5bp.html', 'hello_world.html')
    for name, parent_block in parent_template.blocks.iteritems():
        context.blocks.setdefault(name, []).append(parent_block)
    for event in parent_template.root_render_func(context):
        yield event

def block_content(context):
    l_message = context.resolve('message')
    t_1 = environment.filters['e']
    if 0: yield None
    yield u'\n    <h1>%s</h1>\n' % (
        escape(t_1(l_message)), 
    )

def block_css(context):
    l_super = context.super('css', block_css)
    if 0: yield None
    yield u'\n%s\n    <style type="text/css">\n        h1 {\n            color: #0099FF;\n            font-family: \'trebuchet ms\', trebuchet, arial, sans-serif;\n            font-size: 72px;\n            text-align: center;\n            margin-top: 24px;\n        }\n    </style>\n' % (
        escape(context.call(l_super)), 
    )

def block_title(context):
    l_message = context.resolve('message')
    t_1 = environment.filters['e']
    if 0: yield None
    yield escape(t_1(l_message))

blocks = {'content': block_content, 'css': block_css, 'title': block_title}
debug_info = '1=8&18=14&19=19&5=22&6=26&3=29'