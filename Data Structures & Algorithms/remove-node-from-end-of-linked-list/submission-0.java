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
        int length = 0;
        ListNode temp = head;
        ListNode dummy = new ListNode(0, head);
        while (temp != null) {
            temp = temp.next;
            length++;
        }

        int front = length - n - 1;
        // find the frontth node
        ListNode toRemove = dummy;
        while(front >= 0) {
            front--;
            toRemove = toRemove.next;
        }

        // remove
        System.out.println(toRemove.val);
        toRemove.next = toRemove.next.next;
        return dummy.next;
    }
}
