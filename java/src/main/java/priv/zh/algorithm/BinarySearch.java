package priv.zh.algorithm;


/*
* @author 赵恒
* 简单算法练习：二分搜索
*/

public class BinarySearch{
    /*
    *  思路：二分查找就是在有序的列表上对给定索引值进行定位的一个过程（设定列表值递增）
    */    
    public  static  int binarySearch(int []orderList,int value,int start,int end){
        int position=(start+end)>>>1;
        if(value<orderList[start]||value>orderList[end]||start>end)
           return -1;
        if(value>orderList[position]){
           return binarySearch(orderList, value,position+1,end);
        }
        else if(value<orderList[position]){
           return binarySearch(orderList, value,start,position-1);
        }
        return position;
    }
}