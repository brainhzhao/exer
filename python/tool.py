#!/usr/bin/env python3


#this module is a tool program
#author zhaoheng
#date 20181205


import re
import os


class Tool(object):
    def __init__(self,filename,savefile):
        self.filename=filename
        self.savefile=savefile
        self.file=open(self.filename,mode='r',encoding='utf8',newline='\n')
        self.save=open(self.savefile,mode='w',encoding='utf8',newline='\n')
    def generate_create_sql(self):

        temp=self.file.readline()
        while temp!='':
            str=temp
            if re.search('CREATE TABLE',temp):
                table_name=''
                table_name=re.search('`.*`',temp)
                table_name=temp[table_name.span()[0]+1:table_name.span()[1]-1]
            if re.match(r'^-|\\n',temp):
                temp=self.file.readline()
                continue
            if re.search('ENGINE',temp):
                str=str[0:str.find(';')]+' COMMENT \''+table_name+'表\';\n'
            if re.search(',',temp):
                if 'COMMENT' not in temp:
                    str=str[0:str.find(',')]+' COMMENT \'默认字段\',\n'
            temp=self.file.readline()
            self.save.write(str)
    
    def generate_init_sql(self,dirname):
        dirs=os.listdir(dirname)
        for dir in dirs:
            if os.path.isdir(dirname+os.path.sep+dir):
                child_dir=os.listdir(dirname+os.path.sep+dir)
                for item in child_dir:
                    print('source ./'+dir+'/'+item+'\n')


 

if __name__=='__main__':
    tool=Tool(r'C:\Users\ZHAOHENGB\Desktop\aml_script\script\a',r'C:\Users\ZHAOHENGB\Desktop\aml_script\script\a.sql')
    #tool.generate_create_sql()
    tool.generate_init_sql(r'C:\Users\ZHAOHENGB\Desktop\aml_script\script')