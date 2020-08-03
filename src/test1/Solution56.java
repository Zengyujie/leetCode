package test1;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution56 implements Base {
	
	public int[][] merge(int[][] intervals) {
		if(intervals == null || intervals.length == 0) {
			return intervals;
		}
		Arrays.sort(intervals, (e1, e2)->{
			return Integer.compare(e1[0], e2[0]);
		});
		int curr = 0;
		for(int i = 0; i < intervals.length; i++) {
			if(intervals[curr][1] >= intervals[i][0]) {
				intervals[curr][1] = Math.max(intervals[curr][1], intervals[i][1]);
			}else {
				curr++;
				intervals[curr][0] = intervals[i][0];
				intervals[curr][1] = intervals[i][1];
			}
		}
		return Arrays.copyOf(intervals, curr + 1);
    }
	
	public void loop(int[][] matrix, int left, int right, int start, int end) {
		int mid = (left + right) / 2;
		int tag = start;
		for(; tag < end; tag++) {
			if(matrix[tag][1] >= mid) {
				break;
			}
		}
		if(tag == start) {
			
		}
		loop(matrix, left, mid, start, tag);
		loop(matrix, mid, right, tag, end);
	}
	
	public int contain(int[] n1, int[] n2) {
		if(n1[0] < n2[0] && n1[1] > n2[1])
			return 1;
		else if(n2[0] < n1[0] && n2[1] > n1[1])
			return 2;
		else if(n1[0] > n2[1] || n2[0] > n1[1])
			return 3;
		else
			return -1;
	}

	@Override
	public void runFunc() {
		// TODO Auto-generated method stub
		int nums[][] = {{2,3},{4,5},{6,7},{1,10}};
		int[][] res = merge(nums);
		for(int[] n : res) {
			System.out.println(Arrays.toString(n));
		}
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
