package test1;

import java.util.ArrayList;
import java.util.List;

public class Solution49 implements Base {

	public double myPow(double x, int n) {
		if(x == 1.0){
            return x;
        }
        if(x == 0.0){
            return x;
        }

        if(x == -1.0){
            return (n % 2 == 0) ? -x : x;
        }
        
        if(n  == Integer.MIN_VALUE) {
        	return 0.0;
        }
        
        if(n == 0) {
			return 1.0;
		}else if(n > 0) {
			int t = 0;
			double res = 1;
			while(t < n) {
				t++;
				res = res * x;
			}
			return res;
		}else {
			int t = 0;
			double res = 1.0;
			n = -n;
			while(t < n) {
				t++;
				res = res * (1/x);
			}
			return res;
		}
    }
	
	
	public double myPow1(double x, int n) {
		if(n == 0) {
			return 1.0;
		}
		if(n  == Integer.MIN_VALUE) {
        	return 0.0;
        }
		int n1 = Math.abs(n);
		double res = x;
		double x1 = x;
		int t = 1;
		int t1 = 0;
		List<Double> list = new ArrayList<>();
		list.add(res);
		while(t <= n1 - t) {
			res = res * res;
			t = t + t;
			list.add(res);
		}
		res = list.remove(list.size() - 1);
		x1 = res;
		t1 = t;
		while(t1 < n1) {
			while(t1 > n1 - t) {
				t = t / 2;
				x1 = list.remove(list.size() - 1);
			}
			t1 += t;
			res = res * x1;
		}
		return n > 0 ? res : 1/res;
	}
	
	@Override
	public void runFunc() {
		// TODO Auto-generated method stub
		System.out.println(myPow1(1.0, Integer.MAX_VALUE));

	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
