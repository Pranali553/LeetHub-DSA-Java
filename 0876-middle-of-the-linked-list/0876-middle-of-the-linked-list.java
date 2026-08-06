class Solution {
    public ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode temp = head;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        int mid = count/2;

        temp = head;
        while(mid > 0){
            temp = temp.next;
            mid--;
        }
        return temp;
    }
}