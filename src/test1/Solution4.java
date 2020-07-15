package test1;


/*
 * 
 * 
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。

请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

你可以假设 nums1 和 nums2 不会同时为空。

示例 1:

nums1 = [1, 3]
nums2 = [2]

则中位数是 2.0
示例 2:

nums1 = [1, 2]
nums2 = [3, 4]

则中位数是 (2 + 3)/2 = 2.5

 */

public class Solution4 implements Base{

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int len1 = nums1.length;
		int len2 = nums2.length;
		int middle = (len1 + len2)/2;
		int last = 0, curr = 0,m = 0, n = 0;
		for(int i = 0; i <= middle; i++) {
			last = curr;
			if(m < len1&&n < len2) {
				if(nums1[m] < nums2[n]) {
					curr = nums1[m++];
				}else {
					curr = nums2[n++];
				}
			}else if(m == len1 && n < len2) {
				curr = nums2[n++];
			}else if(n == len2 && m < len1) {
				curr = nums1[m++];
			}
		}
		
		if((len1 + len2) % 2 == 0) {
			return ((double)last + (double)curr)/2;
		}else {
			return (double)curr;
		}
    }
	
	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void runFunc() {
		// TODO Auto-generated method stub
		int[] nums1 = {1,2};
		int[] nums2 = {3,4};
		double res = this.findMedianSortedArrays(nums1, nums2);
		System.out.println(res);
		
		int[] nums11 = {1,3};
		int[] nums22 = {2};
		double res1 = this.findMedianSortedArrays(nums11, nums22);
		System.out.println(res1);
	}

}
