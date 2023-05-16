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
    public ListNode partition(ListNode head, int x) {
        ListNode list1=new ListNode(0);
        ListNode list2=new ListNode(0);

        ListNode l1=list1;
        ListNode l2=list2;

        while(head!=null){
            if(head.val<x){
                l1.next=head;
                l1=l1.next;
            }
            else{
                l2.next=head;
                l2=l2.next;
            }
            head=head.next;

        }
        l1.next=list2.next;
        l2.next=null;
        return list1.next;
    }
}
