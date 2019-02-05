#!/usr/bin/env python3

#handle excel file
#contain read excel method and write excel file.
#author silencezhao
#date 20181103
#version 1.0

import xlrd
import os

class HandleExcel(object):
    def __init__(self,fileName,writeFileName):
        self.fileName=fileName
        try:
           self.writeFileName=open(writeFileName,mode='w')
        except FileNotFoundError as fileError:
            print("file not found"+fileError,separator='\n')
        print(fileName+" will be handled!\n")
    def format_str(self,strs):
        str=''
        if len(strs)>0:
            for i in range(0,len(strs)):
                if i != len(strs)-1:
                    str+=strs[i]+","
                else:
                    str+=strs[i]
        return str
    def readExcel(self):
        workbook =xlrd.open_workbook(self.fileName)
        #sheets=workbook.sheet_names()
        desSheet=workbook.sheet_by_name("指标定义sql")
        for i in range(4,desSheet.nrows):
            strs=desSheet.cell(i,5).value.replace("\'",'\\\'').split(",")
            for j in range(0,len(strs)):
                if strs[j].find("TIMESTAMPDIFF")>0:
                    strs[j+1]="case when "+strs[j+1]+" is null or  "+strs[j+1]+"=\\\'\\\' then @DATA_DATE@ else substr("+strs[j+1]+",1,8) end"
                    print(strs[j+1])
                    break
            self.writeFileName.write("update aml.aml_si_indic_sql \nset indic_sel_sql=\'"+self.format_str(strs)+"\' \nwhere indickey=\'"+desSheet.cell(i,0).value+"\';\n")
                                        
        if not self.writeFileName:
            self.writeFileName.close()
    def generate_alter_column(self):
        workbook =xlrd.open_workbook(self.fileName)
        #sheets=workbook.sheet_names()
        desSheet=workbook.sheet_by_name("指标定义sql")
        for i in range(4,desSheet.nrows):
            str=desSheet.cell(i,0)
            self.writeFileName.write(r"mysqldump -h 10.2.34.44 -P 6450 -ubx_aml -pLmFcPM7FUEpAH9Ps aml AML_F_S_"+str.value+r"_D >C:\Users\ZHAOHENGB\Desktop\aml_script\indic"+r"\AML_F_S_"+str.value+"_D.sql \n")
                                 

if __name__=='__main__':
    handleExcel=HandleExcel(r"C:\Users\ZHAOHENGB\Documents\WeChat Files\zh474086141\Files\客户风险评级指标(1).xlsx",r'C:\Users\ZHAOHENGB\Desktop\文档\反洗钱\SmartAml4.0风险评级模型_靳嘉.txt')
    handleExcel.generate_alter_column()
    #handleExcel.readExcel()



