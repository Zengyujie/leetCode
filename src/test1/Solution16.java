package test1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution16 implements Base {
	
/*
 * 



 */

	public int threeSumClosest1(int[] nums, int target) {
		if(nums == null || nums.length < 3)
			return 0;
		int minRes = nums[0] + nums[1] + nums[2];
		for(int i = 0; i < nums.length; i++) {
			for(int j = i + 1; j < nums.length; j++) {
				for(int k = j + 1; k < nums.length; k++) {
					int temp = nums[i] + nums[j] + nums[k];
					if(temp == target)
						return temp;
					minRes = (Math.abs(temp - target) > Math.abs(minRes - target)) ? minRes : temp;
				}
			}
		}
		return minRes;
	}
	
	
	public int threeSumClosest(int[] nums, int target) {
		if(nums == null || nums.length < 3)
			return 0;
		int result = nums[0] + nums[1] + nums[2];
		Arrays.sort(nums);
		int t1= 0;
		int right = nums.length - 1;
		int left = 0;
		while(left < right) {
			for(int j = left + 1; j < right; j++) {
				t1 = nums[left] + nums[j] + nums[right];
				if(t1 == target) {
					return target;
				}
				System.out.println(nums[left] +":" + nums[j] + ":" + nums[right]);
				result = Math.abs(result - target) > Math.abs(t1 - target)? t1 : result;
			}
			int l = nums[left + 1] - nums[left];
			int r = nums[right] - nums[right - 1];
			
		}
		
		return result;
    }
	
	
	@Override
	public void runFunc() {
		// TODO Auto-generated method stub
		int nums[] = {-1,0,1,1,55};
		int res = this.threeSumClosest(nums, 3);
		System.out.println(res);
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
