package learnthebasics.recursion;

public class Recursion {
    static long nthFibonacci(long n){
        if (n < 2) return n;
        return nthFibonacci(n-1) + nthFibonacci(n-2);
    }

    static int isPalindrome(String S) {
        if (S.length() == 0 || S.length() == 1) return 1;
        if (S.charAt(0) == S.charAt(S.length()-1)) {
            return isPalindrome(S.substring(1, S.length()-1));
        }
        return 0;
    }

    static long factorial(int N){
        if(N == 0) return 1;
        return N * factorial(--N);
    }

    static long sumOfSeries(long n) {
        if (n == 0) return 0;
        long sum = (n*n*n) + sumOfSeries(--n);
        return sum;
    }

    public void printNos2(int N) {
        if(N == 0) return;
        System.out.print(N + " ");
        printNos2(--N);
    }

    void printGfg(int N) {
        if (N == 0) return;
        System.out.print("GFG ");
        N--;
        printGfg(N);
    }

    public void printNos(int N) {
        if(N == 0) return;
        N--;
        printNos(N);
        System.out.print(N+1 + " ");
    }
}
