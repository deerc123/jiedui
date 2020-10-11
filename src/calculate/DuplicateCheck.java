package calculate;

//查重
import java.util.ArrayList;

public class DuplicateCheck {
  private ArrayList<TreeNode> sameRootList = new ArrayList<>();

 // public boolean duplicateCheck(Character root, BinaryTree binaryTree) {



     // return true;
//  }

  public static boolean CompareStringByChar(String strA,String strB)
  {
      boolean IsEqual = true;
      char[] arrA = strA.toCharArray();
      char[] arrB = strB.toCharArray();
      for (int i=0;i<arrA.length;i++)
      {
          char c=arrA[i];
          if (strB.indexOf(c)==-1)
          {
              IsEqual = false;
          }
          else
          {
              if(GetSameCharCount(c,arrA)!=GetSameCharCount(c,arrB))
              {
                  IsEqual = false;
              }
          }
      }
      for(int k=0;k<arrB.length;k++)//char charb in arrB
      {
          char b=arrB[k];
          if (strA.indexOf(b)==-1)//!strA.Contains(charb)
          {
              IsEqual = false;
          }
          else
          {
              if (GetSameCharCount(b, arrA) != GetSameCharCount(b, arrB))
              {
                  IsEqual = false;
              }
          }
      }
      return IsEqual;
  }

//获得某字符在字符串中的数量
  private static int GetSameCharCount(Character chara,char[] arrChar)
  {
      int count = 0;
      for(int j=0;j<arrChar.length;j++)
      {
          if(chara.equals(arrChar[j]))
          {
              count++;
          }
      }
      return count;
  }


  public static boolean checkDuplicate(String strA,ArrayList arrayList){
      int co=0;
      for(int q=0;q<arrayList.size();q++){
         if (CompareStringByChar(strA,(String) arrayList.get(0))){
             co++;
         }
      }
      return co!=0;
  }

}








