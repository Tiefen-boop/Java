public class Fibonacci {
    public static void main(String[] args) {
    }

    public static int fibIterative(int n){
        if (n==0 | n==1)
            return 1;
        int pos = 2, posMin1 = 1, posMin2 = 1;
        n -=2;
        while (n>=0){
            pos = posMin1 + posMin2;
            posMin2 = posMin1;
            posMin1 = pos;
            n--;
        }
        return pos;
    }

    public static int fibRecursive(int n){
        if (n==0 | n==1)
            return 1;
        return fibRecursive(n-1) + fibRecursive(n-2);
    }

    public static int fibRecMemoized(int n){
        int[] answersTable = new int[n+1];
        return fibRecMemoized(answersTable, n);
    }

    public static int fibRecMemoized(int[] table, int n){
        if (n==0 | n==1)
            return 1;
        if (table[n] == 0){
            table[n] = fibRecMemoized(table, n-1) + fibRecMemoized(table, n-2);
        }
        return table[n];
    }
}
