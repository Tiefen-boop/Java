import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {6, 2, 7, 28, 8, 32, 7, 65, 4, 25432, 76, 5, 1, 2, 54};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSort(int[] arr) {
        for(int i = 1 ; i< arr.length; i ++)
        {
            for(int j = i; j > 0 & arr[j] < arr[j-1]; j--)
            {
                swap(arr, j,j-1);
            }
        }
    }

    public static void swap(int[] arr, int i , int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j]=tmp;
    }
}