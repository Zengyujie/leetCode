package test1;

import java.util.ArrayList;
import java.util.List;

public class Solution46 implements Base {

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> lists = new ArrayList<>();
		if(nums == null || nums.length == 0){
			return lists;
		}
		
		loop(lists, new ArrayList<Integer>(), nums);
		return lists;
    }
	
	public static void loop(List<List<Integer>> lists, List<Integer> list, int[] nums){
		if(list.size() == nums.length){
			lists.add(list);
			return;
		}
		for(int i = 0; i < nums.length; i++){
			if(!list.contains(nums[i])){
				List<Integer> temp = new ArrayList<>();
				temp.addAll(list);
				temp.add(nums[i]);
				loop(lists, temp, nums);
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
