package binarysearch.onedimension;

import java.util.ArrayList;
import java.util.Arrays;

public class Bs2darray {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{67}};
        System.out.println(Arrays.toString(findPeakGrid(matrix)));
    }



    public static int[] findPeakGrid(int[][] mat) {
        if (mat.length == 1) return new int[]{0, isPeakInARow(mat[0])};

        for (int i = 0; i < mat.length; i++) {
            int column = isPeakInARow(mat[i]);
            if (column != -1) {
                if (i == 0 && (mat[i][column] > mat[i+1][column]) ) {
                    // only above
                    return new int[]{i, column};
                } else if (i == mat.length - 1 && mat[i][column] > mat[i-1][column] ) {
                    // only below
                    return new int[]{i, column};
                }
                // above and below
                if (mat[i][column] > mat[i+1][column] && mat[i][column] > mat[i-1][column] ) {
                    return new int[]{i, column};
                }
            }
        }

        return new int[]{-1, -1};
    }

    private static int isPeakInARow(int[] mat) {
        int low = 0;
        int high = mat.length - 1;

        while (low <  high - 1) {
            int mid = (low + high) / 2;
            if (mat[mid] > mat[mid-1] && mat[mid] > mat[mid+1]) {
                if (mat[low] > mat[mid]) high = mid - 1;
                else if (mat[high] > mat[mid]) low = mid + 1;
                else return mid;
            } else if (mat[mid-1] < mat[mid+1] || mat[mid-1] < mat[high]) {
                // Series is increasing i.e. peak lies on the right
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (low == high || mat[low] > mat[high]) {
            return low;
        } else if (mat[high] > mat[low]) {
            return high;
        }

        return -1;
    }

    private static boolean searchMatrix2(int[][] matrix, int target) {
        int lowRow = 0;
        int highCol = matrix[0].length - 1;

        while (lowRow < matrix.length && highCol >= 0) {
            if (matrix[lowRow][highCol] == target) return true;
            else if (matrix[lowRow][highCol] > target) {
                highCol--;
            } else {
                lowRow++;
            }
        }

        return false;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int high = (matrix[0].length) * (matrix.length) - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int rowNumber = mid / matrix[0].length;
            int columnNumber = mid - ((rowNumber) * matrix[0].length);

            if (matrix[rowNumber][columnNumber] == target) return true;
            else if (matrix[rowNumber][columnNumber] > target) high = mid - 1;
            else low = mid + 1;
        }

        return false;
    }

    public static int maximumOnesRow(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
        int minIndex = m;
        int resultRow = -1;

        for (int i = 0; i < n; i++) {
            int index = binarySearch(matrix.get(i), 1);
            if (index < minIndex) {
                minIndex = index;
                resultRow = i;
            }
        }

        return resultRow;
    }

    private static int binarySearch(ArrayList<Integer> arrayList, int key) {
        int low = 0;
        int high = arrayList.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arrayList.get(mid) == key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
