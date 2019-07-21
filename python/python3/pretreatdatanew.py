#!/usr/bin/env python3

#author wyf
#version 20190717
#propose: pretreat data

import os
import numpy as np
import cv2

"""
   预处理训练图片，随机选取若干比例图片加入随机噪音
"""
class PretreatData(object):
    
    def __init__(self, origin_train_no_path,origin_train_yes_path,transfer_train_no_path,transfer_train_yes_path, *args, **kwargs):
        self.origin_train_no_path=origin_train_no_path
        self.origin_train_yes_path=origin_train_yes_path
        self.transfer_train_no_path=transfer_train_no_path
        self.transfer_train_yes_path=transfer_train_yes_path
        #源文件路径
        self.origin_train_no_files=os.listdir(origin_train_no_path)
        #源文件路径
        self.origin_train_yes_files=os.listdir(origin_train_yes_path)
        #源no图片加噪音数量
        self.no_noise_count=kwargs["no_count"]
        #源yes图片加噪音数量
        self.yes_noise_count=kwargs["yes_count"]
        #分离后的no，yes路径
        self.slice={}
        #目标文件路径
        if not os.path.exists(transfer_train_no_path):
            os.makedirs(transfer_train_no_path)
        if not os.path.exists(transfer_train_yes_path):
            os.makedirs(transfer_train_yes_path)
    
     #选择要加噪音的图片
    def selectpic(self,*args,**kwargs):
        self.slice["no_noise_files"]=[]
        self.slice["no_files"]=[]
        self.slice["yes_noise_files"]=[]
        self.slice["yes_files"]=[]
        for i in range(0,len(self.origin_train_no_files)):
            if (i*np.random.randint(999,99999999))%self.no_noise_count==0:
                self.slice["no_noise_files"].append(self.origin_train_no_files[i])
            if len(self.slice["no_noise_files"])==self.no_noise_count:
                break
        for i in range(0,len(self.origin_train_yes_files)):
            if (i*np.random.randint(999,99999999))%self.yes_noise_count==0:
                self.slice["yes_noise_files"].append(self.origin_train_yes_files[i])
            if len(self.slice["yes_noise_files"])==self.yes_noise_count:
                break
        self.slice["no_files"]=[item for item in self.origin_train_no_files if item not in self.slice["no_noise_files"]]
        self.slice["yes_files"]=[item for item in self.origin_train_yes_files if item not in self.slice["yes_noise_files"]]

       
    def pretreat(self,*args,**kwargs):
        self.selectpic()
        noise_no_files=self.slice["no_noise_files"]
        no_files=self.slice["no_files"]
        noise_yes_files=self.slice["yes_noise_files"]
        yes_files=self.slice["yes_files"]
        for i in range(0,self.no_noise_count):
            im=cv2.imread(os.path.join(self.origin_train_no_path,noise_no_files[i]))
            cv2.imwrite(os.path.join(self.transfer_train_no_path,noise_no_files[i]),self.addnoise(im,self.generatenoise([0,255],[400,400,3],im.shape)))
        for i in range(0,self.yes_noise_count):
            im=cv2.imread(os.path.join(self.origin_train_yes_path,noise_yes_files[i]))
            cv2.imwrite(os.path.join(self.transfer_train_yes_path,noise_yes_files[i]),self.addnoise(im,self.generatenoise([0,255],[400,400,3],im.shape)))
        for i in range(0,len(no_files)):
            im=cv2.imread(os.path.join(self.origin_train_no_path,no_files[i]))
            cv2.imwrite(os.path.join(self.transfer_train_no_path,no_files[i]),im)
        for i in range(0,len(yes_files)):
            im=cv2.imread(os.path.join(self.origin_train_yes_path,yes_files[i]))
            cv2.imwrite(os.path.join(self.transfer_train_yes_path,yes_files[i]),im)

    """
       产生指定维度指定大小的随机噪音
       scope:区域
       generatedim:生成维度
       filldim:填充维度
    """
    def generatenoise(self,scope,generatedim,filldim,*args,**kwargs):
        #生成指定维度的随机数
        fillrand=np.zeros(filldim)
        generaterand=np.random.randint(scope[0],scope[1],generatedim)
        randomStartX=np.random.randint(0,filldim[0]-generatedim[0]+1)
        randomEndX=randomStartX+generatedim[0]-1
        randomStartY=np.random.randint(0,filldim[1]-generatedim[1]+1)
        randomEndY=randomStartY+generatedim[1]-1
        fillx,filly=0,0
        for x in range(0,filldim[0]):
            if x>=randomStartX and x<=randomEndX:
                filly=0
                for y in range(0,filldim[1]):
                    if y>=randomStartY and y <= randomEndY:
                        fillrand[x,y]=generaterand[fillx,filly]
                        filly+=1
                fillx+=1
        return fillrand
        
    #将生成的噪音数据加到原图像上头去
    def addnoise(self,origin,noise,*args,**kwargs):
        return origin+noise


if __name__=="__main__":
    pretreat=PretreatData(r'D:\code\zhdemo\python\asserts\images',r'D:\code\zhdemo\python\asserts\images',r'D:\code\zhdemo\python\asserts\no',r'D:\code\zhdemo\python\asserts\yes',no_count=10,yes_count=10)
    pretreat.pretreat()