package SegmentTree;

public class SegmentTreeUsingTree {
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
    public static Node BuildTree(int arr[],int start,int end)
    {
        if(start==end)
        {
            return new Node(arr[start]);
        }
        int mid=start+(end-start)/2;
        Node left=BuildTree(arr,start,mid);
        Node right=BuildTree(arr,mid+1,end);
        Node current=new Node(Math.max(left.data,right.data));
        current.left=left;
        current.right=right;
        return current;
    }
    public static void update(int arr[],Node root,int start,int end,int ind,int newValue)
    {
        if(start==end)
        {
            root.data=newValue;
            arr[ind]=newValue;
            return;
        }
        int mid=start+(end-start)/2;
        if(ind>mid && ind<=end)
        {
            update(arr,root.right,mid+1,end,ind,newValue);
        }
        else
        {
            update(arr,root.left,start,mid,ind,newValue);
        }
        root.data=Math.max(root.data,newValue);
    }
    public static int getSum(Node root,int st,int en,int low,int high)
    {
        if(st>=low && en>=high)
            return root.data;
        if(en<low || st>high)
            return 0;
        int mid=low+(high-low)/2;
        return  Math.max(getSum(root.left,st,en,low,mid),
        getSum(root.right,st,en,mid+1,high));
    }
    public static void Print(Node root)
    {
        if(root==null)
            return;
        Print(root.left);
        System.out.print(root.data+" ");
        Print(root.right);
    }
    public static void main(String[] args) {
        int arr[]={5,6,2,3,4,8,7,9,6,12,15};
        int n=arr.length-1;
        Node root=BuildTree(arr,0,n);
        Print(root);
        System.out.println();
        int ans=getSum(root,0,n,0,n);
        System.out.println(ans);
        update(arr,root,0,n,9,17);
        int ans2=getSum(root,0,2,0,n);
        System.out.println(ans2);
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
    }
}
