package test1;

import java.util.HashSet;

/*
 * 
 * 
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

 */

public class Solution3 implements Base{

	public int lengthOfLongestSubstring(String s) {
		if(s == null)
			return 0;
		char[] charSet = s.toCharArray();
		int start = 0, end = 0, max = 0, loc = 0, len = charSet.length;
		while(start < len && end < len) {
			loc = -1;
			for(int i = start; i <= end; i++) {
				if(i == end) {
					max = Math.max((end - start) + 1, max);
				}else {
					if(charSet[i] == charSet[end]) {
						loc = i;
						max = Math.max((end - loc), max);
						break;
					}
				}
				
			}
			if(loc != -1) {
				start = loc + 1;
			}
			end++;
		}
		return max;
    }
	
	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void runFunc() {
		String test1 = "bbbbb";
		String test2 = "abcabcbb";
		String test3 = "pwwkew";
		String test4 = " ";
		String test5 = "au";
		System.out.println(lengthOfLongestSubstring(test1));
		System.out.println(lengthOfLongestSubstring(test2));
		System.out.println(lengthOfLongestSubstring(test3));
		System.out.println(lengthOfLongestSubstring(test4));
		System.out.println(lengthOfLongestSubstring(test5));
	}

}
