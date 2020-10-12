package calculate;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import calculate.DuplicateCheck;
import org.junit.After;


import java.util.ArrayList;

import static org.junit.Assert.*;

public class DuplicateCheckTest {

    @After
    public void tearDown() throws Exception {
        System.out.println("DuplicateCheck测试结束");
    }

    /**
     * 对比两个含元素相同
     * 每个元素含数量相同
     * 长度相等但元素位置不同的string
     * 若相同return
     */
    @Test
    public void compareStringByChar_1() {
        boolean b = DuplicateCheck.CompareStringByChar("123456789", "129876343");
        System.out.println(b);

    }

    /**
     * 对比两个含元素相同
     * 每个元素含数量不相同
     * 长度相等但元素位置不同的string
     * 若相同return ture
     */
    @Test
    public void compareStringByChar_2() {
        boolean b = DuplicateCheck.CompareStringByChar("4555", "5454");
        System.out.println(b);
    }


    /**
     * 对比两个含元素不相同
     * 每个元素含数量不相同
     * 长度相等但元素位置不同的string
     * 若相同return ture
     */
    @Test
    public void compareStringByChar_3() {
        boolean b = DuplicateCheck.CompareStringByChar("45233", "54540");
        System.out.println(b);
    }


    /**
     * 对比两个含元素不相同
     * 每个元素含数量不相同
     * 长度不相等 元素位置不同的string
     * 若相同return ture
     */
    @Test
    public void compareStringByChar_4() {
        boolean b = DuplicateCheck.CompareStringByChar("11020", "245677");
        System.out.println(b);
    }
    /**
     * 有含元素相同且每个元素组成相同且长度相等的字符串
     */
    @Test
    public void checkDuplicate_1() {
        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add("12345");
        arrayList.add("38948");
        arrayList.add("7328281");
        arrayList.add("123344");
        boolean b=DuplicateCheck.checkDuplicate("12345",arrayList);
        System.out.println(b);

    }

    /**
     * 没有含元素相同且每个元素组成相同且长度相等的字符串
     */
    @Test
    public void checkDuplicate_2() {
        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add("12345");
        arrayList.add("38948");
        arrayList.add("7328281");
        arrayList.add("123344");
        boolean b=DuplicateCheck.checkDuplicate("12355",arrayList);
        System.out.println(b);

    }

}
