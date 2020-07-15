package test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution22 implements Base {

	
	public List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<>();
		if(n <= 0)
			return list;
		char[] arr = new char[n * 2];
		loop(n, list, arr, 0, 0, 0);
		return list;
    }
	
	public void loop(int n, List<String> list, char[] arr, int index, int left, int right) {
		char[] arr1 = Arrays.copyOf(arr, arr.length);
		if(index == arr1.length) {
			list.add(new String(arr1));
			return;
		}
		if(left < n && right < n) {
			if(left > right) {
				arr1[index] = '(';
				loop(n, list, arr1, index + 1, left + 1, right);
				arr1[index] = ')';
				loop(n, list, arr1, index + 1, left, right + 1);
			}else if(left == right) {
				arr1[index] = '(';
				loop(n, list, arr1, index + 1, left + 1, right);
			}
		}else if(left == n && right < n){
			arr1[index] = ')';
			loop(n, list, arr1, index + 1, left, right + 1);
		}
	}
	
	@Override
	public void runFunc() {
		// TODO Auto-generated method stub
		List<String> list = generateParenthesis(0);
		list.forEach(System.out::println);

	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
