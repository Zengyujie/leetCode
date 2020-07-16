package test1;

public class Solution45 implements Base {

	
	public static int jump(int[] nums) {
		if(nums == null || nums.length == 0)
			return 0;
		int curr = nums.length - 1;
		if(curr == 0){
			return 0;
		}
		int count = 0;
		while(curr != 0){
			for(int i = 0; i < curr; i++){
				if(nums[i] + i >= curr){
					curr = i;
					count++;
					break;
				}
				if(i == curr - 1){
					return Integer.MAX_VALUE;
				}
			}
		}
		return count;
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
