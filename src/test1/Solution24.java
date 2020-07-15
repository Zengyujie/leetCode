package test1;

import test1.Solution23.ListNode;

public class Solution24 implements Base {
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	
	public ListNode swapPairs(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode root = null;
		ListNode t1 = null, t2 = null, t3 = null;
		t1 = head;
		t2 = head.next;
		t1.next = t2.next;
		t2.next = t1;
		root = t2;
		t3 = t1;
		t1 = t3.next;
		if(t1 == null) {
			return root;
		}
		t2 = t1.next;
		while(t1 != null && t2 != null) {
			t1.next = t2.next;
			t2.next = t1;
			t3.next = t2;
			t3 = t1;
			if(t3.next != null && t3.next.next != null) {
				t1 = t3.next;
				t2 = t1.next;
			}else {
				break;
			}
			
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
	
	public void printList(ListNode n) {
		while(n != null) {
			System.out.println(n.val);
			n = n.next;
		}
	}

	@Override
	public void runFunc() {
		// TODO Auto-generated method stub
		ListNode li = getLists1(1,2,3,4);
		li = swapPairs(li);
		while(li != null) {
			System.out.println(li.val);
			li = li.next;
		}
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
