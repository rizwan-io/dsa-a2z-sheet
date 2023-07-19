package learnthebasics.basicmaths;

public class BasicMaths {

    // optimal - improved euclidean theorem
    public static Long[] lcmAndGcd4(Long A , Long B) {
        Long[] result = new Long[2];
        long max = Math.max(A, B);
        long min = Math.min(A, B);

        while (min != 0 && max !=0) {
            long x = max-min;
            long y = min;
            max = Math.max(x, y);
            min = Math.min(x, y);
        }

        result[1] = max;
        result[0] = (A*B)/result[1];
        return result;
    }


    // optimal - euclidean theorem
    public static Long[] lcmAndGcd3(Long A , Long B) {
        Long[] result = new Long[2];
        long max = Math.max(A, B);
        long min = Math.min(A, B);

        while (min != 0 && max !=0) {
            long x = max-min;
            long y = min;
            max = Math.max(x, y);
            min = Math.min(x, y);
        }

        result[1] = max;
        result[0] = (A*B)/result[1];
        return result;
    }

    // better approach
    public static Long[] lcmAndGcd2(Long A , Long B) {
        Long[] result = new Long[2];
        long min = Math.min(A, B);

        // HCF
        for (long i = 1; i <= min; i++) {
            if (A%i == 0 && B%i == 0) result[1] = i;
        }

        result[0] = (A*B)/result[1];
        return result;
    }

    // bruteforce approach
    public static Long[] lcmAndGcd(Long A , Long B) {
        Long[] result = new Long[2];
        long min = Math.min(A, B);
        long max = Math.max(A, B);
        long temp = A * B;


        for (long i = max; i <= temp; i++) {
            if (i%A == 0 && i%B == 0) {
                result[0] = i;
                break;
            }
        }

        // HCF
        for (long i = 1; i <= min; i++) {
            if (A%i == 0 && B%i == 0) result[1] = i;
        }
        return result;
    }


    // optimal approach
    public static int isPrime(int N) {
        if (N < 2) return 0;
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (N % i == 0) return 0;
        }
        return 1;
    }

    // optimal approach
    public static int countFactors(int N) {
        int count = 0;
        for (int i = 1; i <= Math.sqrt(N); i++) {
            if (N%i == 0) {
                count+=2;
                if (i == Math.sqrt(N)) count--;
            }
        }
        return count;
    }

    // optimal approach
    public static String armstrongNumber(int n) {
        int x = n;
        int result = 0;

        while (x != 0) {
            int temp = x % 10;
            result += Math.pow(temp, 3);
            x = x / 10;
        }

        if (result == n) return "Yes";
        return "No";
    }

    // optimal approach
    public static String is_palindrome(int n) {
        int result = 0;
        int x = n;

        while (x != 0) {
            int digit = x % 10;
            result = result*10 + digit;
            x = x/10;
        }

        if (result == n) return "Yes";
        return "No";
    }

    // optimal approach
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int digit = x % 10;
            result = result*10 + digit;
            x = x/10;
        }
        return result;
    }

    // optimal approach
    public static int countDigit2(long x) {
        return (int) Math.ceil(Math.log10(x+1));
    }

    // Bruteforce approach
    public static int countDigit(long x) {
        int digits = 0;
        while(x != 0) {
            x /= 10;
            digits++;
        }
        return digits;
    }
}
