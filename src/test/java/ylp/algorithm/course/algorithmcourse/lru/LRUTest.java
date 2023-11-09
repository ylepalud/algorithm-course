package ylp.algorithm.course.algorithmcourse.lru;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LRUTest {

    @Test
    void update() {
    }

    @Test
    void completeLifeCycle() {
        // Given
        LRU<String, Integer> lru = new LRU<>(3);

        Assertions.assertThat(lru.get("foo"))
                .isEmpty();

        lru.update("foo", 0);

        Assertions.assertThat(lru.get("foo"))
                .contains(0);

        //

        Assertions.assertThat(lru.get("baz"))
                .isEmpty();

        lru.update("baz", 1);

        Assertions.assertThat(lru.get("baz"))
                .contains(1);

        //

        Assertions.assertThat(lru.get("bar"))
                .isEmpty();

        lru.update("bar", 2);

        Assertions.assertThat(lru.get("bar"))
                .contains(2);

        //

        Assertions.assertThat(lru.get("ball"))
                .isEmpty();

        lru.update("ball", 2);

        Assertions.assertThat(lru.get("ball"))
                .contains(2);

        Assertions.assertThat(lru.get("foo"))
                .isEmpty();

    }
}