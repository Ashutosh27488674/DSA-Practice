package Codechef;

public class PalindromeUsingRecursion {
    public static boolean isPalindrome(int arr[],int i,int j)
    {
        if(i>j)
        {
            return true;
        }
        if(arr[i]!=arr[j])
            return false;
        return isPalindrome(arr,i+1,j-1);

    }

    public static void main(String[] args) {
        int arr[]={1,2,1};
        System.out.println(isPalindrome(arr,0,arr.length-1));
    }
}
