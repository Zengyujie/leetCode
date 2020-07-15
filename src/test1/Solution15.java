package test1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution15 implements Base {
	
	
/*

给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

示例：

给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]


*/
	
	
	public List<List<Integer>> threeSum1(int[] nums) {
		if(nums == null)
			return  null;
		List<List<Integer>> lists = new LinkedList<List<Integer>>();
		if(nums.length < 3)
			return lists;
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < nums.length; i++) {
			if(map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i]) + 1);
			}else {
				map.put(nums[i], 1);
			}
		}
		int temp = 0;
		int t1= 0, t2 = 0;
		Object arr[] = map.keySet().toArray();
		Arrays.sort(arr);
		for(int i = 0; i < arr.length; i++) {
			temp = (Integer)arr[i];
			if(temp >= 0) {
				if(map.get(0) != null && map.get(0) >= 3) {
					lists.add(Arrays.asList(0, 0, 0));
				}
				break;
			}
			for(int j = i; j < arr.length; j++) {
				t1 = (Integer)arr[j];
				t2 = -temp - t1;
				if(t2 < 0 || t1 > t2){
					break;
				}
				if(map.containsKey(t1) && map.containsKey(t2)) {
					if(i == j) {
						if(map.get(temp) >= 2)
							lists.add(Arrays.asList(temp, t1, t2));
					}else {
						if(temp == t2) {
							if(map.get(temp) >= 2) {
								lists.add(Arrays.asList(temp, t1, t2));
							}
						}else if(t1 == t2) {
							if(map.get(t1) >= 2) {
								lists.add(Arrays.asList(temp, t1, t2));
							}else {
								
							}
						}else {
							lists.add(Arrays.asList(temp, t1, t2));
						}
					}
				}
			}
		}
		return lists;
    }
	
	
	public List<List<Integer>> threeSum2(int[] nums) {
		if(nums == null)
			return  null;
		List<List<Integer>> lists = new LinkedList<List<Integer>>();
		if(nums.length < 3)
			return lists;
		Arrays.sort(nums);
		int t1= 0;
		int len = nums.length;
		int left = 0, right = len;
		while(left < right && nums[left] < 0) {
			for(int j = left + 1, k = right - 1; j < k;) {
				t1 = nums[left] + nums[j] + nums[k];
				if(t1 == 0) {
					lists.add(Arrays.asList(nums[left], nums[j], nums[k]));
					while(j < k && nums[j] == nums[j + 1])
						j++;
					j++;
					
					while(j < k && nums[k] == nums[k - 1])
						k--;
					k--;
				}
				
				if(t1 < 0) {
					while(j < k && nums[j] == nums[j + 1])
						j++;
					j++;
				}
				
				if(t1 > 0){
					while(j < k && nums[k] == nums[k - 1])
						k--;
					k--;
				}
			}
			
			while(left < right - 1 && nums[left] < 0 && nums[left] == nums[left + 1])
				left++;
			left++;
		}
		if(left < right && nums[left] == 0 && left + 2 < right && nums[left + 2] == 0) {
			lists.add(Arrays.asList(0, 0, 0));
		}
		return lists;
    }
	
	


	@Override
	public void runFunc() {
		// TODO Auto-generated method stub
		
		int nums[] = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
		
		List<List<Integer>> list =  threeSum2(nums);
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
