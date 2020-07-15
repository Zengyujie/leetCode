package test1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution18 implements Base {
	
	public List<List<Integer>> fourSum(int[] nums, int target) {
		if(nums == null)
			return  null;
		List<List<Integer>> lists = new LinkedList<List<Integer>>();
		if(nums.length < 4)
			return lists;
		Arrays.sort(nums);
		for(int i = 0; i < nums.length - 3; i++) {
			List<List<Integer>> temp = ThreeSum(nums, target - nums[i]);
			for(int j = 0; j < temp.size(); j++) {
				temp.get(j).add(nums[i]);
			}
			lists.addAll(temp);
			while(i < nums.length - 3 && nums[i] == nums[i + 1])i++;
		}
		return lists;
	}
	
	
	public List<List<Integer>> ThreeSum(int[] nums, int tar) {
		List<List<Integer>> lists = new LinkedList<List<Integer>>();
		int t1= 0;
		int len = nums.length;
		int left = 0, right = len;
		double target = (double)tar / 3;
		while(left < right && nums[left] < target) {
			for(int j = left + 1, k = right - 1; j < k;) {
				t1 = nums[left] + nums[j] + nums[k];
				if(t1 == target) {
					lists.add(Arrays.asList(nums[left], nums[j], nums[k]));
					while(j < k && nums[j] == nums[j + 1])
						j++;
					j++;
					
					while(j < k && nums[k] == nums[k - 1])
						k--;
					k--;
				}
				
				if(t1 < target) {
					while(j < k && nums[j] == nums[j + 1])
						j++;
					j++;
				}
				
				if(t1 > target){
					while(j < k && nums[k] == nums[k - 1])
						k--;
					k--;
				}
			}
			
			while(left < right - 1 && nums[left] < target && nums[left] == nums[left + 1])
				left++;
			left++;
		}
		if(left < right && nums[left] == target && left + 2 < right && nums[left + 2] == target) {
			lists.add(Arrays.asList((int)target, (int)target, (int)target));
		}
		return lists;
    }
	
	
	public List<List<Integer>> fourSum1(int[] nums, int target) {
		if(nums == null)
			return  null;
		List<List<Integer>> lists = new LinkedList<List<Integer>>();
		if(nums.length < 4)
			return lists;
		Arrays.sort(nums);
		for(int i = 0; i < nums.length; i++) {
			for(int j = i + 1; j < nums.length; j++) {
				for(int k = j + 1; k < nums.length; k++) {
					for(int w = k + 1; w < nums.length; w++) {
						if(nums[i] + nums[j] + nums[k] + nums[w] == target) {
							lists.add(Arrays.asList(nums[i], nums[j], nums[k], nums[w]));
							break;
						}
					}
					while(k < nums.length - 1 && nums[k] == nums[k + 1])k++;
				}
				while(j < nums.length - 1 && nums[j] == nums[j + 1])j++;
			}
			while(i < nums.length - 1 && nums[i] == nums[i + 1])i++;
		}
		return lists;
    }
	
	
	@Override
	public void runFunc() {
		// TODO Auto-generated method stub
		int nums[] = {1, 0, -1, 0, -2, 2};
		
		List<List<Integer>> list =  fourSum(nums, 0);
		for(List<Integer> it : list) {
			System.out.println(it);
		}

	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
