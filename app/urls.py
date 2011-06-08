# -*- coding: utf-8 -*-
"""URL definitions."""
from tipfy.routing import Rule

rules = [
    Rule('/', name='front-page', handler='home.handlers.FrontPageHandler'),
    Rule('/<template>', name='page', handler='home.handlers.PageHandler'),
    Rule('/home', name='home-page', handler='home.handlers.HomePageHandler'),
    Rule('/hello', name='hello-world', handler='hello_world.handlers.HelloWorldHandler'),
    Rule('/pretty', name='hello-world-pretty', handler='hello_world.handlers.PrettyHelloWorldHandler'),
]
