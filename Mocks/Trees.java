package Mocks;
import java.util.*;
public class Trees {
//     Node root=null;
     class Node
    {
        int data;
        Node left,right;
        Node(int data)
        {
            this.data=data;
            left=right=null;
        }
    }
    public  Node insert(Node root,int key)
    {
        if(root==null) {
//            System.out.println("Ashutosh");
            Node newnode=new Node(key);
            return newnode;
        }
        if(key>root.data)
            root.right=insert(root.right,key);
        else
            root.left=insert(root.left,key);
        return root;
    }
    public  void inOrder(Node root)
    {
        if(root==null)
            return ;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    public int depth(Node root)
    {
        if(root==null)
            return 0;
        return  Math.max(depth(root.left),depth(root.right))+1;
    }
    public void sumofKthlevel(Node root,int k)
    {
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        int c=0;
        while(!q.isEmpty())
        {
            int x=q.size();
            int sum=0;
            c++;

            for(int i=0;i<x;i++)
            {
                Node temp=q.poll();
                sum+=temp.data;
                if(temp.left!=null)
                    q.add(temp.left);
                if(temp.right!=null)
                    q.add(temp.right);
            }
            if(c==k) {
                System.out.println(sum);
                break;
            }
        }
    }
    public static void main(String[] args) {
        Trees obj=new Trees();
        Node root=null;
        root=obj.insert(root,16);
//        System.out.println(root.data);
       root= obj.insert(root,12);
//        System.ou/t.println(root.left.data);
        root=obj.insert(root,8);
        root=obj.insert(root,15);
        root=obj.insert(root,3);
        root=obj.insert(root,11);
        root=obj.insert(root,32);
        root=obj.insert(root,20);
        root=obj.insert(root,35);
        root=obj.insert(root,-1);
        obj.inOrder(root);
        int depth=obj.depth(root);
        System.out.println();
        System.out.println(depth);
        obj.sumofKthlevel(root,2);


    }
}
