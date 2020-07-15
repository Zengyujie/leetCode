package test1;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution1 implements Base{
	
/*
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 
 * 两个 整数，并返回他们的数组下标。
你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1] */
	
	
	
	public void runFunc() {
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		int[] res = twoSum(nums, target);
		System.out.println(Arrays.toString(res));
		
	}
	
	public int[] twoSum(int[] nums, int target) {
		int[] res = {-1, -1};
		int len = nums.length;
		Loop:for(int i = 0; i < len; i++) {
			for(int j = i + 1; j < len; j++) {
				if((nums[i] + nums[j]) == target) {
					res[0] = i;
					res[1] = j;
					break Loop;
				}
			}
		}
		
        return res;
    }
	
	public String getInfo() {
		return "solution1";
	}
	

}