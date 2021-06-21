//L.2 Add Two Numbers
//O(max(m, n)) time, O(max(m, n)) space (m, n are the length of the two linkedlists)
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
        ListNode head = new ListNode();
        ListNode cursor = head;
        int temp = 0;
        int newVal = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                newVal = l1.val + l2.val + temp;
                temp = 0;
                if (newVal >= 10) {
                    temp = newVal / 10;
                    newVal %= 10;
                }
                cursor.val = newVal;
                if (l1.next== null && l2.next == null) {
                    break;
                }
                cursor.next = new ListNode();
                cursor = cursor.next;
                l1 = l1.next; 
                l2 = l2.next;
            } else if (l1 == null) {
                newVal = l2.val + temp;
                temp = 0;
                if (newVal >= 10) {
                    temp = newVal / 10;
                    newVal %= 10;
                }
                cursor.val = newVal;
                if (l2.next == null) {
                    break;
                }
                cursor.next = new ListNode();
                cursor = cursor.next;
                l2 = l2.next;
            } else {
                newVal = l1.val + temp;
                temp = 0;
                if (newVal >= 10) {
                    temp = newVal / 10;
                    newVal %= 10;
                }
                cursor.val = newVal;
                if (l1.next == null) {
                    break;
                }
                cursor.next = new ListNode();
                cursor = cursor.next;
                l1 = l1.next;
            }
        }
        if (temp != 0) {
            cursor.next = new ListNode(temp);
        }
        return head;
    }
}