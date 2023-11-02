package ylp.algorithm.course.algorithmcourse;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class SlidingWindows {
    public static <T, R> List<R> slidingWindow(Collection<T> collection,
                                            int windowSize,
                                            Function<Collection<T>, R> conversion
                                         ) {
        Function<T, Queue<T>> computeWindow = computeWindow(windowSize);

        return collection.stream()
                .map(computeWindow)
                .filter(Predicate.not(Collection::isEmpty))
                .map(conversion)
                .toList();
    }

    private static <T> Function<T, Queue<T>> computeWindow(int windowsSize) {
        Queue<T> window = new ArrayDeque<>();

        return element -> {
            window.add(element);

            if (window.size() > windowsSize) {
                window.poll();
            }

            if (window.size() != windowsSize) {
                return new ArrayDeque<>();
            }

            return window;
        };
    }
}
