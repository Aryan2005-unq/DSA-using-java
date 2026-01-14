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
    public void reorderList(ListNode head) {
        if(head == null){
            return ;
        }
        ListNode slow = head;
        ListNode fast = head;
      // finding the middle node 
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
      // reversing the right part of the list 
        ListNode previous = null,current = slow,temp;
        while(current!=null){
            temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
      // merging the final reordered list
        ListNode first = head,second = previous;
        while(second.next!=null){
            temp = first.next;
            first.next = second;
            first = temp;

            temp = second.next;
            second.next = first;
            second = temp;
        }
    }
}
