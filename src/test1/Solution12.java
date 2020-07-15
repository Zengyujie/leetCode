package test1;

public class Solution12 implements Base {
	
//	I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
//	X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
//	C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。

	
	public String intToRoman(int num) {
		StringBuilder sb = new StringBuilder();
		int res = num / 1000;
		if(res > 0)
			insert(sb, 'M', res);
		num = num % 1000;
		
		
		res = num/100;
		if(res == 9)
			sb.append("CM");
		else if(res > 5 && res < 9) {
			sb.append('D');
			insert(sb, 'C', res - 5);
		}else if(res == 5) {
			sb.append('D');
		}
		else if(res == 4)
			sb.append("CD");
		else if(res < 4 && res > 0) 
			insert(sb, 'C', res);
		num = num % 100;
		
		res = num/10;
		if(res == 9)
			sb.append("XC");
		else if(res > 5 && res < 9) {
			sb.append('L');
			insert(sb, 'X', res - 5);
		}else if(res == 5) {sb.append('L');}
		else if(res == 4)
			sb.append("XL");
		else if(res < 4 && res > 0)
			insert(sb, 'X', res);
		num = num % 10;
		
		res = num;
		if(res == 9)
			sb.append("IX");
		else if(res > 5 && res < 9) {
			sb.append('V');
			insert(sb, 'I', res - 5);
		}else if(res == 5) {sb.append('V');}
		else if(res == 4)
			sb.append("IV");
		else if(res < 4 && res > 0) {
			insert(sb, 'I', res);
		}
		
		
		
		
		return sb.toString();
    }
	
	public void insert(StringBuilder sb, char c, int num) {
		for(int i = 0; i < num; i++)
			sb.append(c);
	}
	
	

	@Override
	public void runFunc() {
		// TODO Auto-generated method stub
		System.out.println(intToRoman(58));
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
