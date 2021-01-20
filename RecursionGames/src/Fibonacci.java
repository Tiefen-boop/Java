public class Fibonacci {
    public static void main(String[] args) {
        for ( int i = 0; i< 10; i++)
        System.out.print(fibCount(0, i) + ", ");
    }

    public static int fibIterative(int n) {
        if (n < 2)
            return 1;
        int ans = 2, prev = 1;
        for (int i = 2; i <= n; i++) {
            ans += prev;
            prev = ans - prev;
        }
        return ans;
    }

    public static int fibRecursive(int n){
        if (n==0 | n==1)
            return 1;
        return fibRecursive(n-1) + fibRecursive(n-2);
    }

    public static int fibCount(int m, int n){ //counts the number of calls to fibRecursive(m) when calculating fibRecursive(n)
        if (m > n)
            return 0;
        if (m == n)
            return 1;
        if (n < 2)
            return 0;
        return fibCount(m , n-1) + fibCount(m , n-2);
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
