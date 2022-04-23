package SegmentTree;

public class SegmentTreeUsingArray {
    public static void BuildTree(int arr[],int seg[],int ind,int low,int high)
    {
        if(low==high) {
            seg[ind] = arr[low];
            return;
        }
        int mid=low+(high-low)/2;
        BuildTree(arr,seg,2*ind+1,low,mid);
        BuildTree(arr,seg,2*ind+2,mid+1,high);
        seg[ind]=Math.max(seg[2*ind+1],seg[2*ind+2]);

    }
    public static int getMax(int arr[],int seg[],int ind,int low,int high,int rs,int re)
    {
        if(rs<=low && re>=high)
            return seg[ind];
        if(rs>high || re<low)
            return 0;
        int mid=low+(high-low)/2;
        return Math.max(getMax(arr,seg,2*ind+1,low,mid,rs,re),getMax(arr,seg,2*ind+2,mid+1,high,rs,re));
    }
    static void updateValue(int arr[], int[]
            st, int ss,
                            int se, int index,
                            int value,
                            int node)
    {
        if (index < ss || index > se) {
            System.out.println("Invalid Input");
            return;
        }

        if (ss == se) {

            // update value in array and in
            // segment tree
            arr[index] = value;
            st[node] = value;
        }
        else {
            int mid = ss+(se-ss)/2;

            if (index >= ss && index <= mid)
                updateValue(arr, st, ss, mid,
                        index, value,
                        2 * node + 1);
            else
                updateValue(arr, st, mid + 1, se, index,
                        value, 2 * node + 2);

            st[node] = Math.max(st[2 * node + 1],
                    st[2 * node + 2]);
        }
        return;
    }
    public static void update(int arr[],int seg[],int ind,int index,int low,int high,int value)
    {
        if(index<low  || index>high)
            return;
        if(low==high)
        {
           seg[ind]=value;
           arr[index]=value;
           return;
        }
            int mid = low * (high - low) / 2;
            if (index >=low && index <=mid) {
                update(arr, seg, 2 * ind + 1, index, low, mid, value);
            }
            else
            {
                update(arr, seg, 2 * ind + 2, index, mid+1, high, value);
            }
            seg[ind] = Math.max(seg[2 * ind + 1], seg[2 * ind + 2]);
        return;
    }

    public static void main(String[] args) {
        int arr[]={1,2,3,9,5,6,7,8,9};
        int seg[]=new int[arr.length*4];
        BuildTree(arr,seg,0,0,arr.length-1);
        for(int i=0;i<seg.length;i++)
            System.out.print(seg[i]+" ");
        System.out.println();
        System.out.println(getMax(arr,seg,0,0,arr.length-1,2,5));
        updateValue(arr,seg,0,arr.length-1,5,15,0);
        System.out.println(getMax(arr,seg,0,0,arr.length-1,2,5));
        for(int i=0;i<seg.length;i++)
            System.out.print(seg[i]+" ");
    }
}
