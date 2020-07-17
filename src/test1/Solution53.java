package test1;

import java.util.Arrays;

public class Solution53 implements Base {
	
	public int maxSubArray(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		int max = nums[0];
		for(int i = 1; i < nums.length; i++) {
			nums[i] = Math.max(nums[i - 1] + nums[i], nums[i]);
			if(nums[i] > max)
				max = nums[i];
		}
		System.out.println(max);
		return max;
    }

	@Override
	public void runFunc() {
		// TODO Auto-generated method stub
		int[] nums = {1,2,-1,-2,2,1,-2,1,4,-5,4};
		maxSubArray(nums);

	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
