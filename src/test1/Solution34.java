package test1;

public class Solution34 implements Base {
	
	public int[] searchRange(int[] nums, int target) {
		int[] res = {-1,-1};
		if(nums == null || nums.length == 0)
			return res;
		
		int temp = binarySearch(nums, target);
		if(temp == -1)
			return res;
		int left = temp, right = temp;
		while(nums[temp] == nums[left]) {
			left--;
			if(left < 0)
				break;
		}
			
		while(nums[temp] == nums[right]) {
			right++;
			if(right > nums.length - 1)
				break;
		}
		res[0] = left + 1;
		res[1] = right - 1;
		return res;
    }
	
	public int binarySearch(int[] nums, int target) {
		int left = 0;
		int right =  nums.length;
		while(left < right) {
			int mid = (left + right) / 2;
			if(nums[mid] < target) {
				left = mid + 1;
			}else if(nums[mid] > target) {
				right = mid;
			}else {
				return mid;
			}
		}
		return -1;
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
