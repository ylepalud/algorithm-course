package ylp.algorithm.course.algorithmcourse.search;

public class LinearSearch {

    public static boolean hasItem(int[] array, int value) {
        for (int element: array) {
            if (element == value) return true;
        }
        return false;
    }

}
