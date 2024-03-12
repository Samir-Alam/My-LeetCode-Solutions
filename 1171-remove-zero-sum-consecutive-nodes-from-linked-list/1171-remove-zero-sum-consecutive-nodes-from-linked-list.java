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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode front = new ListNode(0, head);
        ListNode start = front;
        while (start != null) {
            int prefixSum = 0;
            ListNode end = start.next;
            while (end != null) {
                prefixSum += end.val;
                if (prefixSum == 0) {
                    start.next = end.next;
                }
                end = end.next;
            }
            start = start.next;
        }
        return front.next;
    }
}