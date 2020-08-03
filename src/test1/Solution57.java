package test1;

import java.util.Arrays;

public class Solution57 implements Base {
	
	
	public int[][] insert(int[][] intervals, int[] newInterval) {
		if(intervals == null || intervals.length == 0) {
			return new int[][] {newInterval};
		}
		if(newInterval == null) {
			return intervals;
		}
		int l = 0, r = intervals.length;
		int mid = 0;
		while(l < r) {
			mid = (l + r) / 2;
			if(intervals[mid][1] < newInterval[0]) {
				l = mid + 1;
			}else if(intervals[mid][0] > newInterval[1]) {
				r = mid;
			}else {
				int lcurr = 0, rcurr = 0;
				if(intervals[mid][0] > newInterval[0]) {
					intervals[mid][0] = newInterval[0];
					for(int i = mid - 1; i >= 0; i--) {
						if(intervals[i][1] < newInterval[0]) {
							break;
						}else {
							lcurr++;
							intervals[mid][0] = Math.min(intervals[i][0], newInterval[0]);
						}
					}
				}
				intervals[mid - lcurr][0] = intervals[mid][0];
				intervals[mid - lcurr][1] = intervals[mid][1];
				if(intervals[mid][1] < newInterval[1]) {
					intervals[mid - lcurr][1] = newInterval[1];
					for(int i = mid + 1; i < intervals.length; i++) {
						if(intervals[i][0] > newInterval[1]) {
							break;
						}else {
							rcurr++;
							intervals[mid - lcurr][1] = Math.max(intervals[i][1], newInterval[1]);
						}
					}
				}
				for(int i = mid + rcurr + 1; i < intervals.length; i++) {
					intervals[i - rcurr - lcurr][0] = intervals[i][0];
					intervals[i - rcurr - lcurr][1] = intervals[i][1];
				}
				return Arrays.copyOf(intervals, intervals.length - lcurr - rcurr);
			}
		}
		int[][] res = new int[intervals.length + 1][];
		for(int i = 0; i < res.length; i++) {
			if(i == l) {
				res[i] = newInterval;
			}else if(i > l) {
				res[i] = intervals[i - 1];
			}else {
				res[i] = intervals[i];
			}
		}
		return res;
    }
	

	@Override
	public void runFunc() {
		// TODO Auto-generated method stub
		int nums[][] = {{0,5},{9,12}};
		int interval[] = {7,16};
		int[][] res = insert(nums, interval);
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
