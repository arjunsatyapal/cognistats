# -*- coding: utf-8 -*-
"""App configuration."""

__compiled_templates = False

config = {}

config['tipfyext.jinja2'] = {'templates_dir': 'templates'}
if __compiled_templates:
    config['tipfyext.jinja2']['templates_compiled_target'] = '%s/__compiled__' % config['tipfyext.jinja2']['templates_dir']
