package test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution120 implements Base {
	
	public int minimumTotal(List<List<Integer>> triangle) {
		if(triangle == null || triangle.size() == 0) {
			return 0;
		}
		int[][] tri = new int[triangle.size()][];
		for(int i = 0; i < tri.length; i++) {
			tri[i] = new int[triangle.get(i).size()];
		}
		for(int i = tri.length - 1; i >= 0; i--) {
			for(int j = 0; j < tri[i].length; j++) {
				if(i == tri.length - 1) {
					tri[i][j] = triangle.get(i).get(j);
				}else {
					tri[i][j] = Math.min(tri[i + 1][j], tri[i + 1][j + 1]) + triangle.get(i).get(j);
				}
			}
		}
		return tri[0][0];
    }
	
	public int minimumTotal1(List<List<Integer>> triangle) {
		if(triangle == null || triangle.size() == 0) {
			return 0;
		}
		int[] tri = new int[triangle.size()];
		for(int i = tri.length - 1; i >= 0; i--) {
			for(int j = 0; j <= i; j++) {
				if(i == tri.length - 1) {
					tri[j] = triangle.get(i).get(j);
				}else {
					tri[j] = Math.min(tri[j + 1], tri[j]) + triangle.get(i).get(j);
				}
			}
		}
		return tri[0];
    }
	

	@Override
	public void runFunc() {
		// TODO Auto-generated method stub
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> l1 = Arrays.asList(2);
		List<Integer> l2 = Arrays.asList(3,4);
		List<Integer> l3 = Arrays.asList(6,5,7);
		List<Integer> l4 = Arrays.asList(4,1,8,3);
		list.add(l1);
		list.add(l2);
		list.add(l3);
		list.add(l4);
		System.out.println(minimumTotal1(list));

	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
