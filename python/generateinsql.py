#! /usr/bin/env python3

#to generate insert sql
#author zhaoheng
#date 20181217 20:54
#version 1.0

import re
import os

class GenerateTools(object):
    def __init__(self,filename,savefilename):
        try:
            self.openfile=open(filename,mode='r+',encoding='utf8')
            self.savefile=savefilename
            self.savedirname=savefilename
        except FileNotFoundError as identifier:
            print('error:'+identifier.strerror)
            raise identifier
    def generate_ins_sql(self):
        if self.openfile is not None:
            print('begin generate')
            temp=self.openfile.readline()
            while temp is not '':
                items=temp.split(',')
                self.savefile.write(temp[0:temp.find('(')+1]+items[2]+',\'9999-12-31\''+temp[temp.find(','):]+'')
                temp=self.openfile.readline()
            print('end generate')
    def close_file_stream(self):
        if self.openfile is not None:
            self.openfile.close()
        if self.savefile is not None:
            self.savefile.close()     
    def generate_proc(self):
        temp='1'
        resultfile=''
        while temp is not '':
            temp=self.openfile.readline()
            if re.search('DROP PROCEDURE IF EXISTS',temp):
                proc_name=''
                proc_name=re.search('`.*`',temp)
                proc_name=temp[proc_name.span()[0]+1:proc_name.span()[1]-1]
                filename=os.path.join(self.savedirname,proc_name)+'.sql'
                resultfile=open(filename,mode="w+",encoding='utf-8')
            if re.search('-',temp):
                continue
            try:
                resultfile.write(temp.replace('DEFINER=`root`@`%`',' '))
            except AttributeError:
                continue
            

           

if __name__=='__main__':
    tool=GenerateTools(r'C:\Users\ZHAOHENGB\Documents\WeChat Files\zh474086141\Files\1.sql',r'G:\proc')
    tool.generate_proc()