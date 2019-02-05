#!/usr/bin/env python3


# handle regular text file
# author SilenceZhao
# version 1.0
# date 20181120

import os


if __name__=="__main1__":
    file_name_list=open(r"C:\Users\ZHAOHENGB\Desktop\aml_script\aml_f_s_cjc9001_d.sql")
    write_file=open(r"C:\Users\ZHAOHENGB\Desktop\aml_script\aml_init_unix_test_data.sql",mode="w")
    temp=file_name_list.readline()
    count=0
    while temp is not '':
        if ',' in temp:
            if  'INDICVAL' in temp:
                write_file.write(temp[0:temp.rfind(',')]+" COMMENT \'指标结果值\',\n")
            elif 'DATA_DATE' in temp:
                write_file.write(temp[0:temp.rfind(',')]+" COMMENT \'数据日期\',\n")
            elif 'INDICKEY' in temp:
                write_file.write(temp[0:temp.rfind(',')]+" COMMENT \'指标编码\',\n")
            elif 'OBJKEY' in temp:
                write_file.write(temp[0:temp.rfind(',')]+" COMMENT \'统计对象ID\',\n")          
        else:
            write_file.write(temp+"\n")
        if 'DROP' in temp:
            count+=1
        temp=file_name_list.readline()
    file_name_list.close()
    write_file.close()
    print("handle success,table count "+str(count))


if __name__=="__main2__":
    file_name_list=open(r"D:\cygwin64\home\zhaohengb\dict")
    write_file=open(r"D:\cygwin64\home\zhaohengb\dict_log",mode="w")
    temp=file_name_list.readline()
    count=0
    while temp is not '':
        arr=temp.split('dict-name=')
        if len(arr)>1:
            write_file.write(arr[1].split('"')[1]+"\n")
        temp=file_name_list.readline()
    file_name_list.close()
    write_file.close()
    print("handle success,table count "+str(count))


if __name__=="__main__":
    file_name_list=os.listdir(r'C:\Users\ZHAOHENGB\Desktop\aml_script\上线\aml_init_data')
    write_file=open(r"C:\Users\ZHAOHENGB\Desktop\aml_script\上线\init.sql",mode="w")
    for i in range(0,len(file_name_list)):
        write_file.write('source ./aml_init_data/'+file_name_list[i]+'\n')
    write_file.close()
    print("handle success,table count ")