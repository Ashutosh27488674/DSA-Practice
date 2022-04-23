package BinaryTree;

public class BinaryTreeInorderTraversalUsingRecursion {
    static class TreeNode
    {
        int data;
        BinaryTreePostOrderTraversalUsingRecusion.TreeNode left,right;
        TreeNode(int data)
        {
            this.data=data;
            left=right=null;
        }
    }
    public static void InOrder(BinaryTreePostOrderTraversalUsingRecusion.TreeNode root)
    {
        if(root==null)
        {
            return ;
        }

        InOrder(root.left);
        System.out.print(root.data+" ");
        InOrder(root.right);

    }

    public static void main(String[] args) {
        BinaryTreePostOrderTraversalUsingRecusion.TreeNode root=new BinaryTreePostOrderTraversalUsingRecusion.TreeNode(1);
        BinaryTreePostOrderTraversalUsingRecusion.TreeNode node1=new BinaryTreePostOrderTraversalUsingRecusion.TreeNode(2);
        BinaryTreePostOrderTraversalUsingRecusion.TreeNode node2=new BinaryTreePostOrderTraversalUsingRecusion.TreeNode(3);
        BinaryTreePostOrderTraversalUsingRecusion.TreeNode node3=new BinaryTreePostOrderTraversalUsingRecusion.TreeNode(4);
        BinaryTreePostOrderTraversalUsingRecusion.TreeNode node4=new BinaryTreePostOrderTraversalUsingRecusion.TreeNode(5);
        BinaryTreePostOrderTraversalUsingRecusion.TreeNode node5=new BinaryTreePostOrderTraversalUsingRecusion.TreeNode(6);
        BinaryTreePostOrderTraversalUsingRecusion.TreeNode node6=new BinaryTreePostOrderTraversalUsingRecusion.TreeNode(7);
        BinaryTreePostOrderTraversalUsingRecusion.TreeNode node7=new BinaryTreePostOrderTraversalUsingRecusion.TreeNode(8);
        root.left=node1;
        root.right=node2;
        node1.left=node3;
        node1.right=node4;
        node2.left=node5;
        node2.right=node6;
        node3.left=node7;
        InOrder(root);



    }
}
