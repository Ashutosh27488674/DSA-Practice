package Codechef;
import java.util.*;

public class SubArrayOfArray {
    public static void Subarray(int arr[], int i, int j, ArrayList<ArrayList<Integer>> ds) {
        if (j == arr.length)
            return;
        if (i > j) {
            Subarray(arr, 0, j + 1, ds);
        }
        else {

            ArrayList<Integer> sub = new ArrayList<>();
            for (int x = i; x <= j; x++) {
                sub.add(arr[x]);
            }
            ds.add(new ArrayList<>(sub));
            Subarray(arr, i + 1, j, ds);
        }
    }

    public static void main(String[] args) {
        int arr[]={1,2,3};
        ArrayList<ArrayList<Integer>> ds=new ArrayList<ArrayList<Integer>>();
        Subarray(arr,0,0,ds);
        for(int i=0;i<ds.size();i++)
        {
            System.out.println(ds.get(i));
        }
    }
}
