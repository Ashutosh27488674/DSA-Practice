package BinaryTree;

public class BinaryTreeInorderUsingRecursion {
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
    public static void PreOrder(TreeNode root)
    {
        if(root==null)
        {
            return ;
        }
        System.out.print(root.data+" ");
        PreOrder(root.left);
        PreOrder(root.right);
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
        PreOrder(root);



    }

}
