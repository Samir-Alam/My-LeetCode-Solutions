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
    private ListNode mergekthLists(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode head;
        if(l1.val <= l2.val) head = l1;
        else head = l2;

        if(l1.val <= l2.val) head.next = mergekthLists(l1.next, l2);
        else head.next = mergekthLists(l1, l2.next);
        return head;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        ListNode head = lists[0];

        for(int i = 1; i < lists.length; ++i)
            head = mergekthLists(head, lists[i]);

        return head;
    }
}