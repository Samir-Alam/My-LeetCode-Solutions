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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode temp = head;
        if(head.next == null){
            head = head.next;
            return head;
        }
        ListNode first = head, second = head;
        for (int i = 0; i < n; i++) {
            if (second.next == null) {
                if (i == n - 1)
                    head = head.next;
                return head;
            }
            second = second.next;
        }
        while(second.next != null){
            first = first.next;
            second = second.next;
        }
        first.next = first.next.next;
        return head;
    }
}