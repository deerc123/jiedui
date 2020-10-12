package calculate;

import java.util.ArrayList;


/**
 *
 * @author kuku713
 * @version 1.0
 *
 */


public class BinaryTree {


    private TreeNode root;
    private int num;
    private ArrayList<TreeNode> opeList = new ArrayList<TreeNode>();
    private ArrayList<BinaryTree>binaryTreesList=new ArrayList<>();
 
    public ArrayList<TreeNode> getOpeList() {
	 return opeList;
 }

    public BinaryTree(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setTreeNode(TreeNode root) {
        this.root = root;
    }


    /**
     * 获取最终的表达式，必须在CalAndVal()方法后调用
     *
     * @return str
     */
    public String toString() {
        String str = root.toString();
        str = str.substring(1, str.length() - 1);
        return str;

    }

    /**
     * 计算并验证表达式
     *
     * @return result
     */
    public String CalAndVal() {
        return root.getResult(opeList);
    }

    /**
     * 计算二叉树的深度(层数)
     *
     * @return deep
     */
    public int getDeep() {
        int i = this.num;
        int deep = 2;
        while (i / 2 > 0) {
            deep++;
            i /= 2;
        }
        return deep;
    }

    /**
     * 生成二叉树
     */
    public void createBTree() {
        TreeNode lchild, rchild, lnode, rnode;
        String check;
       do {
           if (num == 1) {
               lchild = new TreeNode(String.valueOf(Ran.getNumber(100)), null, null);
               rchild = new TreeNode(String.valueOf(Ran.getNumber(100)), null, null);
               root = new TreeNode(String.valueOf(Ran.getOperator()), lchild, rchild);
           } else {
               int num1 = 0;
               int n = getDeep() - 3;
               boolean[] place = Ran.getChildPlace(num);
               char rootString = Ran.getOperator();
               root = new TreeNode(String.valueOf(rootString), null, null);
               opeList.add(root);


               //System.out.println(root.getStr());

               for (int i = 0; i < n; i++) {
                   for (int j = 0; j < (int) Math.pow(2, i); j++, num1++) {
                       lchild = new TreeNode(String.valueOf(Ran.getOperator()), null, null);
                       rchild = new TreeNode(String.valueOf(Ran.getOperator()), null, null);
                       opeList.get(j + num1).setChild(lchild, rchild);
                       opeList.add(lchild);
                       opeList.add(rchild);
                   }
               }

               for (int i = 0; i < place.length; i++) {
                   if (place[i]) {
                       int a1 = Ran.getNumber(10);
                       lnode = new TreeNode(String.valueOf(Ran.getNumber(100)), null, null);
                       rnode = new TreeNode(String.valueOf(Ran.getNumber(100)), null, null);
                       if (i % 2 == 0) {
                           lchild = new TreeNode(String.valueOf(Ran.getOperator()), lnode, rnode);
                           opeList.add(lchild);
                           opeList.get(num1).setLchild(lchild);
                       } else {
                           rchild = new TreeNode(String.valueOf(Ran.getOperator()), lnode, rnode);
                           opeList.add(rchild);
                           opeList.get(num1).setRchild(rchild);
                       }
                   } else {
                       if (i % 2 == 0) {
                           lchild = new TreeNode(String.valueOf(Ran.getNumber(100)), null, null);
                           opeList.get(num1).setLchild(lchild);
                       } else {

                           rchild = new TreeNode(String.valueOf(Ran.getNumber(100)), null, null);
                           opeList.get(num1).setRchild(rchild);
                       }
                   }
                   num1 = num1 + i % 2;
               }
               //BinaryList binaryList=new BinaryList();
              // String check=deleteCharString0(root.toString(),')','(');
               //binaryList.saveBinary(deleteCharString0(root.toString(),')','('));

               //BinaryList args=new BinaryList();
               //args.args(root);
               //RootSave rootSave=new RootSave();
               //rootSave.saveRoot(rootString);
               //binaryTreesList.add(this);
           }
           //check=deleteCharString0(root.toString(),')','(');
       }while (DuplicateCheck.checkDuplicate(root.toString(),BinaryList.saveList)||root.getLchild()==null||root.getRchild()==null);
        BinaryList.saveBinary(deleteCharString0(root.toString(),')','('));
/*改前
        if (num == 1) {
            lchild = new TreeNode(String.valueOf(Ran.getNumber(10)), null, null);
            rchild = new TreeNode(String.valueOf(Ran.getNumber(10)), null, null);
            root = new TreeNode(String.valueOf(Ran.getOperator()), lchild, rchild);
        } else {
            int num1 = 0;
            int n = getDeep() - 3;
            boolean[] place = Ran.getChildPlace(num);
            char rootString = Ran.getOperator();
            root = new TreeNode(String.valueOf(rootString), null, null);
            opeList.add(root);


            //System.out.println(root.getStr());

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < (int) Math.pow(2, i); j++, num1++) {
                    lchild = new TreeNode(String.valueOf(Ran.getOperator()), null, null);
                    rchild = new TreeNode(String.valueOf(Ran.getOperator()), null, null);
                    opeList.get(j + num1).setChild(lchild, rchild);
                    opeList.add(lchild);
                    opeList.add(rchild);
                }
            }

            for (int i = 0; i < place.length; i++) {
                if (place[i]) {
                    int a1 = Ran.getNumber(10);
                    lnode = new TreeNode(String.valueOf(Ran.getNumber(10)), null, null);
                    rnode = new TreeNode(String.valueOf(Ran.getNumber(10)), null, null);
                    if (i % 2 == 0) {
                        lchild = new TreeNode(String.valueOf(Ran.getOperator()), lnode, rnode);
                        opeList.add(lchild);
                        opeList.get(num1).setLchild(lchild);
                    } else {
                        rchild = new TreeNode(String.valueOf(Ran.getOperator()), lnode, rnode);
                        opeList.add(rchild);
                        opeList.get(num1).setRchild(rchild);
                    }
                } else {
                    if (i % 2 == 0) {
                        lchild = new TreeNode(String.valueOf(Ran.getNumber(10)), null, null);
                        opeList.get(num1).setLchild(lchild);
                    } else {

                        rchild = new TreeNode(String.valueOf(Ran.getNumber(10)), null, null);
                        opeList.get(num1).setRchild(rchild);
                    }
                }
                num1 = num1 + i % 2;
            }
            //BinaryList binaryList=new BinaryList();
            // String check=deleteCharString0(root.toString(),')','(');
            //binaryList.saveBinary(deleteCharString0(root.toString(),')','('));

            //BinaryList args=new BinaryList();
            //args.args(root);
            //RootSave rootSave=new RootSave();
            //rootSave.saveRoot(rootString);
            //binaryTreesList.add(this);
        }*/
       // check=deleteCharString0(root.toString(),')','(');
    }

public String deleteCharString0(String sourceString, char c1,char c2) {
        String deleteString = "";
        for (int i = 0; i < sourceString.length(); i++) {
            if (sourceString.charAt(i) != c1&&sourceString.charAt(i)!=c2) {
                deleteString += sourceString.charAt(i);
            }
        }

        return deleteString;
    }
}
