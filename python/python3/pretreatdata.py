import cv2
import os
import matplotlib.image as im
import numpy as np


train1 ='E:/data/mnc/train_test/0603/test/no/'
train2 ='E:/data/mnc/train_test/0603/test/yes/'
train11 ='E:/data/mnc/train_test/0603#/test/no/'
train22 ='E:/data/mnc/train_test/0603#/test/yes/'

files1=os.listdir(train1)
files2=os.listdir(train2)

if not os.path.exists(train11):
    os.makedirs(train11)
if not os.path.exists(train22):
    os.makedirs(train22)

for file in files1:
    img=cv2.imread(train1+file)
    img=img+np.random.randint(0,25,[1000,1000,3])
    new_path = train11 + file.split(".")[0]
    cv2.imwrite(new_path+".jpg",img)

for file in files2:
    img=cv2.imread(train2+file)
    img =img+np.random.randint(0,25,[1000,1000,3])
    new_path = train22+ file.split(".")[0]
    cv2.imwrite(new_path+".jpg",img)