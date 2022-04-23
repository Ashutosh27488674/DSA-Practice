package BinaryTree;

public class PerfectBinaryTreeFromInOrder {
    static class Node{
        int data;
        Node left,right;
        Node(int data)
        {
            this.data=data;
            left=right=null;
        }
        public static Node CunstructTree(int in[] ,int st,int end)
        {
            if(st>end)
            {
                return null;
            }
            Node tnode=new Node(in[st+(end-st)/2]);
            if(st==end)
                return tnode ;
            tnode.left=CunstructTree(in,st,(st+(end-st)/2)-1);
            tnode.right=CunstructTree(in,(st+(end-st)/2)+1,end);
            return tnode;

        }
        public static void InOrder(Node root)
        {
            if(root==null)
                return;
            System.out.print(root.data+" ");
            InOrder(root.left);

            InOrder(root.right);
        }
        public static void main(String[] args) {
            int in[]={4,2,5,1,6,3,7};
            Node root=CunstructTree(in,0,in.length-1);
            InOrder(root);

        }
    }
}
