/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node itr=head;
        Node front=head;

        while(itr!=null){
            front=itr.next;
            Node copy=new Node(itr.val);
            itr.next=copy;
            copy.next=front;
            itr=front;
        }

        itr=head;
        while(itr!=null){
            if(itr.random!=null){
                //System.out.println(itr.next.val);
                itr.next.random=itr.random.next;
            }
            itr=itr.next.next;
        }

        itr=head;
        Node ans=new Node(0);
        Node copy=ans;

        while(itr!=null){
            front=itr.next.next;
            copy.next=itr.next;
            itr.next=front;
            copy=copy.next;
            itr=itr.next;
        }
        return ans.next;
    }
}
