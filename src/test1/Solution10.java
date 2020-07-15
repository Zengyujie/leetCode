package test1;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution10 implements Base {
	
	
/*
给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。

'.' 匹配任意单个字符
'*' 匹配零个或多个前面的那一个元素
所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。

说明:

s 可能为空，且只包含从 a-z 的小写字母。
p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
示例 1:

输入:
s = "aa"
p = "a"
输出: false
解释: "a" 无法匹配 "aa" 整个字符串。
示例 2:

输入:
s = "aa"
p = "a*"
输出: true
解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
示例 3:

输入:
s = "ab"
p = ".*"
输出: true
解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
示例 4:

输入:
s = "aab"
p = "c*a*b"
输出: true
解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
示例 5:

输入:
s = "mississippi"
p = "mis*is*p*."
输出: false


*/
	
	public boolean isMatch(String s, String p) {
		if(s == null||p == null)
			return false;
		if(s.isEmpty()&& p.isEmpty())
			return true;
		if(!s.isEmpty()&&p.isEmpty())
			return false;
		
		int len = s.length();
		ArrayList<String> list = getPattern(p);
		System.out.println(list);
		int loc = -1, minLen = 0;
		int[] flag = new int[list.size()];
		for(int i = 0; i < list.size(); i++) {
			String temp = list.get(i);
			if(temp.equals(".")) {
				flag[i] = 2;
				minLen++;
			}else if(temp.contains("*")) {
				flag[i] = 3;
			}else {
				flag[i] = 1;
				minLen += temp.length() ;
				if(loc == -1)
					loc = i;
			}
		}
		System.out.println(Arrays.toString(flag));
		if(loc == -1) {
			if(minLen > len)
				return false;
		}
		int j= 0;
		int lenFlag = 0;
		int t2 = 0;
		String t1 = "";
		for(j = 0; j < list.size() && lenFlag < len; j++) {
			if(flag[j] == 1) {
				t1 = list.get(j);
				t2 = s.indexOf(t1, lenFlag);
				if(t2 == -1||t2 != lenFlag)
					break;
				lenFlag = t2 + t1.length();
			}else if(flag[j] == 2) {
				lenFlag++;
			}else if(flag[j] == 3) {
				t1 = list.get(j);
				if(t1.contains(".")) {
						lenFlag = len;
						if(j == list.size() - 1)
							j = list.size();
						break;
				}
				while(lenFlag < len && s.charAt(lenFlag) == t1.charAt(0)) {
						lenFlag++;
				}	
			}
		}
		if(lenFlag == len && j == list.size())
			return true;
		if(lenFlag == len && j < list.size()) {
			int curr = 0;
			for(int i = 0; i < list.size(); i++) {
				if(flag[i] == 1) {
					curr = s.indexOf(list.get(i), curr);
					if(curr == -1) {
						return false;
					}
					curr = curr + list.get(i).length();
				}else if(flag[i] == 2) {
					curr++;
				}
				if(curr > len)
					return false;
			}
			return true;
		}
	
		return false;
		
    }
	
	public ArrayList<String> getPattern(String str) {
		int len = str.length();
		int start = 0, end = 0;
		ArrayList<String> list = new ArrayList<>();
		while(start < len && end < len) {
			if(str.charAt(end) == '.') {
				if(end + 1 < len && str.charAt(end + 1) == '*') {
					end++;
					continue;
				}
				if(end > start)
					list.add(new String(str.substring(start, end)));
				list.add(".");
				start = ++end;
			}else if(str.charAt(end) == '*') {
				if(end - 1 > start)
					list.add(new String(str.substring(start, end - 1)));
				int ten = end + 1;
				if(ten < len) {
					while(ten < len && str.charAt(ten) == str.charAt(end - 1))
						ten++;
					if(ten > end + 1) {
						if(str.charAt(end - 1) == '.') {
							for(int w = end + 1; w < ten; w++) {
								list.add(".");
							}
						}else {
							list.add(new String(str.substring(end + 1, ten)));
						}
					}
				}
				list.add(str.substring(end - 1, end + 1));
				end = ten;
				start = end;
			}else {
				end++;
			}
		}
		if(start < len) {
			list.add(str.substring(start, len));
		}
		return list;
	}
	
	
	

	@Override
	public void runFunc() {
		// TODO Auto-generated method stub
		String s1 = "aab";
		String p1 = "c*a*b";
		String s2 = "ab";
		String p2 = ".*";
		String s = "mississippi";
		String p = "mis*is*p*.";
		String p4 = "ab.*";
		String s4 = "ababab";
		System.out.println(this.isMatch(s4, p4));
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
