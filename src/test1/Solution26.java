package test1;

import java.util.Arrays;

public class Solution26 implements Base {

	public int removeDuplicates(int[] nums) {
		if(nums == null)
			return 0;
		int curr = 0;
		for(int i = 0; i < nums.length; i++) {
			while(i < nums.length - 1 && nums[i] == nums[i + 1]) {
				i++;
			}
			nums[curr++] = nums[i];
		}
		return curr;
    }
	
	
	@Override
	public void runFunc() {
		// TODO Auto-generated method stub
		int nums[] = {0,0,1,1,1,2,2,3,3,4};
		System.out.println(removeDuplicates(nums));
		System.out.println(Arrays.toString(nums));

	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
