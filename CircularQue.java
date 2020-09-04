package com.company;

public class CircularQue {
    int size;
    int [] crQue;
    int front , rear;
    CircularQue(int cap){
        size = cap;
        crQue = new int[cap];
        front =-1;
        rear =-1;
    }

    boolean isEmpty(){
        return rear ==-1;
    }

    boolean isFull(){
        if(front==0 &&rear == size+1){
            return true;
        }
        return front == rear + 1;
    }

    void crenQue(int val){
        if(isFull()){
            System.out.println("Queue is Full");
        }else{
            if(front ==-1){
                front = 0;
            }
            rear = (rear+1) % size;
            crQue[rear]= val;

        }
    }

    int crdeQue(){
        int del;
        if(isEmpty()){
            System.out.println("Queue is Empty so cannot Deque");
            return -1;
        }else{
            del = crQue[front];
            if(front==rear){
                front =-1;
                rear =-1;
            }else{
                front = (front+1) % size;
            }
            return del;
        }
    }

    int crPeek(){
        return crQue[front];
    }

    void crPrint(){
        int i;
        if(isEmpty()){
            System.out.println("Queue is Empty");
            System.exit(1);
        }else{
            for(i=front;i!=rear;i = (i+1) % size){
                System.out.print(crQue[i]+" ");
            }System.out.print(crQue[i]+" ");
        }
    }

    public static void main(String[] args){
        CircularQue cq = new CircularQue(5);

        System.out.println(cq.isEmpty());

        System.out.println(cq.crdeQue());

        cq.crenQue(2);
        cq.crenQue(7);
        cq.crenQue(3);
        cq.crenQue(9);
        cq.crenQue(4);

        cq.crPrint();

        cq.crdeQue();
        cq.crdeQue();
        System.out.println();
        cq.crPrint();

        cq.crenQue(10);
        cq.crenQue(8);
        System.out.println();
        cq.crPrint();

    }
}
