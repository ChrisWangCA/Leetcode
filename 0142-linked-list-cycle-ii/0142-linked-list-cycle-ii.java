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
                ListNode indexA = fast;
                ListNode indexB = head;
                while(indexA != indexB){
                    indexA = indexA.next;
                    indexB = indexB.next;
                }
                return indexA;
            }
        }
        return null;
    }
}