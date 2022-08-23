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
    public boolean isPalindrome(ListNode head) {
    //     if(head == null || head.next == null)
    //         return true;
    //     ArrayList<Integer> arr = new ArrayList<>();
    //     while(head != null){
    //         arr.add(head.val);
    //         head = head.next;
    //     }
    //     return isPalin(arr);
    // }
    // public boolean isPalin(ArrayList<Integer> arr){
    //     int n = arr.size();
    //     for(int i = 0; i < n; i++){
    //         if(arr.get(i) != arr.get(n - 1 - i))
    //             break;
    //         else if(i >= n - 1 - i)
    //             return true;
    //     }
    //     return false;
        
        if(head == null)
                return true;
            ListNode p1 = head, p2 = head, p3 = p1.next, pre = p1;
            while(p2.next != null && p2.next.next != null) {
                p2 = p2.next.next;
                pre = p1;
                p1 = p3;
                p3 = p3.next;
                p1.next = pre;
            }
            if(p2.next == null)
                p1 = p1.next;
            while(p3 != null) {
                if(p1.val != p3.val)
                    return false;
                p1 = p1.next;
                p3 = p3.next;
            }
            return true;
    }
}