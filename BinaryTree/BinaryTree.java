package BinaryTree;
import java.util.*;
public class BinaryTree {
    static class Node
    {
        int data;
        Node left,right;
        Node(int data)
        {
            this.data=data;
            left=right=null;
        }
        public static void inOrder(Node root,ArrayList<Integer> arr)
        {
            if(root==null)
                return ;
            inOrder(root.left,arr);
            System.out.print(root.data+" ");
            arr.add(root.data);
            inOrder(root.right,arr);
        }
        public static boolean isBst(Node root)
        {
            ArrayList<Integer> arr=new ArrayList<>();
            inOrder(root,arr);
            for(int i=1;i<arr.size();i++)
            {
                if(arr.get(i)<arr.get(i-1))
                    return false;
            }
            return true;

        }

        public static void main(String[] args) {
            Node root=new Node(8);
            Node node1=new Node(6);
            Node node2=new Node(16);
            Node node3=new Node(4);
            Node node4=new Node(7);
            Node node5=new Node(9);
            Node node6=new Node(18);
            root.left=node1;
            root.right=node2;
            node1.left=node3;
            node1.right=node4;
            node2.left=node5;
            node2.right=node6;
            boolean flag=isBst(root);
            System.out.println();
            if(flag==true)
            {
                System.out.println("Binary tree is BST.");
            }
            else
                System.out.println("Binary tree is not BST");
        }

    }
}
