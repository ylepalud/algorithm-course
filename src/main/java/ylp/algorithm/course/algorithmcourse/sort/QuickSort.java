package ylp.algorithm.course.algorithmcourse.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort {

    public static int[] sort(int[] array) {
        qs(array, 0, array.length - 1);
        return array;
    }

    private static void qs(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }

        int pivotIndex = partition(array, low, high);
        qs(array, low, pivotIndex -1);
        qs(array,pivotIndex + 1, high);
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];

        int index = low - 1;

        for (int i = 0; i <= high; i++) {
            if (array[i] <= pivot) {
                index++;
                int tmp = array[i];
                array[i] = array[index];
                array[index] = tmp;
            }
        }

        index++;
        array[high] = array[index];
        array[index] = pivot;
        return index;
    }
}
