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

        if(head==null || k==1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next=head;

        ListNode cur=dummy;
        ListNode temp=dummy;
        ListNode prev=dummy;

        int count=0;
        while(cur.next!=null){
            cur=cur.next;
            count++;
        }
        System.out.println(count);

        while(count>=k){
            cur=prev.next;
            temp=cur.next;

           for(int i=1;i<k;i++){
                cur.next=temp.next;
                temp.next=prev.next;
                prev.next=temp;
                temp=cur.next;
            }
            prev=cur;
            count-=k;
        }
        return dummy.next;
        
    }
}
