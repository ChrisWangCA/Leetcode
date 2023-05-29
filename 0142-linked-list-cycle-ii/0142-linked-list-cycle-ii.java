/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                ListNode cur1 = fast;
                ListNode cur2 = head;
                while(cur1 != null){
                    if(cur1 == cur2) return cur1;
                    cur1 = cur1.next;
                    cur2 = cur2.next;
                }
            }
        }
        return null;
    }
}