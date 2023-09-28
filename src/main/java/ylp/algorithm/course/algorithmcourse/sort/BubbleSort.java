package ylp.algorithm.course.algorithmcourse.sort;

import java.util.Arrays;

public class BubbleSort {

    /**
     * Every time we got the end of the array (i loop) we know for sure that the biggest number is at the right
     * That's why we don't go up until the end for the j loop
     *
     * Complexity = o(n^2)
     * i loop o(n)
     * j loop o(n)
     * i = 0 j = 0 to n-1
     * i = 1 j = 0 to n-2
     * i = 2 j = 0 to n-3
     * ... etc
     * This is like sum of a range of number = (n(n-1))/2 <-> n(n-1) <-> n^2 + n <-> n^2
     */
    public static int[] sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length -1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
        return array;
    }

    private static void swap(int[] array, int i, int j) {
        int a = array[i];
        array[i] = array[j];
        array[j] = a;
    }
}
