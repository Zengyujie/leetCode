package test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution51 implements Base {

	public List<List<String>> solveNQueens(int n) {
		List<List<String>> lists = new ArrayList<>();
		if(n == 0) {
			return  lists;
		}
		List<int[]> list = new ArrayList<>();
		int arr[] = new int[n];
		loop(list, arr, 0);
		for(int i = 0; i < list.size(); i ++) {
			int[] t1 = list.get(i);
			ArrayList<String> li = new ArrayList<>();
			for(int j = 0; j < t1.length; j++) {
				char[] c = new char[t1.length];
				Arrays.fill(c, '.');
				c[t1[j]] = 'Q';
				li.add(new String(c));
			}
			lists.add(li);
		}
		
		return lists;
    }
	
	
	public void loop(List<int[]> list, int[] arr, int curr) {
		if(curr == arr.length) {
			list.add(arr);
			return;
		}
		for(int i = 0; i < arr.length; i++) {
			arr[curr] = i;
			if(check(arr, curr)) {
				loop(list, Arrays.copyOf(arr, arr.length), curr + 1);
			}
		}
	}
	
	public boolean check(int[] nums, int curr) {
		if(curr == 0) {
			return true;
		}
		for(int i = 1; i <= curr; i++) {
			int left = i - 1;
			int right = i + 1;
			while(left >= 0) {
				if(nums[left] == nums[i]) {
					return false;
				}
				if(Math.abs(nums[left] - nums[i]) == i - left) {
					return false;
				}
				left--;
			}
			while(right <= curr) {
				if(nums[right] == nums[i]) {
					return false;
				}
				if(Math.abs(nums[right] - nums[i]) == right - i) {
					return false;
				}
				right++;
			}
		}
		return true;
	}
	
	
	@Override
	public void runFunc() {
		// TODO Auto-generated method stub
		solveNQueens(1);

	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
