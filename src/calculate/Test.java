package calculate;

/*public class Test {
	public static void main(String args[]){
		BinaryTree bTree;
		for(int i = 0; i < 10; i++){
			bTree = new BinaryTree(2);
			bTree.createBTree();
			String result = bTree.CalAndVal();
			System.out.println(bTree.toString() + "=" + result);
		}
	}
}*/

/*public class Test{
	public static void main(String[] args){
    //BinaryTree binaryTree=new BinaryTree(3);
    //binaryTree.createBTree(10,1);
    CreatSubjects creatSubjects=new CreatSubjects();
   
  
    	
    	    creatSubjects.creatSubject(10000,1);
		
	
	}
}*/
public class Test {
    public static void main(String[] args){
        //BinaryTree binaryTree=new BinaryTree(2);
        //binaryTree.createBTree(10000,1);
        System.out.println("---------四则运算----------");
        System.out.println("请选择操作");
        System.out.println("1.生成题目");
        System.out.println("2.进行批改");
        System.out.println("3.退出");
        CreatSubjects creatSubjects=new CreatSubjects();
        int count= Integer.parseInt(args[0]);
        int num= Integer.parseInt(args[1]);
        creatSubjects.creatSubject(count,num);

//System.out.println("-2".indexOf(0));
        //BinaryTree binaryTree= (BinaryTree) BinaryList.saveList.get(0);
        //System.out.println(binaryTree.toString().indexOf()+"------");
        //System.out.println(BinaryList.saveList.get(0)+"-------");
        //System.out.println(BinaryList.saveList.get(0).getRchild().getStr()+"-------");
       // System.out.println(BinaryList.saveList.get(0).getLchild()+"-------");
        //System.out.println(RootSave.rootList.get(0));
        //int c=Integer.parseInt("1/3");
        //System.out.println(c);
       // DuplicateCheck duplicateCheck=new DuplicateCheck();
       // boolean b=duplicateCheck.CompareStringByChar("423","234");
        //System.out.println(b);
    }
    }