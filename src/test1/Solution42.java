package test1;

import java.util.Stack;

public class Solution42 implements Base {
	
	

	public int trap(int[] height) {
		int result = 0, left = 0;
		boolean isDesc = false;
		for(int i = 1; i < height.length; i++) {
			int temp = height[i] - height[i - 1];
			if(temp <= 0) {
				isDesc = true;
			}else if(temp > 0) {
				if(isDesc) {
					if(left < i - 1) {
						int j = i;
						int tempMax = j;
						while(j < height.length && height[left] > height[j]) {
							if(height[j] >= height[tempMax]) {
								tempMax = j;
							}
							j++;
						}
						if(j == height.length) {
							result += calculateV1(height, left, tempMax);
							left = tempMax;
							i = tempMax;
						}else {
							result += calculateV1(height, left, j);
							left = j;
							i = j;
						}
					}
					isDesc = false;
				}else {
					left = i;
				}
			}
		}
		return result;
    }
	
	
	public int calculateV1(int[] h, int start, int end) {
		int res = 0;
		int level = Math.min(h[start], h[end == h.length? end - 1: end]);
		for(int i = start + 1; i < end; i++) {
			int temp = level - h[i];
			if(temp > 0)
				res += temp;
		}
		return res;
	}
	
	public int trap1(int[] height) {
		int[] res = Loop(height, 0, height.length);
		return res[1] + res[2];
    }
	
	public int[] Loop(int[] h, int left, int right){
		int res[] = {0, 0, 0};
		if(right - left < 2) {
			res[0] = left;
			res[1] = 0;
			res[2] = 0;
			return res;
		}
		int loc = left, tempMax = h[left];
		for(int i = left; i < right; i++) {
			if(h[i] > tempMax) {
				loc = i;
				tempMax = h[i];
			}
		}
		res[0] = loc;
		int[] l = Loop(h, left, loc);
		int[] r = Loop(h, loc + 1, right);
		int lm = l[0], rm = r[0];
		res[1] = calculateV(h, lm, loc) + l[1];
		res[2] = calculateV(h, loc, rm) + r[2];
		return res;
	}

	public int calculateV(int[] h, int start, int end) {
		int res = 0;
		int level = Math.min(h[start], h[end == h.length? end - 1: end]);
		for(int i = start + 1; i < end; i++) {
			res += level - h[i];
		}
		return res;
	}
	
	

	@Override
	public void runFunc() {
		// TODO Auto-generated method stub
		int heights[] = {0,1,0,2,1,0,1,3,2,1,2,1};
		int result = trap(heights);
		System.out.println("result is: " + result);

	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
