package test1;

public class Solution9 implements Base {
	
/*

判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

示例 1:

输入: 121
输出: true
示例 2:

输入: -121
输出: false
解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
示例 3:

输入: 10
输出: false
解释: 从右向左读, 为 01 。因此它不是一个回文数。
进阶:

你能不将整数转为字符串来解决这个问题吗？



*/
	
	public boolean isPalindrome(int x) {
		if(x < 0)
			return false;
		if(x == 0)
			return true;
		int res = 0, temp = x;
		while(temp > 0) {
			res = res * 10 + temp % 10;
			temp /= 10;
		}
		return res == x;
    }

	@Override
	public void runFunc() {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome(121));
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
