package ylp.algorithm.course.algorithmcourse.search;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class BinarySearch {

    private static final Logger LOGGER = LoggerFactory.getLogger(BinarySearch.class.getSimpleName());

    /**
     * Implementation of the binary search
     * /!\ array must be sorted !! /!\
     *
     * Complexity: o(log(n))
     * */
    public static boolean hasItem(int[] array, int lookingValue) {
        if (array.length == 0) return false;

        int midIndex = getHalfIndex(array);

        LOGGER.info("Looking in {} for {} at index {}", array, lookingValue, midIndex);

        int midPoint = array[midIndex];

        if (midPoint == lookingValue) return true;

        if (midPoint > lookingValue) {
            int[] leftHalf = Arrays.copyOfRange(array, 0, midIndex);
            return hasItem(leftHalf, lookingValue);
        }

        int[] rightHalf = Arrays.copyOfRange(array, midIndex + 1, array.length);
        return hasItem(rightHalf, lookingValue);
    }

    private static int getHalfIndex(int[] array) {
        return Math.max(
                Math.round((float) array.length / 2) - 1,
                0
        );
    }
}
