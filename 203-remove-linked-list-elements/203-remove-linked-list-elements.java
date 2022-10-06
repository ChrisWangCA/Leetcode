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
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1,head);
        ListNode fast = dummy;
        ListNode slow = dummy;
        while(fast!=null){
            if(fast.val == val){
                slow.next = fast.next;
            }else{
                slow = fast;
            }
            fast = fast.next;
        }   
        return dummy.next;
    }
}