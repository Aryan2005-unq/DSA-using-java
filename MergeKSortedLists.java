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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> priority = new PriorityQueue<>();

        ListNode dummy = new ListNode(1);
        ListNode merge = dummy;

        for(ListNode list : lists){
            while(list!=null){
                priority.add(list.val);
                list = list.next;
            }
        }
        while(!priority.isEmpty()){
            merge.next = new ListNode(priority.remove());
            merge = merge.next;
        }
        return dummy.next;
    }
}


// Implementation using priority queue which stores values according to priority (smallest value greater priority) 
//So that we can just remove the elements one by one and merge into a new list and return the list 
