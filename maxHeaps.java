package com.company;

public class maxHeaps {
    int initialsize;
    int [] items ;

    maxHeaps(int x){
        initialsize = 0;
        items = new int[x];
    }

    private int leftChild (int parent){ return (parent * 2 ) + 1;}  // 2 * i + 1
    private int rightChild (int parent){ return (parent * 2) + 2;} // 2 * i + 2
    private int parentIndex (int child){return (child - 1) / 2 ;} // i - 1 / 2

    private boolean hasLeftchild (int index) {return leftChild(index) < initialsize; } // will return true if child exists
    private boolean hasRightchild (int index) { return rightChild(index) < initialsize;} // will return true if child exists
    private boolean hasParent (int index) { return parentIndex(index) >= 0 ;} // will return true if child exists

    private int leftVal (int index) {return items[leftChild(index)];} // will get the value of left-child
    private int rightVal(int index){return items[rightChild(index)];} // will get value of right-child
    private int parentVal (int index){return items[parentIndex(index)];} // will get value of child-parent

    // it will help in deleting the node by replacing with last node
    private void swap(int index1 , int index2){
        int temp = items[index1];
        items[index1] = items[index2];
        items[index2] = temp;
    }

    public int peek(){
        if(items.length == 0){
            System.out.println("Heap is empty");
        }
        return items[0];
    }

    public int remove(){
        if(items.length == 0){
            System.out.println("Cannot remove from emmty heap");
        }
        int temp = items[0];
        items[0] = items[initialsize-1];
        initialsize --;
        heapDown();
        return temp;
    }

    public void add(int x){
        if(initialsize == items.length){
            System.out.println("Cannot add heap is full");
        }
        items[initialsize] = x;
        heapUp();
        initialsize++;

    }

    private void heapUp() {
        int index = initialsize;
        // here it will see whether it has parent or not and parent val is less than the current val
        // if true it will swap current value with parent value
        // it will then update the index value with parent index to bubble up
        while(hasParent(index) && items[index] > parentVal(index)){
            swap(parentIndex(index),index);
            index = parentIndex(index);
        }
    }


    private void heapDown() {
        int index = 0;
        // here as long as index has left child
        // we save bigval = left index
        // we check if it has index has right child and rightval > leftval then update bigval = right index
        // if the parent node is > than next node then break else swap them
        // update index val = bigval
        while(hasLeftchild(index)){
            int bigIndex = leftChild(index);
            //always leftVal is greater than rightVal
            if(hasRightchild(index) && rightVal(index) > leftVal(index)){
                bigIndex = rightChild(index);
            }
            if(items[index]>items[bigIndex]){
                break;
            }else{
                swap(index,bigIndex);
            }
            index = bigIndex;
        }
    }

    public void print(){
        if(items.length==0){
            System.out.println("Heap is Empty");
        }else{
            for(int i=0;i<initialsize;i++){
                System.out.print(items[i]+", ");
            }
            System.out.println();
        }
    }

    public static void main(String[]args){
        maxHeaps heap = new maxHeaps(7);
        heap.add(10);
        heap.add(15);
        heap.add(30);
        heap.add(40);
        heap.add(50);
        heap.add(100);
        heap.add(40);

        heap.print();

        heap.remove();
        System.out.println();
        heap.print();
    }
}
