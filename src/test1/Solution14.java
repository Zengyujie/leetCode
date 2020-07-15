package test1;

public class Solution14 implements Base {
	
	
	public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        String temp = "", s1 = "";
        int k = 0;
        for(int i = 0; i < len; i++){
            if(i == 0)
                temp = strs[0];
            else{
                s1 = strs[i];
                for(k = 0; k < temp.length() && k < s1.length(); k++){
                    if(temp.charAt(k) != s1.charAt(k))
                        break;
                }
                temp = temp.substring(0, k);
            }
        }
        return temp;
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
