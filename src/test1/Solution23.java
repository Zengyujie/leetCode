package test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution23 implements Base {

	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "" + val;
		}
	}
	
	public ListNode getLists(Object[] args) {
		ListNode root = null, curr = null;
		for(int i = 0; i < args.length; i++) {
			if(root == null) {
				root = new ListNode((Integer)args[i]);
				curr = root;
			}else {
				curr.next = new ListNode((Integer)args[i]);
				curr = curr.next;
			}
		}
		return root;
	}
	
	
	
	public ListNode mergeKLists(ListNode[] lists) {
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i = 0; i < lists.length; i++) {
			ListNode temp = lists[i];
			while(temp != null) {
				arr.add(temp.val);
				temp = temp.next;
			}
		}
		Object[] arr1 = arr.toArray();
		Arrays.sort(arr1);
		return getLists(arr1);
    }
	
	public ListNode mergeKLists1(ListNode[] lists) {
		ListNode root = null;
		ListNode currMin = null;
		ArrayList<ListNode> arr = new ArrayList<>();
		for(int i = 0; i < lists.length; i++) {
			if(lists[i] != null) {
				arr.add(lists[i]);
			}
		}
		if(arr.size() < 1) {
			return root;
		}
		ListNode[] temp = arr.toArray(new ListNode[1]);
		Comparator<ListNode> co = new Comparator<ListNode>() {

			@Override
			public int compare(ListNode o1, ListNode o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1.val, o2.val);
			}
			
		};
		Arrays.sort(temp, co);
		int emptyCount = temp.length, counter = 0;
		while(counter < emptyCount) {
			if(root == null) {
				root = temp[0];
				currMin = root;
				temp[0] = temp[0].next;
				if(temp[0] == null) {
					counter++;
				}
			}else {
				while(temp[0] != null && temp[0].next != null && temp[0].val == temp[0].next.val) {
					currMin.next = temp[0];
					currMin = currMin.next;
					temp[0] = temp[0].next;
				}
				if(temp[0] == null) {
					counter++;
				}else if(temp[0].next == null) {
					currMin.next = temp[0];
					currMin = currMin.next;
					counter++;
					temp[0] = null;
				}else {
					currMin.next = temp[0];
					currMin = currMin.next;
					temp[0] = temp[0].next;
				}
			}
			if(temp[0] == null)
				temp = Arrays.copyOfRange(temp, 1, temp.length);
			Arrays.sort(temp, co);
		}
		return root;
    }
	
	public ListNode getLists1(int... args) {
		ListNode root = null, curr = null;
		for(int i = 0; i < args.length; i++) {
			if(root == null) {
				root = new ListNode(args[i]);
				curr = root;
			}else {
				curr.next = new ListNode(args[i]);
				curr = curr.next;
			}
		}
		return root;
	}
	
	
	public ListNode mergeKLists2(ListNode[] lists) {
		ListNode root = null;
		int i = 0;
		for(; i < lists.length; i++) {
			if(lists[i] != null) {
				root = lists[i];
				break;
			}
		}
		for(int j = i + 1; j < lists.length; j++) {
			ListNode t1 = root, t2 = new ListNode(1);
			ListNode t3 = t2;
			ListNode curr = lists[j];
			while(curr != null && t1 != null) {
				if(t1.val <= curr.val) {
					t3.next = t1;
					t1 = t1.next;
				}else {
					t3.next = curr;
					curr = curr.next;
				}
				t3 = t3.next;
			}
			if(curr == null) {
				t3.next = t1;
			}
			if(t1 == null) {
				t3.next = curr;
			}
			root = t2.next;
		}
		return root;
    }
	
	
	public ListNode merge(ListNode[] lists, int left, int right) {
		if(left + 1 == right) {
			return lists[left];
		}else if(left >= right) {
			return null;
		}
		int mid = (left + right) >> 1;
		return merge2List(merge(lists, left, mid), merge(lists, mid, right));
    }
	
	
	public ListNode merge2List(ListNode l1, ListNode l2) {
		ListNode t1 = l1, t2 = new ListNode(1);
		ListNode t3 = t2;
		ListNode curr = l2;
		while(curr != null && t1 != null) {
			if(t1.val <= curr.val) {
				t3.next = t1;
				t1 = t1.next;
			}else {
				t3.next = curr;
				curr = curr.next;
			}
			t3 = t3.next;
		}
		if(curr == null) {
			t3.next = t1;
		}
		if(t1 == null) {
			t3.next = curr;
		}
		return t2.next;
	}
	
	@Override
	public void runFunc() {
		// TODO Auto-generated method stub
		int nums[] = {1,4,2,5,4};
		ListNode l1 = getLists1(1,4,5);
		ListNode l2 = getLists1(1,3,4);
		ListNode l3 = getLists1(2,6);
		ListNode[] lists = new ListNode[] {l1, l2, l3};
		ListNode root = merge(lists, 0, lists.length);
		System.out.println("test");
		while(root != null) {
			System.out.println(root.val);
			root = root.next;
		}
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
