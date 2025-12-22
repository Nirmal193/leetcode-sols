/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode current = node;
        ListNode next = node.next;
        if(next != null){
            int temp = current.val;
            current.val = next.val;
            next.val = temp;
        }
        ListNode nextPointer = (next == null) ? null : next.next;
        current.next = nextPointer;
    }
}