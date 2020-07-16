package test1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution50 implements Base {

	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> lists = new ArrayList<>();
		if(strs == null || strs.length == 0){
			return lists;
		}
		HashMap<Character, Integer> map = generateMap(strs[0]);
		ArrayList<String> list = new ArrayList<>();
		list.add(strs[0]);
		HashMap<HashMap<Character, Integer>, List<String>> set = new HashMap<>();
		set.put(map, list);
		for(int i = 1; i < strs.length; i++){
			map = generateMap(strs[i]);
			if(set.containsKey(map)){
				set.get(map).add(strs[i]);
			}else{
				list = new ArrayList<>();
				list.add(strs[i]);
				set.put(map, list);
			}
		}
		lists.addAll(set.values());
		return lists;
    }
	
	public static HashMap<Character, Integer> generateMap(String s){
		HashMap<Character, Integer> map1 = new HashMap<>();
		for(int i = 0; i < s.length(); i++){
			int n1 = map1.getOrDefault(s.charAt(i), 0);
			map1.put(s.charAt(i), n1 + 1);
		}
		return map1;
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
