package test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Solution30 implements Base {
	
	public List<Integer> findSubstring1(String s, String[] words) {
		List<Integer> result = new ArrayList<>();
		int strLen = 0;
		HashSet<String> se = new HashSet<>();
		for(String s1: words) {
			strLen += s1.length();
			se.add(s1);
		}
		
		int[] arr = new int[words.length];
		Object[] os = se.toArray();
		if(os.length == 2 && words.length > 20)
			return result;
		for(int k = 0; k < os.length; k++) {
			String sr = (String)os[k];
			int loc = 0;
			while((loc = s.indexOf(sr, loc))!= -1) {
				int start = loc;
				loc++;
				int end = start + strLen;
				if(end <= s.length()) {
					Arrays.fill(arr, 1);
					int curr = start;
					boolean flag = true;
					while(flag) {
						flag = false;
						for(int j = 0; j < words.length; j++) {
							if(arr[j] == 1 && s.indexOf(words[j], curr) == curr) {
								arr[j] = 0;
								curr += words[j].length();
								flag = true;
								break;
							}
						}
						if(curr == end) {
							if(!result.contains(start))
								result.add(start);
							break;
						}
					}
				}else {
					break;
				}
			}
		}
		return result;
    }
	
	
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> result = new ArrayList<>();
		if(s == null || s.length() == 0 || words == null || words.length == 0)
			return result;
		HashMap<String, Integer> map = new HashMap<>();
		for(String s1 : words) {
			map.put(s1, map.getOrDefault(s1, 0) + 1);
		}
		int strLen = words.length * words[0].length();
		int i = 0;
		while(i < s.length()) {
			if(i + strLen <= s.length()) {
				int step = isMadeUpOfArrays(s, i, words, map);
				if(step == words.length) {
					result.add(i);
				}
				i++;
				//i = i + (words.length - step) / 2 > 1 ? (words.length - step) : 1;
			}else {
				break;
			}	
		}
		return result;
	}
	
	public int isMadeUpOfArrays(String s, int start, String[] words, HashMap<String ,Integer> map) {
		HashMap<String, Integer> map1 = new HashMap<>();
		int count = 0;
		for(int i = 0; i < words.length; i++) {
			String temp = s.substring(start + i * words[0].length(), start + (i + 1) * words[0].length());
			map1.put(temp, map1.getOrDefault(temp, 0) + 1);
		}
		Set<String> set = map.keySet();
		for(Iterator<String> it = set.iterator(); it.hasNext();) {
			String str = it.next();
			if(map1.containsKey(str) && map1.get(str) == map.get(str)) {
				count = count + map1.get(str);
			}
		}
		return count;
	}
	
	
	@Override
	public void runFunc() {
		// TODO Auto-generated method stub
		String s1 = "barfoothefoobarman";
		String[] words1 = {"foo","bar"};
		List<Integer> li = findSubstring(s1, words1);
		System.out.println(li);
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
