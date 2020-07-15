package test1;

public class Solution96 implements Base {
	
	public int numTrees(int n) {
		if(n < 0) {
			return 0;
		}
		if(n >= 0 && n <= 1) {
			return 1;
		}
		int[] log = new int[n + 1];
		log[0] = 1;
		log[1] = 1;
		return numTrees2(n, log);
	}
	
	public int numTrees2(int n, int[] log) {
		if(log[n] != 0) {
			return log[n];
		}
		int sum = 0;
		for(int i = 1; i <= n; i++) {
			sum = sum + numTrees2(i - 1, log) * numTrees2(n - i, log);
		}
		log[n] = sum;
		return sum;
    }
	
	public int numTrees1(int n) {
        // 提示：我们在这里需要用 long 类型防止计算过程中的溢出
		/*
		 * 卡特兰数
		 * h(n)= h(0)*h(n-1) + h(1)*h(n-2) + ... + h(n-1)h(0) (其中n>=2)
		 * 应用：
		 * 1，栈的不同出栈序列：考虑第一个出的是谁，栈内有多少元素，栈外有多少元素
		 * 2，直角三角形网络的走法
		 * 3，n对括号的排列情况
		 * 
		 * 
		 */
        long C = 1;
        for (int i = 0; i < n; ++i) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }



	@Override
	public void runFunc() {
		// TODO Auto-generated method stub
		System.out.println(numTrees(6));
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
