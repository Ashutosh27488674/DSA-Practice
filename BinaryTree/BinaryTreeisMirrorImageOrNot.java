package BinaryTree;

public class BinaryTreeisMirrorImageOrNot {
     static class Node
     {
         int data;
         Node left,right;
         Node(int data)
         {
             this.data=data;
             left=right=null;
         }
         public static Node mirror(Node root)
         {
             if(root==null)
                 return null;
             root.left=mirror(root.left);
             root.right=mirror(root.right);
             Node temp=root.left;
             root.left=root.right;
             root.right=temp;
             return root;
         }
         public static boolean isMirror(Node root1,Node root2)
         {
             if (root1!=null && root2!=null)
                 return (isMirror(root1.left,root2.right) && isMirror(root1.right,root2.left));
             if(root1==null && root2==null)
                 return true;
             else
                 return false;

         }
         public static void main(String[] args) {
             Node root=new Node(1);
             Node node1 =new Node(2);
             Node node2 =new Node(3);
             Node node3 =new Node(4);
             Node node4 =new Node(5);
             Node node5 =new Node(6);
             Node node6 =new Node(7);
             Node node7 =new Node(8);
             root.left=node1;
             root.right=node2;
             node1.left=node3;
             node1.right=node4;
             node2.left=node5;
             node2.right=node6;
             node3.left=node7;
//             Node root1=mirror(root.left);
             boolean res=isMirror(root.left,root.right);
             System.out.println(res);

         }
     }
}
