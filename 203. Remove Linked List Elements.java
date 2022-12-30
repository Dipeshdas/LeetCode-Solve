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
    public ListNode removeElements(ListNode head, int val) {

        //1st approach------>>>>

        // if(head==null){
        //     return head;
        // }
        // ListNode ans=new ListNode(0);
        // ListNode cur=ans;
        
        // ListNode temp=head;
        
        // while(temp!=null){
        //     if(temp.val!=val){
        //         cur.next=new ListNode(temp.val);
        //         cur=cur.next;
        //     }
        //     temp=temp.next; 
        // }
        // return ans.next;


        //Second Approach------------->>>>>

         if(head==null){
            return head;
        }

        ListNode temp=head;
        ListNode prev=new ListNode();
        ListNode cur=prev; 

        while(temp!=null){
            if(temp.val==val){
                temp=temp.next;
            }
            else{
                cur.next=temp;
                temp=temp.next; 
                cur=cur.next;
            }
        }
        cur.next=temp;
        return prev.next;
    }
}
