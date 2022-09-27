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
    public int getDecimalValue(ListNode head) {
        // if(head.next == null)
        //     return head.val;
        // List<Integer> a = new ArrayList<>();
        // while(head != null){
        //     a.add(head.val);
        //     head = head.next;
        // }
        // int res = 0;
        // for(int i = 0; i < a.size(); i++){
        //     res += Math.pow(2, i) * a.get(a.size() - i - 1);
        // }
        // return res;
        
        //2nd Solution
        int num = head.val;
        while (head.next != null) {
            num = num * 2 + head.next.val;
            head = head.next;    
        }
        return num;
    }
}