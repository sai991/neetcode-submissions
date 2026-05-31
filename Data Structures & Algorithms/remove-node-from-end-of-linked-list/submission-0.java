class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode res = head;
        int count = 0;
        while (res != null) {
            res = res.next;
            count++;
        }

        int wanted = count - n + 1; // 1-indexed position from front to remove

        ListNode res1 = dummy; // start from dummy
        for (int tmp = 0; tmp < wanted - 1; tmp++) {
            res1 = res1.next;
        }

        res1.next = res1.next.next;
        return dummy.next;
    }
}