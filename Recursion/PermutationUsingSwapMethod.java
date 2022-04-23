package Recursion;

import java.util.ArrayList;

public class PermutationUsingSwapMethod {
    public static void swap(ArrayList<Integer> arr,int i,int j)
    {
        int temp=arr.get(i);
        arr.set(i,arr.get(j));
        arr.set(j,temp);
    }

    public static void Permutation(int i,ArrayList<Integer> arr,ArrayList<ArrayList<Integer>> ans,int n)
    {
        if(i==n)
        {
//            System.out.println(arr);
            ans.add(new ArrayList<Integer>(arr));
            return;
        }
        for(int j=i;j<n;j++)
        {
            swap(arr,i,j);
            Permutation(i+1,arr,ans,n);
            swap(arr,i,j);

        }
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr=new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        int n=arr.size();
        Permutation(0,arr,ans,n);
//        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        for(int i=0;i<ans.size();i++)
        {

            System.out.println(ans.get(i));
        }
//        System.out.println(ans.size());

    }
}
