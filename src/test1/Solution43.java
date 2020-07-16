package test1;

import java.util.Arrays;

public class Solution43 implements Base {

	public static String multiply(String num1, String num2) {
		if(num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0){
			return "0";
		}
		if(num1.equals("0") || num2.equals("0"))
            return "0";
		String s1, s2;
		if(num1.length() > num2.length()){
			s1 = num1;
			s2 = num2;
		}else{
			s1 = num2;
			s2 = num1;
		}
		
		String[] strs = new String[10];
		for(int i = 0; i < 10; i++){
			strs[i] = multiplyOne(s1, (char)(i + '0'));
		}
		char[] result = new char[s1.length() * s2.length() + 1];
		Arrays.fill(result, '0');
		int curr = result.length - 1;
		for(int i = s2.length() - 1; i >= 0; i--){
			char c = s2.charAt(i);
			char[] temp = strs[c - '0'].toCharArray();
			boolean flag = false;
			for(int j = 0; j < temp.length; j++){
				int n1 = temp[temp.length - 1 - j] - '0';
				int n2 = result[curr - j] - '0';
				int n3 = n1 + n2;
				if(flag){
					n3++;
					flag = false;
				}
				if(n3 >= 10){
					flag = true;
				}
				result[curr - j] = (char)(n3 % 10 + '0');
				System.out.println(result[curr - j]);
			}
			if(flag){
				result[curr - temp.length] = '1';
			}
			curr--;
		}
		int loc = 0;
		for(; loc < result.length; loc++){
			if(result[loc] != '0'){
				break;
			}
		}
		System.out.println(result);
		return new String(result, loc, result.length - loc);
    }
	
	public static String multiplyOne(String str, char c){
		if(c == '0')
			return "0";
		if(c == '1')
			return str;
		char[] arr = str.toCharArray();
		int temp = -1;
		int n1 = c - '0';
		boolean flag = false;
		for(int i = arr.length - 1; i >= 0; i--){
			int n2 = arr[i] - '0';
			int res = n1 * n2;
			if(flag){
				res = res + temp;
				flag = false;
			}
			arr[i] = (char)(res % 10 + '0');
			if(res >= 10){
				temp = res / 10;
				flag = true;
			}
		}
		StringBuilder sb = new StringBuilder();
		if(flag){
			sb.append((char)(temp + '0'));
		}
		sb.append(arr);
		return sb.toString();
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
