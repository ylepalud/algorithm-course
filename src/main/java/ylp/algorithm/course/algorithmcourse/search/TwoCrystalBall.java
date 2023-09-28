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

    * Here we are mixing concepts of BinarySearch and Linear search
    * We divide the array in small chunk until we found a chunk that overlaps with result
    * Then we linear search in the small chunk
    *
    * Complexity = o(sqrt(n))
    */
    public static Optional<Integer> whenDoesItBreak(boolean[] ballResistance) {
        int offset = (int) Math.round(Math.sqrt(ballResistance.length));

        int lowerBand = 0;
        int upperBand = lowerBand + offset;

        while (!ballResistance[upperBand]) {
            LOGGER.info("Looking in {} Lower band {} upper band {}", ballResistance, lowerBand, upperBand);
            lowerBand = upperBand;
            upperBand = upperBand + offset;

            if (upperBand >= ballResistance.length) {
                upperBand = ballResistance.length - 1;
                LOGGER.info("Looking in {} Lower band {} upper band {}", ballResistance, lowerBand, upperBand);
                break;
            }
        }

        for (int i = lowerBand; i <= upperBand; i++) {
            if (ballResistance[i]) {
                LOGGER.info("Found breaking point at {}", i);
                return Optional.of(i);
            }
        }

        LOGGER.info("No breaking point");
        return Optional.empty();
    }

    public static <T> Optional<Integer> whenDoesItBreak(T[] array, Predicate<T> predicate) {
        int offset = (int) Math.round(Math.sqrt(array.length));

        int lowerBand = 0;
        int upperBand = lowerBand + offset;

        while (!predicate.test(array[upperBand])) {
            LOGGER.info("Looking in {} Lower band {} upper band {}", array, lowerBand, upperBand);
            lowerBand = upperBand;
            upperBand = upperBand + offset;

            if (upperBand >= array.length) {
                upperBand = array.length - 1;
                LOGGER.info("Looking in {} Lower band {} upper band {}", array, lowerBand, upperBand);
                break;
            }
        }

        for (int i = lowerBand; i <= upperBand; i++) {
            if (predicate.test(array[i])) {
                LOGGER.info("Found breaking point at {}", i);
                return Optional.of(i);
            }
        }

        LOGGER.info("No breaking point");
        return Optional.empty();
    }
}
