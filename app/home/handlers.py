# -*- coding: utf-8 -*-
"""
    home.handlers
    ~~~~~~~~~~~~~~~~~~~~

    document it
"""
from tipfy.app import Response
from tipfy.handler import RequestHandler
from tipfyext.jinja2 import Jinja2Mixin
#from tipfy.ext.auth import AppEngineAuthMixin, user_required

class FrontPageHandler(RequestHandler, Jinja2Mixin): 
    def get(self):
        """Simply returns a rendered template with an enigmatic salutation."""
        context = {
            'message': 'Hello, World! -- this is the front page',
        }
        return self.render_response('hello_world.html', **context)


class HomePageHandler(RequestHandler, Jinja2Mixin):#, AppEngineAuthMixin):
    #@tipfy.ext.auth.user_required
    def get(self):
        """They gotta be logged in for this one."""
        #tipfy.get_config()
        context = {
            'message': 'You done logged in!',
        }
        return self.render_response('hello_world.html', **context)
