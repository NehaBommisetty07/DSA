/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // 1. Handle edge cases
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // 2. Compute the length and find the old tail
        ListNode oldTail = head;
        int n = 1;
        while (oldTail.next != null) {
            oldTail = oldTail.next;
            n++;
        }

        // 3. Close the loop (make it circular)
        oldTail.next = head;

        // 4. Find the new tail: (n - k % n - 1)th node
        // and the new head: (n - k % n)th node
        ListNode newTail = head;
        for (int i = 0; i < n - (k % n) - 1; i++) {
            newTail = newTail.next;
        }
        
        ListNode newHead = newTail.next;

        // 5. Break the ring
        newTail.next = null;

        return newHead;
    }
}