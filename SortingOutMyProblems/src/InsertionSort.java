import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {6, 2, 7, 28, 8, 32, 7, 65, 4, 25432, 76, 5, 1, 2, 54};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++)
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                int tmp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = tmp;
            }
    }
}