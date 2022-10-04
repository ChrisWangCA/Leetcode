/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1,head);
        ListNode cur = dummy;
        while(cur.next!=null && cur.next.next!=null){
            ListNode temp1 = cur.next;
            ListNode temp2 = cur.next.next.next;
            cur.next = temp1.next;
            cur.next.next = temp1;
            temp1.next = temp2;
            cur = cur.next.next;
        }
        return dummy.next;
    }
}