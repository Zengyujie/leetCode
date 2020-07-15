package test1;

public class Solution38 implements Base {
	
	public String countAndSay(int n) {
		if(n == 1) {
			return "1";
		}
		String str = "1";
		for(int j = 1; j < n; j++) {
			StringBuilder sb = new StringBuilder();
			char curr = ' ';
			int count = 0;
			for(int i = 0; i < str.length(); i++) {
				curr = str.charAt(i);
				count = 1;
				while(i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
					count++;
					i++;
				}
				sb.append(count);
				sb.append(curr);	
			}
			str = sb.toString();
		}
		return str;
    }
	
	

	@Override
	public void runFunc() {
		// TODO Auto-generated method stub
		System.out.println(countAndSay(4));
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
