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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int size=len(head);

        ListNode ans=new ListNode();
        ListNode prev=ans;
        ListNode cur=head;

        for(int i=0;i<size-n;i++){
            prev.next=cur;
            cur=cur.next;
            prev=prev.next;
        }
        prev.next=cur.next;
        return ans.next;
        
    }

    public int len(ListNode head){
        ListNode temp=head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;

        }
        return count;
    }
}
