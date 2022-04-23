 package Codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Holiday
{
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes her
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0)
        {

            int n=sc.nextInt(),k=sc.nextInt();
            String s;
            s = sc.next();
            int max1=Integer.MIN_VALUE,d=0,c=0,j=0,b=0;
            for(int i=0;i<s.length();i++)
            {
                if(s.charAt(i)=='0')
                {
                    d++;
                }
                else if(s.charAt(i)=='1')
                {
                    if(d>=k)
                    {
                        b++;
                    }
                    if(c==0)
                    {
                        d++;
                        c++;
                    }
                    else
                    {
                        // System.out.println(i+" "+j);
                        max1=Math.max(max1,i-j);
                        while(s.charAt(j)!='1')
                        {
                            d--;
                            j++;

                            // System.out.println(d+" "+j);

                        }
                        d++;
                        c++;
                        // d--;
                        // j++;
                    }
                }
                max1=Math.max(max1,i-j);
            }
            if(max1/k>b)
            {
                System.out.println(b+1);
            }
            else
            {
                System.out.println(b);
            }
            t--;
        }
    }
}
