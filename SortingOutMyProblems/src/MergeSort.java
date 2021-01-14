import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {6, 2, 7, 28, 8, 32, 7, 65, 4, 25432, 76, 5, 1, 2, 54};
        arr = mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] mergeSort(int[] arr) {
        if (arr.length < 2)
            return arr;
        int[] left = splitLeft(arr);
        int[] right = splitRight(arr);
        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);
    }

    //input: array. output: first half of array.
    public static int[] splitLeft(int[] arr) {
        int[] leftHalf = new int[arr.length / 2];
        for (int i = 0; i < leftHalf.length; i++)
            leftHalf[i] = arr[i];
        return leftHalf;
    }

    //input: array. output: second half of array.
    public static int[] splitRight(int[] arr) {
        int[] rightHalf = new int[arr.length - (arr.length / 2)];
        for (int i = arr.length / 2; i < arr.length; i++)
            rightHalf[i - (arr.length / 2)] = arr[i];
        return rightHalf;
    }

    //input: two sorted arrays. output: ordered merge of two arrays
    public static int[] merge(int[] arr1, int[] arr2) {
        int[] merge = new int[arr1.length + arr2.length];
        int i = 0, j = 0;
        while (i < arr1.length & j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                merge[i + j] = arr1[i];
                i++;
            } else {
                merge[i + j] = arr2[j];
                j++;
            }
        }
        while (i < arr1.length) {
            merge[i + j] = arr1[i];
            i++;
        }
        while (j < arr2.length) {
            merge[i + j] = arr2[j];
            j++;
        }
        return merge;
    }
}