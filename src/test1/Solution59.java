package test1;

import java.util.ArrayList;
import java.util.List;

public class Solution59 implements Base {

	public int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
        if(n == 0){
            return matrix;
        }
		int len = n - 1;
		int curr = 0;
		int count = 1;
		while(len > 0) {
			for(int i = curr; i < curr + len; i++) {
				matrix[curr][i] = count++;
			}
			for(int i = curr; i < curr + len; i++) {
				matrix[i][curr + len] = count++;
			}
			for(int i = curr + len; i > curr; i--) {
				matrix[curr + len][i] = count++;
			}
			for(int i = curr + len; i > curr; i--) {
				matrix[i][curr] = count++;
			}
			len = len - 2;
			curr++;
		}
		if(len == 0) {
			matrix[curr][curr] = count;
		}
		return matrix;
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
