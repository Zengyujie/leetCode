package test1;

import java.util.ArrayList;
import java.util.List;

public class Solution54 implements Base {

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0){
            return list;
        }
		int lenr = matrix[0].length - 1;
		int lenc = matrix.length - 1;
		int curr = 0;
		while(lenr > 0 && lenc > 0) {
			for(int i = curr; i < curr + lenr; i++) {
				list.add(matrix[curr][i]);
			}
			for(int i = curr; i < curr + lenc; i++) {
				list.add(matrix[i][curr + lenr]);
			}
			for(int i = curr + lenr; i > curr; i--) {
				list.add(matrix[curr + lenc][i]);
			}
			for(int i = curr + lenc; i > curr; i--) {
				list.add(matrix[i][curr]);
			}
			lenr = lenr - 2;
			lenc = lenc - 2;
			curr++;
		}
		if(lenr == 0 && lenc > 0) {
			for(int j = curr; j <= curr + lenc; j++) {
				list.add(matrix[j][curr]);
			}
		}
		if(lenc == 0 && lenr > 0) {
			for(int j = curr; j <= curr + lenr; j++) {
				list.add(matrix[curr][j]);
			}
		}
		if(lenc == 0 && lenr == 0) {
			list.add(matrix[curr][curr]);
		}
		System.out.println(list);
		return list;
    }
	
	
	@Override
	public void runFunc() {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		spiralOrder(matrix);

	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
