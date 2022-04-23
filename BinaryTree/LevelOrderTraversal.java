package BinaryTree;
import java.util.*;
public class LevelOrderTraversal {
    static class Node
    {
        int data;
        Node left,right;
        Node(int data)
        {
            this.data=data;
            left=right=null;
        }
    }
    public static void LevelOrder(Node root)
    {
        if(root==null)
        {
            System.out.println("Tree is Empty");
        }
        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty())
        {
            Node temp=q.poll();
            System.out.print(temp.data+" ");
            if(temp.left!=null)
                q.add(temp.left);
            if(temp.right!=null)
                q.add(temp.right);
        }

    }
    public static void LevelOrderNew(Node root)
    {
        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        q.add(null);
        while(!q.isEmpty())
        {
            Node temp=q.poll();
            if(temp==null)
            {
                if(q.isEmpty())
                {
                    continue;
                }
                else
                {
                    System.out.println();
                    q.add(null);
                    continue;
                }

            }
            System.out.print(temp.data+" ");
            if(temp.left!=null)
                q.add(temp.left);
            if(temp.right!=null)
                q.add(temp.right);
        }

    }
    public static void main(String[] args) {
        Node root=new Node(1);
        Node node1=new Node(2);
        Node node2=new Node(3);
        Node node3=new Node(4);
        Node node4=new Node(5);
        Node node5=new Node(6);
        Node node6=new Node(7);
        Node node7=new Node(8);
        root.left=node1;
        root.right=node2;
        node1.left=node3;
        node1.right=node4;
        node2.left=node5;
        node2.right=node6;
        node3.left=node7;
        node3.right=new Node(9);
//        LevelOrder(root);
        System.out.println();
        LevelOrderNew(root);



    }
}
