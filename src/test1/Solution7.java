package test1;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution7 implements Base{
	
/*
 * 
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

示例 1:

输入: 123
输出: 321
 示例 2:

输入: -123
输出: -321
示例 3:

输入: 120
输出: 21
注意:

假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。

 * 
 * (non-Javadoc)
 * @see test1.Base#runFunc()
 */
	
	public int reverse(int x) {
		int res = 0;
		if(x < 0) {
			try{
				res =  -Integer.parseInt(new StringBuffer(String.valueOf(-x)).reverse().toString());
			}catch(Exception e){
				res = 0;
			}
		}else {
			try{
				res =  Integer.parseInt(new StringBuffer(String.valueOf(x)).reverse().toString());
			}catch(Exception e) {
				res = 0;
			}
		}
		return res;
    }
	
	
	@Override
	public void runFunc() {
		System.out.println(Integer.parseInt(new StringBuffer("120").reverse().toString()));
		// TODO Auto-generated method stub
		DataInputStream dis = new DataInputStream(System.in);
		int res = 0;
		try {
			res = dis.read();
			System.out.println(reverse(res));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(dis != null)
				try {
					dis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
