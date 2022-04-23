package BinaryTree;

public class BinaryTreeUsingPreandInOrder {
    static int prestart=0;
    static class Node{
        int data;
        Node left,right;
        Node(int data)
        {
            this.data=data;
            left=right=null;
        }
        public static int search(int in[],int x)
        {
            for(int i=0;i<in.length;i++)
            {
                if(in[i]==x)
                {
                    return i;
                }
            }
            return -1;
        }
        public static Node MakeTree(int []in,int pre[],int instart,int inend)
        {
            if(instart>inend)
                return null;
            Node newnode=new Node(pre[prestart++]);
            if(instart==inend)
            {
                return newnode;
            }
            int ind=search(in,newnode.data);
            newnode.left=MakeTree(in,pre,instart,ind-1);
            newnode.right=MakeTree(in,pre,ind+1,inend);
            return newnode;
        }
        public static void postOrder(Node root)
        {
            if(root==null)
                return;
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");
        }
        public static void main(String[] args) {
            int in[]={5,4,2,6,1,3};
            int pre[]={1,2,4,5,6,3};
            Node root=MakeTree(in,pre,0,5);
            postOrder(root);

        }
    }
}
