package calculate;

import java.util.ArrayList;

/**
 * @author kuku713
 * @version 1.0
 */


public class TreeNode {

    private String str;
    private TreeNode rchild = null;
    private TreeNode lchild = null;
    public TreeNode() {
    }

    public TreeNode(String str) {
        this.str = str;
    }

    public TreeNode(String str, TreeNode lchild, TreeNode rchild) {
        this.str = str;
        this.rchild = rchild;
        this.lchild = lchild;
    }

    public void setChild(TreeNode lchild, TreeNode rchild) {
        this.lchild = lchild;
        this.rchild = rchild;
    }

    public TreeNode getRchild() {
        return rchild;
    }

    public void setRchild(TreeNode rchild) {
        this.rchild = rchild;
    }

    public TreeNode getLchild() {
        return lchild;
    }

    public void setLchild(TreeNode lchild) {
        this.lchild = lchild;
    }

    public String getStr() {
        return str;
    }

    public String getResult(ArrayList arrayList) {
        if (hasChild()) {
            switch (str) {
                case "+":
                    //左右子树如果有孩子，说明左右子树是一个表达式，而不是数字节点。
                    if (getRchild().hasChild() || getLchild().hasChild()) {


                        //判断左右邻括号的运算符是否为'/'，是的话进入分数运算
                        if (getRchild().str.equals("/") || getLchild().str.equals("/")) {

                            if (getRchild().str.equals("/") && getLchild().str.equals("/")) {
                                FractionStack f1 = new FractionStack();
                                f1.setNumerator(Integer.parseInt(getLchild().getLchild().getResult(arrayList)));
                                f1.setDenominator(Integer.parseInt(getLchild().getRchild().getResult(arrayList)));
                                FractionStack f2 = new FractionStack();
                                f2.setNumerator(Integer.parseInt(getRchild().getLchild().getResult(arrayList)));
                                f2.setDenominator(Integer.parseInt(getRchild().getRchild().getResult(arrayList)));
                                FractionCal f = new FractionCal();
                                return f.fracAdd(f1, f2).getRealRes();
                            }


                            if ((getLchild().str.equals("+") || getLchild().str.equals("-") || getLchild().str.equals("*") || !(getLchild().hasChild())) && getRchild().str.equals("/")) {
                                FractionStack f1 = new FractionStack();
                                f1.setNumerator(Integer.parseInt(getLchild().getResult(arrayList)));
                                f1.setDenominator(1);
                                FractionStack f2 = new FractionStack();
                                f2.setNumerator(Integer.parseInt(getRchild().getLchild().getResult(arrayList)));
                                f2.setDenominator(Integer.parseInt(getRchild().getRchild().getResult(arrayList)));
                                FractionCal f = new FractionCal();

                                return f.fracAdd(f1, f2).getRealRes();
                            }

                            if (getLchild().str.equals("/") && (getRchild().str.equals("+") || getRchild().str.equals("-") || getRchild().str.equals("*") || !(getRchild().hasChild()))) {
                                FractionStack f1 = new FractionStack();
                                f1.setNumerator(Integer.parseInt(getLchild().getLchild().getResult(arrayList)));
                                f1.setDenominator(Integer.parseInt(getLchild().getRchild().getResult(arrayList)));
                                FractionStack f2 = new FractionStack();
                                f2.setNumerator(Integer.parseInt(getRchild().getResult(arrayList)));
                                f2.setDenominator(1);
                                FractionCal f = new FractionCal();
                                return f.fracAdd(f1, f2).getRealRes();
                            }

                        }
                         return String.valueOf(Integer.parseInt(getLchild().getResult(arrayList)) + Integer.parseInt(getRchild().getResult(arrayList)));
                    }
                    return String.valueOf(Integer.parseInt(getLchild().getResult(arrayList)) + Integer.parseInt(getRchild().getResult(arrayList)));


                case "-":

                    //左右子树如果有孩子，说明左右子树是一个表达式，而不是数字节点。
                    if (getRchild().hasChild() || getLchild().hasChild()) {


                        //判断左右邻括号的运算符是否为'/'
                        if (getRchild().str.equals("/") || getLchild().str.equals("/")) {


                            if (getRchild().str.equals("/") && getLchild().str.equals("/")) {
                                FractionStack f1 = new FractionStack();
                                f1.setNumerator(Integer.parseInt(getLchild().getLchild().getResult(arrayList)));
                                f1.setDenominator(Integer.parseInt(getLchild().getRchild().getResult(arrayList)));
                                FractionStack f2 = new FractionStack();
                                f2.setNumerator(Integer.parseInt(getRchild().getLchild().getResult(arrayList)));
                                f2.setDenominator(Integer.parseInt(getRchild().getRchild().getResult(arrayList)));
                                FractionCal f = new FractionCal();
                                if ((f.fracSub(f1, f2).getRealRes()).charAt(0) == '-') {
                                    TreeNode treeNode = new TreeNode();
                                    treeNode = getLchild();
                                    this.lchild = this.rchild;
                                    this.rchild = treeNode;


                                    FractionCal f5 = new FractionCal();
                                    return f5.fracSub(f2, f1).getRealRes();
                                }
                                return f.fracSub(f1, f2).getRealRes();
                            }


                            if (getLchild().str.equals("+") || getLchild().str.equals("-") || getLchild().str.equals("*") || !(getLchild().hasChild())) {
                                FractionStack f1 = new FractionStack();
                                f1.setNumerator(Integer.parseInt(getLchild().getResult(arrayList)));
                                f1.setDenominator(1);
                                FractionStack f2 = new FractionStack();
                                f2.setNumerator(Integer.parseInt(getRchild().getLchild().getResult(arrayList)));
                                f2.setDenominator(Integer.parseInt(getRchild().getRchild().getResult(arrayList)));
                                FractionCal f = new FractionCal();
                                if ((f.fracSub(f1, f2).getRealRes()).charAt(0) == '-') {
                                    TreeNode treeNode = new TreeNode();
                                    treeNode = getLchild();
                                    this.lchild = this.rchild;
                                    this.rchild = treeNode;

                                    FractionCal f5 = new FractionCal();
                                    return f5.fracSub(f2, f1).getRealRes();
                                }
                                return f.fracSub(f1, f2).getRealRes();
                            }


                            if (getLchild().str.equals("/") && (getRchild().str.equals("+") || getRchild().str.equals("-") || getRchild().str.equals("*") || !(getRchild().hasChild()))) {
                                FractionStack f1 = new FractionStack();
                                f1.setNumerator(Integer.parseInt(getLchild().getLchild().getResult(arrayList)));
                                f1.setDenominator(Integer.parseInt(getLchild().getRchild().getResult(arrayList)));
                                FractionStack f2 = new FractionStack();
                                f2.setNumerator(Integer.parseInt(getRchild().getResult(arrayList)));
                                f2.setDenominator(1);
                                FractionCal f = new FractionCal();
                                if ((f.fracSub(f1, f2).getRealRes()).charAt(0) == '-') {
                                    TreeNode treeNode = new TreeNode();
                                    treeNode = getLchild();
                                    this.lchild = this.rchild;
                                    this.rchild = treeNode;

                                    FractionCal f5 = new FractionCal();
                                    return f5.fracSub(f2, f1).getRealRes();
                                }

                                return f.fracSub(f1, f2).getRealRes();

                            }

                        }
                        if (Integer.parseInt(getLchild().getResult(arrayList)) > Integer.parseInt(getRchild().getResult(arrayList)) || Integer.parseInt(getLchild().getResult(arrayList)) == Integer.parseInt(getRchild().getResult(arrayList))) {
                            return String.valueOf(Integer.parseInt(getLchild().getResult(arrayList)) - Integer.parseInt(getRchild().getResult(arrayList)));
                        }
                        if (Integer.parseInt(getLchild().getResult(arrayList)) < Integer.parseInt(getRchild().getResult(arrayList))) {
                            TreeNode treeNode = new TreeNode();
                            treeNode = getLchild();
                            this.lchild = this.rchild;
                            this.rchild = treeNode;
                            return  String.valueOf(Integer.parseInt(getLchild().getResult(arrayList)) - Integer.parseInt(getRchild().getResult(arrayList)));
                        }
                        return this.getResult(arrayList);
                    }
                    
            



                    else {
                        if (Integer.parseInt(getLchild().str) > Integer.parseInt(getRchild().str) || Integer.parseInt(getLchild().str) == Integer.parseInt(getRchild().str)) {
                            return String.valueOf(Integer.parseInt(getLchild().str) - Integer.parseInt(getRchild().str));
                        }
                        if (Integer.parseInt(getLchild().getResult(arrayList)) < Integer.parseInt(getRchild().getResult(arrayList))) {
                            TreeNode treeNode = new TreeNode();
                            treeNode = getLchild();
                            this.lchild = this.rchild;
                            this.rchild = treeNode;
                            return String.valueOf(Integer.parseInt(getLchild().str) - Integer.parseInt(getRchild().str));
                        }
                      //  return this.getResult(arrayList);

                    }




                case "*":

                    //左右子树如果有孩子，说明左右子树是一个表达式，而不是数字节点。
                    if (getRchild().hasChild() || getLchild().hasChild()) {
                        //判断左右邻括号的运算符是否为'/'
                        if (getRchild().str.equals("/") || getLchild().str.equals("/")) {
                            if (getRchild().str.equals("/") && getLchild().str.equals("/")) {
                                FractionStack f1 = new FractionStack();
                                f1.setNumerator(Integer.parseInt(getLchild().getLchild().getResult(arrayList)));
                                f1.setDenominator(Integer.parseInt(getLchild().getRchild().getResult(arrayList)));
                                FractionStack f2 = new FractionStack();
                                f2.setNumerator(Integer.parseInt(getRchild().getLchild().getResult(arrayList)));
                                f2.setDenominator(Integer.parseInt(getRchild().getRchild().getResult(arrayList)));
                                FractionCal f = new FractionCal();
                                return f.fracMul(f1, f2).getRealRes();
                            } else if (getLchild().str.equals("+") || getLchild().str.equals("-") || getLchild().str.equals("*") || !(getLchild().hasChild())) {
                                FractionStack f1 = new FractionStack();
                                f1.setNumerator(Integer.parseInt(getLchild().getResult(arrayList)));
                                f1.setDenominator(1);
                                FractionStack f2 = new FractionStack();
                                f2.setNumerator(Integer.parseInt(getRchild().getLchild().getResult(arrayList)));
                                f2.setDenominator(Integer.parseInt(getRchild().getRchild().getResult(arrayList)));
                                FractionCal f = new FractionCal();

                                return f.fracMul(f1, f2).getRealRes();
                            }
                            FractionStack f1 = new FractionStack();
                            f1.setNumerator(Integer.parseInt(getLchild().getLchild().getResult(arrayList)));
                            f1.setDenominator(Integer.parseInt(getLchild().getRchild().getResult(arrayList)));
                            FractionStack f2 = new FractionStack();
                            f2.setNumerator(Integer.parseInt(getRchild().getResult(arrayList)));
                            f2.setDenominator(1);
                            FractionCal f = new FractionCal();

                            return f.fracMul(f1, f2).getRealRes();
                        }
                        return String.valueOf(Integer.parseInt(getLchild().getResult(arrayList)) * Integer.parseInt(getRchild().getResult(arrayList)));
                    }

                    return String.valueOf(Integer.parseInt(getLchild().getResult(arrayList)) * Integer.parseInt(getRchild().getResult(arrayList)));

                    /**
                     * 获取每个节点的运算结果，并检验除法
                     * 1)除数为0
                     * 2)不能整除
                     * 出现以上两种情况的话将该运算符转换成其他三种运算符
                     *
                     * @return result
                     */
                case "/":
                    if (getRchild().getResult(arrayList).equals("0")||getRchild().getResult(arrayList).equals("0")) {
                        while (str.equals("/")) {
                            str = String.valueOf(Ran.getOperator());
                            System.out.println(str);
                        }
                        return this.getResult(arrayList);
                    }

                    //左右子树如果有孩子，说明左右子树是一个表达式，而不是数字节点。
                    if (getRchild().hasChild() || getLchild().hasChild()) {
                        //判断左右邻括号的运算符是否为'/'
                        if (getRchild().str.equals("/") || getLchild().str.equals("/")) {

                            if (getRchild().str.equals("/") && getLchild().str.equals("/")) {
                                FractionStack f1 = new FractionStack();
                                f1.setNumerator(Integer.parseInt(getLchild().getLchild().getResult(arrayList)));
                                f1.setDenominator(Integer.parseInt(getLchild().getRchild().getResult(arrayList)));
                                FractionStack f2 = new FractionStack();
                                f2.setNumerator(Integer.parseInt(getRchild().getLchild().getResult(arrayList)));
                                f2.setDenominator(Integer.parseInt(getRchild().getRchild().getResult(arrayList)));
                                FractionCal f = new FractionCal();
                                return f.fractDiv(f1, f2).getRealRes();
                            } else if (getLchild().str.equals("+") || getLchild().str.equals("-") || getLchild().str.equals("*") || !(getLchild().hasChild())) {
                                FractionStack f1 = new FractionStack();
                                f1.setNumerator(Integer.parseInt(getLchild().getResult(arrayList)));
                                f1.setDenominator(1);
                                FractionStack f2 = new FractionStack();
                                f2.setNumerator(Integer.parseInt(getRchild().getLchild().getResult(arrayList)));
                                f2.setDenominator(Integer.parseInt(getRchild().getRchild().getResult(arrayList)));
                                FractionCal f = new FractionCal();
                               
                                return f.fractDiv(f1, f2).getRealRes();
                            }
                            FractionStack f1 = new FractionStack();
                            f1.setNumerator(Integer.parseInt(getLchild().getLchild().getResult(arrayList)));
                            f1.setDenominator(Integer.parseInt(getLchild().getRchild().getResult(arrayList)));
                            FractionStack f2 = new FractionStack();
                            f2.setNumerator(Integer.parseInt(getRchild().getResult(arrayList)));
                            f2.setDenominator(1);
                            FractionCal f = new FractionCal();

                            return f.fractDiv(f1, f2).getRealRes();
                        }
                    else if (Integer.parseInt(getLchild().getResult(arrayList)) % Integer.parseInt(getRchild().getResult(arrayList)) != 0) {
                        if (arrayList.indexOf(this) == 0) {
                            FractionStack f1 = new FractionStack();
                            f1.setNumerator(Integer.parseInt(getLchild().getResult(arrayList)));
                            f1.setDenominator(Integer.parseInt(getRchild().getResult(arrayList)));

                            return f1.getRealRes();
                        }
                    }
                        return String.valueOf(Integer.parseInt(getLchild().getResult(arrayList)) / Integer.parseInt(getRchild().getResult(arrayList)));
                        }
                       /* while (str.equals("/")) {
                            str = String.valueOf(Ran.getOperator());
                        }*/

                    //return this.getResult(arrayList);

                    return String.valueOf(Integer.parseInt(getLchild().getResult(arrayList)) / Integer.parseInt(getRchild().getResult(arrayList)));
            }
        }
        return str;
    }
  
    
    public static int parseInt(String s){
        try {
          return Integer.parseInt(s);
        }
        catch(NumberFormatException e){
          e.printStackTrace();
        }
		return 0;
      }

    /**
     * 先对每个运算式添加括号，然后根据去括号法则，去掉多余的子式的括号
     *
     * @return string
     */
    public String toString() {
        String Lstr = "", Rstr = "", Str = "";
        
        if (hasChild()) {
        	
        
            //右子树如果有孩子，说明右子树是一个表达式，而不是数字节点。
            if (getRchild().hasChild()) {
                //判断左邻括号的运算符是否为'/'
                if (str.equals("/")) {
                    //获取右子树的表达式，保留括号
                    Rstr = getRchild().toString();
                }
                //判断左邻括号的运算符是否为'*'或'-'
                else if (str.equals("*") || str.equals("-")) {
                    //判断op是否为'+'或'-'
                    if (getRchild().str.equals("+") || getRchild().str.equals("-")) {
                        Rstr = getRchild().toString();
                    } else {
                        //获取右子树的表达式，并且去括号
                        Rstr = getRchild().toString().substring(1, getRchild().toString().length() - 1);
                    }
                } else {
                    //右子树除此之外都是可以去括号的。
                    Rstr = getRchild().toString().substring(1, getRchild().toString().length() - 1);
                }
            } else {
                Rstr = getRchild().str;
            }
            //左子树的情况同右子树类似
            if (getLchild().hasChild()) {
                if (str.equals("*") || str.equals("/")) {
                    if (getLchild().str.equals("+") || getLchild().str.equals("-")) {
                        Lstr = getLchild().toString();
                    } else {
                        Lstr = getLchild().toString().substring(1, getLchild().toString().length() - 1);
                    }
                } else {
                    Lstr = getLchild().toString().substring(1, getLchild().toString().length() - 1);
                }
            } else {
                Lstr = getLchild().str;
            }
            //获取当前的运算式，并加上括号
            Str = "(" + Lstr + str + Rstr + ")";
        } else {
            //若没有孩子，说明是数字节点，直接返回数字
            Str = str;
            
        }

 
    	 return Str;
    }

    public boolean hasChild() {
        if (lchild == null && rchild == null)
            return false;
        else
            return true;
    }
}

