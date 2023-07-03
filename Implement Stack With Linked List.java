class LinkedListNode 
{
    int data;
    LinkedListNode next;
    
    LinkedListNode(int data) 
    {
        this.data = data;
        this.next = null;
    }
}

public class Stack 
{
    
    //Make the class variables here
    LinkedListNode head;
    int size;
    public Stack() 
    {
        head=null;
        size=0;

        //Implement the default constructor
    }

    public int getSize() 
    {
        return size;
        //Implement the function
    }
    
    public boolean isEmpty() 
    {
        return size==0;
        //Implement the function
    }

    public void push(int data) 
    {
        LinkedListNode temp=new LinkedListNode(data);
        temp.next=head;
        head=temp;
        size++;
        //Implement the function
    }

    public void pop() 
    {
        if(size!=0){
            head=head.next;
            size--;
        }
        
        //Implement the function
    }

    public int getTop() 
    {
        if(size==0){
            return -1;
        }
        return head.data;
        //Implement the function
    }
}
