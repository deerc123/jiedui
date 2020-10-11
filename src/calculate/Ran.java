package calculate;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;



public class Ran {
	
	/**
	 * 获取随机的符号
	 * 
	 * @return operator
	 */
	
	public static char getOperator(){
		char operator = 0;
		Random ran = new Random();
		int i = ran.nextInt(4);
		switch(i){
			case 0:
				operator = '+';
				break;
			case 1:
				operator = '-';
				break;
			case 2:
				operator = '*';
				break;
			case 3:
				operator = '/';
				break;
		}
		return operator;
	}
	
	
	
	public static int getRandom(int min, int max){
        Random random = new Random();
        return random.nextInt( max - min + 1 ) + min;
    }

  
    /**
	 * 根据输入的范围获取随机数
	 * 
	 * @param max
	 * @return number
	 */
    public static int getNumber(int max){
		int number = 0;
		Random ran = new Random();
		number = ran.nextInt(max+1);
		return number;
	}


	
	/**
	 * 根据运算符的个数随机产生子节点的位置
	 * 
	 * @param num
	 * @return childPlace
	 */
	
	public static boolean[] getChildPlace(int num){
		int d = 0;
		int size = 0, j=1;
		while(num >= (int)Math.pow(2, j)){
			j++;
		}
		d = (int)Math.pow(2, j) - 1 - num;
		size = (int)Math.pow(2, j-1);
		boolean[] k = new boolean[size];
		for(int i = 0; i < size; i++){
			k[i] = true;
		}
		for(int i = 0; i < d; i++){
			Random ran = new Random();
			int f = ran.nextInt(size);
			while(k[f] == false)
			{
				f = ran.nextInt(size);
			}
			k[f] = false;
		}
		return k;
	}
}