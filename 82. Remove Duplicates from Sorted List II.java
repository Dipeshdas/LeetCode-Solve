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
        if(head==null) return null;

        ListNode ans=new ListNode();
        ans.next=head;

        ListNode ptr=ans;

        while(ptr.next!=null && ptr.next.next!=null){

            if(ptr.next.val == ptr.next.next.val){
                int value=ptr.next.val;
                while(ptr.next!=null && ptr.next.val==value){
                    ptr.next=ptr.next.next;
                }
            }
            else{
                ptr=ptr.next;
            }
        }
        return ans.next;
    }
}
