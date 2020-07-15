package test1;

public class Solution11 implements Base {
	
/*
给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。



*/
	
	public int maxArea(int[] h) {
		int len = h.length;
		int left = 0, right = len - 1;
		int max = 0, temp = 0;
		while(left <= right) {
			temp = Math.min(h[left], h[right]) * (right - left);
			if(temp > max)
				max = temp;
			if(h[left] > h[right])
				right--;
			else
				left++;
		}
		return  max;
	}
	
	
	public int maxArea1(int[] height) {
		int len = height.length;
		int square = 0;
		int curr = 0, t1 = 0, tempMax = 0, loc = 0;
		while(curr < len) {
			tempMax = 0;
			t1 = curr;
			loc = -1;
			while(t1 < len && height[t1] <= height[curr]) {
				if(tempMax <= height[t1] && t1 != curr) {
					tempMax = height[t1];
					loc = t1;
				}
				t1++;
			}
			if(loc == len - 1) {
				square += height[loc] * (loc - curr);
				break;
			}
			if(loc != -1) {
				if(height[loc] > height[curr]) {
					square += height[curr] * (loc - curr);
				}else {
					square += tempMax * (loc - curr);
				}
				curr = loc;
			}else {
				square += height[curr];
				curr++;
			}			
			if(curr == len - 1)
				break;
		}
		
		return square;
    }
	
	public int[] getMaxArea(int height[], int left, int right) {
		if(left + 1 == right) {
			if(right == height.length)
				return new int[] {left, 0};
			else
				return new int[] {left, Math.min(left, right)};
		}
		int[] temp = new int[]{0,0};//第一位表示是否存在高的，第二位表示高位多少，第三位表示容积
		int tempMax = 0;
		for(int i = left; i < right; i++) {
			if(height[i] > height[tempMax]) {
				tempMax = i;
			}
		}
		int leftMax[] = {0,0};
		if(left == tempMax) {
			leftMax[0] = left;
		}else {
			leftMax = getMaxArea(height, left, tempMax);
		}
		
		int rightMax[] = {0,0};
		if(right - 1 == tempMax) {
			rightMax[0] = right - 1;
		}else {
			rightMax = getMaxArea(height, tempMax + 1, right);
		}
		
		System.out.println("left:" + leftMax[0] + "right:" + rightMax[0]);
		
		
		
		if(height[leftMax[0]] <= height[tempMax]) {
			temp[1] = height[leftMax[0]] * (tempMax - leftMax[0]);
		}else {
			if(tempMax == right - 1)
				temp[1] = height[tempMax] * (tempMax - leftMax[0]);
			else {
				if(height[rightMax[0]] > height[tempMax])
					temp[1] = Math.min(height[rightMax[0]] , height[leftMax[0]]) * (tempMax - leftMax[0]);
				else
					temp[1] = height[tempMax] * (tempMax - leftMax[0]);
			}
		}
		
		if(height[rightMax[0]] <= height[tempMax]) {
			temp[1] += height[rightMax[0]] * (rightMax[0] - tempMax);
		}else {
			if(tempMax == left)
				temp[1] += height[tempMax] * (rightMax[0] - tempMax);
			else {
				if(height[leftMax[0]] > height[tempMax])
					temp[1] += Math.min(height[rightMax[0]] , height[leftMax[0]]) * (rightMax[0] - tempMax);
				else
					temp[1] += height[tempMax] * (rightMax[0] - tempMax);
			}
		}
		System.out.println(temp[1]);
		return temp;
	}
	

	@Override
	public void runFunc() {
		// TODO Auto-generated method stub
		System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));

	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
