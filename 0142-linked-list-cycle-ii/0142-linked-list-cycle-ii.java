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
            if(slow == fast){
                ListNode cur1 = head;
                ListNode cur2 = fast;
                while(cur1 != cur2){
                    cur1 = cur1.next;
                    cur2 = cur2.next;
                }
                return cur1;
            }
        }
        return null;
    }
}