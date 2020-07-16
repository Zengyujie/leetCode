package test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution47 implements Base {

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> lists = new ArrayList<>();
		if(nums == null || nums.length == 0){
			return lists;
		}
		boolean used[] = new boolean[nums.length];
		Arrays.fill(used, false);
		loop(lists, new ArrayList<Integer>(), nums, used);
		return lists;
    }
	
	public static void loop(List<List<Integer>> lists, List<Integer> list, int[] nums, boolean[] used){
		if(list.size() == nums.length){
			if(!lists.contains(list))
				lists.add(list);
			return;
		}
		for(int i = 0; i < nums.length; i++){
			if(!used[i]){
				List<Integer> temp = new ArrayList<>();
				temp.addAll(list);
				temp.add(nums[i]);
				boolean[] bs = Arrays.copyOf(used, used.length);
				bs[i] = true;
				loop(lists, temp, nums, bs);
			}
		}
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
