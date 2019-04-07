#!/usr/bin/env python3


def iterator_test(file):
    str=file.readline()
    while str is not '':
        yield str
        str=file.readline()

if __name__=='__main__':
    f=open(r"d:\code\java\zhdemo\python\python3\cookbookdemo\operator\yield_exer.py")
    for str in iterator_test(f):
            print(str,end='\t')