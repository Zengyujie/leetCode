package test1;

/*
给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储 一位 数字。
如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
示例：
输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
*/

public class Solution2 implements Base{
	
	public void runFunc() {
		String str = "(9) + (1 -> 9 ->9 ->9 -> 9 ->9 ->9 -> 9 ->9->9->9)";
		str = str.trim();
		str = str.replace("+", "%");
		String[] strs = str.split("%");
		ListNode[] lists = new ListNode[strs.length];
		for(int i = 0; i < strs.length; i++) {
			lists[i] = this.String2ListNode(strs[i].trim());
		}
		ListNode temp = lists[0],t1 = null;
		for(int i = 1; i < lists.length; i++) {
			temp = addTwoNumbers(temp, lists[i]);
		}
		System.out.println(ListNode2String(temp));
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int flag = 0, temp = 0;
		boolean tag = true;
		ListNode n = l1, pre = null;
		while(l1 != null || l2 != null) {
			
			if(l1 != null && l2 != null) {
				temp = l1.val + l2.val + flag;
				l1.val = temp % 10;
				flag = temp / 10;
				pre = l1;
				if(l1.next == null && l2.next == null && flag != 0) {
					l1.next = new ListNode(flag);
					break;
				}
				l1 = l1.next;
				l2 = l2.next;
			}
			
			if(l1 != null && l2 == null) {
				if(flag == 0) {
					break;
				}
				temp = l1.val + flag;
				l1.val = temp % 10;
				flag = temp / 10;
				if(l1.next == null && flag != 0) {
					l1.next = new ListNode(flag);
					break;
				}
				l1 = l1.next;
			}
			
			if(l1 == null && l2 != null) {
				if(tag) {
					pre.next = l2;
					tag = false;
				}
				if(flag == 0) {
					break;
				}
				temp = l2.val + flag;
				l2.val = temp % 10;
				flag = temp / 10;
				if(l2.next == null && flag != 0) {
					l2.next = new ListNode(flag);
					break;
				}
				l2 = l2.next;
			}
		}
		return n;
		//return Int2ListNode(ListNode2Int(l1) + ListNode2Int(l2));
    }
	
	public int ListNode2Int(ListNode n) {
		int temp = 0, count = 1;
		while(n != null) {
			temp += n.val * count;
			count *= 10;
			n = n.next;
		}
		return temp;
	}
	
	public ListNode Int2ListNode(int num) {
		ListNode n = null, temp = null;
		String str = String.valueOf(num);
		for(int i = str.length() - 1; i >= 0; i--) {
			if(n == null) {
				n = new ListNode(Integer.parseInt(str.charAt(i) + ""));
				temp = n;
			}else {
				temp.next = new ListNode(Integer.parseInt(str.charAt(i) + ""));
				temp = temp.next;
			}
		}
		return n;
	}
	
	public ListNode String2ListNode(String str) {
		ListNode n = null, temp = null;
		str = str.substring(1, str.length()-1);
		String[] strs = str.split("->");
		for(String s: strs) {
			if(null == n) {
				n = new ListNode(Integer.parseInt(s.trim()));
				temp = n;
			}else {
				temp.next = new ListNode(Integer.parseInt(s.trim()));
				temp = temp.next;
			}
			
		}
		return n;
	}
	
	public String ListNode2String(ListNode n) {
		StringBuffer sb = new StringBuffer();
		while(n != null) {
			sb.append(n.val);
			sb.append("t");
			n = n.next;
		}
		String str = sb.toString();
		return str.substring(0, str.length() - 1).replace("t", " -> ");
	}
	
	public String getInfo() {
		return "solution2";
	}

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


