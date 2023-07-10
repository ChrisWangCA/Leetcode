/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        int lenA = 0;
        int lenB = 0;
        while(curA!=null){
            curA = curA.next;
            lenA++;
        }
        while(curB!=null){
            curB = curB.next;
            lenB++;
        }
        curA = headA;
        curB = headB;
        if(lenB > lenA){
           int len = lenA;
            lenA = lenB;
            lenB = len;
            ListNode cur = curA;
            curA = curB;
            curB = cur;
        }
        int gap = lenA - lenB;
        while(gap-- > 0){
            curA = curA.next;
        }
        while(curA != null){
            if(curA == curB) return curA;
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}