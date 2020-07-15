package test1;

import test1.Solution24.ListNode;

public class Solution25 implements Base {

	
	
	public ListNode reverseKGroup(ListNode head, int k) {
		if(k <= 0)
			return head;
		ListNode fakeNode = new ListNode(1);
		fakeNode.next = head;
		ListNode t1 = fakeNode;
		while(t1 != null) {
			if(getNextN(t1, k) != null) {
				int i = 0; 
				while(i < k / 2) {
					ListNode pre1  = getNextN(t1, i);
					ListNode pre2 = getNextN(t1, k - 1 - i);
					swap2Node(pre1, pre2);
					i++;
				}
			}
			t1 = getNextN(t1, k);
		}
		return fakeNode.next;
    }
	
	public ListNode getNextN(ListNode node, int n) {
		int i = 0;
		if(n <= 0)
			return node;
		while(node != null) {
			node = node.next;
			i++;
			if(i == n)
				break;
		}
		return node;
	}
	
	public void swap2Node(ListNode pre1,ListNode pre2) {
		
		ListNode n1 = pre1.next;
		ListNode n2 = pre2.next;
		if(n1 == null || n2 == null || n1 == n2) {
			return;
		}
		if(n1 == pre2) {
			n1.next = n2.next;
			n2.next = n1;
			pre1.next = n2;
			return;
		}
		if(n2 == pre1) {
			n2.next = n1.next;
			n1.next = n2;
			pre2.next = n1;
			return;
		}
		
		ListNode t = n1.next;
		n1.next = n2.next;
		n2.next = t;
		pre1.next = n2;
		pre2.next = n1;
	}
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "node value: " + val;
		}
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
		System.out.println("-----print-------");
		while(n != null) {
			System.out.println(n.val);
			n = n.next;
		}
	}
	
	
	public ListNode reverseKGroup1(ListNode head, int k) {
		if(k <= 0)
			return head;
		ListNode fakeNode = new ListNode(1);
		fakeNode.next = head;
		ListNode t1 = fakeNode, t2 = null, t3 = null;
		while(t1 != null) {
			t3 = t1.next;
			if((t2 = getNextN(t1, k)) != null) {
				reverseSubList(t1, t2);
			}
			t1 = t3;
		}
		return fakeNode.next;
    }
	
	public void reverseSubList(ListNode headPre, ListNode tail) {
		ListNode head = headPre.next;
		while(head != tail) {
			ListNode t1 = head.next;
			head.next = tail.next;
			tail.next = head;
			head = t1;
		}
		headPre.next = head;
	}
	
	public ListNode getNextN1(ListNode node, int n) {
		int i = 0;
		if(n <= 0)
			return node;
		while(node != null) {
			node = node.next;
			i++;
			if(i == n)
				break;
		}
		return node;
	}
	
	
	@Override
	public void runFunc() {
		// TODO Auto-generated method stub
		ListNode l = getLists1(1,2,3,4,5);
		l = reverseKGroup1(l, 5);
		printList(l);
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
