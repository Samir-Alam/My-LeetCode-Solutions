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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null)
            return list2;
        else if(list2 == null)
            return list1;
        ListNode head = new ListNode(), temp;
        if(list1.val <= list2.val){
            head.val = list1.val;
            list1 = list1.next;
        }else{
            head.val = list2.val;
            list2 = list2.next;
        }
        temp = head;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                ListNode curr = new ListNode(list1.val);
                temp.next = curr;
                temp = temp.next;
                list1 = list1.next;
            }else{
                ListNode curr = new ListNode(list2.val);
                temp.next = curr;
                temp = temp.next;
                list2 = list2.next;
            }
        }
        if(list1 != null){
            temp.next = list1;
        }
        else if(list2 != null)
            temp.next = list2;
        return head;
    }
}