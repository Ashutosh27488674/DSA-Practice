package Recursion;
import java.util.*;

public class AllPermutation {
    public static void Permutation(int arr[],ArrayList<Integer> ds,ArrayList<ArrayList<Integer>> ans,boolean map[],int n)
    {
        if(ds.size()==n)
        {
            ans.add(new ArrayList<Integer>(ds));
            return;
        }
        for(int j=0;j<n;j++)
        {
            if(!map[j])
            {
                ds.add(arr[j]);
                map[j]=true;
                Permutation(arr,ds,ans,map,n);
                map[j]=false;
                ds.remove(ds.size()-1);
            }
        }
    }
    public static void main(String[] args) {
        int arr[]={1,2,3};
        int n=arr.length;
        ArrayList<Integer> ds=new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        boolean map[]=new boolean[n];
        Permutation(arr,ds,ans,map,n);
        for(int i=0;i<ans.size();i++)
        {
            System.out.println(ans.get(i));
        }


    }
}
