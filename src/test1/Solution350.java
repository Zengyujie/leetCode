package test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Solution350 implements Base {

	public int[] intersect(int[] nums1, int[] nums2) {
		if(nums1 == null || nums2 == null) {
			return new int[]{};
		}
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i < nums1.length; i++) {
			for(int j = 0; j < nums2.length; j++) {
				if(nums1[i] == nums2[j] && !list.contains(j))
				{
					list.add(j);
					break;
				}
			}
		}
		int[] res = new int[list.size()];
		for(int i = 0; i < list.size(); i++) {
			res[i] = nums2[list.get(i)];
		}
		return res;
    }
	
	
	public int[] intersect1(int[] nums1, int[] nums2) {
		if(nums1 == null || nums2 == null) {
			return new int[]{};
		}
		
	
		HashSet<Integer> set = new HashSet<>(nums1.length);
		ArrayList<Integer> list = new ArrayList<>(nums2.length);
		for(int i = 0; i < nums1.length; i++) {
			set.add(nums1[i]);
		}
		for(int j = 0; j < nums2.length; j++) {
			if(set.contains(nums2[j]) && !list.contains(j)) {
				list.add(j);
			}
		}
		int[] res = new int[list.size()];
		for(int i = 0; i < list.size(); i++) {
			res[i] = nums2[list.get(i)];
		}
		return res;
    }
	
	@Override
	public void runFunc() {
		// TODO Auto-generated method stub
		int[] nums1 = {1,2,2,1};
		int[] nums2 = {2,2};
		int[] res = intersect1(nums1, nums2);
		System.out.println(Arrays.toString(res));

	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
