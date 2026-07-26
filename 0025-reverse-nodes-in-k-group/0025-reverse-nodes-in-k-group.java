/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */

class Solution {

    // Reverse a linked list
    public ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode temp = head;

        while (temp != null) {
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }

        return prev;
    }

    // Find the kth node from head
    public ListNode findKthNode(ListNode head, int k) {

    int count = 1;

    while (head != null && count < k) {
        head = head.next;
        count++;
    }

    return head;
}

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode temp = head;
        ListNode prevLast = null;

        while (temp != null) {

            // Find kth node
            ListNode kthNode = findKthNode(temp, k);

            // Less than k nodes left
            if (kthNode == null) {

                if (prevLast != null)
                    prevLast.next = temp;

                break;
            }

            // Save next group's starting node
            ListNode nextNode = kthNode.next;

            // Break the current group
            kthNode.next = null;

            // First group
            if (temp == head) {
                head = reverse(temp);
            }
            else {
                prevLast.next = reverse(temp);
            }

            // temp becomes the last node after reversing
            prevLast = temp;

            // Connect with next group
            temp.next = nextNode;

            // Move to next group
            temp = nextNode;
        }

        return head;
    }
}