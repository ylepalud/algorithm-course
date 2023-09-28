package ylp.algorithm.course.algorithmcourse.search;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;
import java.util.function.Predicate;

public class TwoCrystalBall {

    private final static Logger LOGGER = LoggerFactory.getLogger(TwoCrystalBall.class.getSimpleName());

    /*
    Image that you have an array with boolean sort with all false value and then all true.
    Find the minimum index at which it's true. (You can change this problem with any array and a predicate)

    It's called 2 crystal ball problem because you have the right to test have only 1 true test

    * Here we are mixing concepts of BinarySearch and Linear search
    * We divide the array in small chunk until we found a chunk that overlaps with result
    * Then we linear search in the small chunk
    *
    * Complexity = o(sqrt(n))
    */
    public static Optional<Integer> whenDoesItBreak(boolean[] ballResistance) {
        int offset = (int) Math.floor(Math.sqrt(ballResistance.length));

        int upperBand = offset;

        for (; upperBand < ballResistance.length; upperBand += offset) {
            if (ballResistance[upperBand]) {
                break;
            }
        }

        int lowerBand = upperBand - offset;

        for (int i = lowerBand; i <= upperBand && upperBand < ballResistance.length; i++) {
            if (ballResistance[i]) {
                LOGGER.info("Found breaking point at {}", i);
                return Optional.of(i);
            }
        }

        LOGGER.info("No breaking point");
        return Optional.empty();
    }

    public static <T> Optional<Integer> whenDoesItBreak(T[] array, Predicate<T> predicate) {
        int offset = (int) Math.floor(Math.sqrt(array.length));

        int upperBand = offset;

        for (; upperBand < array.length; upperBand += offset) {
            if (predicate.test(array[upperBand])) {
                break;
            }
        }

        int lowerBand = upperBand - offset;

        for (int i = lowerBand; i <= upperBand && upperBand < array.length; i++) {
            if (predicate.test(array[i])) {
                LOGGER.info("Found breaking point at {}", i);
                return Optional.of(i);
            }
        }

        LOGGER.info("No breaking point");
        return Optional.empty();
    }
}
