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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        StringBuilder st1 = new StringBuilder();
        StringBuilder st2 = new StringBuilder();

        while (l1 != null) {
            st1.append(l1.val);   // Bug fix: was 'val', should be 'l1.val'
            l1 = l1.next;         // Bug fix: missing — caused infinite loop
        }

        while (l2 != null) {
            st2.append(l2.val);   // Bug fix: was 'val', should be 'l2.val'
            l2 = l2.next;         // Bug fix: missing — caused infinite loop
        }

        st1.reverse();
        st2.reverse();

        // Bug fix: BigInteger instead of Integer to handle large numbers
        java.math.BigInteger res = new java.math.BigInteger(st1.toString())
                                 .add(new java.math.BigInteger(st2.toString()));

        String st = res.toString();
        StringBuilder sb = new StringBuilder(st);
        sb.reverse();

        // Build the result linked list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (int c = 0; c < sb.length(); c++) {
            int digit = sb.charAt(c) - '0';
            current.next = new ListNode(digit);
            current = current.next;
        }

        return dummy.next;
    }
}