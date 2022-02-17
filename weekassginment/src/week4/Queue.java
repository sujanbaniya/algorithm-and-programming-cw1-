package week4;

public class Queue {

int queues [];
int front=-1;
int rear=-1;
int size = 5;

Queue(){
queues=new int[10];
}

public void enqueue(int data) {
if(isFUll()) {
System.out.println("overflow");
}
else if(front==-1 && rear==-1){

front=rear=0;
queues[rear]=data;

}
else {
rear = (rear+1)%size;
queues[rear]=data;
// System.out.println("rear number is: " + queues[rear]);
// System.out.println("front number is: " + queues[front]);

}
}

public int dequeue() {

if(isEmpty()) {
System.out.println("underflow");
return -1;
}
else if(front==rear) {

int x=front;
front=rear=-1;
return queues[x];
}
else {
int z = front;
front = (front+1)%size;
return queues[z];
}
}

public boolean isEmpty() {

if(front==-1 && rear==-1) {
return true;
}
return false;
}

public boolean isFUll() {

if((rear+1)%size==front) {
return true;
}
return false;
}



}