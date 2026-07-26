public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode temp1 = headA;
        ListNode temp2 = headB;

        int l1 = 0;
        int l2 = 0;

        // Find length of List A
        while (temp1 != null) {
            l1++;
            temp1 = temp1.next;
        }

        // Find length of List B
        while (temp2 != null) {
            l2++;
            temp2 = temp2.next;
        }

        // Reset pointers
        temp1 = headA;
        temp2 = headB;

        int diff = Math.abs(l1 - l2);

        // Move the pointer of the longer list ahead by diff nodes
        if (l1 > l2) {
            while (diff > 0) {
                temp1 = temp1.next;
                diff--;
            }
        } else {
            while (diff > 0) {
                temp2 = temp2.next;
                diff--;
            }
        }

        // Move both pointers together
        while (temp1 != temp2) {
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return temp1;
    }
}