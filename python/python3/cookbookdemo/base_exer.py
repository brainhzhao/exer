#! /usr/bin/env python3

# author zhaoheng
# date 20190402

import os


class BaseExer(object):
    def __init__(self,*args,**dictargs):
        for arg in args:
            print('args->',arg)
        for dictarg in dictargs:
            print('dictarg->',dictarg)

if __name__=="__main__":
    print()