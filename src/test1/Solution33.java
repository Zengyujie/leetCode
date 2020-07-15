package test1;

public class Solution33 implements Base {
	
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
	
	public int search(int[] nums, int target) {
		int left = 0;
		int right =  nums.length;
		if(nums[0] > nums[nums.length - 1]) {
				int step = 1;
				int i = 0;
				int t = 0;
				while(i < nums.length && nums[i] >= nums[t]) {
					t = i;
					i = i + step;
					step += step;
				}
				if(i > nums.length - 1){
                    i = nums.length - 1;
                }
				while(nums[i] < nums[t]) {
					i--;
				}
				right = i + 1;
				if(target >= nums[0]) {
					left = 0;
				}else {
					left = right;
					right = nums.length;
				}
		}
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
		int nums[] = {2,1};
		System.out.println(search(nums, 5));

	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
