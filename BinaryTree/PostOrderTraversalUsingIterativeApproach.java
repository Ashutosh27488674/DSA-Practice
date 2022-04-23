package BinaryTree;

import java.util.Stack;

public class PostOrderTraversalUsingIterativeApproach {
    static class TreeNode
    {
        int data;
        TreeNode left,right;
        TreeNode(int data)
        {
            this.data=data;
            left=right=null;
        }
    }
    public static  void PostOrder(TreeNode root)
    {
        Stack<TreeNode> stack=new Stack<>();
        Stack<TreeNode> stack1=new Stack<>();
        if(root==null)
            return ;
        stack.push(root);
        while(!stack.isEmpty())
        {
            TreeNode temp=stack.pop();
            stack1.push(temp);
            if(temp.left!=null)
                stack.push(temp.left);
            if(temp.right!=null)
                stack.push(temp.right);


        }
        while(!stack1.isEmpty())
        {
            System.out.print(stack1.pop().data+" ");
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
        PostOrder(root);



    }
}
