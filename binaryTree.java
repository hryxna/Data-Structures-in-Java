package com.company;

class NodeT{
    int data;
    NodeT left;
    NodeT right;

    NodeT(int D){
        this.data = D;
    }

    void insertIn(int value){
        if(value <= data){
            if(left == null){
                left = new NodeT(value);
            }else{
                left.insertIn(value);
            }
        }else{
            if(right == null){
                right = new NodeT(value);
            }else{
                right.insertIn(value);
            }
        }
    }

    /*
    public static Node insert(Node root,int data) {
            if(root == null){
                root = new Node(data);
                return root;
            }else{
                Node curr = root;
                if(data < root.data){
                    if(root.left == null){
                        curr = new Node(data);
                        root.left = curr;
                    }else{
                        curr = insert(root.left,data);
                    }
                }else{
                    if(root.right == null){
                        curr = new Node(data);
                        root.right = curr;
                    }else{
                        curr = insert(root.right,data);
                    }
                }
            }
            return root;

        }
    */

    /*
    public void preOrderWithoutRecursion() {
    Stack<TreeNode> nodes = new Stack<>();
    nodes.push(root);

    while (!nodes.isEmpty()) {
      TreeNode current = nodes.pop();
      System.out.printf("%s ", current.data);

      if (current.right != null) {
        nodes.push(current.right);
      }
      if (current.left != null) {
        nodes.push(current.left);
      }
    }
  }
    */




    boolean hasNodeValue(int value) {
        if (value == data) {
            return true;
        } else if (value < data) {
            if (left == null) return false;
            else {
                return left.hasNodeValue(value);
            }
        } else {
            if (right == null) return false;
            else {
                return right.hasNodeValue(value);
            }
        }
    }

    // left root right
    void printInOrder(){
        if(left != null){
            left.printInOrder();
        }
        System.out.println(data);
        if(right != null){
            right.printInOrder();
        }
    }

    // root left right
    void printPreOrder() {
        System.out.println(data);
        if (left != null) {
            left.printPreOrder();
        }
        if (right != null) {
            right.printPreOrder();
        }
    }

    //left right root
    void printPostOrder() {
        if (left != null) {
            left.printPostOrder();
        }
        if (right != null) {
            right.printPostOrder();
        }
        System.out.println(data);
    }

    boolean isLeaf(){
        return right == null && left == null;
    }

    int height(){
        if(data == 0) return 0;

        if(isLeaf()) return 0;

        else{
            int l =0; int r =0;
            if(left != null){
               l = left.height();
            }
            if(right != null){
                r = right.height();
            }
            return Math.max(l,r)+1;
        }
    }


    /*int depth(){
        int d= 1;

        if(data == 0) return 0;

        return d;
    }*/

    int noOfNodes(){
        if(data == 0) return 0;
        else{
            int count =0;
            if(left != null) count += left.noOfNodes();
            if(right != null) count += right.noOfNodes();
            return count+1;
        }

    }
    // full binary tree is the one with either 0 or 2 nodes
    boolean isFullBinaryTree(){
        if(data ==0) return true;

        if(left == null && right == null) return true;

        if(left != null && right != null){
            return left.isFullBinaryTree() && right.isFullBinaryTree();
        }

        return false;
    }
    
    // complete binary tree is the one in which all the levels are completely filled except last leaf might not have right sibling
    boolean isCompleteBinaryTree(NodeT root,int index , int node_count){
        
        if(root == null) return true;
        
        if(index >= node_count) return false;

        return isCompleteBinaryTree(left,2 * index + 1,node_count) && isCompleteBinaryTree(right,2 * index + 2,node_count);

    }

}


public class binaryTree {
    public static void main(String[] args) {

        NodeT root = new NodeT(15);
        root.insertIn(2);
        root.insertIn(46);
        root.insertIn(6);
        root.insertIn(1);

        //root.insertIn(5);

        root.printInOrder();
        System.out.println();

        root.printPreOrder();
        System.out.println();

        root.printPostOrder();
        System.out.println();
        System.out.println("\n"+root.height());

        System.out.println(root.hasNodeValue(100));

        System.out.println(root.isFullBinaryTree());

        //System.out.println(root.depth());
        System.out.println(root.noOfNodes());

        System.out.println(root.isCompleteBinaryTree(root,0,root.noOfNodes()));
    }
}
