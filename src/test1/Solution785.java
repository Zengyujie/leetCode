package test1;

public class Solution785 implements Base {

	
	public static boolean isBipartite(int[][] graph) {
		int[] colors = new int[graph.length];
		for(int i = 0; i < colors.length; i++){
			if(colors[i] == 0){
				colors[i] = 1;
			}
			if(!loop(graph, colors, i)){
				return false;
			}
		}
		return true;
    }
	
	public static boolean loop(int[][] graph, int[] arr, int curr){
		int[] temp = graph[curr];
		int color = arr[curr];
		for(int i = 0; i < temp.length; i++){
			if(arr[temp[i]] == color){
				return false;
			}else if(arr[temp[i]] == 0){
				arr[temp[i]] = -color;
				if(!loop(graph, arr, temp[i])){
					return false;
				}
			}
		}
		return true;
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
