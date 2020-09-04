package com.company;

public class minHeaps {

    int space ;
    int [] items;

    minHeaps(int x){
        space =0;
        items = new int[x];
    }
    private int getLeftIndex(int parent){return 2 * parent + 1;}
    private int getRightIndex(int parent){return 2 * parent + 2;}
    private int getParentIndex(int child){return (child - 1) / 2;}

    private boolean hasLeftChild(int index){return getLeftIndex(index) < space;}
    private boolean hasRightChild(int index){return getRightIndex(index) < space;}
    private boolean hasParent(int index){return getParentIndex(index) >= 0;}

    private int leftChild(int index){return items[getLeftIndex(index)];}
    private int rightChild(int index){return items[getRightIndex(index)];}
    private int childParent(int index){return items[getParentIndex(index)];}

    private void swap(int index1 , int index2){
        int temp = items[index1];
        items[index1] = items[index2];
        items[index2] = temp;
    }

    public int peek(){
        if(items.length == 0){
            System.out.println("Queue is Empty");
        }
        return items[0];
    }

    public void add(int x){
        if(space == items.length){
            System.out.println("Queue is Full cannot add element");
        }
        items[space] = x;
        heapUp();
        space++;
    }

    public int remove(){
        if(items.length == 0){
            System.out.println("Queue is empty you cannot remove");
        }
        int temp = items[0];
        items[0] = items[space-1];
        space--;
        heapDown();
        return temp;
    }

    public void heapUp(){
        int index = space;
        // here it will see whether it has parent or not and parent val is greater than the current val
        // if true it will swap current value with parent value
        // it will then update the index value with parent index to bubble up
        while(hasParent(index) && childParent(index) > items[index]){
            swap(getParentIndex(index),index);
            index = getParentIndex(index);
        }
    }

    public void heapDown(){
        // here as long as index has left child
        // we save smallval = left index
        // we check if it has index has right child and leftval > rightval then update smallval = right index
        // if the parent node is < than next node then break else swap them
        // update index val = smallval
        int index = 0;
        while(hasLeftChild(index)){
            int smallIndex = getLeftIndex(index);
            //always leftVal is smaller than rightVal
            if(hasRightChild(index) && leftChild(index) > rightChild(index)){
                smallIndex = getRightIndex(index);
            }
            if(items[index] < items[smallIndex]){
                break;
            }
            else{
                swap(smallIndex,index);
            }
            index = smallIndex;
        }
    }

    public void printMin(){
        if(items.length == 0){
            System.out.println("Queue is empty cannot print");
        }else{
            for(int i=0;i<space;i++){
                System.out.print(items[i]+", ");
            }
            System.out.println();
        }
    }


    public static void main(String[]args){

        minHeaps pq = new minHeaps(7);
        pq.add(40);
        pq.add(100);
        pq.add(50);
        pq.add(40);
        pq.add(30);
        pq.add(15);
        pq.add(10);

        pq.printMin();

        pq.remove();
        System.out.println();
        pq.printMin();

    }
}
