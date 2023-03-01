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
    // public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    //     ListNode head=new ListNode();
    //     ListNode cur=head;
    //     while(list1!=null && list2!=null){
            
    //         if(list1.val<=list2.val){
    //             cur.next=list1;
    //             list1=list1.next;  
    //         }
    //         else{
    //             cur.next=list2;
    //             list2=list2.next;
    //         }
    //         cur=cur.next;
    //     }
    //     if(list1!=null){
    //         cur.next=list1;
    //     }
    //     else{
    //         cur.next=list2;
    //     }
    //     return head.next;
    // }

    //s.c-O(1) T.C-O(N1+N2)
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if(list1==null) return list2;
            if(list2==null) return list1;
            if(list1.val>list2.val){
                ListNode temp=list1;
                list1=list2;
                list2=temp;
            }

            ListNode res=list1;
            while(list1!=null && list2!=null){
                ListNode temp=null;
                while(list1!=null && list1.val<=list2.val){
                    temp=list1;
                    list1=list1.next;
                }
                temp.next=list2;

                ListNode swap=list1;
                list1=list2;
                list2=swap;

            }
            return res;
    }
}
