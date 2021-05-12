import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {6, 2, 7, 28, 8, 32, 7, 65, 4, 25432, 76, 5, 1, 2, 54};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectionSort(int[] arr) {
        for (int i=0;i<arr.length-1;i++){
            int minIndex=findMinIndex(arr,i,arr.length-1);
            swap(arr,minIndex,i);

        }

    }
    public static int findMinIndex(int[] arr,int i, int j){
        int minIndex=i;
        for (int k=i+1;k<=j;k++){
            if (arr[k]<arr[minIndex])
                minIndex=k;
        }
        return minIndex;
    }
    public static void swap(int[] arr, int i , int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j]=tmp;
    }
}