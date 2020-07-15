package test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Solution17 implements Base{

	public List<String> letterCombinations(String digits) {
		List<String> list = new ArrayList<>();
		if(digits == null || digits.length() == 0)
			return list;
		HashMap<Character, String> pattern = new HashMap<>();
		pattern.put('2', "abc");
		pattern.put('3', "def");
		pattern.put('4', "ghi");
		pattern.put('5', "jkl");
		pattern.put('6', "mno");
		pattern.put('7', "pqrs");
		pattern.put('8', "tuv");
		pattern.put('9', "wxyz");
		char[] arr = digits.toCharArray();
		addString(pattern, list, arr, 0);
		return list;
    }
	
	public void addString(HashMap<Character, String> pattern, List<String> list, char[] arr, int index) {
		char[] arr1 = Arrays.copyOf(arr, arr.length);
		if(index == arr.length) {
			list.add(new String(arr1));
			return;
		}
		String temp = pattern.get(arr1[index]);
		for(int i = 0; i < temp.length(); i++) {
			arr1[index] = temp.charAt(i);
			addString(pattern, list, arr1, index+1);
		}
	}
	
	@Override
	public void runFunc() {
		// TODO Auto-generated method stub
		String digits = "23";
		List<String> list = letterCombinations(digits);
		list.forEach(System.out::println);
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
