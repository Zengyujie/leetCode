package test1;

/*
 * 
 * 
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"

 */

public class Solution5 implements Base{

	public String longestPalindrome(String s) {
		if(s == null)
			return null;
		else if(s.isEmpty())
			return s;
		else {
			int lenL = 0, lenR = 1;
			int maxLen = 0, curr = 0;
			char c = ' ';
			int strLen = s.length();
			for(int i = 0; i < strLen; i++) {
				c = s.charAt(i);
				curr = i;
				while((curr = s.indexOf(c, curr + 1)) != -1) {
					if(isPalindrome(s,i,curr+1)) {
						if((curr + 1 - i) > maxLen) {
							lenL = i;
							lenR = curr + 1;
							maxLen = curr + 1 - i;
						}
					}
				}
				if(strLen - i < maxLen) {
					break;
				}
			}
			return s.substring(lenL, lenR);
		}
	}

	public boolean isPalindrome(String s, int start, int end){
		int charLen = (end - start) / 2 + start;
		for(int i = start; i < charLen; i++) {
			if(s.charAt(i) != s.charAt(end - 1 - (i - start))) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void runFunc() {
		// TODO Auto-generated method stub
		String[] strs = {"cbbd"};
		for(String s : strs) {
			try {
				System.out.println(s + " : " + longestPalindrome(s));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
