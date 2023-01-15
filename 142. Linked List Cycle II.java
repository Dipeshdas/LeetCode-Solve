/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode hasCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            
            if(slow==fast){
                System.out.println(slow.val);
                return slow;
            }
        }
        return null;
    }
    public ListNode detectCycle(ListNode head) {
        ListNode meet=hasCycle(head);
        
        ListNode cur=head;
        
        if(meet==null){
            return null;
        }
        
        while(cur!=meet){
            cur=cur.next;
            meet=meet.next;
        }
        return cur;
    }
}
