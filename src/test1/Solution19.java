package test1;

public class Solution19 implements Base {

	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head == null || n <= 0)
			return null;
		int curr = 1;
		ListNode lastN = null, currNode = head, lastPre = null;
		while(currNode != null) {
			if(curr == n) {
				lastN = head;
			}
			currNode = currNode.next;
			if(currNode == null) {
				break;
			}
			if(lastN != null) {
				lastPre = lastN;
				lastN = lastN.next;
			}
			curr++;
		}
		if(lastPre != null) {
			lastPre.next = lastPre.next.next;
		}else {
			if(lastN != null) {
				head = head.next;
			}
		}
		return head;
    }
	
	@Override
	public void runFunc() {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		//l1.next.next = new ListNode(3);
		
		
		ListNode l2 = this.removeNthFromEnd(l1, 2);
		System.out.println("-----");
		while(l2 != null) {
			System.out.println(l2.val);
			l2 = l2.next;
		}
		

	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
