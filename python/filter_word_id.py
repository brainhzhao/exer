#!/usr/bin/env python

# -*- coding:utf-8 -*- 

# author:
# version:1.0
# date:20190128
# propose:filter word id


# define a class to handle input file 

class FilterWord(object):
    #construnct func,define input file stream and output stream
    def __init__(self,in_file_name,out_file_name,limit_num):
        try:
            self.in_file=open(in_file_name,mode='r')
            self.out_file=open(out_file_name,mode='w')
            self.limit_num=limit_num
        except  IOError as error:
            print 'file not found'

    #filter func,main func        
    def filter(self):
        # define a list for store word_id
        lines=['','','','','','','','','','']
        line_num=0
        while True:
            temp=self.in_file.readline()
            nums=temp.split(' ')
            lines[int(nums[1][:1])]+=(nums[1]+' ')
            line_num+=1
            # limit read 30000 lines
            if temp is None or line_num>self.limit_num:
                break
        # write to out file
        for i in xrange(0,9):
            if lines[i]=='':
                continue
            self.out_file.write(lines[i]+'\n')
            self.out_file.flush()   
        # close file stream
        self.out_file.close()
        self.in_file.close()
    

if __name__=="__main__":
    filter_word=FilterWord('/media/heng/SilenceZhao/forubuntu/googledownload/docword.enron.txt','/media/heng/SilenceZhao/forubuntu/googledownload/doc.txt',30000)
    filter_word.filter()
