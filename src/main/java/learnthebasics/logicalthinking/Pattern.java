package learnthebasics.logicalthinking;

public class Pattern {

    // first subtract n from each number then it is observed that
    // the number is the min distance from the edges
    // add n to the final result
    public static void pattern22(int n) {
        for (int i = 0; i < 2*n-1; i++) {
            for (int j = 0; j < 2*n-1; j++) {
                int k = Math.min((i), Math.min(((2*n-2)-i), Math.min((j), (2*n-2)-j)));
                System.out.print(n-k + " ");
            }
            System.out.println();
        }
    }

    // starts only on the border
    public static void pattern21(int n) {
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0 || i == n-1 || j == n-1) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println();
        }
    }

    // observed symmetry: write code for upper half then lower half
    // another method: this can also be solved using the below approach
    public static void pattern20(int n) {
        int spaces = 2*n-2;
        for (int i = 0; i < 2*n-1; i++) {
            int stars = i+1;
            if (i >= n) stars = 2*n-(i+1);
            for (int j = 0; j < stars; j++) {
                System.out.print("*");
            }
            for (int j = 0; j < spaces; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < stars; j++) {
                System.out.print("*");
            }
            if (i >= n-1) spaces += 2;
            else spaces -= 2;
            System.out.println();
        }
    }

    // symmetry observed: write code for the upper half then the lower half
    public static void pattern19(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                System.out.print("*");
            }
            for (int j = 0; j < 2*i; j++) {
                System.out.print(" ");
            }
            for (int j = i; j < n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            for (int j = 0; j < 2*(n-i-1); j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
    public static void pattern18(int n) {
        for (int i = 0; i < n; i++) {
            char count = (char) ('A' + n - 1);
            for (int j = 0; j <= i; j++) {
                System.out.print(count + " ");
                count--;
            }
            System.out.println();
        }
    }
    public static void pattern17(int n) {
        for (int i = 0; i < n; i++) {
            char count = 'A';
            for (int j = 0; j < n-i-1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < (2*i)+1; j++) {
                System.out.print(count);
                if (j >= i) count--;
                else count++;
            }
            System.out.println();
        }
    }
    public static void pattern16(int n) {
        char count = 'A';
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(count);
            }
            count++;
            System.out.println();
        }
    }
    public static void pattern15(int n) {
        for (int i = 0; i < n; i++) {
            char count = 'A';
            for (int j = 0; j < n-i; j++) {
                System.out.print(count++);
            }
            System.out.println();
        }
    }
    public static void pattern14(int n) {
        for (int i = 0; i < n; i++) {
            char count = 'A';
            for (int j = 0; j <= i; j++) {
                System.out.print(count++);
            }
            System.out.println();
        }
    }
    public static void pattern13(int n) {
        int count = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(count++ + " ");
            }
            System.out.println();
        }
    }
    public static void pattern12(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            for (int j = 1; j <= 2*(n-i); j++) {
                System.out.print("  ");
            }
            for (int j = i; j > 0; j--) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
    public static void pattern11(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i+1; j++) {
                if ((i+j)%2 == 0) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }

    // observed symmetry: write code for upper half then lower half
    public static void pattern10(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i+1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n-i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // observed symmetry: write code for upper half then lower half
    public static void pattern9(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-i-1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i+1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < (n-i); j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void pattern8(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2*(n-i)-1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void pattern7(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-i-1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < (2*i)+1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void pattern6(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n-i+1; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
    public static void pattern5(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void pattern4(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    public static void pattern3(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
    public static void pattern2(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void pattern1(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
