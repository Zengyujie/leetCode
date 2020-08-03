package test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution60 implements Base {

	
	public String getPermutation(int n, int k) {
		if(n < 0 || k < 0)
			return null;
		int[] temp = new int[n];
		List<Character> list = new ArrayList<>();
		temp[0] = 1;
		list.add('1');
		int loc = 0;
		k--;
		StringBuffer sb = new StringBuffer();
		for(int i = 1; i < n; i++) {
			temp[i] = temp[i - 1] * (i + 1);
			if(k >= temp[i]) {
				loc = i;
			}
			list.add((char) (i + '1'));
		}
		for(int i = 0; i < n - 2 - loc; i++) {
			sb.append(list.remove(0));
		}
		while(loc >= 0) {
			sb.append(list.remove(k / temp[loc]));
			k = k % temp[loc];
			loc--;
		}
		while(!list.isEmpty()) {
			sb.append(list.remove(0));
		}
		return sb.toString();
    }
	
	public String getPermutation1(int n, int k) {
		if(n < 0 || k < 0)
			return null;
		long res = 1;
		for(long i = 1; i <= n; i++) {
			res *= i;
		}
		if(k > res) {
			return null;
		}
		boolean[] flags = new boolean[n];
		Arrays.fill(flags, true);
		List<String> list = new ArrayList<>();
		loop(list, flags, new StringBuffer(), k);
		System.out.println(list);
		return list.get(list.size() - 1);
    }
	
	
	public void loop(List<String> list, boolean[] nums, StringBuffer sb, int k) {
		if(list.size() < k) {
			if(sb.length() == nums.length) {
				list.add(sb.toString());
				return;
			}
			for(int i = 0; i < nums.length; i++) {
				if(nums[i]) {
					boolean[] temp = Arrays.copyOf(nums, nums.length);
					temp[i] = false;
					StringBuffer sb1 = new StringBuffer().append(sb);
					sb1.append(i+1);
					loop(list, temp, sb1, k);
				}
			}
		}
	}
	
	
	
	@Override
	public void runFunc() {
		// TODO Auto-generated method stub
		System.out.println(getPermutation(4,8));
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
