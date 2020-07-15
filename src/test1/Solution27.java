package test1;

public class Solution27 implements Base {
	
	public int removeElement(int[] nums, int val) {
		if(nums == null)
			return 0;
		int curr = 0;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] != val) {
				nums[curr++] = nums[i];
			}
			
		}
		return curr;
    }

	@Override
	public void runFunc() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
