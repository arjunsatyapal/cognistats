# -*- coding: utf-8 -*-
"""
    home.handlers
    ~~~~~~~~~~~~~~~~~~~~

    document it
"""
import os
import logging

from tipfy.app import Response
from tipfy.handler import RequestHandler
from tipfyext.jinja2 import Jinja2Mixin
import tipfyext.jinja2
from tipfyext.jinja2 import default_config
#from tipfy.ext.auth import AppEngineAuthMixin, user_required


class PageHandler(RequestHandler, Jinja2Mixin):
    def get(self, template=None):
        """Simply returns a rendered template with an enigmatic salutation."""
        context = {}
        path = os.path.join(tipfyext.jinja2.default_config['templates_dir'],
                            template + '.html')
        if not os.path.exists(path):
            return Response(self.jinja2.render_template(
                    self, 'error_handlers/404.html', **context), status=404)
        return self.render_response(template + '.html', **context)


class FrontPageHandler(RequestHandler, Jinja2Mixin): 
    def get(self):
        """Simply returns a rendered template with an enigmatic salutation."""
        context = {}
        return self.render_response('front.html', **context)


class HomePageHandler(RequestHandler, Jinja2Mixin):#, AppEngineAuthMixin):
    #@tipfy.ext.auth.user_required
    def get(self):
        """They gotta be logged in for this one."""
        #tipfy.get_config()
        context = {
            'message': 'You done logged in!',
        }
        return self.render_response('front.html', **context)

