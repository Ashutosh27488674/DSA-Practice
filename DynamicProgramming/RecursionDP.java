package DynamicProgramming;

public class RecursionDP {
    public static int fibonacci(int n,int arr[])
    {
        if(n<=1)
            return n;
        if(arr[n]!=-1)
            return arr[n];
        return arr[n]=fibonacci(n-1,arr)+fibonacci(n-2,arr);
    }
    public static void main(String[] args) {
       int n=5;
       int arr[]=new int[n+1];
       arr[0]=0;
       arr[1]=1;
       for(int i=2;i<=n;i++)
           arr[i]=-1;
       fibonacci(n,arr);
       for(int i=0;i<n;i++)
           System.out.println(arr[i]);

    }
}