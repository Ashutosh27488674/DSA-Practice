package BinaryTree;
import java.util.*;

public class PreOrderTraversalIterativeApproach {
    static class TreeNode {
        int data;
        TreeNode left,right;
        TreeNode(int data)
        {
            this.data=data;
            left=right=null;
        }
    }
    public static int Max(TreeNode root,int max1)
    {
        if(root==null)
            return max1;
        if(root!=null)
            max1=Math.max(max1,root.data);
        return Math.max(Max(root.left,max1),Max(root.right,max1));



    }
    public static void InOrder(TreeNode root)
    {
        Stack<TreeNode> st=new Stack<>();
        TreeNode curr=root;
        while(!st.isEmpty() || curr!=null)
        {
           while(curr!=null)
           {
               st.push(curr);
               curr=curr.left;
           }
           curr=st.pop();
            System.out.print(curr.data+" ");
            curr=curr.right;
        }
    }
    public static  void PostOrder(TreeNode root)
    {
        Stack<TreeNode> stack=new Stack<>();
        if(root==null)
            return ;
        stack.push(root);
        while(!stack.isEmpty())
        {
            TreeNode temp=stack.pop();
            System.out.print(temp.data+" ");
            if(temp.right!=null)
                stack.push(temp.right);
            if(temp.left!=null)
                stack.push(temp.left);

        }
    }
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        TreeNode node1=new TreeNode(2);
        TreeNode node2=new TreeNode(3);
       TreeNode node3=new TreeNode(4);
        TreeNode node4=new TreeNode(5);
      TreeNode node5=new TreeNode(6);
        TreeNode node6=new TreeNode(7);
       TreeNode node7=new TreeNode(8);
        root.left=node1;
        root.right=node2;
        node1.left=node3;
        node1.right=node4;
        node2.left=node5;
        node2.right=node6;
        node3.left=node7;
        System.out.print("Pre Order Traversal : ");
        PostOrder(root);
        System.out.println();
        System.out.print("InOrder Traversal : ");
        InOrder(root);
        System.out.println();
        System.out.println(Max(root,Integer.MIN_VALUE));
    }
}
