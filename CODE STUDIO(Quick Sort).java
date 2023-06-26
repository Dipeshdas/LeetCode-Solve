import java.util.* ;
import java.io.*; 
public class Solution {
    public static List<Integer> quickSort(List<Integer> arr){
        QuickSort(arr,0,arr.size()-1);
        return arr;
    }

    public static void QuickSort(List<Integer> arr,int low,int high){
        if(low<high){
            int partition=qs(arr,low,high);
            QuickSort(arr,low,partition-1);
            QuickSort(arr,partition+1,high);
        }
    }

    public static int qs(List<Integer> arr,int low,int high){
        int pivot=arr.get(low);
        int i=low;
        int j=high;

        while(i<j){
            while(arr.get(i)<=pivot && i<high){
                i++;
            }
            while(arr.get(j)>pivot && j>low){
                j--;
            }

            if(i<j){
                int temp=arr.get(i);
                arr.set(i,arr.get(j));
                arr.set(j,temp);
            }
        }
        int temp=arr.get(low);
        arr.set(low,arr.get(j));
        arr.set(j,temp);
        return j;

    }
}
