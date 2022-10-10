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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1,head);
        ListNode cur = dummy;
        for(int i=1;i<left;i++){
            cur = cur.next;
        }
        head = cur.next;
        for(int i=left;i<right;i++){
            ListNode next = head.next;
            head.next = next.next;
            next.next = cur.next;
            cur.next = next;
        }
        return dummy.next;
    }
}