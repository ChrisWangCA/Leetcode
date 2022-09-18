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
    public boolean isPalindrome(ListNode head) {
        ListNode mid = getMid(head);
        ListNode right = reverse(mid.next);
        ListNode p1 = head;
        ListNode p2 = right;
        while(p2!=null){
            if(p1.val != p2.val) return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        mid.next = reverse(right);
        return true;
    }
    private ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while(cur!=null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
    private ListNode getMid(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}