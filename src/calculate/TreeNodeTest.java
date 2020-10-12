package calculate;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import calculate.BinaryTree;
import calculate.TreeNode;
import org.junit.After;


import static org.junit.Assert.*;

public class TreeNodeTest {

    @After
    public void tearDown() throws Exception {
        System.out.println("TreeNode测试结束");
    }

    @Test
    public void getResult_1() {
        BinaryTree binaryTree=new BinaryTree(3);//3个运算符
        binaryTree.createBTree();
        TreeNode treeNode=binaryTree.getRoot();
        String s=treeNode.getResult(binaryTree.getOpeList());
        System.out.println(binaryTree.getRoot().toString()+"="+s);
    }

    @Test
    public void getResult_2() {
        BinaryTree binaryTree=new BinaryTree(2);//3个运算符
        binaryTree.createBTree();
        TreeNode treeNode=binaryTree.getRoot();
        String s=treeNode.getResult(binaryTree.getOpeList());
        System.out.println(binaryTree.getRoot().toString()+"="+s);
    }
}