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
        int lenA = 0;
        int lenB = 0;
        ListNode curA = headA;
        ListNode curB = headB;
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
            int temp = lenA;
            lenA = lenB;
            lenB = temp;
            ListNode temp2 = curA;
            curA = curB;
            curB = temp2;
        }
        int gap = lenA - lenB;
        while(gap-- > 0){
            curA = curA.next;
        }
        while(curA!=null){
            if(curA == curB) return curA;
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}