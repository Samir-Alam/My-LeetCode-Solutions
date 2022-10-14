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
    public ListNode deleteMiddle(ListNode head) {
        // if(head.next == null)
        //     return null;
        // int n = 0;
        // ListNode temp = head;
        // while(temp != null){
        //     n++;
        //     temp = temp.next;
        // }
        // n /= 2;
        // temp = head;
        // while(n-- > 1)
        //     temp = temp.next;
        // temp.next = temp.next.next;
        // return head;
        
        //2nd Solution
        if (head.next == null)
            return null;
        ListNode slow = head, fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}