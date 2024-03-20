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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode slow = list1, fast = list1.next;
        ListNode tail = list2;
        while(tail.next != null){
            tail = tail.next;
        }
        int i = a;
        while(i <= b){
            fast = fast.next;
            i++;
        }
        while(a-1 > 0){
            slow = slow.next;
            fast = fast.next;
            a--;
        }
        slow.next = list2;
        tail.next = fast;
        return list1;
    }
}