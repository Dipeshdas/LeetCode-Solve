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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode ans=new ListNode();
        ListNode cur=ans;
        ListNode temp=head;
        while(temp.next!=null){
            if(temp.val==temp.next.val){
                temp=temp.next;
                cur.next=temp;
            }
            else{
                cur.next=temp;
                temp=temp.next;
                cur=cur.next;
            }
        }
        return ans.next;

        
    }
}
