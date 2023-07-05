class MyCircularQueue {
    int front,rear;
    int arr[];
    public MyCircularQueue(int k) {
        arr=new int[k];
        front=-1;
        rear=-1;
    }
    
    public boolean enQueue(int value) {
        int size=arr.length;
        if((rear+1)%size==front){
            return false;
        }
        if(front==-1) front=0;
        rear=(rear+1)%size;
        arr[rear]=value;
        return true;
    }
    
    public boolean deQueue() {
        if(front==-1){
            return false;
        }
        if(front==rear){
            front=-1;
            rear=-1;
        }
        else{
            front=(front+1)%arr.length;
        }
        return true;
        
    }
    
    public int Front() {
        if(front==-1){
            return -1;
        }
        return arr[front];
    }
    
    public int Rear() {
        if(rear==-1){
            return -1;
        }
        return arr[rear];
    }
    
    public boolean isEmpty() {
        if(front==-1){
            return true;
        }
        return false;
    }
    
    public boolean isFull() {
        if((rear+1)%arr.length==front){
            return true;
        }
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
