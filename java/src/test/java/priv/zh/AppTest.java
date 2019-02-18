package priv.zh;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import java.lang.Thread;
import priv.zh.algorithm.BinarySearch;
/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void testBinarySearch(){
        int[] orderList={2,3,5,6,7,8,12,3434,54454,3434343,34343232,93232323};
        System.out.println(BinarySearch.binarySearch(orderList, 56, 0, orderList.length-1));
    }
}
