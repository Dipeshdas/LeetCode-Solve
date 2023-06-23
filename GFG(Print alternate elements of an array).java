//{ Driver Code Starts
//Initial Template for Java
import java.util.*;

class Alternate
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
             GfG gfg = new GfG();
             gfg.print(arr, n);
             System.out.println();
             
        }
    }
}
// } Driver Code Ends


//User function Template for Java

// arr[] is the array 
// n is the number of elements in array.
class GfG
{
    public static void print(int arr[], int n)
    {
        System.out.print(arr[0]);
        for(int i=1;i<n;i++){
            if(i%2==0)
                System.out.print(" "+arr[i]);
        }
    }
}
