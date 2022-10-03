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
    public int pairSum(ListNode head) {
        List<Integer> a = new ArrayList<>();
        while(head != null){
            a.add(head.val);
            head = head.next;
        }
        int n = a.size(), sum = 0;
        for(int i = 0; i < n/2; i++)
            sum = Math.max(sum, a.get(i) + a.get(n - i - 1));
        return sum;
    }
}