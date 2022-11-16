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
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode big = new ListNode(0);
        ListNode bigHead = big;
        ListNode cur = head;
        while(cur != null){
            if(cur.val < x){
                small.next = cur;
                small = cur;
            }else{
                big.next = cur;
                big = cur;
            }
            cur = cur.next;
        }
        big.next = null;
        small.next = bigHead.next;
        return smallHead.next;
    }
}