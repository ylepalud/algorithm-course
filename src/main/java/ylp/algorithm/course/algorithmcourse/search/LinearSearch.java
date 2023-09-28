package ylp.algorithm.course.algorithmcourse.search;

public class LinearSearch {

    /**
     * Implementation of the linear search
     *
     * Complexity: o(n)
     */
    public static boolean hasItem(int[] array, int value) {
        for (int element: array) {
            if (element == value) return true;
        }
        return false;
    }

}
