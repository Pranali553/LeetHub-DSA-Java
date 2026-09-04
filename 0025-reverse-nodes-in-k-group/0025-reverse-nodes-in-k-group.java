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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevNode = null;

        while(temp != null){
            ListNode kthNode = getKthNode(temp,k);
        
        if(kthNode == null){
            if(prevNode != null){
                prevNode.next = temp;
            }
            break;
        }
        ListNode nextNode = kthNode.next;
        kthNode.next = null;
        reverse(temp);

        if(temp == head){
            head = kthNode;
        }else{
            prevNode.next = kthNode;
        }
        prevNode = temp;
        temp = nextNode;
    }
    return head;
}
private ListNode getKthNode(ListNode temp, int k){
    int cnt = 1;
    while(temp != null){
        if(cnt == k) return temp;
        cnt++;
        temp = temp.next;
    }
    return temp;
}
private void reverse(ListNode head){
    ListNode prev = null;
    while(head != null){
        ListNode next = head.next;
        head.next = prev;
        prev = head;
        head = next;
    }
}
}