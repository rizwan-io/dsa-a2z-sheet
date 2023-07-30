import arrays.medium.MediumArrayProblems;

import java.util.Arrays;

public class Main {
     // Main method to test the programs.
    public static void main(String[] args) {
        int[][] arr = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        System.out.println(Arrays.deepToString(arr));
        MediumArrayProblems.setZeroes3(arr);
        System.out.println(Arrays.deepToString(arr));
    }
}
