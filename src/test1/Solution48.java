package test1;

import java.util.Arrays;

public class Solution48 implements Base {
	
	
	public void rotate(int[][] matrix) {
		if(matrix == null)
			return;
		int temp = 0;
		for(int i = 0; i < matrix.length; i++) {
			for(int j = i + 1; j < matrix[i].length; j++) {
				temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length / 2; j++) {
				temp = matrix[i][j];
				matrix[i][j] = matrix[i][matrix[i].length - 1 - j];
				matrix[i][matrix[i].length - 1 - j] = temp;
			}
		}
		
    }
	
	
	

	@Override
	public void runFunc() {
		// TODO Auto-generated method stub
		int[][] matrix = new int [][] {
			{1,2,3},
			{4,5,6},
			{7,8,9}
		};
		rotate(matrix);
		for(int i = 0; i < matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}

	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
