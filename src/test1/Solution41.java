package test1;

public class Solution41 implements Base {

	public int firstMissingPositive(int[] nums) {
		int left = Integer.MAX_VALUE - 1, right = Integer.MAX_VALUE - 1;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] > 0) {
				if(nums[i] < left) {
					if(left == Integer.MAX_VALUE - 1) {
						right = nums[i];
					}
					left = nums[i];
				}
				if(nums[i] == right + 1) {
					right = nums[i];
				}
			}
		}
		if(left > 1) {
			return 1;
		}else {
			return right + 1;
		}

    }
	
	
	@Override
	public void runFunc() {
		// TODO Auto-generated method stub
		int nums[] = {3,4,-1,1};
		System.out.println(firstMissingPositive(nums));
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
