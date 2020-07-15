package test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution39 implements Base {
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		return co(candidates, target);
    }
	
	public List<List<Integer>> co(int[] c, int t) {
		List<List<Integer>> res = new ArrayList<>();
		if(c == null || c.length == 0) {
			return res;
		}
		Arrays.sort(c);
		List<Integer> list = new ArrayList<>();
		HashSet<List<Integer>> set = new HashSet<>();
		loop(set, list, c, t, 0);
		for(List<Integer> list1 : set) {
			res.add(list1);
		}
		return res;
    }
	
	public void loop(Set<List<Integer>> res, List<Integer>list, int[] c, int t, int curr) {
		for(; curr < c.length; curr++) {
			if(c[curr] == t) {
				list.add(c[curr]);
				res.add(list);
				break;
			}else if(c[curr] < t) {
				List<Integer> newList = new ArrayList<Integer>();
				newList.addAll(list);
				newList.add(c[curr]);
				loop(res, newList, c, t - c[curr], curr + 1);
			}else {
				list = null;
			}
		}
	}

	@Override
	public void runFunc() {
		// TODO Auto-generated method stub
		int[] c = {10,1,2,7,6,1,5};
		co(c, 8);
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
