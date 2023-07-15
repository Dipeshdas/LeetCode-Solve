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
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode slow=head;
        ListNode fast=head;
        ListNode prev=null;

        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next=null;
        ListNode l1=sortList(head);
        ListNode l2=sortList(slow);
        //System.out.println(l1.val);
        return mergeSort(l1,l2);
    }
    public static ListNode mergeSort(ListNode l1,ListNode l2){
        ListNode fh=null;
        ListNode ft=null;

        while(l1!=null && l2!=null){
            if(fh==null && ft==null){
                if(l1.val>l2.val){
                    fh=l2;
                    ft=l2;
                    l2=l2.next;
                }
                else{
                    fh=l1;
                    ft=l1;
                    l1=l1.next;
                }
            }
            if(l1!=null && l2!=null){
                if(l1.val<l2.val){
                    ft.next=l1;
                    ft=ft.next;
                    l1=l1.next;
                }
                else{
                    ft.next=l2;
                    ft=ft.next;
                    l2=l2.next;
                }
            }
        }
        if(l1!=null){
            ft.next=l1;
        }
        if(l2!=null){
            ft.next=l2;
        }
        return fh;
    }
}
