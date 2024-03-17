// 1171. Remove Zero Sum Consecutive Nodes from Linked List java solution

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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        while (current != null) {
            int sum = 0;
            ListNode runner = current.next;
            while (runner != null) {
                sum += runner.val;
                if (sum == 0) {
                    current.next = runner.next;
                }
                runner = runner.next;
            }
            current = current.next;
        }

        return dummy.next;
    }
}
