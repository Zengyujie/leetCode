package test1;

import java.util.Stack;

public class Solution31 implements Base {
	
	
	public int longestValidParentheses(String s) {
		if(s == null || s.length() <= 1) {
			return 0;
		}
		int currl = 0, currr = 0;
		int maxl = 0, maxr = 0;
		int prel = -2, prer = -2;
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> pair = new Stack<>();
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '(') {
				stack.push(i);
			}else {
				if(stack.isEmpty()) {
					pair.clear();
				}else {
					//存在合法匹配时
					currl = stack.pop();
					currr = i;	
					prel = currl;
					prer = currr;
					while(!pair.isEmpty()) {
						prer = pair.pop();
						prel = pair.pop();
						if(prel < currl) {
							break;
						}
					}
					if(prer + 1 == currl) {
						prer = currr;
						pair.push(prel);
						pair.push(prer);
					}else {
						if(prel < currl) {
							pair.push(prel);
							pair.push(prer);
						}	
						pair.push(currl);
						pair.push(currr);
						if(prer - prel < currr - currl) {
							prer = currr;
							prel = currl;
						}
					}
					if(prer - prel > maxr - maxl) {
						maxr = prer;
						maxl = prel;
					}
				}
			}
		}
		int res = maxr - maxl;
		return res == 0 ? 0 : res + 1;
    }
	
	@Override
	public void runFunc() {
		// TODO Auto-generated method stub
		System.out.println(longestValidParentheses("(()()"));

	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
