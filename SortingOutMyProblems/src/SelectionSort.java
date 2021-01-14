import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {6, 2, 7, 28, 8, 32, 7, 65, 4, 25432, 76, 5, 1, 2, 54};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int swapIndex = findMin(arr, i);
            int tmp = arr[i];
            arr[i] = arr[swapIndex];
            arr[swapIndex] = tmp;
        }
    }

    //input: array and index. output: index of min value in array from given index to end of array
    public static int findMin(int[] arr, int startIndex) {
        int min = arr[startIndex], minIndex = startIndex;
        for (int i = startIndex; i < arr.length; i++)
            if (arr[i] < min) {
                min = arr[i];
                minIndex = i;
            }
        return minIndex;
    }
}