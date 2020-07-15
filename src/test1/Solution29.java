package test1;

import java.util.Stack;

public class Solution29 implements Base {
	
	public int divide(int dividend, int divisor) {
		if(divisor == 0) {
			return Integer.MAX_VALUE;
		}
		if(dividend == 0)
			return 0;
		
		if(dividend == Integer.MIN_VALUE && divisor == -1) {
			return Integer.MAX_VALUE;
		}
		if(dividend == divisor)
			return 1;
		if(divisor == Integer.MIN_VALUE)
			return 0;
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();
		if(dividend == Integer.MIN_VALUE) {	
			boolean flag = false;
			if(divisor > 0) {
				flag = true;
				divisor = -divisor;
			}
			if(divisor <= dividend)
				return 0;
			int count = 0;
			int d = 0;
			int t1 = divisor;
			int t2 = 1;
			s1.push(t1);
			s2.push(t2);
			while(dividend - t1 <= t1) {
				t1 = t1 + t1;
				t2 = t2 + t2;
				s1.push(t1);
				s2.push(t2);
			}
			if(s1.isEmpty()) {
				count = 1;
			}
			while(!s2.isEmpty()) {
				t1 = s1.pop();
				t2 = s2.pop();
				if(dividend - d <= t1) {
					d += t1;
					count += t2;
				}
			}
			return flag ? -count : count;
		}else {
			boolean flag = false;
			if(dividend < 0 && divisor> 0 || dividend >0 && divisor < 0) {
				flag = true;
			}
			dividend = Math.abs(dividend);
			divisor = Math.abs(divisor);
			if(divisor > dividend)
				return 0;
			int count = 0;
			int d = 0;
			int t1 = divisor;
			int t2 = 1;
			s1.push(t1);
			s2.push(t2);
			while(dividend - t1 >= t1) {
				t1 = t1 + t1;
				t2 = t2 + t2;
				s1.push(t1);
				s2.push(t2);
			}
			if(s1.isEmpty()) {
				count = 1;
			}
			while(!s2.isEmpty()) {
				t1 = s1.pop();
				t2 = s2.pop();
				if(dividend - d >= t1) {
					d += t1;
					count += t2;
				}
			}
			return flag? -count : count;
		}
    }
	
	

	@Override
	public void runFunc() {
		// TODO Auto-generated method stub
		System.out.println(divide(-1010369383,Integer.MIN_VALUE));

	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
