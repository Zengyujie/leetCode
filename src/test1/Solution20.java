package test1;

import java.util.Stack;

public class Solution20 implements Base {

	public boolean isValid(String s) {
		if(s == null || s.length() == 0)
			return true;
		Stack<Character> stack = new Stack<>();
		int len = s.length();
		char c1 = ' ', c2 = ' ';
		for(int i = 0; i < len; i++) {
			c1 = s.charAt(i);
			if(c1 == '(' || c1 == '[' || c1 == '{') {
				stack.push(c1);
			}else if(c1 == ')' || c1 == ']' || c1 == '}') {
				if(!stack.isEmpty()) {
					c2 = stack.pop();
					if(c2 == '(' && c1 == ')'||
					   c2 == '[' && c1 == ']'||
					   c2 == '{' && c1 == '}') {
						
					}else {
						return false;
					}
						
				}
				else
					return false;
			}else {
				return false;
			}
		}
		if(stack.isEmpty())
			return true;
		else
			return false;
    }
	
	
	@Override
	public void runFunc() {
		// TODO Auto-generated method stub
		System.out.println(this.isValid("(]"));

	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
