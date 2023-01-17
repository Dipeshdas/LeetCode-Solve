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
    public void swap(ListNode l1,ListNode l2){
        if(l1==null || l2==null){
            return;
        }
        int temp=l1.val;
        l1.val=l2.val;
        l2.val=temp;
    }
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode temp1=head; 
        ListNode temp2=head.next; 
        
        while(temp1!=null && temp2!=null && temp2.next!=null){
            swap(temp1,temp2);
            temp1=temp1.next.next;
            temp2=temp2.next.next;
        }
        swap(temp1,temp2);
        return head;
    }
}
