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
        while(cur.next != null && cur.next.next != null){
            ListNode t1 = cur.next;
            ListNode t2 = cur.next.next.next;
            cur.next = cur.next.next;
            cur.next.next = t1;
            t1.next = t2;
            cur = cur.next.next;
        }
        return dummy.next;
    }
}