import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {6, 2, 7, 28, 8, 32, 7, 65, 4, 25432, 76, 5, 1, 2, 54};
        arr = mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int [] mergeSort(int[] arr) {
        if (arr.length <= 1)
            return arr;
        int[][] split = Split(arr);
        split[0] = mergeSort(split[0]);
        split[1] = mergeSort(split[1]);
        return merge(split[0], split[1]);
    }
    public static int [] [] Split(int []arr) {
        int[][] split = new int[2][];
        split[0] = new int[arr.length / 2];
        split[1] = new int[arr.length - (arr.length / 2)];

        int i = 0;
        while (i < split[0].length) {
            split[0][i] = arr[i];
            i++;
        }
        while (i < arr.length) {
            split[1][i - split[0].length] = arr[i];
            i++;
        }
        return split;
    }
    public static int [] merge(int[]arr1,int[]arr2){
        int[]arr=new int [arr1.length+arr2.length];
        int a1=0;
        int a2=0;
        while (a1< arr1.length & a2 < arr2.length){
            if (arr1[a1]<arr2[a2]) {
                arr[a1+a2] = arr1[a1];
                a1++;
            }
            else {
                arr[a1+a2] = arr2[a2];
                a2++;
            }
        }
        while (a1< arr1.length){
            arr[a1+a2]=arr1[a1];
            a1++;
        }
        while (a2< arr2.length){
            arr[a1+a2]=arr2[a2];
            a2++;
        }
        return arr;
    }


}