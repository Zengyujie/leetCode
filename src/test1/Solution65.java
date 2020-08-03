package test1;

import java.util.HashMap;

public class Solution65 implements Base {

	public boolean isNumber(String s) {
		if(s == null)
			return  false;
		s = s.trim();
		if(s.isEmpty())
			return false;
        boolean symbolFlag = true;
        boolean eFlag = true;
        boolean dotFlag = true;
        boolean numFlag = false;
        boolean useE = false;
        boolean useDot = false;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < 10; i++){
            map.put((char)('0' + i), i);
        }
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)) {
            	if(!numFlag)
            		numFlag = true;
            }else {
            	if(c == '-' || c == '+'){
            		if(i != 0) {
            			symbolFlag = false;
            		}
                }else if(c == 'e') {
                	if(!useE && i > 0 && map.containsKey(s.charAt(i - 1)) && i < s.length() - 1 && map.containsKey(s.charAt(i + 1))) {
                		useE = true;
                	}else {
                		eFlag = false;
                	}
                }else if(c == '.') {
                	if(!useDot && i > 0 && map.containsKey(s.charAt(i - 1)) && i < s.length() - 1 && map.containsKey(s.charAt(i + 1))) {
                		useDot = true;
                	}else if(i == 0 && i < s.length() - 1 && map.containsKey(s.charAt(i + 1))){
                		useDot = true;
                	}else if(!useDot && i > 0 && i == s.length() - 1 && map.containsKey(s.charAt(i - 1))){
                		useDot = true;
                	}else if(s.length() > 2 && i == 1 && symbolFlag && map.containsKey(s.charAt(i + 1))){
                		useDot = true;
                	}else {
                		dotFlag = false;
                	}
                }else {
                	return false;
                }
            } 
        }
        return symbolFlag && dotFlag && eFlag&&numFlag;
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
