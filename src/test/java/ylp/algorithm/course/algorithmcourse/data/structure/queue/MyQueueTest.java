package ylp.algorithm.course.algorithmcourse.data.structure.queue;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MyQueueTest {

    @Test
    void push() {
        MyQueue<Integer> integerMyQueue = new MyQueue<>();

        integerMyQueue.push(1);
        integerMyQueue.push(2);
        integerMyQueue.push(3);

        assertThat(integerMyQueue.size())
                .isEqualTo(3);

        assertThat(integerMyQueue.pop().get())
                .isEqualTo(1);

        assertThat(integerMyQueue.size())
                .isEqualTo(2);

        assertThat(integerMyQueue.pop().get())
                .isEqualTo(2);

        assertThat(integerMyQueue.size())
                .isEqualTo(1);

        assertThat(integerMyQueue.pop().get())
                .isEqualTo(3);

        assertThat(integerMyQueue.size())
                .isEqualTo(0);

        assertThat(integerMyQueue.pop())
                .isEmpty();
    }
}