package test1;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Solution174 implements Base {

	volatile int min = Integer.MAX_VALUE;
	
	public int calculateMinimumHP(int[][] dungeon) {
//		if(dungeon == null) {
//			return 0;
//		}
//		//TreeSet<Integer> set = new TreeSet<Integer>(Integer::compare);
//		int row = dungeon.length - 1;
//		int col = dungeon[0].length - 1;
//		trace(dungeon, 1, row, col);
//		return min;
		
		int row = dungeon.length;
		int col = dungeon[0].length;
		int[][] d = new int[row][col];
		for(int i = row - 1; i >= 0; i--) {
			for(int j = col - 1; j >= 0; j--) {
				if(i == row - 1 && j == col - 1) {
					d[i][j] = dungeon[i][j] >= 0 ?  1 : 1 - dungeon[i][j];
				}else if(i == row - 1 && j < col - 1) {
					if(dungeon[i][j] >= 0) {
						d[i][j] = dungeon[i][j] >= d[i][j + 1]? 1 : d[i][j + 1] - dungeon[i][j];
					}else {
						d[i][j] = d[i][j + 1] - dungeon[i][j];
					}
				}else if(i < row - 1 && j == col - 1) {
					if(dungeon[i][j] >= 0) {
						d[i][j] = dungeon[i][j] >= d[i + 1][j]? 1 : d[i + 1][j] - dungeon[i][j];
					}else {
						d[i][j] = d[i + 1][j] - dungeon[i][j];
					}
				}else {
					if(dungeon[i][j] >= 0) {
						int tempMin = Math.min(d[i][j + 1], d[i + 1][j]);
						d[i][j] = dungeon[i][j] >= tempMin ? 1 : tempMin - dungeon[i][j];
					}else {
						d[i][j] = Math.min(d[i][j + 1] - dungeon[i][j], d[i + 1][j] - dungeon[i][j]);
					}
				}
			}
		}
		return d[0][0];
		
	}
	
	public void trace(int[][] d, TreeSet<Integer> set, int tempValue, int row, int col) {
		int temp = d[row][col];
		if(temp >= tempValue) {
			tempValue = 1;
		}else {
			tempValue = tempValue - temp;
		}
		if(row > 0 && col > 0) {
			trace(d, set, tempValue, row - 1, col);
			trace(d, set, tempValue, row, col - 1);
		}else if(row == 0 && col > 0) {
			trace(d, set, tempValue, row, col - 1);
		}else if(row > 0 && col == 0) {
			trace(d, set, tempValue, row - 1, col);
		}else if(row == 0 && col == 0){
			if(set.isEmpty() || tempValue < set.first()) {
				set.add(tempValue);
			}
		}	
	}
	
	public void trace(int[][] d, int tempValue, int row, int col) {
		int temp = d[row][col];
		if(temp >= tempValue) {
			tempValue = 1;
		}else {
			tempValue = tempValue - temp;
		}
		if(row > 0 && col > 0) {
			trace(d, tempValue, row - 1, col);
			trace(d, tempValue, row, col - 1);
		}else if(row == 0 && col > 0) {
			trace(d, tempValue, row, col - 1);
		}else if(row > 0 && col == 0) {
			trace(d, tempValue, row - 1, col);
		}else if(row == 0 && col == 0){
			if(tempValue < min) {
				min = tempValue;
			}
		}	
	}
	
	public void trace1(int[][] d, TreeSet<Integer> set, int tempValue, int row, int col) {
		int temp = d[row][col];
		if(temp >= tempValue) {
			tempValue = 1;
		}else {
			tempValue = tempValue - temp;
		}
		if(row > 0 && col > 0) {
			trace(d, set, tempValue, row - 1, col);
			trace(d, set, tempValue, row, col - 1);
		}else if(row == 0 && col > 0) {
			trace(d, set, tempValue, row, col - 1);
		}else if(row > 0 && col == 0) {
			trace(d, set, tempValue, row - 1, col);
		}else if(row == 0 && col == 0){
			if(set.isEmpty() || tempValue < set.first()) {
				set.add(tempValue);
			}
		}	
	}
	
	
	public void trace(int[][] d, List<int[]> list, int[] tempValue, int count, int row, int col) {
		tempValue[count] = d[row][col];
		if(row > 0 && col > 0) {
			trace(d, list, tempValue, count + 1, row - 1, col);
			trace(d, list, tempValue, count + 1, row, col - 1);
		}else if(row == 0 && col > 0) {
			trace(d, list, tempValue, count + 1, row, col - 1);
		}else if(row > 0 && col == 0) {
			trace(d, list, tempValue, count + 1, row - 1, col);
		}else if(row == 0 && col == 0){
				list.add(tempValue);
		}	
	}
	
	@Override
	public void runFunc() {
		// TODO Auto-generated method stub
		int dungeon[][] = new int[][] {
			{-2,-3,3},{-5,-10,1},{10,30,-5}
		};
		
		System.out.println(calculateMinimumHP(dungeon));
		

	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
