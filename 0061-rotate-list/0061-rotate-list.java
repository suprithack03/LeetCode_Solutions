class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0)
            return head;

        // Find length and last node
        int length = 1;
        ListNode tail = head;

        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        k = k % length;

        if (k == 0)
            return head;

        // Find new last node
        ListNode newLast = head;

        for (int i = 1; i < length - k; i++) {
            newLast = newLast.next;
        }

        // New head
        ListNode newHead = newLast.next;

        // Rotate
        tail.next = head;
        newLast.next = null;

        return newHead;
    }
}